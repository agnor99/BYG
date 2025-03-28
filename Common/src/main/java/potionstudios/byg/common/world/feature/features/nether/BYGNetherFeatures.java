package potionstudios.byg.common.world.feature.features.nether;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.BYGTreeConfig;
import potionstudios.byg.common.world.feature.config.HangingColumnWithBaseConfig;
import potionstudios.byg.common.world.feature.config.QuartzSpikeConfig;
import potionstudios.byg.common.world.feature.config.SimpleBlockProviderConfig;
import potionstudios.byg.common.world.feature.placement.BYGPlacedFeaturesUtil;

import java.util.List;
import java.util.function.Supplier;

import static potionstudios.byg.common.world.feature.features.BYGFeaturesUtil.*;

public class BYGNetherFeatures {


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SUBZERO_ASH_BLOCK = createConfiguredFeature("subzero_ash_block", () -> Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BYGBlocks.SUBZERO_ASH_BLOCK.get())), List.of(BYGBlocks.SUBZERO_ASH_BLOCK.get())));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SUBZERO_ASH = createPatchConfiguredFeatureWithBlock("subzero_ash", BYGBlocks.SUBZERO_ASH, 35);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> QUARTZ_CRYSTAL = createPatchConfiguredFeatureWithBlock("quartz_crystal", BYGBlocks.QUARTZ_CRYSTAL, 15);


    public static final Supplier<RuleTest> BRIMSTONE = () -> new BlockMatchTest(BYGBlocks.BRIMSTONE.get());
    public static final Supplier<RuleTest> BLUE_NETHERRACK = () -> new BlockMatchTest(BYGBlocks.BLUE_NETHERRACK.get());
    public static final Supplier<RuleTest> SCORIA_STONE = () -> new BlockMatchTest(BYGBlocks.SCORIA_STONE.get());

    public static final Holder<ConfiguredFeature<SimpleBlockProviderConfig, ?>> BRIMSTONE_VOLCANO = createConfiguredFeature("brimstone_volcano", BYGFeatures.VOLCANO, () -> new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.BRIMSTONE.get())));
    public static final Holder<ConfiguredFeature<ColumnFeatureConfiguration, ?>> QUARTZ_COLUMNS = createConfiguredFeature("quartz_columns", BYGFeatures.QUARTZ_COLUMNS, () -> new ColumnFeatureConfiguration(ConstantInt.of(1), UniformInt.of(1, 3)));
    public static final Holder<ConfiguredFeature<QuartzSpikeConfig, ?>> QUARTZ_SPIKE = createConfiguredFeature("quartz_spike", BYGFeatures.QUARTZ_SPIKES, () -> new QuartzSpikeConfig.Builder().setBlock(BYGBlocks.QUARTZITE_SAND.get()).build());

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_PENDORITE = createConfiguredFeature("ore_pendorite", () -> Feature.ORE, () -> new OreConfiguration(BLUE_NETHERRACK.get(), BYGBlocks.PENDORITE_ORE.defaultBlockState(), 6));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_EMERALDITE = createConfiguredFeature("ore_emeraldite", () -> Feature.ORE, () -> new OreConfiguration(SCORIA_STONE.get(), BYGBlocks.EMERALDITE_ORE.defaultBlockState(), 6));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_ANTHRACITE = createConfiguredFeature("ore_anthracite", () -> Feature.ORE, () -> new OreConfiguration(BRIMSTONE.get(), BYGBlocks.ANTHRACITE_ORE.defaultBlockState(), 10));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_GOLD_BRIMSTONE = createConfiguredFeature("ore_gold_brimstone", () -> Feature.ORE, () -> new OreConfiguration(BRIMSTONE.get(), BYGBlocks.BRIMSTONE_NETHER_GOLD_ORE.defaultBlockState(), 10));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_QUARTZ_BRIMSTONE = createConfiguredFeature("ore_quartz_brimstone", () -> Feature.ORE, () -> new OreConfiguration(BRIMSTONE.get(), BYGBlocks.BRIMSTONE_NETHER_QUARTZ_ORE.defaultBlockState(), 10));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_GOLD_BLUE_NETHERRACK = createConfiguredFeature("ore_gold_blue_netherrack", () -> Feature.ORE, () -> new OreConfiguration(BLUE_NETHERRACK.get(), BYGBlocks.BLUE_NETHER_GOLD_ORE.defaultBlockState(), 10));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_QUARTZ_BLUE_NETHERRACK = createConfiguredFeature("ore_quartz_blue_netherrack", () -> Feature.ORE, () -> new OreConfiguration(BLUE_NETHERRACK.get(), BYGBlocks.BLUE_NETHER_GOLD_ORE.defaultBlockState(), 10));
    public static final Holder<ConfiguredFeature<SimpleBlockProviderConfig, ?>> BRIMSTONE_PILLARS = createConfiguredFeature("brimstone_pillars", BYGFeatures.PILLARS, () -> new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.BRIMSTONE.get())));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BORIC_FIRE_PATCH = createConfiguredFeature("boric_fire_patch", () -> Feature.RANDOM_PATCH, () ->
        new RandomPatchConfiguration(24, 4, 7,
            BYGPlacedFeaturesUtil.createPlacedFeatureDirect(createConfiguredFeature(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(SimpleStateProvider.simple(BYGBlocks.BORIC_FIRE.get()))),
                createSolidDownAndAirAllAroundFilter(BlockPredicate.matchesBlocks(BlockPos.ZERO.relative(Direction.DOWN), BYGBlocks.BRIMSTONE.get()))))
    );

    public static final Holder<ConfiguredFeature<SimpleBlockProviderConfig, ?>> SOUL_SOIL_PILLARS = createConfiguredFeature("soul_soil_pillars", BYGFeatures.PILLARS, () -> new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.WARPED_SOUL_SOIL.defaultBlockState())));
    public static final Holder<ConfiguredFeature<SimpleBlockProviderConfig, ?>> FROST_MAGMA_PILLARS = createConfiguredFeature("frost_magma_pillars", BYGFeatures.PILLARS, () -> new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.FROST_MAGMA.defaultBlockState())));
    public static final Holder<ConfiguredFeature<SimpleBlockProviderConfig, ?>> MAGMA_PILLARS = createConfiguredFeature("magma_pillars", BYGFeatures.PILLARS, () -> new SimpleBlockProviderConfig(BlockStateProvider.simple(BYGBlocks.MAGMATIC_STONE.defaultBlockState())));
    public static final Holder<ConfiguredFeature<HangingColumnWithBaseConfig, ?>> HANGING_LANTERNS = createConfiguredFeature("hanging_lanterns", BYGFeatures.HANGING_FEATURE, () -> new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.SCORIA_STONE.get()).setBlock(Blocks.CAVE_AIR.defaultBlockState()).setEndBlock(BYGBlocks.WAILING_BELL_BLOSSOM.defaultBlockState()).setMinLength(1).setMaxLength(4).setWhitelist(ImmutableList.of(BYGBlocks.SCORIA_STONE.get())).build());
    public static final Holder<ConfiguredFeature<SimpleBlockProviderConfig, ?>> SYTHIAN_FUNGUS_PILLARS = createConfiguredFeature("sythian_fungus_pillars", BYGFeatures.PILLARS, () -> new SimpleBlockProviderConfig(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BYGWoodTypes.SYTHIAN.wood().defaultBlockState(), 9).add(BYGWoodTypes.SYTHIAN.wood().defaultBlockState(), 1))));
    public static final Holder<ConfiguredFeature<HangingColumnWithBaseConfig, ?>> HANGING_CHAINS = createConfiguredFeature("hanging_chains", BYGFeatures.HANGING_FEATURE, () -> new HangingColumnWithBaseConfig.Builder().setBaseBlock(BYGBlocks.SCORIA_STONE.get()).setBlock(Blocks.CHAIN.defaultBlockState()).setEndBlock(Blocks.CHAIN.defaultBlockState()).setMinLength(8).setMaxLength(16).setWhitelist(ImmutableList.of(BYGBlocks.SCORIA_STONE.get())).build());
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SUBZERO_ASHES = createConfiguredFeature("subzero_ashes", () -> Feature.RANDOM_SELECTOR, () -> new RandomFeatureConfiguration(ImmutableList.of(
        new WeightedPlacedFeature(BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SUBZERO_ASH), 0.6F)),
        BYGPlacedFeaturesUtil.createPlacedFeatureDirect(SUBZERO_ASH_BLOCK)));


    public static final Holder<ConfiguredFeature<BYGTreeConfig, ?>> WAILING_PILLAR = createConfiguredFeature("wailing_pillar1", BYGFeatures.WAILING_PILLAR1, () -> new BYGTreeConfig.Builder().setTrunkBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.BASALT.defaultBlockState(), 8).add(Blocks.POLISHED_BASALT.defaultBlockState(), 2))).setLeavesBlock(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 4).add(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3).add(Blocks.BLACKSTONE.defaultBlockState(), 2).add(BYGBlocks.DUSTED_POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3))).setMaxHeight(30).setMinHeight(22).build());

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> NYLIUM_SOUL_PATCH_FIRE = createConfiguredFeature("nylium_soul_patch_fire", () -> Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SOUL_FIRE)), List.of(BYGBlocks.WARPED_SOUL_SOIL.get(), BYGBlocks.WARPED_SOUL_SAND.get())));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> MAGMA_PATCH_FIRE = createConfiguredFeature("magma_patch_fire", () -> Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.FIRE)), List.of(BYGBlocks.MAGMATIC_STONE.get())));

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SUBZERO_CRYSTAL = createConfiguredFeature("subzero_crystal", BYGFeatures.SUBZERO_CRYSTAL, () -> FeatureConfiguration.NONE);

    public static void loadClass() {}
}
