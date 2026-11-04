package net.igobyjake.rosegoldequipment.item;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.igobyjake.rosegoldequipment.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {
    public static final CreativeModeTab ROSE_GOLD_ITEMS_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(rosegoldequipment.MOD_ID, "rose_gold_group"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ROSE_GOLD_INGOT))
                    .title(Component.translatable("itemgroup.rosegoldequipment.rose_gold_group"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.ROSE_GOLD_INGOT);
                        output.accept(ModItems.ROSE_GOLD_NUGGET);
                        output.accept(ModItems.RAW_ROSE_GOLD);

                        output.accept(ModItems.ROSE_GILDED_BEETROOT);
                        output.accept(ModItems.ROSE_GILDED_COOKIE);
                        output.accept(ModItems.ROSE_GILDED_MUSHROOM);
                        output.accept(ModItems.ROSEY_BEETROOT_STEW);
                        output.accept(ModItems.ROSE_MUSHROOM_OMELETTE);
                        output.accept(ModItems.ROSE_FULL_JELLY);

                        output.accept(ModItems.ROSE_GOLDEN_SWORD);
                        output.accept(ModItems.ROSE_GOLDEN_PICKAXE);
                        output.accept(ModItems.ROSE_GOLDEN_SHOVEL);
                        output.accept(ModItems.ROSE_GOLDEN_AXE);
                        output.accept(ModItems.ROSE_GOLDEN_HOE);

                        output.accept(ModItems.ROSE_GOLDEN_HELMET);
                        output.accept(ModItems.ROSE_GOLDEN_CHESTPLATE);
                        output.accept(ModItems.ROSE_GOLDEN_LEGGINGS);
                        output.accept(ModItems.ROSE_GOLDEN_BOOTS);

                        output.accept(ModBlocks.ROSE_GOLD_BLOCK);
                        output.accept(ModBlocks.RAW_ROSE_GOLD_BLOCK);

                        output.accept(ModBlocks.ROSE_GOLD_DOOR);
                        output.accept(ModBlocks.ROSE_GOLD_TRAPDOOR);
                    }).build());

    public static void registerItemGroups() {
        rosegoldequipment.LOGGER.info("Registering creative tab for " + rosegoldequipment.MOD_ID);
    }
}
