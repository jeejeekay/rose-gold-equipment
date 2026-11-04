package net.igobyjake.rosegoldequipment.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.igobyjake.rosegoldequipment.block.ModBlocks;
import net.igobyjake.rosegoldequipment.item.ModArmorMaterials;
import net.igobyjake.rosegoldequipment.item.ModItems;
import net.minecraft.client.data.*;
import net.minecraft.client.item.ItemAsset;
import net.minecraft.client.render.item.model.ConditionItemModel;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.property.bool.HasComponentProperty;
import net.minecraft.client.render.model.json.ModelVariant;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool roseGoldPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROSE_GOLD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_ROSE_GOLD_BLOCK);

        blockStateModelGenerator.registerDoor(ModBlocks.ROSE_GOLD_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.ROSE_GOLD_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ROSE_GOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_GOLD_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ROSE_GOLD, Models.GENERATED);

        itemModelGenerator.register(ModItems.ROSE_GILDED_BEETROOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_GILDED_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_GILDED_MUSHROOM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSEY_BEETROOT_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_MUSHROOM_OMELETTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_MUSHROOM_PARTIAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_MUSHROOM_CRUMBS, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_FULL_JELLY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_HALF_JELLY, Models.GENERATED);

        itemModelGenerator.register(ModItems.ROSE_GOLDEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROSE_GOLDEN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROSE_GOLDEN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROSE_GOLDEN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROSE_GOLDEN_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(ModItems.ROSE_GOLDEN_HELMET, ModArmorMaterials.ROSE_GOLD_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ROSE_GOLDEN_CHESTPLATE, ModArmorMaterials.ROSE_GOLD_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ROSE_GOLDEN_LEGGINGS, ModArmorMaterials.ROSE_GOLD_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ROSE_GOLDEN_BOOTS, ModArmorMaterials.ROSE_GOLD_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

    }
}
