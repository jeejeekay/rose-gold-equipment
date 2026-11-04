package net.igobyjake.rosegoldequipment.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.igobyjake.rosegoldequipment.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ROSE_GOLD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(rosegoldequipment.MOD_ID, "rose_gold_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ROSE_GOLD_INGOT))
                    .displayName(Text.translatable("itemgroup.rosegoldequipment.rose_gold_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ROSE_GOLD_INGOT);
                        entries.add(ModItems.ROSE_GOLD_NUGGET);
                        entries.add(ModItems.RAW_ROSE_GOLD);

                        entries.add(ModItems.ROSE_GILDED_BEETROOT);
                        entries.add(ModItems.ROSE_GILDED_COOKIE);
                        entries.add(ModItems.ROSE_GILDED_MUSHROOM);
                        entries.add(ModItems.ROSEY_BEETROOT_STEW);
                        entries.add(ModItems.ROSE_MUSHROOM_OMELETTE);
                        entries.add(ModItems.ROSE_FULL_JELLY);

                        entries.add(ModItems.ROSE_GOLDEN_SWORD);
                        entries.add(ModItems.ROSE_GOLDEN_PICKAXE);
                        entries.add(ModItems.ROSE_GOLDEN_SHOVEL);
                        entries.add(ModItems.ROSE_GOLDEN_AXE);
                        entries.add(ModItems.ROSE_GOLDEN_HOE);

                        entries.add(ModItems.ROSE_GOLDEN_HELMET);
                        entries.add(ModItems.ROSE_GOLDEN_CHESTPLATE);
                        entries.add(ModItems.ROSE_GOLDEN_LEGGINGS);
                        entries.add(ModItems.ROSE_GOLDEN_BOOTS);

                        entries.add(ModBlocks.ROSE_GOLD_BLOCK);
                        entries.add(ModBlocks.RAW_ROSE_GOLD_BLOCK);

                        entries.add(ModBlocks.ROSE_GOLD_DOOR);
                        entries.add(ModBlocks.ROSE_GOLD_TRAPDOOR);

                    }).build());


    public static void registerItemGroups() {
        //rosegoldequipment.LOGGER.info("Registering Item Groups for " + rosegoldequipment.MOD_ID);
    }
}
