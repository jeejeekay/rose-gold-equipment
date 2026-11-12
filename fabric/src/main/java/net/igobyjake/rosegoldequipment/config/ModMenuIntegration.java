package net.igobyjake.rosegoldequipment.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.loader.api.FabricLoader;

/**
 * Adds a "Config" button to Rose Gold Equipment in Mod Menu (the "modmenu" entrypoint in
 * fabric.mod.json; only used when Mod Menu is installed). The screen itself needs Cloth Config.
 */
public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        if (!FabricLoader.getInstance().isModLoaded("cloth-config")) return ModMenuApi.super.getModConfigScreenFactory();
        return ClothConfigScreen::create;
    }
}
