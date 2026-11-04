package net.igobyjake.rosegoldequipment.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.igobyjake.rosegoldequipment.item.ModItems;
import net.igobyjake.rosegoldequipment.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(ModTags.Items.ROSE_GOLD_REPAIRABLE).add(ModItems.ROSE_GOLD_INGOT);

        valueLookupBuilder(ItemTags.SWORDS).add(ModItems.ROSE_GOLDEN_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES).add(ModItems.ROSE_GOLDEN_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS).add(ModItems.ROSE_GOLDEN_SHOVEL);
        valueLookupBuilder(ItemTags.AXES).add(ModItems.ROSE_GOLDEN_AXE);
        valueLookupBuilder(ItemTags.HOES).add(ModItems.ROSE_GOLDEN_HOE);

        // Vanilla builds "trimmable armor" and the armor enchanting tags from these four,
        // so this one step makes the armor trimmable AND enchantable.
        valueLookupBuilder(ItemTags.HEAD_ARMOR).add(ModItems.ROSE_GOLDEN_HELMET);
        valueLookupBuilder(ItemTags.CHEST_ARMOR).add(ModItems.ROSE_GOLDEN_CHESTPLATE);
        valueLookupBuilder(ItemTags.LEG_ARMOR).add(ModItems.ROSE_GOLDEN_LEGGINGS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR).add(ModItems.ROSE_GOLDEN_BOOTS);

        // Lets the ingot go in the smithing table's material slot.
        valueLookupBuilder(ItemTags.TRIM_MATERIALS).add(ModItems.ROSE_GOLD_INGOT);
    }
}
