package potionstudios.byg.common.world.feature.gen.end.trees.bulbis;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.gen.overworld.mushrooms.util.BYGAbstractMushroomFeature;

public class BulbisTree3 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public BulbisTree3(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(WorldGenLevel worldIn, RandomSource rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getState(rand, pos);
        int randTreeHeight = 8 + rand.nextInt(5);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwEndTags(config, worldIn, pos.below(), BYGBlocks.IVIS_PHYLIUM.get())) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 2, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 3, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 4, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 0, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 0, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 1, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 1, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 3, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 3, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 3, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 3, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-2, 4, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 4, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 4, 2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 4, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 5, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 5, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 5, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 5, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 5, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 5, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 5, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 5, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 5, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 5, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 5, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 5, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-4, 6, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 6, -4));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 6, 4));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(4, 6, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 7, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 7, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 7, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 6, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, -1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(0, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, -2));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-1, 9, -1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-1, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, -2));
                this.shroomlight(worldIn, mainmutable.set(pos).move(0, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, -2));
                this.shroomlight(worldIn, mainmutable.set(pos).move(1, 9, -1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(1, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, -1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-2, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, -2));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-1, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, -3));
                this.shroomlight(worldIn, mainmutable.set(pos).move(0, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, -2));
                this.shroomlight(worldIn, mainmutable.set(pos).move(1, 10, -1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(1, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, -2));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-1, 11, 0));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-1, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 12, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 12, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 12, -1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(0, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 12, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 12, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 12, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 12, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 12, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 13, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 13, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 13, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 14, 0));
            }
        }
        return true;
    }
    private void shroomlight(WorldGenLevel reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.PURPLE_SHROOMLIGHT.defaultBlockState());
        }
    }
}