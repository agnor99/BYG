package potionstudios.byg.common.world.structure.arch;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.*;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.NoisySphereConfig;
import potionstudios.byg.common.world.structure.BYGStructurePieceTypes;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ArchPiece extends StructurePiece {

    public static final boolean DEBUG = false;

    private final Set<BlockPos> positions = new HashSet<>();
    private final NoisySphereConfig config;

    public ArchPiece(Set<BlockPos> positions, NoisySphereConfig config, int $$1, BoundingBox $$2) {
        super(BYGStructurePieceTypes.ARCH_PIECE, $$1, $$2);
        this.config = config;
        this.positions.addAll(positions);
    }

    public ArchPiece(StructurePieceSerializationContext context, CompoundTag tag) {
        super(BYGStructurePieceTypes.ARCH_PIECE, tag);

        RegistryOps<Tag> tagRegistryOps = RegistryOps.create(NbtOps.INSTANCE, context.registryAccess());

        ListTag positions = tag.getList("positions", Tag.TAG_COMPOUND);

        for (Tag position : positions) {
            this.positions.add(NbtUtils.readBlockPos((CompoundTag) position));
        }
        this.config = NoisySphereConfig.CODEC.decode(tagRegistryOps, tag.get("config")).result().orElseThrow().getFirst();
    }

    @Override
    protected void addAdditionalSaveData(StructurePieceSerializationContext context, CompoundTag compoundTag) {
        ListTag positions = new ListTag();

        RegistryOps<Tag> tagRegistryOps = RegistryOps.create(NbtOps.INSTANCE, context.registryAccess());

        for (BlockPos position : this.positions) {
            positions.add(NbtUtils.writeBlockPos(position));
        }
        compoundTag.put("positions", positions);
        compoundTag.put("config", NoisySphereConfig.CODEC.encodeStart(tagRegistryOps, this.config).result().orElseThrow());
    }

    @Override
    public void postProcess(WorldGenLevel worldGenLevel, StructureFeatureManager structureFeatureManager, ChunkGenerator chunkGenerator, Random random, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
        Long2ObjectOpenHashMap<BlockState> toPlace = new Long2ObjectOpenHashMap<>(1000);

        for (BlockPos position : this.positions) {
            if (position.getY() == Integer.MIN_VALUE) {
                position = new BlockPos(position.getX(), worldGenLevel.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, position.getX(), position.getZ()) + 1, position.getZ());
            }

            if (DEBUG) {
                worldGenLevel.setBlock(position, Blocks.GLOWSTONE.defaultBlockState(), 2);
            } else {
                BYGFeatures.BOULDER.fillList(toPlace, worldGenLevel.getSeed(), random, position, config);
            }
        }
        toPlace.forEach((aLong, state) -> {
            worldGenLevel.setBlock(BlockPos.of(aLong), state, 2);
        });

        for (long aLong : toPlace.keySet()) {
            for (Holder<PlacedFeature> spawningFeature : config.spawningFeatures()) {
                spawningFeature.value().place(worldGenLevel, chunkGenerator, random, BlockPos.of(aLong));
            }
        }

    }
}
