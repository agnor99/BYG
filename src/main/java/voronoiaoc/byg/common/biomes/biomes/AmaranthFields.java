package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.Optional;
import java.util.Random;

public class AmaranthFields extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG);
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final Category CATEGORY = Category.PLAINS;
    static final float DEPTH = 0.125F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 0.8F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Weather WEATHER = new Weather(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.class_5496 SPAWN_SETTINGS = new SpawnSettings.class_5496();
    static final GenerationSettings.class_5495 GENERATION_SETTINGS = (new GenerationSettings.class_5495()).method_30996(SURFACE_BUILDER);

    public AmaranthFields() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).skyColor(BiomeHelper.calcSkyColor(0.8F)).moodSound(BiomeMoodSound.CAVE).build(), GENERATION_SETTINGS.method_30987(), SPAWN_SETTINGS.method_31007(), Optional.ofNullable(PARENT));
        ////StructureFeature.VILLAGE.configure(new StructurePoolFeatureConfig(new Identifier("village/plains/town_centers"), 6));
//        //this.add//StructureFeature(DefaultBiomeFeatures.PILLAGER_OUTPOST);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(GENERATION_SETTINGS);
        BYGFeatures.addAmaranthFieldFlowers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addLandCarvers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDungeons(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addMineables(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultOres(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addFrozenTopLayer(GENERATION_SETTINGS);

        SPAWN_SETTINGS.method_31011(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 12, 4, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PIG, 10, 4, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.COW, 8, 4, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.HORSE, 5, 2, 6));
        SPAWN_SETTINGS.method_31011(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.DONKEY, 1, 1, 3));
        SPAWN_SETTINGS.method_31011(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 5, 1, 1));

    }

    @Override
    public Biome getRiver() {
        return Biomes.RIVER;
    }

    @Override
    public Biome getHill() {
        Random rand = new Random();
        return (rand.nextInt(5) == 0) ? BYGBiomeList.FRESHWATERLAKE : BYGBiomeList.JACARANDAFOREST;
    }

    @Override
    public Biome getEdge() {
        return null;
    }

    @Override
    public Biome getBeach() {
        return null;
    }

    @Override
    public Biome getMutation() {
        return null;
    }
}