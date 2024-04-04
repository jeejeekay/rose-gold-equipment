package jeejeekay.rosegoldequipment.datagen;

import jeejeekay.rosegoldequipment.block.ModBlocks;
import jeejeekay.rosegoldequipment.item.custom.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.DataWriter;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.loot.LootTable;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RAW_ROSE_GOLD_BLOCK);
        addDrop(ModBlocks.ROSE_GOLD_BLOCK);
        addDrop(ModBlocks.ROSE_GOLD_DOOR, doorLikeDrops(ModBlocks.ROSE_GOLD_DOOR));
        addDrop(ModBlocks.ROSE_GOLD_TRAPDOOR);
    }

    public LootTable.Builder doorLikeDrops(Block block) {
        return this.dropsWithProperty(block, DoorBlock.HALF, DoubleBlockHalf.LOWER);
    }
}
