package net.igobyjake.rosegoldequipment;

import com.mojang.logging.LogUtils;
import net.igobyjake.rosegoldequipment.block.ModBlocks;
import net.igobyjake.rosegoldequipment.item.ModCreativeModeTabs;
import net.igobyjake.rosegoldequipment.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(rosegoldequipment.MOD_ID)
public class rosegoldequipment {
    public static final String MOD_ID = "rosegoldequipment";
    public static final Logger LOGGER = LogUtils.getLogger();

    public rosegoldequipment(IEventBus modEventBus, ModContainer modContainer) {
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
}
