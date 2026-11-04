package net.igobyjake.rosegoldequipment.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.igobyjake.rosegoldequipment.trim.ModTrimMaterials;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {
    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot", settings -> new Item(settings.trimMaterial(ModTrimMaterials.ROSE_GOLD)));
    public static final Item ROSE_GOLD_NUGGET = registerItem("rose_gold_nugget", Item::new);
    public static final Item RAW_ROSE_GOLD = registerItem("raw_rose_gold", Item::new);
    
    public static final Item ROSE_GILDED_BEETROOT = registerItem("rose_gilded_beetroot",
            setting -> new Item(setting.food(ModFoodComponents.ROSE_GILDED_BEETROOT,ModFoodComponents.ROSE_GILDED_BEETROOT_EFFECT)));
    public static final Item ROSEY_BEETROOT_STEW = registerItem("rosey_beetroot_stew",
            setting -> new Item(setting.maxCount(1).food(ModFoodComponents.ROSEY_BEETROOT_STEW,ModFoodComponents.ROSEY_BEETROOT_STEW_EFFECT)
                    .useRemainder(Items.BOWL)));
    public static final Item ROSE_MUSHROOM_CRUMBS = registerItem("rose_mushroom_crumbs",
            setting -> new Item(setting.maxCount(1).food(ModFoodComponents.ROSE_MUSHROOM_CRUMBS,ModFoodComponents.ROSE_MUSHROOM_OMELETTE_EFFECT)
                    .useRemainder(Items.BOWL)));
    public static final Item ROSE_MUSHROOM_PARTIAL = registerItem("rose_mushroom_partial",
            setting -> new Item(setting.maxCount(1).food(ModFoodComponents.ROSE_MUSHROOM_PARTIAL,ModFoodComponents.ROSE_MUSHROOM_OMELETTE_EFFECT)
                    .useRemainder(ModItems.ROSE_MUSHROOM_CRUMBS)));
    public static final Item ROSE_MUSHROOM_OMELETTE = registerItem("rose_mushroom_omelette",
            setting -> new Item(setting.maxCount(1).food(ModFoodComponents.ROSE_MUSHROOM_OMELETTE,ModFoodComponents.ROSE_MUSHROOM_OMELETTE_EFFECT)
                    .useRemainder(ModItems.ROSE_MUSHROOM_PARTIAL)));
    public static final Item ROSE_HALF_JELLY = registerItem("rose_half_jelly",
            setting -> new Item(setting.maxCount(1).food(ModFoodComponents.ROSE_HALF_JELLY,ModFoodComponents.ROSE_FULL_JELLY_EFFECT)));
    public static final Item ROSE_FULL_JELLY = registerItem("rose_full_jelly",
            setting -> new Item(setting.maxCount(1).food(ModFoodComponents.ROSE_FULL_JELLY,ModFoodComponents.ROSE_FULL_JELLY_EFFECT)
                    .useRemainder(ModItems.ROSE_HALF_JELLY)));
    public static final Item ROSE_GILDED_MUSHROOM = registerItem("rose_gilded_mushroom",
            setting -> new Item(setting.food(ModFoodComponents.ROSE_GILDED_MUSHROOM,ModFoodComponents.ROSE_GILDED_MUSHROOM_EFFECT)));

    public static final Item ROSE_GILDED_COOKIE = registerItem("rose_gilded_cookie",
            setting -> new Item(setting.food(ModFoodComponents.ROSE_GILDED_COOKIE,ModFoodComponents.ROSE_GILDED_COOKIE_EFFECT)));
    
    public static final Item ROSE_GOLDEN_SWORD = registerItem("rose_golden_sword",
            setting -> new Item(setting.sword(ModToolMaterials.ROSE_GOLD, 4.0F, -2.4F)));
    public static final Item ROSE_GOLDEN_PICKAXE = registerItem("rose_golden_pickaxe",
            setting -> new Item(setting.pickaxe(ModToolMaterials.ROSE_GOLD, 2.0F, -2.8F)));
    public static final Item ROSE_GOLDEN_SHOVEL = registerItem("rose_golden_shovel",
            setting -> new ShovelItem(ModToolMaterials.ROSE_GOLD, 2.5F, -3.0F, setting));
    public static final Item ROSE_GOLDEN_AXE = registerItem("rose_golden_axe",
            setting -> new AxeItem(ModToolMaterials.ROSE_GOLD, 7.0F, -3.1F, setting));
    public static final Item ROSE_GOLDEN_HOE = registerItem("rose_golden_hoe",
            setting -> new HoeItem(ModToolMaterials.ROSE_GOLD, -1.0F, -1.0F, setting));


    public static final Item ROSE_GOLDEN_HELMET = registerItem("rose_golden_helmet",
            setting -> new Item(setting.armor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item ROSE_GOLDEN_CHESTPLATE = registerItem("rose_golden_chestplate",
            setting -> new Item(setting.armor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item ROSE_GOLDEN_LEGGINGS = registerItem("rose_golden_leggings",
            setting -> new Item(setting.armor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item ROSE_GOLDEN_BOOTS = registerItem("rose_golden_boots",
            setting -> new Item(setting.armor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, EquipmentType.BOOTS)));
    


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(rosegoldequipment.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(rosegoldequipment.MOD_ID, name)))));
    }
    public static void registerModItems() {
        rosegoldequipment.LOGGER.info("Welcome Rosey World - " + rosegoldequipment.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ROSE_GOLD_INGOT);
            entries.add(ROSE_GOLD_NUGGET);
            entries.add(RAW_ROSE_GOLD);
        });
    }
}