package voronoiaoc.byg.common.world.feature.biomefeatures;//package voronoiaoc.byg.common.world.feature.biomefeatures;
//

import net.minecraft.class_5458;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import voronoiaoc.byg.core.byglists.BYGBlockList;


public class BYGFeaturesInVanilla {
    public static void addFeatures() {
        for (Biome biome : class_5458.field_25933) {
            biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, BYGBlockList.PENDORITE_ORE.getDefaultState(), 4)).method_30374(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 16))));
            biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, BYGBlockList.ROCKY_STONE.getDefaultState(), 24)).method_30374(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 35))));
            biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, BYGBlockList.SCORIA_STONE.getDefaultState(), 24)).method_30374(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 35))));
            biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, BYGBlockList.SOAPSTONE.getDefaultState(), 24)).method_30374(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 35))));

            if (biome == Biomes.FOREST || biome == Biomes.PLAINS) {
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.ROSE_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.SHORT_GRASS_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.ANGELICA_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));

            }

            if (biome == Biomes.TAIGA || biome == Biomes.TAIGA_MOUNTAINS) {
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.BLUEBERRY_BUSH_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.SHORT_GRASS_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
            }

            if (biome == Biomes.JUNGLE || biome == Biomes.JUNGLE_HILLS) {
                BYGTreeFeatures.addRainbowTrees(Biomes.JUNGLE);
                BYGTreeFeatures.addRainbowTrees(Biomes.JUNGLE_HILLS);
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.SHORT_GRASS_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.BEGONIA_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.BISTORT_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.GUZMANIA_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.INCAN_LILY_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.LAZARUS_BELLFLOWER_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.TORCH_GINGER_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.RICHEA_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
            }

//            if (biome == Biomes.JUNGLE) {
//                biome.addStructureFeature(BYGFeatureList.BYGVILLAGE.configure(new VillageConfig("byg:village/jungle/town_centers"), 6));
//                biome.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES, BYGFeatureList.BYGVILLAGE.configure(new VillageConfig("byg:village/jungle/town_centers", 6)).method_30374(Decorator.NOPE.configure(DecoratorConfig.DEFAULT)));
//
//            }

            if (biome == Biomes.DESERT || biome == Biomes.DESERT_HILLS) {
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.SHORT_GRASS_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.MINI_CACTUS_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
            }

            if (biome == Biomes.SWAMP || biome == Biomes.SWAMP_HILLS) {
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.SHORT_GRASS_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.TINY_LILYPAD_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.WILTED_GRASS_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
            }

            if (biome == Biomes.BEACH) {
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.BEACH_GRASS_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.SHORT_BEACH_GRASS_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
            }
            if (biome == Biomes.DARK_FOREST || biome == Biomes.FOREST) {
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.LEAF_PILE_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.GREEN_MUSHROOM_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.WOOD_BLEWIT_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.WEEPING_MILKCAP_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
                biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(BYGFeatureConfigs.BLACK_PUFF_CONFIG).method_30374(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));

            }
        }
    }
}
