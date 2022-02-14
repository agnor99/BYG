package potionstudios.byg.common.world.feature.overworld;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import potionstudios.byg.common.world.feature.config.LargeLakeFeatureConfig;
import potionstudios.byg.common.world.math.noise.fastnoise.FastNoise;
import potionstudios.byg.util.MLBlockTags;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class LargeLakeFeature extends Feature<LargeLakeFeatureConfig> {

    public static Direction[] DIRECTIONS = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.DOWN};
    public static FastNoise fastNoise;
    protected static long seed;

    public LargeLakeFeature(Codec<LargeLakeFeatureConfig> $$0) {
        super($$0);
    }

    @Override
    public boolean place(FeaturePlaceContext<LargeLakeFeatureConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, LargeLakeFeatureConfig config) {
        setSeed(world.getSeed());

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(blockPos);
        BlockPos.MutableBlockPos mutable2 = new BlockPos.MutableBlockPos().set(mutable);
        int xRadius = config.getRandomRadius(random) / 2;
        int yRadius = config.getRandomDepth(random);
        int zRadius = config.getRandomRadius(random) / 2;

        int blendSize = 0;
        List<BlockPos> positions = new ArrayList<>();
        Function<BlockPos, BlockState> lakeBorderStateFunction = (blockPos3) -> config.borderStateProvider().getState(random, blockPos3);
        Function<BlockPos, BlockState> lakeFloorStateFunction = (blockPos3) -> config.lakeFloorStateProvider().getState(random, blockPos3);

        for (int x = -xRadius - blendSize; x <= xRadius + blendSize; x++) {
            for (int z = -zRadius - blendSize; z <= zRadius + blendSize; z++) {
                for (int y = -yRadius; y < 0; y++) {
//                    mutable.setY(world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, mutable.getX() + x, mutable.getZ() + z));
                    mutable2.set(mutable).move(x, y, z);

                    //Credits to Hex_26 for this equation!
                    double xSquared = Math.pow(x, 2);
                    double ySquared = Math.pow(y, 2);
                    double zSquared = Math.pow(z, 2);
                    double squaredDistance = xSquared + ySquared + zSquared;

                    if (squaredDistance <= xRadius * zRadius) {
                        double equationResult = xSquared / Math.pow(xRadius, 2) + ySquared / Math.pow(yRadius, 2) + zSquared / Math.pow(zRadius, 2);
                        double threshold = 1 + 1.4 * fastNoise.GetNoise(mutable2.getX(), mutable2.getZ());
                        if (equationResult >= threshold) {
                            continue;
                        }

                        positions.add(new BlockPos(mutable2.getX(), mutable2.getY(), mutable2.getZ()));
                    }
                }
            }
        }

        int waterLevel = blockPos.getY();
        for (BlockPos position : positions) {
           waterLevel = Math.min(world.getHeight(Heightmap.Types.WORLD_SURFACE_WG, position.getX(), position.getZ()) - 1, waterLevel);
        }

        ArrayList<Pair<BlockPos, BlockState>> fallingBlocks = new ArrayList<>();
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (BlockPos position : positions) {
            BlockPos.MutableBlockPos mutable3 = mutableBlockPos.set(position.getX(), Math.min(position.getY(), waterLevel), position.getZ());

            if(mutable3.getY() == waterLevel) {
                setLakeBlocks(world, lakeBorderStateFunction, mutable3);
                BlockPos.MutableBlockPos mutable4 = new BlockPos.MutableBlockPos().set(mutable3);
                for (int i = 0; i < 10; i++) {
                    mutable4.move(Direction.UP);
                    BlockState blockStateAbove = world.getBlockState(mutable4);
                    Block stateAboveBlock = blockStateAbove.getBlock();
                    if (stateAboveBlock instanceof FallingBlock) {
                        fallingBlocks.add(new Pair<>(mutable4.immutable(), blockStateAbove));
                        world.removeBlock(mutable4, false);

                    } else if (canReplace(blockStateAbove)) {
                        world.removeBlock(mutable4, false);
                    } else {
                        break;
                    }
                }
            } else {
                setLakeBlocks(world, lakeFloorStateFunction, mutable3);
            }
        }
        for (Pair<BlockPos, BlockState> fallingBlock : fallingBlocks) {
            BlockPos pos = fallingBlock.getFirst();
            BlockPos.MutableBlockPos fallingMutable = new BlockPos.MutableBlockPos().set(pos);
            while (!world.getBlockState(fallingMutable).canOcclude()) {
                fallingMutable.move(Direction.DOWN);
            }
            world.setBlock(fallingMutable.move(Direction.UP), fallingBlock.getSecond(), 2);
        }

        return true;
    }

    private void setLakeBlocks(WorldGenLevel world, Function<BlockPos, BlockState> stateFunction, BlockPos mutable2) {
        world.setBlock(mutable2, Blocks.WATER.defaultBlockState(), 2);
        world.scheduleTick(mutable2, Fluids.WATER, 0);

        BlockPos.MutableBlockPos mutable3 = new BlockPos.MutableBlockPos().set(mutable2);
        for (Direction value : DIRECTIONS) {
            mutable3.setWithOffset(mutable2, value);
            if (world.getBlockState(mutable3).getBlock() != Blocks.WATER) {
                world.setBlock(mutable3, stateFunction.apply(mutable3), 2);
            }
        }
    }

    private void fillDownwards(WorldGenLevel world, Function<BlockPos, BlockState> stateFunction, BlockPos.MutableBlockPos mutable3) {
        while (mutable3.getY() > world.getMinBuildHeight()) {
            world.setBlock(mutable3, stateFunction.apply(mutable3), 2);
            mutable3.move(Direction.DOWN);
        }
    }

    public static void setSeed(long worldSeed) {
        if (seed != worldSeed || fastNoise == null) {
            fastNoise = new FastNoise((int) worldSeed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
            fastNoise.SetFrequency(0.05f);
            seed = worldSeed;
        }
    }

    private static boolean canReplace(BlockState state) {
        return state.getMaterial().isReplaceable()
                || state.is(BlockTags.BASE_STONE_OVERWORLD)
                || state.is(MLBlockTags.END_STONES)
                || state.is(MLBlockTags.SANDSTONE)
                || state.is(BlockTags.FLOWERS)
                || state.is(MLBlockTags.ORES) // Handles floating ores
                || state.is(BlockTags.DIRT)
                || state.is(BlockTags.TERRACOTTA)
                || state.getMaterial().equals(Material.PLANT)
                || state.getMaterial().equals(Material.WATER_PLANT)
                || state.getMaterial().equals(Material.REPLACEABLE_WATER_PLANT);
    }
}
