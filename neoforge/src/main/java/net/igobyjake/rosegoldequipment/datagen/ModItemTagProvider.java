package net.igobyjake.rosegoldequipment.datagen;

import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.igobyjake.rosegoldequipment.item.ModItems;
import net.igobyjake.rosegoldequipment.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, rosegoldequipment.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModTags.Items.ROSE_GOLD_REPAIRABLE)
                .add(ModItems.ROSE_GOLD_INGOT.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.ROSE_GOLDEN_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.ROSE_GOLDEN_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.ROSE_GOLDEN_SHOVEL.get());
        tag(ItemTags.AXES)
                .add(ModItems.ROSE_GOLDEN_AXE.get());
        tag(ItemTags.HOES)
                .add(ModItems.ROSE_GOLDEN_HOE.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ROSE_GOLDEN_HELMET.get())
                .add(ModItems.ROSE_GOLDEN_CHESTPLATE.get())
                .add(ModItems.ROSE_GOLDEN_LEGGINGS.get())
                .add(ModItems.ROSE_GOLDEN_BOOTS.get());

        this.tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.ROSE_GOLD_INGOT.get());
    }
}
