package net.igobyjake.rosegoldequipment.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.igobyjake.rosegoldequipment.block.ModBlocks;
import net.igobyjake.rosegoldequipment.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Pickaxe mines these. The door/trapdoor need this too, otherwise they drop nothing
        // (they "require the correct tool", and without this there is no correct tool).
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(key(ModBlocks.ROSE_GOLD_BLOCK))
                .add(key(ModBlocks.RAW_ROSE_GOLD_BLOCK))
                .add(key(ModBlocks.ROSE_GOLD_DOOR))
                .add(key(ModBlocks.ROSE_GOLD_TRAPDOOR));

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(key(ModBlocks.ROSE_GOLD_BLOCK))
                .add(key(ModBlocks.RAW_ROSE_GOLD_BLOCK));

        tag(BlockTags.DOORS).add(key(ModBlocks.ROSE_GOLD_DOOR));
        tag(BlockTags.TRAPDOORS).add(key(ModBlocks.ROSE_GOLD_TRAPDOOR));

        // Rose gold tools mine like iron.
        tag(ModTags.Blocks.INCORRECT_FOR_ROSE_GOLD_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);
    }

    // Since 26.2, tags are built from registry keys instead of the block objects.
    private static ResourceKey<Block> key(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).orElseThrow();
    }
}
