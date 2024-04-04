package jeejeekay.rosegoldequipment.datagen;

import jeejeekay.rosegoldequipment.item.custom.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture){
        super(output,completableFuture);
    }

@Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
    getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
            .add(ModItems.ROSE_GOLDEN_BOOTS, ModItems.ROSE_GOLDEN_CHESTPLATE, ModItems.ROSE_GOLDEN_LEGGINGS, ModItems.ROSE_GOLDEN_HELMET);
    }
}
