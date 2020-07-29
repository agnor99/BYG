package voronoiaoc.byg.common.biomes.subbiomes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeHelper;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import voronoiaoc.byg.core.byglists.BYGSBList;

import java.util.Optional;

public class NorthernForest extends Biome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(BYGSBList.BOREAL_SB, SurfaceBuilder.GRASS_CONFIG);
    static final Precipitation PRECIPATATION = Precipitation.SNOW;
    static final Category CATEGORY = Category.ICY;
    static final float DEPTH = 0.15F;
    static final float SCALE = 0.1F;
    static final float TEMPERATURE = -0.15F;
    static final float DOWNFALL = 0.4F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;
    static final Weather WEATHER = new Weather(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.class_5496 SPAWN_SETTINGS = new SpawnSettings.class_5496();
    static final GenerationSettings.class_5495 GENERATION_SETTINGS = (new GenerationSettings.class_5495()).method_30996(SURFACE_BUILDER);

    public NorthernForest() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).skyColor(BiomeHelper.calcSkyColor(0.8F)).moodSound(BiomeMoodSound.CAVE).build(), GENERATION_SETTINGS.method_30987(), SPAWN_SETTINGS.method_31007(), Optional.ofNullable(PARENT));
//this.add//StructureFeature(DefaultBiomeFeatures.PILLAGER_OUTPOST);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addLandCarvers(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDungeons(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addMineables(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultOres(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultDisks(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultMushrooms(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addDefaultVegetation(GENERATION_SETTINGS);
        BYGFeatures.addGrass(GENERATION_SETTINGS);
        BYGFeatures.addBYGMushrooms(GENERATION_SETTINGS);
        BYGFeatures.addWinterScilla(GENERATION_SETTINGS);
        BYGFeatures.addWinterRose(GENERATION_SETTINGS);
        BYGFeatures.addSnowdrops(GENERATION_SETTINGS);
        BYGFeatures.addRockyStoneBoulder(GENERATION_SETTINGS);
        BYGTreeFeatures.addNorthernForestTrees(GENERATION_SETTINGS);
        DefaultBiomeFeatures.addFrozenTopLayer(GENERATION_SETTINGS);

        SPAWN_SETTINGS.method_31011(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SNOW_GOLEM, 1, 1, 2));
        SPAWN_SETTINGS.method_31011(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 10, 2, 3));
        SPAWN_SETTINGS.method_31011(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.POLAR_BEAR, 1, 1, 2));
        SPAWN_SETTINGS.method_31011(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 10, 8, 8));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 100, 4, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 5, 1, 1));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 20, 4, 4));
        SPAWN_SETTINGS.method_31011(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.STRAY, 80, 4, 4));
    }

    @Override
    public int getGrassColorAt(double posX, double posZ) {
        return 9192767;
    }

    @Override
    public int getFoliageColor() {
        return 10044989;
    }

//    @Override
//    public Biome getRiver() {
//        return Biomes.RIVER;
//    }
}
