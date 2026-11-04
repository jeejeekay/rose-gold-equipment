package net.igobyjake.rosegoldequipment.datagen;

import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.igobyjake.rosegoldequipment.block.ModBlocks;
import net.igobyjake.rosegoldequipment.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, rosegoldequipment.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.ROSE_GOLD_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_GOLD_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_ROSE_GOLD.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.ROSE_MUSHROOM_CRUMBS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_MUSHROOM_PARTIAL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_MUSHROOM_OMELETTE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_HALF_JELLY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_FULL_JELLY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_GILDED_BEETROOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_GILDED_COOKIE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_GILDED_MUSHROOM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSEY_BEETROOT_STEW.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.ROSE_GOLDEN_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_GOLDEN_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_GOLDEN_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_GOLDEN_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_GOLDEN_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        TrimmedArmorModels.generate(itemModels, ModItems.ROSE_GOLDEN_HELMET.get(), ItemModelGenerators.TRIM_PREFIX_HELMET);
        TrimmedArmorModels.generate(itemModels, ModItems.ROSE_GOLDEN_CHESTPLATE.get(), ItemModelGenerators.TRIM_PREFIX_CHESTPLATE);
        TrimmedArmorModels.generate(itemModels, ModItems.ROSE_GOLDEN_LEGGINGS.get(), ItemModelGenerators.TRIM_PREFIX_LEGGINGS);
        TrimmedArmorModels.generate(itemModels, ModItems.ROSE_GOLDEN_BOOTS.get(), ItemModelGenerators.TRIM_PREFIX_BOOTS);

        /* BLOCKS */
        blockModels.createTrivialCube(ModBlocks.RAW_ROSE_GOLD_BLOCK.get());

        blockModels.family(ModBlocks.ROSE_GOLD_BLOCK.get())
                .door(ModBlocks.ROSE_GOLD_DOOR.get())
                .trapdoor(ModBlocks.ROSE_GOLD_TRAPDOOR.get());

    }

}
