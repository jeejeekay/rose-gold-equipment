package jeejeekay.rosegoldequipment.item.custom;

import jeejeekay.rosegoldequipment.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import jeejeekay.rosegoldequipment.RoseGoldEquipment;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static void registerItemGroups(){

    }
    public static final ItemGroup ROSE_GOLD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RoseGoldEquipment.MOD_ID,"rose_gold"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.rose_gold_group"))
                    .icon(() -> new ItemStack(ModItems.ROSE_GOLD_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ROSE_GOLD_INGOT);
                        entries.add(ModItems.RAW_ROSE_GOLD);
                        entries.add(ModItems.ROSE_GOLDEN_PICKAXE);
                        entries.add(ModItems.ROSE_GOLDEN_AXE);
                        entries.add(ModItems.ROSE_GOLDEN_HOE);
                        entries.add(ModItems.ROSE_GOLDEN_SHOVEL);
                        entries.add(ModItems.ROSE_GOLDEN_SWORD);
                        entries.add(ModItems.ROSE_GOLDEN_HELMET);
                        entries.add(ModItems.ROSE_GOLDEN_CHESTPLATE);
                        entries.add(ModItems.ROSE_GOLDEN_LEGGINGS);
                        entries.add(ModItems.ROSE_GOLDEN_BOOTS);

                        entries.add(ModBlocks.ROSE_GOLD_BLOCK);
                        entries.add(ModBlocks.RAW_ROSE_GOLD_BLOCK);
                        entries.add(ModBlocks.ROSE_GOLD_DOOR);
                        entries.add(ModBlocks.ROSE_GOLD_TRAPDOOR);

                    }).build());
}
