package net.igobyjake.rosegoldequipment.block;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.function.Function;

public class ModBlocks {
    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            properties -> new Block(properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final Block RAW_ROSE_GOLD_BLOCK = registerBlock("raw_rose_gold_block",
            properties -> new Block(properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.COPPER)));

    public static final Block ROSE_GOLD_DOOR = registerBlock("rose_gold_door",
            properties -> new DoorBlock(BlockSetType.COPPER, properties.strength(2f).requiresCorrectToolForDrops().noOcclusion()));
    public static final Block ROSE_GOLD_TRAPDOOR = registerBlock("rose_gold_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.COPPER, properties.strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Identifier id = Identifier.fromNamespaceAndPath(rosegoldequipment.MOD_ID, name);
        Block block = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, id)));
        Registry.register(BuiltInRegistries.ITEM, id, new BlockItem(block,
                new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, id))));
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void registerModBlocks() {
        rosegoldequipment.LOGGER.info("Registering blocks for " + rosegoldequipment.MOD_ID);

        // Also list the blocks in the vanilla Building Blocks tab.
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            entries.accept(ROSE_GOLD_BLOCK);
            entries.accept(RAW_ROSE_GOLD_BLOCK);
        });
    }
}
