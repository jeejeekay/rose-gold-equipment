package net.igobyjake.rosegoldequipment.gametest;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmithingRecipeInput;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.util.List;

/**
 * The automated version of docs/TESTING.md.
 *
 * Only uses vanilla classes and looks our items up by name, so this exact file
 * works on both Fabric and NeoForge. Each public method is one GameTest; the
 * loader-specific files (RoseGoldGameTests) just hook them up.
 */
public final class RoseGoldChecks {
    private static final String MOD = "rosegoldequipment";
    private static final String[] ARMOR = {"helmet", "chestplate", "leggings", "boots"};

    private RoseGoldChecks() {}

    static Item item(String name) {
        Item item = BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath(MOD, name));
        if (item == null || item == Items.AIR) throw new IllegalStateException("missing item " + MOD + ":" + name);
        return item;
    }

    static Block block(String name) {
        Block block = BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(MOD, name));
        if (block == null || block == Blocks.AIR) throw new IllegalStateException("missing block " + MOD + ":" + name);
        return block;
    }

    // ---------------------------------------------------------------- trims

    /** The trim material is registered and its tooltip text is light rose gold. */
    public static void trimMaterial(GameTestHelper h) {
        ResourceKey<TrimMaterial> key = ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(MOD, "rose_gold"));
        var material = h.getLevel().registryAccess().lookupOrThrow(Registries.TRIM_MATERIAL).get(key);
        h.assertTrue(material.isPresent(), "trim material rosegoldequipment:rose_gold is not registered");
        TextColor color = material.get().value().description().getStyle().getColor();
        h.assertTrue(color != null && color.getValue() == 0xFFBBB6, "trim text colour should be #FFBBB6 but is " + color);
        h.succeed();
    }

    /** Rose gold works in the smithing table on rose gold AND vanilla armor (incl. leather, turtle). */
    public static void trimSmithing(GameTestHelper h) {
        ItemStack ingot = new ItemStack(item("rose_gold_ingot"));
        h.assertTrue(ingot.has(DataComponents.PROVIDES_TRIM_MATERIAL), "rose gold ingot does not provide a trim material");
        h.assertTrue(ingot.is(ItemTags.TRIM_MATERIALS), "rose gold ingot is not in #minecraft:trim_materials");

        ItemStack template = new ItemStack(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE);
        List<Item> armors = List.of(item("rose_golden_helmet"), item("rose_golden_chestplate"), item("rose_golden_leggings"),
                item("rose_golden_boots"), Items.IRON_CHESTPLATE, Items.GOLDEN_HELMET, Items.DIAMOND_LEGGINGS,
                Items.NETHERITE_BOOTS, Items.CHAINMAIL_HELMET, Items.LEATHER_CHESTPLATE, Items.TURTLE_HELMET);
        for (Item armor : armors) {
            boolean matches = h.getLevel().recipeAccess().getRecipeFor(RecipeType.SMITHING,
                    new SmithingRecipeInput(template, new ItemStack(armor), ingot), h.getLevel(),
                    (ResourceKey<Recipe<?>>) null).isPresent();
            h.assertTrue(matches, "no smithing trim recipe for " + armor + " + rose gold ingot");
        }
        // Vanilla materials still trim rose gold armor.
        boolean diamondOnRoseGold = h.getLevel().recipeAccess().getRecipeFor(RecipeType.SMITHING,
                new SmithingRecipeInput(template, new ItemStack(item("rose_golden_chestplate")), new ItemStack(Items.DIAMOND)),
                h.getLevel(), (ResourceKey<Recipe<?>>) null).isPresent();
        h.assertTrue(diamondOnRoseGold, "rose gold chestplate can't be trimmed with diamond");
        h.succeed();
    }

    // ---------------------------------------------------------------- armor

    /** 3 + 7 + 5 + 2 = 17 armor points, trimmable, repairable with the ingot. */
    public static void armor(GameTestHelper h) {
        double total = 0;
        ItemStack ingot = new ItemStack(item("rose_gold_ingot"));
        for (String piece : ARMOR) {
            ItemStack stack = new ItemStack(item("rose_golden_" + piece));
            h.assertTrue(stack.is(ItemTags.TRIMMABLE_ARMOR), "rose_golden_" + piece + " is not trimmable");
            h.assertTrue(stack.isValidRepairItem(ingot), "rose_golden_" + piece + " can't be repaired with the ingot");
            for (ItemAttributeModifiers.Entry e : stack.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY).modifiers()) {
                if (e.attribute().is(Attributes.ARMOR)) total += e.modifier().amount();
            }
        }
        h.assertTrue(total == 17, "full rose gold set should give 17 armor, gives " + total);
        h.succeed();
    }

    // ---------------------------------------------------------------- tools

    /** Mines like iron; repairs with the ingot. */
    public static void tools(GameTestHelper h) {
        ItemStack pickaxe = new ItemStack(item("rose_golden_pickaxe"));
        h.assertTrue(pickaxe.isCorrectToolForDrops(Blocks.IRON_ORE.defaultBlockState()), "pickaxe can't harvest iron ore");
        h.assertTrue(pickaxe.isCorrectToolForDrops(Blocks.DIAMOND_ORE.defaultBlockState()), "pickaxe can't harvest diamond ore");
        h.assertFalse(pickaxe.isCorrectToolForDrops(Blocks.OBSIDIAN.defaultBlockState()), "pickaxe should NOT harvest obsidian");
        ItemStack ingot = new ItemStack(item("rose_gold_ingot"));
        for (String tool : new String[]{"sword", "pickaxe", "shovel", "axe", "hoe"}) {
            ItemStack stack = new ItemStack(item("rose_golden_" + tool));
            h.assertTrue(stack.isValidRepairItem(ingot), "rose_golden_" + tool + " can't be repaired with the ingot");
            h.assertTrue(stack.getMaxDamage() == 466, "rose_golden_" + tool + " durability should be 466, is " + stack.getMaxDamage());
        }
        h.succeed();
    }

    // ---------------------------------------------------------------- blocks

    /** Each block drops itself with an iron pickaxe, nothing with a stone one; the door drops exactly one. */
    public static void blockDrops(GameTestHelper h) {
        ItemStack iron = new ItemStack(Items.IRON_PICKAXE);
        ItemStack stone = new ItemStack(Items.STONE_PICKAXE);
        BlockPos pos = h.absolutePos(BlockPos.ZERO);   // loot tables don't need the block to be placed
        for (String name : new String[]{"rose_gold_block", "raw_rose_gold_block", "rose_gold_trapdoor"}) {
            Block block = block(name);
            BlockState state = block.defaultBlockState();
            h.assertTrue(iron.isCorrectToolForDrops(state), name + ": iron pickaxe is not the correct tool");
            List<ItemStack> drops = Block.getDrops(state, h.getLevel(), pos, null, null, iron);
            h.assertTrue(drops.size() == 1 && drops.get(0).is(block.asItem()), name + " should drop itself, dropped " + drops);
            if (!name.contains("trapdoor")) {
                h.assertFalse(stone.isCorrectToolForDrops(state), name + " should need an iron pickaxe");
            }
        }
        Block door = block("rose_gold_door");
        BlockState lower = door.defaultBlockState().setValue(DoorBlock.HALF, DoubleBlockHalf.LOWER);
        BlockState upper = door.defaultBlockState().setValue(DoorBlock.HALF, DoubleBlockHalf.UPPER);
        h.assertTrue(iron.isCorrectToolForDrops(lower), "door: iron pickaxe is not the correct tool");
        List<ItemStack> lowerDrops = Block.getDrops(lower, h.getLevel(), pos, null, null, iron);
        List<ItemStack> upperDrops = Block.getDrops(upper, h.getLevel(), pos.above(), null, null, iron);
        h.assertTrue(lowerDrops.size() == 1 && lowerDrops.get(0).getCount() == 1, "door bottom should drop 1 door, dropped " + lowerDrops);
        h.assertTrue(upperDrops.isEmpty(), "door top should drop nothing, dropped " + upperDrops);
        h.succeed();
    }

    // ---------------------------------------------------------------- foods

    private static ItemStack eat(GameTestHelper h, Player player, String food) {
        ItemStack stack = new ItemStack(item(food));
        FoodProperties props = stack.get(DataComponents.FOOD);
        h.assertTrue(props != null && props.canAlwaysEat(), food + " should be edible even when full");
        return stack.finishUsingItem(h.getLevel(), player);
    }

    private static void effect(GameTestHelper h, Player player, Holder<MobEffect> effect, int amplifier, String food) {
        MobEffectInstance inst = player.getEffect(effect);
        h.assertTrue(inst != null && inst.getAmplifier() == amplifier,
                food + " should give " + effect.getRegisteredName() + " level " + (amplifier + 1) + ", got " + inst);
    }

    /** Every food: right effects, right leftover item. */
    public static void foods(GameTestHelper h) {
        Player p = h.makeMockPlayer(GameType.SURVIVAL);
        ItemStack left;

        eat(h, p, "rose_gilded_beetroot");
        effect(h, p, MobEffects.STRENGTH, 0, "rose_gilded_beetroot");
        p.removeAllEffects();

        left = eat(h, p, "rosey_beetroot_stew");
        effect(h, p, MobEffects.STRENGTH, 1, "rosey_beetroot_stew");
        effect(h, p, MobEffects.HASTE, 1, "rosey_beetroot_stew");
        effect(h, p, MobEffects.REGENERATION, 1, "rosey_beetroot_stew");
        h.assertTrue(left.is(Items.BOWL), "stew should leave a bowl, left " + left);
        p.removeAllEffects();

        left = eat(h, p, "rose_mushroom_omelette");
        effect(h, p, MobEffects.HASTE, 1, "rose_mushroom_omelette");
        h.assertTrue(left.is(item("rose_mushroom_partial")), "omelette should leave a partial omelette, left " + left);
        left = eat(h, p, "rose_mushroom_partial");
        h.assertTrue(left.is(item("rose_mushroom_crumbs")), "partial should leave crumbs, left " + left);
        left = eat(h, p, "rose_mushroom_crumbs");
        h.assertTrue(left.is(Items.BOWL), "crumbs should leave a bowl, left " + left);
        p.removeAllEffects();

        left = eat(h, p, "rose_full_jelly");
        effect(h, p, MobEffects.SPEED, 1, "rose_full_jelly");
        h.assertTrue(left.is(item("rose_half_jelly")), "full jelly should leave half jelly, left " + left);
        p.removeAllEffects();

        eat(h, p, "rose_gilded_cookie");
        effect(h, p, MobEffects.SPEED, 0, "rose_gilded_cookie");
        eat(h, p, "rose_gilded_mushroom");
        eat(h, p, "rose_half_jelly");
        h.succeed();
    }

    // ---------------------------------------------------------------- dev tools

    /** The /function rosegoldequipment:showcase file parsed on this Minecraft version (one bad line drops the whole file). */
    public static void showcaseLoads(GameTestHelper h) {
        boolean loaded = h.getLevel().getServer().getFunctions()
                .get(Identifier.fromNamespaceAndPath(MOD, "showcase")).isPresent();
        h.assertTrue(loaded, "function rosegoldequipment:showcase failed to load - check the log for the bad command");
        h.succeed();
    }
}
