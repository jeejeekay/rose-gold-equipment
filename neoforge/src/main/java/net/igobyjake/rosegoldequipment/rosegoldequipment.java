package net.igobyjake.rosegoldequipment;

import net.igobyjake.rosegoldequipment.config.ModConfigs;
import com.mojang.logging.LogUtils;
import net.igobyjake.rosegoldequipment.block.ModBlocks;
import net.igobyjake.rosegoldequipment.item.ModCreativeModeTabs;
import net.igobyjake.rosegoldequipment.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(rosegoldequipment.MOD_ID)
public class rosegoldequipment {
    public static final String MOD_ID = "rosegoldequipment";
    public static final Logger LOGGER = LogUtils.getLogger();

    public rosegoldequipment(IEventBus modEventBus, ModContainer modContainer) {
        // Settings first: items read them when they are created.
        ModConfigs.register(modContainer);
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    // Also list the basics in the vanilla tabs (same as the Fabric version).
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ROSE_GOLD_INGOT);
            event.accept(ModItems.ROSE_GOLD_NUGGET);
            event.accept(ModItems.RAW_ROSE_GOLD);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.ROSE_GOLD_BLOCK);
            event.accept(ModBlocks.RAW_ROSE_GOLD_BLOCK);
        }
    }

    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Doors/trapdoors have see-through pixels. (From 26.1 on, Minecraft works this out by itself.)
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROSE_GOLD_DOOR.get(), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ROSE_GOLD_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        }
    }
}
