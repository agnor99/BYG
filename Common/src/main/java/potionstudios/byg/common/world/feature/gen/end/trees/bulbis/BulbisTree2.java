package potionstudios.byg.common.world.feature.gen.end.trees.bulbis;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.config.BYGMushroomConfig;
import potionstudios.byg.common.world.feature.gen.overworld.mushrooms.util.BYGAbstractMushroomFeature;

public class BulbisTree2 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public BulbisTree2(Codec<BYGMushroomConfig> configIn) {
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
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 5, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 6, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 7, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 8, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 9, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 10, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 11, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 12, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 0, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 0, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 1, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 1, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 1, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 1, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 3, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-2, 4, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 4, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 5, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 5, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 6, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 6, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 6, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 6, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 6, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 6, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-4, 7, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 7, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 7, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 7, 2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-2, 7, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 7, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 7, -4));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 7, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(4, 7, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-5, 8, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 8, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 8, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 8, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 8, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 8, -4));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 8, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(4, 8, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-5, 9, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 9, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 9, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 9, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 11, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 11, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 11, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 11, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-2, 12, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 12, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 12, 2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 12, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 13, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 13, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 13, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 13, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 13, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 13, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 13, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 13, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 13, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 13, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 13, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 13, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-4, 14, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 14, -4));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 14, 4));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(4, 14, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-3, 15, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 15, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 15, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 15, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 7, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 7, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, -3));
                this.shroomlight(worldIn, mainmutable.set(pos).move(2, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 9, 0));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-3, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 13, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 13, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 13, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 13, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 14, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 14, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 14, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 14, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 14, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 14, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 14, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 14, -1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(0, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 14, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 14, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 14, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 14, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 14, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 14, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 14, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 14, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 15, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 15, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 15, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 15, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 15, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 15, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 15, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 15, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 15, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 15, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 15, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 15, -2));
                this.shroomlight(worldIn, mainmutable.set(pos).move(0, 15, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 15, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 15, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 15, -2));
                this.shroomlight(worldIn, mainmutable.set(pos).move(1, 15, 0));
                this.shroomlight(worldIn, mainmutable.set(pos).move(1, 15, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 15, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 15, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 15, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 15, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 15, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 15, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 15, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 15, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 15, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 16, -1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-2, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 16, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 16, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 16, -3));
                this.shroomlight(worldIn, mainmutable.set(pos).move(0, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 16, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 16, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 16, -2));
                this.shroomlight(worldIn, mainmutable.set(pos).move(1, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 16, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 17, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 17, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 17, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 17, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 17, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 17, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 17, -2));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-1, 17, -1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-1, 17, 0));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-1, 17, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 17, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 17, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 17, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 17, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 17, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 17, -2));
                this.shroomlight(worldIn, mainmutable.set(pos).move(1, 17, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 17, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 17, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 17, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 17, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 17, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 17, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 18, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 18, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 18, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 18, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 18, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 18, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 18, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 18, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 18, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 18, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 18, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 18, -1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(0, 18, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 18, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 18, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 18, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 18, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 18, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 18, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 18, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 18, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 18, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 18, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 18, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 18, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 19, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 19, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 19, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 19, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 19, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 19, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 19, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 19, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 19, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 20, 0));
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