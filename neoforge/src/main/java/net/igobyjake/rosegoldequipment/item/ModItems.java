package net.igobyjake.rosegoldequipment.item;

import net.igobyjake.rosegoldequipment.config.RgeConfig;
import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.igobyjake.rosegoldequipment.trim.ModTrimMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(rosegoldequipment.MOD_ID);

    // trimMaterial(...) is what lets the ingot be used in a smithing table to trim armor.
    public static final DeferredItem<Item> ROSE_GOLD_INGOT = ITEMS.registerItem("rose_gold_ingot",
            properties -> new Item(properties.trimMaterial(ModTrimMaterials.ROSE_GOLD)));
    public static final DeferredItem<Item> ROSE_GOLD_NUGGET = ITEMS.registerItem("rose_gold_nugget", Item::new);
    public static final DeferredItem<Item> RAW_ROSE_GOLD = ITEMS.registerItem("raw_rose_gold", Item::new);

    // ---- Food ----
    public static final DeferredItem<Item> ROSE_GILDED_BEETROOT = ITEMS.registerItem("rose_gilded_beetroot",
            properties -> new Item(properties.food(ModFoodProperties.ROSE_GILDED_BEETROOT, ModFoodProperties.ROSE_GILDED_BEETROOT_EFFECT)));
    public static final DeferredItem<Item> ROSEY_BEETROOT_STEW = ITEMS.registerItem("rosey_beetroot_stew",
            properties -> new Item(properties.stacksTo(1).food(ModFoodProperties.ROSEY_BEETROOT_STEW, ModFoodProperties.ROSEY_BEETROOT_STEW_EFFECT)
                    .usingConvertsTo(Items.BOWL)));
    public static final DeferredItem<Item> ROSE_GILDED_COOKIE = ITEMS.registerItem("rose_gilded_cookie",
            properties -> new Item(properties.food(ModFoodProperties.ROSE_GILDED_COOKIE, ModFoodProperties.ROSE_GILDED_COOKIE_EFFECT)));
    public static final DeferredItem<Item> ROSE_GILDED_MUSHROOM = ITEMS.registerItem("rose_gilded_mushroom",
            properties -> new Item(properties.food(ModFoodProperties.ROSE_GILDED_MUSHROOM, ModFoodProperties.ROSE_GILDED_MUSHROOM_EFFECT)));

    // Omelette -> partial -> crumbs -> bowl (each bite leaves the next stage behind)
    public static final DeferredItem<Item> ROSE_MUSHROOM_CRUMBS = ITEMS.registerItem("rose_mushroom_crumbs",
            properties -> new Item(properties.stacksTo(1).food(ModFoodProperties.ROSE_MUSHROOM_CRUMBS, ModFoodProperties.ROSE_MUSHROOM_OMELETTE_EFFECT)
                    .usingConvertsTo(Items.BOWL)));
    public static final DeferredItem<Item> ROSE_MUSHROOM_PARTIAL = ITEMS.registerItem("rose_mushroom_partial",
            properties -> new Item(properties.stacksTo(1).food(ModFoodProperties.ROSE_MUSHROOM_PARTIAL, ModFoodProperties.ROSE_MUSHROOM_OMELETTE_EFFECT)
                    .usingConvertsTo(ROSE_MUSHROOM_CRUMBS.get())));
    public static final DeferredItem<Item> ROSE_MUSHROOM_OMELETTE = ITEMS.registerItem("rose_mushroom_omelette",
            properties -> new Item(properties.stacksTo(1).food(ModFoodProperties.ROSE_MUSHROOM_OMELETTE, ModFoodProperties.ROSE_MUSHROOM_OMELETTE_EFFECT)
                    .usingConvertsTo(ROSE_MUSHROOM_PARTIAL.get())));

    // Full jelly -> half jelly
    public static final DeferredItem<Item> ROSE_HALF_JELLY = ITEMS.registerItem("rose_half_jelly",
            properties -> new Item(properties.stacksTo(1).food(ModFoodProperties.ROSE_HALF_JELLY, ModFoodProperties.ROSE_FULL_JELLY_EFFECT)));
    public static final DeferredItem<Item> ROSE_FULL_JELLY = ITEMS.registerItem("rose_full_jelly",
            properties -> new Item(properties.stacksTo(1).food(ModFoodProperties.ROSE_FULL_JELLY, ModFoodProperties.ROSE_FULL_JELLY_EFFECT)
                    .usingConvertsTo(ROSE_HALF_JELLY.get())));

    // ---- Tools ----
    // (26.3: axes/shovels/hoes are plain Items now; .axe()/.shovel()/.hoe() add stripping, path-making and tilling.)
    public static final DeferredItem<Item> ROSE_GOLDEN_SWORD = ITEMS.registerItem("rose_golden_sword",
            properties -> new Item(properties.sword(ModToolTiers.ROSE_GOLD, RgeConfig.swordBaseDamage(), -2.4F)));
    public static final DeferredItem<Item> ROSE_GOLDEN_PICKAXE = ITEMS.registerItem("rose_golden_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolTiers.ROSE_GOLD, 2.0F, -2.8F)));
    public static final DeferredItem<Item> ROSE_GOLDEN_SHOVEL = ITEMS.registerItem("rose_golden_shovel",
            properties -> new Item(properties.shovel(ModToolTiers.ROSE_GOLD, 2.5F, -3.0F)));
    public static final DeferredItem<Item> ROSE_GOLDEN_AXE = ITEMS.registerItem("rose_golden_axe",
            properties -> new Item(properties.axe(ModToolTiers.ROSE_GOLD, 7.0F, -3.1F)));
    public static final DeferredItem<Item> ROSE_GOLDEN_HOE = ITEMS.registerItem("rose_golden_hoe",
            properties -> new Item(properties.hoe(ModToolTiers.ROSE_GOLD, -1.0F, -1.0F)));

    // ---- Armor ----
    public static final DeferredItem<Item> ROSE_GOLDEN_HELMET = ITEMS.registerItem("rose_golden_helmet",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final DeferredItem<Item> ROSE_GOLDEN_CHESTPLATE = ITEMS.registerItem("rose_golden_chestplate",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> ROSE_GOLDEN_LEGGINGS = ITEMS.registerItem("rose_golden_leggings",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> ROSE_GOLDEN_BOOTS = ITEMS.registerItem("rose_golden_boots",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, ArmorType.BOOTS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
