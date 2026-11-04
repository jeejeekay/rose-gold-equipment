package net.igobyjake.rosegoldequipment.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.igobyjake.rosegoldequipment.item.ModItems;
import net.igobyjake.rosegoldequipment.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.ROSE_GOLD_REPAIRABLE).add(key(ModItems.ROSE_GOLD_INGOT));

        tag(ItemTags.SWORDS).add(key(ModItems.ROSE_GOLDEN_SWORD));
        tag(ItemTags.PICKAXES).add(key(ModItems.ROSE_GOLDEN_PICKAXE));
        tag(ItemTags.SHOVELS).add(key(ModItems.ROSE_GOLDEN_SHOVEL));
        tag(ItemTags.AXES).add(key(ModItems.ROSE_GOLDEN_AXE));
        tag(ItemTags.HOES).add(key(ModItems.ROSE_GOLDEN_HOE));

        // Vanilla builds "trimmable armor" and the armor enchanting tags from these four,
        // so this one step makes the armor trimmable AND enchantable.
        tag(ItemTags.HEAD_ARMOR).add(key(ModItems.ROSE_GOLDEN_HELMET));
        tag(ItemTags.CHEST_ARMOR).add(key(ModItems.ROSE_GOLDEN_CHESTPLATE));
        tag(ItemTags.LEG_ARMOR).add(key(ModItems.ROSE_GOLDEN_LEGGINGS));
        tag(ItemTags.FOOT_ARMOR).add(key(ModItems.ROSE_GOLDEN_BOOTS));

        // Lets the ingot go in the smithing table's material slot.
        tag(ItemTags.TRIM_MATERIALS).add(key(ModItems.ROSE_GOLD_INGOT));
    }

    // Since 26.2, tags are built from registry keys instead of the item objects.
    private static ResourceKey<Item> key(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).orElseThrow();
    }
}
