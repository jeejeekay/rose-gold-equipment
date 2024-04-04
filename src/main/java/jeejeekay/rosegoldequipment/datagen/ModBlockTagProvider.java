package jeejeekay.rosegoldequipment.datagen;

import jeejeekay.rosegoldequipment.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider
{
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg){
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(ModBlocks.RAW_ROSE_GOLD_BLOCK)
            .add(ModBlocks.ROSE_GOLD_BLOCK)
            .add(ModBlocks.ROSE_GOLD_DOOR)
            .add(ModBlocks.ROSE_GOLD_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.RAW_ROSE_GOLD_BLOCK)
            .add(ModBlocks.ROSE_GOLD_BLOCK)
            .add(ModBlocks.ROSE_GOLD_DOOR)
            .add(ModBlocks.ROSE_GOLD_TRAPDOOR);

    }
}
