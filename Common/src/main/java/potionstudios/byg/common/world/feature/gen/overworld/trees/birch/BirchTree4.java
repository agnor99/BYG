package potionstudios.byg.common.world.feature.gen.overworld.trees.birch;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Set;

public class BirchTree4 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public BirchTree4(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, RandomSource rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 0, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 1, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 2, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 3, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 4, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 5, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 6, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 8, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 9, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 10, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 11, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 12, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 13, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 14, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 15, 0), boundsIn);
                placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 16, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 7, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 11, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 12, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 5, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 7, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 8, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 8, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 8, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 8, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 8, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 8, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 8, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 8, 2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 8, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 9, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 9, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 9, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 9, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 9, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 9, 2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 9, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 9, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 9, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 9, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 9, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 9, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 9, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 10, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 10, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 10, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 10, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 10, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 10, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 10, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 10, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 10, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 10, 2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 10, 3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 10, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 10, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 10, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 10, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 10, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 10, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 10, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 11, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 11, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 12, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 12, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 12, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 12, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 12, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 12, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 12, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 12, 2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 12, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 12, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 12, 2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 12, 3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 12, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 12, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 12, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 12, 2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 12, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 12, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 13, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 13, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 13, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 13, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 13, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 13, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 13, 2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 13, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 13, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 13, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 13, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 13, 2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 13, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 13, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 13, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 14, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 14, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 14, 2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 14, 3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 14, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 14, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 15, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 15, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 15, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 15, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 15, 2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 15, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 15, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 15, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 15, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 15, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 15, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 15, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 15, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 15, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 15, 2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 15, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 15, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 16, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 16, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 16, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 16, 2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 16, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 17, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 17, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 17, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 17, 2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 17, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 17, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 17, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 17, 2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 17, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 17, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 17, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 18, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 18, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 18, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 18, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 18, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 18, 1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 18, -1), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 19, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 19, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 19, 0), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 20, 0), boundsIn);
            }
        }
        return true;
    }
}