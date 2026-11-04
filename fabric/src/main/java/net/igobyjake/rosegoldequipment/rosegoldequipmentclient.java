package net.igobyjake.rosegoldequipment;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.igobyjake.rosegoldequipment.block.ModBlocks;
import net.minecraft.client.render.BlockRenderLayer;

public class rosegoldequipmentclient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.ROSE_GOLD_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ROSE_GOLD_TRAPDOOR, BlockRenderLayer.CUTOUT);

    }
}
