package net.igobyjake.rosegoldequipment;

import net.fabricmc.api.ModInitializer;
import net.igobyjake.rosegoldequipment.block.ModBlocks;
import net.igobyjake.rosegoldequipment.item.ModItemGroups;
import net.igobyjake.rosegoldequipment.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class rosegoldequipment implements ModInitializer {
	public static final String MOD_ID = "rosegoldequipment";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
