package net.igobyjake.rosegoldequipment;

import net.igobyjake.rosegoldequipment.config.ConfigFile;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.pack.PackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
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
		// Settings first: items read them when they are created.
		ConfigFile.load();
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		// Optional resource pack shipped inside the jar (src/main/resources/resourcepacks/wooden_handles):
		// rose gold tools with normal brown wooden handles. Off by default; players turn it on in
		// Options -> Resource Packs. Change NORMAL to DEFAULT_ENABLED to have it on by default.
		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(mod -> ResourceLoader.registerBuiltinPack(
				Identifier.fromNamespaceAndPath(MOD_ID, "wooden_handles"), mod,
				Component.translatable("resourcepack.rosegoldequipment.wooden_handles"), PackActivationType.NORMAL));
	}
}
