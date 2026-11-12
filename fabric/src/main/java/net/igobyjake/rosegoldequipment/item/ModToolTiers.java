package net.igobyjake.rosegoldequipment.item;

import net.igobyjake.rosegoldequipment.config.RgeConfig;
import net.igobyjake.rosegoldequipment.util.ModTags;
import net.minecraft.world.item.ToolMaterial;

public class ModToolTiers {
    // durability 466 (1561 with the diamond_durability setting), mining speed 10, +1 attack, enchantability 45
    public static final ToolMaterial ROSE_GOLD = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_ROSE_GOLD_TOOL,
            RgeConfig.toolDurability(), 10.0f, 1.0f, 45, ModTags.Items.ROSE_GOLD_REPAIRABLE);
}
