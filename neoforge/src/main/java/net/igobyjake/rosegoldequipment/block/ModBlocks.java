package net.igobyjake.rosegoldequipment.block;

import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.igobyjake.rosegoldequipment.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(rosegoldequipment.MOD_ID);

    public static final DeferredBlock<Block> ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            (properties) -> new Block(properties
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.IRON)));
    public static final DeferredBlock<Block> RAW_ROSE_GOLD_BLOCK = registerBlock("raw_rose_gold_block",
            (properties) -> new Block(properties
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.IRON)));

    public static final DeferredBlock<DoorBlock> ROSE_GOLD_DOOR = registerBlock("rose_gold_door",
            (properties) -> new DoorBlock(BlockSetType.COPPER, properties.strength(2f).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> ROSE_GOLD_TRAPDOOR = registerBlock("rose_gold_trapdoor",
            (properties) -> new TrapDoorBlock(BlockSetType.COPPER, properties.strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
