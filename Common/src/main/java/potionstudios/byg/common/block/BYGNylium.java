package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import potionstudios.byg.mixin.access.NyliumBlockAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BYGNylium extends NyliumBlock {

    public static final List<Block> BYG_NETHER_SURFACE_BLOCKS = new ArrayList<>();

    private final RandomPatchConfiguration featureConfig;
    private final ResourceKey<Level> worldRegistryKey;
    private final Block dirtBlock;

    public BYGNylium(Properties properties, RandomPatchConfiguration featureConfig, ResourceKey<Level> worldRegistryKey, Block dirtBlock, boolean overrides) {
        super(properties);
        this.featureConfig = featureConfig;
        this.worldRegistryKey = worldRegistryKey;
        this.dirtBlock = dirtBlock;

        if (worldRegistryKey == Level.NETHER && overrides) {
            BYG_NETHER_SURFACE_BLOCKS.add(this);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        if (!NyliumBlockAccess.byg_invokeCanBeNylium(state, world, pos)) {
            world.setBlockAndUpdate(pos, this.dirtBlock.defaultBlockState());
        }
    }

    @Override
    public boolean isBonemealSuccess(Level $$0, Random $$1, BlockPos $$2, BlockState $$3) {
        return this.featureConfig != null;
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter $$0, BlockPos $$1, BlockState $$2, boolean $$3) {
        return this.featureConfig != null;
    }

    @Override
    public void performBonemeal(ServerLevel world, Random rand, BlockPos pos, BlockState state) {
        BlockState blockstate = world.getBlockState(pos);
        BlockPos blockpos = pos.above();
        if (blockstate.is(this) && this.featureConfig != null) {
            BYGGrassBlock.place(world, rand, blockpos, featureConfig);
        }

        if (this.worldRegistryKey == Level.NETHER) {
            if (rand.nextInt(8) == 0) {

                //TODO: 1.18
//                TwistingVinesFeature.place(world, rand, blockpos, 3, 1, 2);
            }
        }
    }
}
