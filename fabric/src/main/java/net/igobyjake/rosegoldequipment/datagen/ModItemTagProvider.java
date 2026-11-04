package net.igobyjake.rosegoldequipment.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.igobyjake.rosegoldequipment.block.ModBlocks;
import net.igobyjake.rosegoldequipment.item.ModItems;
import net.igobyjake.rosegoldequipment.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        valueLookupBuilder(ModTags.Items.ROSE_GOLD_REPAIR)
                .add(ModItems.ROSE_GOLD_INGOT);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.ROSE_GOLDEN_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.ROSE_GOLDEN_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.ROSE_GOLDEN_SHOVEL);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.ROSE_GOLDEN_AXE);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.ROSE_GOLDEN_HOE);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ROSE_GOLDEN_HELMET)
                .add(ModItems.ROSE_GOLDEN_CHESTPLATE)
                .add(ModItems.ROSE_GOLDEN_LEGGINGS)
                .add(ModItems.ROSE_GOLDEN_BOOTS);

        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.ROSE_GOLD_INGOT);
    }
}
