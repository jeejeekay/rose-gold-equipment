package net.igobyjake.rosegoldequipment.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.igobyjake.rosegoldequipment.block.ModBlocks;
import net.igobyjake.rosegoldequipment.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Pickaxe mines these. The door/trapdoor need this too, otherwise they drop nothing
        // (they "require the correct tool", and without this there is no correct tool).
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ROSE_GOLD_BLOCK)
                .add(ModBlocks.RAW_ROSE_GOLD_BLOCK)
                .add(ModBlocks.ROSE_GOLD_DOOR)
                .add(ModBlocks.ROSE_GOLD_TRAPDOOR);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ROSE_GOLD_BLOCK)
                .add(ModBlocks.RAW_ROSE_GOLD_BLOCK);

        valueLookupBuilder(BlockTags.DOORS).add(ModBlocks.ROSE_GOLD_DOOR);
        valueLookupBuilder(BlockTags.TRAPDOORS).add(ModBlocks.ROSE_GOLD_TRAPDOOR);

        // Rose gold tools mine like iron.
        valueLookupBuilder(ModTags.Blocks.INCORRECT_FOR_ROSE_GOLD_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);
    }
}
