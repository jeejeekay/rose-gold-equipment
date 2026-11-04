package net.igobyjake.rosegoldequipment.datagen;

import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.igobyjake.rosegoldequipment.item.ModItems;
import net.igobyjake.rosegoldequipment.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, rosegoldequipment.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.ROSE_GOLD_REPAIRABLE).add(ModItems.ROSE_GOLD_INGOT.get());

        tag(ItemTags.SWORDS).add(ModItems.ROSE_GOLDEN_SWORD.get());
        tag(ItemTags.PICKAXES).add(ModItems.ROSE_GOLDEN_PICKAXE.get());
        tag(ItemTags.SHOVELS).add(ModItems.ROSE_GOLDEN_SHOVEL.get());
        tag(ItemTags.AXES).add(ModItems.ROSE_GOLDEN_AXE.get());
        tag(ItemTags.HOES).add(ModItems.ROSE_GOLDEN_HOE.get());

        // Vanilla builds "trimmable armor" and the armor enchanting tags from these four,
        // so this one step makes the armor trimmable AND enchantable.
        tag(ItemTags.HEAD_ARMOR).add(ModItems.ROSE_GOLDEN_HELMET.get());
        tag(ItemTags.CHEST_ARMOR).add(ModItems.ROSE_GOLDEN_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR).add(ModItems.ROSE_GOLDEN_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR).add(ModItems.ROSE_GOLDEN_BOOTS.get());

        // Lets the ingot go in the smithing table's material slot.
        tag(ItemTags.TRIM_MATERIALS).add(ModItems.ROSE_GOLD_INGOT.get());
    }
}
