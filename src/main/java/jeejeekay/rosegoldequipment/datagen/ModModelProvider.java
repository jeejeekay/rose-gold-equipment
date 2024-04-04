package jeejeekay.rosegoldequipment.datagen;

import jeejeekay.rosegoldequipment.block.ModBlocks;
import jeejeekay.rosegoldequipment.item.custom.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output){super(output);}

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator){
        //BlockStateModelGenerator.BlockTexturePool rosePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ROSE_GOLD_BLOCK);
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_ROSE_GOLD_BLOCK);
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROSE_GOLD_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        /*itemModelGenerator.register(ModItems.ROSE_GOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ROSE_GOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_GOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_GOLD_INGOT, Models.GENERATED);*/

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ROSE_GOLDEN_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ROSE_GOLDEN_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ROSE_GOLDEN_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ROSE_GOLDEN_HELMET));
    }
}
