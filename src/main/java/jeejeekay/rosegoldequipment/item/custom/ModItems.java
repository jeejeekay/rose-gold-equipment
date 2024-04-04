package jeejeekay.rosegoldequipment.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import jeejeekay.rosegoldequipment.RoseGoldEquipment;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
//import net.minecraft.tag.BlockTags;
//import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModItems {

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        /*entries.add(ROSE_GOLD_INGOT);
        entries.add(RAW_ROSE_GOLD);
        entries.add(ROSE_GOLDEN_PICKAXE);
        entries.add(ROSE_GOLDEN_AXE);
        entries.add(ROSE_GOLDEN_HOE);
        entries.add(ROSE_GOLDEN_SHOVEL);
        entries.add(ROSE_GOLDEN_SWORD);
        entries.add(ROSE_GOLDEN_HELMET);
        entries.add(ROSE_GOLDEN_CHESTPLATE);
        entries.add(ROSE_GOLDEN_LEGGINGS);
        entries.add(ROSE_GOLDEN_BOOTS);*/
    }
    public static void registerModItems(){
        RoseGoldEquipment.LOGGER.info("registering rose gold " + RoseGoldEquipment.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM,new Identifier(RoseGoldEquipment.MOD_ID,name),item);
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot",
        new Item(new FabricItemSettings()));
    public static final Item RAW_ROSE_GOLD = registerItem("raw_rose_gold",
            new Item(new FabricItemSettings()));
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static final Item ROSE_GOLDEN_PICKAXE = registerItem("rose_golden_pickaxe",
            new PickaxeItem(ModToolMaterials.ROSEGOLD, 4,-2.8f,
            new FabricItemSettings()));
    public static final Item ROSE_GOLDEN_SHOVEL = registerItem("rose_golden_shovel",
            new ShovelItem(ModToolMaterials.ROSEGOLD,2,-3f,
            new FabricItemSettings()));
    public static final Item ROSE_GOLDEN_AXE = registerItem("rose_golden_axe",
            new AxeItem(ModToolMaterials.ROSEGOLD,4,-3f,
                    new FabricItemSettings()));
    public static final Item ROSE_GOLDEN_HOE = registerItem("rose_golden_hoe",
            new HoeItem(ModToolMaterials.ROSEGOLD,0,-2f,
                    new FabricItemSettings()));
    public static final Item ROSE_GOLDEN_SWORD = registerItem("rose_golden_sword",
            new SwordItem(ModToolMaterials.ROSEGOLD,3,-2.4f,
                    new FabricItemSettings()));
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static final Item ROSE_GOLDEN_HELMET = registerItem("rose_golden_helmet",
            new ArmorItem(ModArmorMaterials.ROSEGOLD, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ROSE_GOLDEN_CHESTPLATE = registerItem("rose_golden_chestplate",
            new ArmorItem(ModArmorMaterials.ROSEGOLD, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ROSE_GOLDEN_LEGGINGS = registerItem("rose_golden_leggings",
            new ArmorItem(ModArmorMaterials.ROSEGOLD, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ROSE_GOLDEN_BOOTS = registerItem("rose_golden_boots",
            new ArmorItem(ModArmorMaterials.ROSEGOLD, ArmorItem.Type.BOOTS, new FabricItemSettings()));

}
