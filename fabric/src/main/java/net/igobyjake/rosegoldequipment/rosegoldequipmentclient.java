package net.igobyjake.rosegoldequipment;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.igobyjake.rosegoldequipment.block.ModBlocks;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class rosegoldequipmentclient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Doors/trapdoors have see-through pixels. (From 26.1 on, Minecraft works this out by itself.)
        BlockRenderLayerMap.putBlock(ModBlocks.ROSE_GOLD_DOOR, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ROSE_GOLD_TRAPDOOR, ChunkSectionLayer.CUTOUT);
    }
}
