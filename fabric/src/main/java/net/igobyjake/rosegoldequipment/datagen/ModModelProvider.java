package net.igobyjake.rosegoldequipment.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.igobyjake.rosegoldequipment.block.ModBlocks;
import net.igobyjake.rosegoldequipment.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModels) {
        blockModels.createTrivialCube(ModBlocks.ROSE_GOLD_BLOCK);
        blockModels.createTrivialCube(ModBlocks.RAW_ROSE_GOLD_BLOCK);
        blockModels.createDoor(ModBlocks.ROSE_GOLD_DOOR);
        blockModels.createOrientableTrapdoor(ModBlocks.ROSE_GOLD_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.ROSE_GOLD_INGOT, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_GOLD_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_ROSE_GOLD, ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.ROSE_GILDED_BEETROOT, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_GILDED_COOKIE, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_GILDED_MUSHROOM, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSEY_BEETROOT_STEW, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_MUSHROOM_OMELETTE, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_MUSHROOM_PARTIAL, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_MUSHROOM_CRUMBS, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_FULL_JELLY, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_HALF_JELLY, ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.ROSE_GOLDEN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_GOLDEN_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_GOLDEN_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_GOLDEN_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.ROSE_GOLDEN_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        // Armor icons that show trims, including rose gold trims.
        TrimmedArmorModels.generate(itemModels, ModItems.ROSE_GOLDEN_HELMET, ItemModelGenerators.TRIM_PREFIX_HELMET);
        TrimmedArmorModels.generate(itemModels, ModItems.ROSE_GOLDEN_CHESTPLATE, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE);
        TrimmedArmorModels.generate(itemModels, ModItems.ROSE_GOLDEN_LEGGINGS, ItemModelGenerators.TRIM_PREFIX_LEGGINGS);
        TrimmedArmorModels.generate(itemModels, ModItems.ROSE_GOLDEN_BOOTS, ItemModelGenerators.TRIM_PREFIX_BOOTS);
    }
}
