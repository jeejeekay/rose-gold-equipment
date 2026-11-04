package net.igobyjake.rosegoldequipment.util;

import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        /** Blocks rose gold tools can NOT mine (same as iron: anything needing diamond or better). */
        public static final TagKey<Block> INCORRECT_FOR_ROSE_GOLD_TOOL = createTag("incorrect_for_rose_gold_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(rosegoldequipment.MOD_ID, name));
        }
    }

    public static class Items {
        /** Items that repair rose gold tools and armor in an anvil. */
        public static final TagKey<Item> ROSE_GOLD_REPAIRABLE = createTag("rose_gold_repairable");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(rosegoldequipment.MOD_ID, name));
        }
    }
}
