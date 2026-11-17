package net.igobyjake.rosegoldequipment;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;

// Client only: the "Config" button in the Mods list opens NeoForge's built-in settings screen,
// which reads config/ModConfigs (and the lang keys rosegoldequipment.configuration.*).
@Mod(value = rosegoldequipment.MOD_ID, dist = Dist.CLIENT)
public class rosegoldequipmentclient {
    public rosegoldequipmentclient(IEventBus modBus, ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        // Optional resource pack shipped inside the jar (src/main/resources/resourcepacks/wooden_handles):
        // rose gold tools with normal brown wooden handles. Off by default; players turn it on in
        // Options -> Resource Packs. To make it on by default, there is no simple switch here -
        // 'true' below would force it on with no way to turn it off.
        modBus.addListener(AddPackFindersEvent.class, event -> event.addPackFinders(
                Identifier.fromNamespaceAndPath(rosegoldequipment.MOD_ID, "resourcepacks/wooden_handles"),
                PackType.CLIENT_RESOURCES,
                Component.translatable("resourcepack.rosegoldequipment.wooden_handles"),
                PackSource.BUILT_IN, false, Pack.Position.TOP));
    }
}
