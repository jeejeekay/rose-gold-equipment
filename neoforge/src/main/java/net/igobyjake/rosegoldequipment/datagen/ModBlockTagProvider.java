package net.igobyjake.rosegoldequipment.datagen;

import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.igobyjake.rosegoldequipment.block.ModBlocks;
import net.igobyjake.rosegoldequipment.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, rosegoldequipment.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Pickaxe mines these. The door/trapdoor need this too, otherwise they drop nothing
        // (they "require the correct tool", and without this there is no correct tool).
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ROSE_GOLD_BLOCK.key())
                .add(ModBlocks.RAW_ROSE_GOLD_BLOCK.key())
                .add(ModBlocks.ROSE_GOLD_DOOR.key())
                .add(ModBlocks.ROSE_GOLD_TRAPDOOR.key());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ROSE_GOLD_BLOCK.key())
                .add(ModBlocks.RAW_ROSE_GOLD_BLOCK.key());

        tag(BlockTags.DOORS).add(ModBlocks.ROSE_GOLD_DOOR.key());
        tag(BlockTags.TRAPDOORS).add(ModBlocks.ROSE_GOLD_TRAPDOOR.key());

        // Rose gold tools mine like iron.
        tag(ModTags.Blocks.INCORRECT_FOR_ROSE_GOLD_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);
    }
}
