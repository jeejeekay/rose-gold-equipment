package net.igobyjake.rosegoldequipment.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.igobyjake.rosegoldequipment.trim.ModTrimMaterials;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {
    // trimMaterial(...) is what lets the ingot be used in a smithing table to trim armor.
    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot",
            properties -> new Item(properties.trimMaterial(ModTrimMaterials.ROSE_GOLD)));
    public static final Item ROSE_GOLD_NUGGET = registerItem("rose_gold_nugget", Item::new);
    public static final Item RAW_ROSE_GOLD = registerItem("raw_rose_gold", Item::new);

    // ---- Food ----
    public static final Item ROSE_GILDED_BEETROOT = registerItem("rose_gilded_beetroot",
            properties -> new Item(properties.food(ModFoodProperties.ROSE_GILDED_BEETROOT, ModFoodProperties.ROSE_GILDED_BEETROOT_EFFECT)));
    public static final Item ROSEY_BEETROOT_STEW = registerItem("rosey_beetroot_stew",
            properties -> new Item(properties.stacksTo(1).food(ModFoodProperties.ROSEY_BEETROOT_STEW, ModFoodProperties.ROSEY_BEETROOT_STEW_EFFECT)
                    .usingConvertsTo(Items.BOWL)));
    public static final Item ROSE_GILDED_COOKIE = registerItem("rose_gilded_cookie",
            properties -> new Item(properties.food(ModFoodProperties.ROSE_GILDED_COOKIE, ModFoodProperties.ROSE_GILDED_COOKIE_EFFECT)));
    public static final Item ROSE_GILDED_MUSHROOM = registerItem("rose_gilded_mushroom",
            properties -> new Item(properties.food(ModFoodProperties.ROSE_GILDED_MUSHROOM, ModFoodProperties.ROSE_GILDED_MUSHROOM_EFFECT)));

    // Omelette -> partial -> crumbs -> bowl (each bite leaves the next stage behind)
    public static final Item ROSE_MUSHROOM_CRUMBS = registerItem("rose_mushroom_crumbs",
            properties -> new Item(properties.stacksTo(1).food(ModFoodProperties.ROSE_MUSHROOM_CRUMBS, ModFoodProperties.ROSE_MUSHROOM_OMELETTE_EFFECT)
                    .usingConvertsTo(Items.BOWL)));
    public static final Item ROSE_MUSHROOM_PARTIAL = registerItem("rose_mushroom_partial",
            properties -> new Item(properties.stacksTo(1).food(ModFoodProperties.ROSE_MUSHROOM_PARTIAL, ModFoodProperties.ROSE_MUSHROOM_OMELETTE_EFFECT)
                    .usingConvertsTo(ROSE_MUSHROOM_CRUMBS)));
    public static final Item ROSE_MUSHROOM_OMELETTE = registerItem("rose_mushroom_omelette",
            properties -> new Item(properties.stacksTo(1).food(ModFoodProperties.ROSE_MUSHROOM_OMELETTE, ModFoodProperties.ROSE_MUSHROOM_OMELETTE_EFFECT)
                    .usingConvertsTo(ROSE_MUSHROOM_PARTIAL)));

    // Full jelly -> half jelly
    public static final Item ROSE_HALF_JELLY = registerItem("rose_half_jelly",
            properties -> new Item(properties.stacksTo(1).food(ModFoodProperties.ROSE_HALF_JELLY, ModFoodProperties.ROSE_FULL_JELLY_EFFECT)));
    public static final Item ROSE_FULL_JELLY = registerItem("rose_full_jelly",
            properties -> new Item(properties.stacksTo(1).food(ModFoodProperties.ROSE_FULL_JELLY, ModFoodProperties.ROSE_FULL_JELLY_EFFECT)
                    .usingConvertsTo(ROSE_HALF_JELLY)));

    // ---- Tools ----
    public static final Item ROSE_GOLDEN_SWORD = registerItem("rose_golden_sword",
            properties -> new Item(properties.sword(ModToolTiers.ROSE_GOLD, 4.0F, -2.4F)));
    public static final Item ROSE_GOLDEN_PICKAXE = registerItem("rose_golden_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolTiers.ROSE_GOLD, 2.0F, -2.8F)));
    public static final Item ROSE_GOLDEN_SHOVEL = registerItem("rose_golden_shovel",
            properties -> new ShovelItem(ModToolTiers.ROSE_GOLD, 2.5F, -3.0F, properties));
    public static final Item ROSE_GOLDEN_AXE = registerItem("rose_golden_axe",
            properties -> new AxeItem(ModToolTiers.ROSE_GOLD, 7.0F, -3.1F, properties));
    public static final Item ROSE_GOLDEN_HOE = registerItem("rose_golden_hoe",
            properties -> new HoeItem(ModToolTiers.ROSE_GOLD, -1.0F, -1.0F, properties));

    // ---- Armor ----
    public static final Item ROSE_GOLDEN_HELMET = registerItem("rose_golden_helmet",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final Item ROSE_GOLDEN_CHESTPLATE = registerItem("rose_golden_chestplate",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final Item ROSE_GOLDEN_LEGGINGS = registerItem("rose_golden_leggings",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final Item ROSE_GOLDEN_BOOTS = registerItem("rose_golden_boots",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, ArmorType.BOOTS)));

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        Identifier id = Identifier.fromNamespaceAndPath(rosegoldequipment.MOD_ID, name);
        return Registry.register(BuiltInRegistries.ITEM, id,
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, id))));
    }

    public static void registerModItems() {
        rosegoldequipment.LOGGER.info("Registering items for " + rosegoldequipment.MOD_ID);

        // Also list the basics in the vanilla Ingredients tab.
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.accept(ROSE_GOLD_INGOT);
            entries.accept(ROSE_GOLD_NUGGET);
            entries.accept(RAW_ROSE_GOLD);
        });
    }
}
