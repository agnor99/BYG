package potionstudios.byg.common.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import potionstudios.byg.mixin.access.WeightedListAccess;
import potionstudios.byg.util.codec.CollectionCodec;

import java.util.Collection;
import java.util.Map;

public final class LevelBiomeTracker {

    private final Map<ResourceKey<Biome>, Collection<ResourceKey<Level>>> biomeDimensions = new Object2ObjectOpenHashMap<>();
    private final Map<ResourceKey<Biome>, ObjectOpenHashSet<ResourceKey<EntityType<?>>>> biomeMobs;

    public LevelBiomeTracker(Map<ResourceKey<Level>, ObjectOpenHashSet<ResourceKey<Biome>>> biomesForLevel, Map<ResourceKey<Biome>, ObjectOpenHashSet<ResourceKey<EntityType<?>>>> biomeMobs) {
        this.biomesForLevel = biomesForLevel;
        biomesForLevel.forEach(((level, biomes) -> {
            for (ResourceKey<Biome> biome : biomes) {
                biomeDimensions.computeIfAbsent(biome, key -> new ObjectOpenHashSet<>()).add(level);
            }
        }));
        this.biomeMobs = biomeMobs;
    }

    public static LevelBiomeTracker client_instance = null;

    public static final Codec<LevelBiomeTracker> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    Codec.unboundedMap(ResourceKey.codec(Registry.DIMENSION_REGISTRY), new CollectionCodec<>(ResourceKey.codec(Registry.BIOME_REGISTRY), ObjectOpenHashSet::new)).fieldOf("biomes_for_level").forGetter(levelBiomeTracker -> levelBiomeTracker.biomesForLevel),
                    Codec.unboundedMap(ResourceKey.codec(Registry.BIOME_REGISTRY), new CollectionCodec<>(ResourceKey.codec(Registry.ENTITY_TYPE_REGISTRY), ObjectOpenHashSet::new)).fieldOf("biome_mobs").forGetter(levelBiomeTracker -> levelBiomeTracker.biomeMobs)
            ).apply(builder, LevelBiomeTracker::new));
    private final Map<ResourceKey<Level>, ObjectOpenHashSet<ResourceKey<Biome>>> biomesForLevel;


    public static LevelBiomeTracker fromServer(MinecraftServer server) {
        Object2ObjectOpenHashMap<ResourceKey<Level>, ObjectOpenHashSet<ResourceKey<Biome>>> map = new Object2ObjectOpenHashMap<>();
        Object2ObjectOpenHashMap<ResourceKey<Biome>, ObjectOpenHashSet<ResourceKey<EntityType<?>>>> entitySpawns = new Object2ObjectOpenHashMap<>();
        for (ServerLevel level : server.getAllLevels()) {
            ObjectOpenHashSet<ResourceKey<Biome>> biomes = map.computeIfAbsent(level.dimension(), key -> new ObjectOpenHashSet<>());

            for (Holder<Biome> possibleBiome : level.getChunkSource().getGenerator().getBiomeSource().possibleBiomes()) {
                ResourceKey<Biome> biomeResourceKey = possibleBiome.unwrapKey().orElseThrow();
                biomes.add(biomeResourceKey);

                for (MobCategory category : MobCategory.values()) {
                    WeightedRandomList<MobSpawnSettings.SpawnerData> mobs = possibleBiome.value().getMobSettings().getMobs(category);
                    ((WeightedListAccess<MobSpawnSettings.SpawnerData>) mobs).byg_getItems().stream().map(spawnerData -> spawnerData.type).map(entityType -> Registry.ENTITY_TYPE.getResourceKey(entityType).orElseThrow()).forEach(entityTypeResourceKey -> {
                        entitySpawns.computeIfAbsent(biomeResourceKey, key -> new ObjectOpenHashSet<>()).add(entityTypeResourceKey);
                    });

                }
            }
        }
        return new LevelBiomeTracker(map, entitySpawns);
    }

    public Map<ResourceKey<Level>, ObjectOpenHashSet<ResourceKey<Biome>>> biomesForLevel() {
        return biomesForLevel;
    }

    public Map<ResourceKey<Biome>, Collection<ResourceKey<Level>>> biomeDimensions() {
        return biomeDimensions;
    }

    public Map<ResourceKey<Biome>, ObjectOpenHashSet<ResourceKey<EntityType<?>>>> getBiomeMobs() {
        return biomeMobs;
    }

    public interface Access {
        LevelBiomeTracker levelBiomeTracker();
    }
}