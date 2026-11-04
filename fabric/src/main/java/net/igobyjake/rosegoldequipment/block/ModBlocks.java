package net.igobyjake.rosegoldequipment.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            properties -> new Block(properties.strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER)));
    public static final Block RAW_ROSE_GOLD_BLOCK = registerBlock("raw_rose_gold_block",
            properties -> new Block(properties.strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER)));


    public static final Block ROSE_GOLD_DOOR = registerBlock("rose_gold_door",
            properties -> new DoorBlock(BlockSetType.COPPER, properties.strength(2f).requiresTool().nonOpaque()));
    public static final Block ROSE_GOLD_TRAPDOOR = registerBlock("rose_gold_trapdoor",
            properties -> new TrapdoorBlock(BlockSetType.COPPER, properties.strength(2f).requiresTool().nonOpaque()));


    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(rosegoldequipment.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(rosegoldequipment.MOD_ID, name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(rosegoldequipment.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(rosegoldequipment.MOD_ID, name)))));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(rosegoldequipment.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(rosegoldequipment.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        rosegoldequipment.LOGGER.info("Registering Mod Blocks for " + rosegoldequipment.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.ROSE_GOLD_BLOCK);
            entries.add(ModBlocks.RAW_ROSE_GOLD_BLOCK);
        });
    }
}
