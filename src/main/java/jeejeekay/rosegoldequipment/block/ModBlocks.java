package jeejeekay.rosegoldequipment.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import jeejeekay.rosegoldequipment.RoseGoldEquipment;
//import jeejeekay.rosegoldequipment.block.custom.ModDoorBlock;
//import jeejeekay.rosegoldequipment.block.custom.ModTrapdoorBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
//import net.minecraft.BlockSetType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
//import net.minecraft.util.registry.Registry;

public class ModBlocks {

    //public static final BlockSetType ROSE_GOLD_TYPE = BlockSetType.register(new BlockSetType("rose_gold_type", false, BlockSoundGroup.METAL, SoundEvents.BLOCK_IRON_DOOR_CLOSE, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE, SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN, SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON, SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON));

    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4f).requiresTool())
    );
    public static final Block RAW_ROSE_GOLD_BLOCK = registerBlock("raw_rose_gold_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4f).requiresTool())
    );
    public static final Block ROSE_GOLD_DOOR = registerBlock("rose_gold_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_DOOR).strength(4f).requiresTool(), BlockSetType.CHERRY));
    public static final Block ROSE_GOLD_TRAPDOOR = registerBlock("rose_gold_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_TRAPDOOR).strength(4f).requiresTool(), BlockSetType.CHERRY));

    private static Item registerBlockItem(String name, Block block)
    {
        return Registry.register(Registries.ITEM, new Identifier(RoseGoldEquipment.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(RoseGoldEquipment.MOD_ID, name), block);
    }
    /*private static Item registerBlockItem(String name, Block block){
        Item item = Registry.register(Registry.ITEM, new Identifier(rosegoldequipment.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }*/
    public static void registerModBlocks(){
        RoseGoldEquipment.LOGGER.info("Registering ModBlocks for " + RoseGoldEquipment.MOD_ID);
    }
}
