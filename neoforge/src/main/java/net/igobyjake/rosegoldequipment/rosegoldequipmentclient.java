package net.igobyjake.rosegoldequipment;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// Client only: the "Config" button in the Mods list opens NeoForge's built-in settings screen,
// which reads config/ModConfigs (and the lang keys rosegoldequipment.configuration.*).
@Mod(value = rosegoldequipment.MOD_ID, dist = Dist.CLIENT)
public class rosegoldequipmentclient {
    public rosegoldequipmentclient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
