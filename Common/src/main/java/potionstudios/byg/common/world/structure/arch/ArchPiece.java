package potionstudios.byg.common.world.structure.arch;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.DataResult;
import it.unimi.dsi.fastutil.longs.Long2ObjectLinkedOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.*;
import net.minecraft.resources.RegistryOps;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.NoisySphereConfig;
import potionstudios.byg.common.world.structure.BYGStructurePieceTypes;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ArchPiece extends StructurePiece {

    public static final boolean DEBUG = false;

    private final Set<BlockPos> positions = new HashSet<>();
    private final NoisySphereConfig config;

    public ArchPiece(Set<BlockPos> positions, NoisySphereConfig config, int $$1, BoundingBox generatingBB) {
        super(BYGStructurePieceTypes.ARCH_PIECE.get(), $$1, generatingBB);
        this.config = config;
        this.positions.addAll(positions);
    }

    public ArchPiece(StructurePieceSerializationContext context, CompoundTag tag) {
        super(BYGStructurePieceTypes.ARCH_PIECE.get(), tag);

        RegistryOps<Tag> tagRegistryOps = RegistryOps.create(NbtOps.INSTANCE, context.registryAccess());

        ListTag positions = tag.getList("positions", Tag.TAG_COMPOUND);

        for (Tag position : positions) {
            this.positions.add(NbtUtils.readBlockPos((CompoundTag) position));
        }

        if (!tag.contains("config")) {
            BYG.LOGGER.error("No arch config info was present.");
        }
        DataResult<Pair<NoisySphereConfig, Tag>> config1 = NoisySphereConfig.CODEC.decode(tagRegistryOps, tag.get("config"));
        config1.error().ifPresent(tagPartialResult -> BYG.LOGGER.error("BYG Arch piece config deserialization error: " + tagPartialResult));

        this.config = config1.result().orElseThrow().getFirst();
    }

    @Override
    protected void addAdditionalSaveData(StructurePieceSerializationContext context, CompoundTag compoundTag) {
        ListTag positions = new ListTag();

        RegistryOps<Tag> tagRegistryOps = RegistryOps.create(NbtOps.INSTANCE, context.registryAccess());

        for (BlockPos position : this.positions) {
            positions.add(NbtUtils.writeBlockPos(position));
        }
        compoundTag.put("positions", positions);
        DataResult<Tag> encodeStart = NoisySphereConfig.CODEC.encodeStart(tagRegistryOps, this.config);
        Optional<DataResult.PartialResult<Tag>> error = encodeStart.error();
        error.ifPresent(tagPartialResult -> BYG.LOGGER.error("BYG Arch piece serialization error: " + tagPartialResult));


        compoundTag.put("config", encodeStart.result().orElseThrow());
    }

    @Override
    public void postProcess(WorldGenLevel worldGenLevel, StructureManager structureFeatureManager, ChunkGenerator chunkGenerator, RandomSource random, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
        Long2ObjectLinkedOpenHashMap<BlockState> toPlace = new Long2ObjectLinkedOpenHashMap<>(1000);

        for (BlockPos position : this.positions) {
            if (position.getY() == Integer.MIN_VALUE) {
                position = new BlockPos(position.getX(), worldGenLevel.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, position.getX(), position.getZ()) + 1, position.getZ());
            }

            if (!boundingBox.isInside(position)) {
                continue;
            }

            if (DEBUG) {
                worldGenLevel.setBlock(position, Blocks.GLOWSTONE.defaultBlockState(), 2);
            } else {
                BYGFeatures.BOULDER.get().fillList(toPlace, worldGenLevel.getSeed(), random, position, config);
            }
        }

        if (toPlace.isEmpty()) {
            return;
        }

        BlockPos.MutableBlockPos min = new BlockPos.MutableBlockPos().set(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        BlockPos.MutableBlockPos max = new BlockPos.MutableBlockPos().set(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

        toPlace.forEach((aLong, state) -> {
            BlockPos pos = BlockPos.of(aLong);
            min.set(Math.min(min.getX(), pos.getX()), Math.min(min.getY(), pos.getY()), Math.min(min.getZ(), pos.getZ()));
            max.set(Math.max(max.getX(), pos.getX()), Math.max(max.getY(), pos.getY()), Math.max(max.getZ(), pos.getZ()));
            worldGenLevel.setBlock(pos, state, 2);
        });


        for (long aLong : toPlace.keySet()) {
            for (Holder<PlacedFeature> spawningFeature : config.spawningFeatures()) {
                spawningFeature.value().place(worldGenLevel, chunkGenerator, random, BlockPos.of(aLong));
            }
        }

        int minX = min.getX() - ArchStructure.PIECE_BB_EXPANSION;
        int minY = min.getY() - ArchStructure.PIECE_BB_EXPANSION;
        int minZ = min.getZ() - ArchStructure.PIECE_BB_EXPANSION;
        int maxX = max.getX() + ArchStructure.PIECE_BB_EXPANSION;
        int maxY = max.getY() + ArchStructure.PIECE_BB_EXPANSION;
        int maxZ = max.getZ() + ArchStructure.PIECE_BB_EXPANSION;
        this.boundingBox = new BoundingBox(minX, minY, minZ, maxX, maxY, maxZ);
    }
}