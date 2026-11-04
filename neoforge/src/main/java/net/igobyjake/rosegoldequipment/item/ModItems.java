package net.igobyjake.rosegoldequipment.item;

import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static net.minecraft.world.item.Items.registerItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(rosegoldequipment.MOD_ID);

    public static final DeferredItem<Item> ROSE_GOLD_INGOT = ITEMS.registerItem("rose_gold_ingot",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> ROSE_GOLD_NUGGET = ITEMS.registerItem("rose_gold_nugget",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> RAW_ROSE_GOLD = ITEMS.registerItem("raw_rose_gold",
            Item::new, new Item.Properties());

   /* public static final DeferredItem<Item> RADISH = ITEMS.registerItem("radish",
            (properties) -> new Item(properties.food(ModFoodProperties.RADISH, ModFoodProperties.RADISH_EFFECT)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, TooltipDisplay tooltipDisplay, Consumer<Component> components, TooltipFlag tooltipFlag) {
                    components.accept(Component.translatable("tooltip.tutorialmod.radish.tooltip"));
                    super.appendHoverText(pStack, pContext, tooltipDisplay, components, tooltipFlag);
                }
            }); */

    public static final DeferredItem<Item> ROSE_GILDED_BEETROOT = ITEMS.registerItem("rose_gilded_beetroot",
            setting -> new Item(setting.food(ModFoodProperties.ROSE_GILDED_BEETROOT,ModFoodProperties.ROSE_GILDED_BEETROOT_EFFECT)));
    public static final DeferredItem<Item> ROSEY_BEETROOT_STEW = ITEMS.registerItem("rosey_beetroot_stew",
            setting -> new Item(setting.stacksTo(1).food(ModFoodProperties.ROSEY_BEETROOT_STEW,ModFoodProperties.ROSEY_BEETROOT_STEW_EFFECT)
                    .usingConvertsTo(Items.BOWL)));
    public static final DeferredItem<Item> ROSE_GILDED_COOKIE = ITEMS.registerItem("rose_gilded_cookie",
            setting -> new Item(setting.food(ModFoodProperties.ROSE_GILDED_BEETROOT,ModFoodProperties.ROSE_GILDED_COOKIE_EFFECT)));

    public static final DeferredItem<Item> ROSE_MUSHROOM_CRUMBS = ITEMS.registerItem("rose_mushroom_crumbs",
            setting -> new Item(setting.stacksTo(1).food(ModFoodProperties.ROSE_MUSHROOM_CRUMBS,ModFoodProperties.ROSE_MUSHROOM_OMELETTE_EFFECT)));
    public static final DeferredItem<Item> ROSE_MUSHROOM_PARTIAL = ITEMS.registerItem("rose_mushroom_partial",
            setting -> new Item(setting.stacksTo(1).food(ModFoodProperties.ROSE_MUSHROOM_PARTIAL,ModFoodProperties.ROSE_MUSHROOM_OMELETTE_EFFECT)
                    .usingConvertsTo(ModItems.ROSE_MUSHROOM_CRUMBS.asItem())));
    public static final DeferredItem<Item> ROSE_MUSHROOM_OMELETTE = ITEMS.registerItem("rose_mushroom_omelette",
            setting -> new Item(setting.stacksTo(1).food(ModFoodProperties.ROSE_MUSHROOM_OMELETTE,ModFoodProperties.ROSE_MUSHROOM_OMELETTE_EFFECT)
                    .usingConvertsTo(ModItems.ROSE_MUSHROOM_PARTIAL.asItem())));

    public static final DeferredItem<Item> ROSE_HALF_JELLY = ITEMS.registerItem("rose_half_jelly",
            setting -> new Item(setting.stacksTo(1).food(ModFoodProperties.ROSE_HALF_JELLY,ModFoodProperties.ROSE_FULL_JELLY_EFFECT)));
    public static final DeferredItem<Item> ROSE_FULL_JELLY = ITEMS.registerItem("rose_full_jelly",
            setting -> new Item(setting.stacksTo(1).food(ModFoodProperties.ROSE_FULL_JELLY,ModFoodProperties.ROSE_FULL_JELLY_EFFECT)
                    .usingConvertsTo(ModItems.ROSE_HALF_JELLY.asItem())));
    public static final DeferredItem<Item> ROSE_GILDED_MUSHROOM = ITEMS.registerItem("rose_gilded_mushroom",
            setting -> new Item(setting.food(ModFoodProperties.ROSE_GILDED_MUSHROOM,ModFoodProperties.ROSE_GILDED_MUSHROOM_EFFECT)));


    public static final DeferredItem<Item> ROSE_GOLDEN_SWORD = ITEMS.registerItem("rose_golden_sword",
            (properties) -> new Item(properties.sword(ModToolTiers.ROSE_GOLD, 4.0F, -2.4f)));
    public static final DeferredItem<Item> ROSE_GOLDEN_PICKAXE = ITEMS.registerItem("rose_golden_pickaxe",
            (properties) -> new Item(properties.pickaxe(ModToolTiers.ROSE_GOLD, 2.0F, -2.8f)));
    public static final DeferredItem<ShovelItem> ROSE_GOLDEN_SHOVEL = ITEMS.registerItem("rose_golden_shovel",
            (properties) -> new ShovelItem(ModToolTiers.ROSE_GOLD, 2.5F, -3.0f, properties));
    public static final DeferredItem<AxeItem> ROSE_GOLDEN_AXE = ITEMS.registerItem("rose_golden_axe",
            (properties) -> new AxeItem(ModToolTiers.ROSE_GOLD, 7.0F, -3.2f, properties));
    public static final DeferredItem<HoeItem> ROSE_GOLDEN_HOE = ITEMS.registerItem("rose_golden_hoe",
            (properties) -> new HoeItem(ModToolTiers.ROSE_GOLD, -1.0F, -1.0f, properties));

    public static final DeferredItem<Item> ROSE_GOLDEN_HELMET = ITEMS.registerItem("rose_golden_helmet",
            (properties) -> new Item(properties.humanoidArmor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final DeferredItem<Item> ROSE_GOLDEN_CHESTPLATE = ITEMS.registerItem("rose_golden_chestplate",
            (properties) -> new Item(properties.humanoidArmor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> ROSE_GOLDEN_LEGGINGS = ITEMS.registerItem("rose_golden_leggings",
            (properties) -> new Item(properties.humanoidArmor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> ROSE_GOLDEN_BOOTS = ITEMS.registerItem("rose_golden_boots",
            (properties) -> new Item(properties.humanoidArmor(ModArmorMaterials.ROSE_GOLD_ARMOR_MATERIAL, ArmorType.BOOTS)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
