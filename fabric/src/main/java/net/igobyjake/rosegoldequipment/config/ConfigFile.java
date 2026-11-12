package net.igobyjake.rosegoldequipment.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.loader.api.FabricLoader;
import net.igobyjake.rosegoldequipment.rosegoldequipment;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Fabric side of the settings: config/rosegoldequipment.json. Loaded at the start of onInitialize
 * (before any item exists); edited in game through Mod Menu + Cloth Config if they're installed
 * (see ClothConfigScreen). Changes need a restart.
 */
public final class ConfigFile {
    private static final Path PATH = FabricLoader.getInstance().getConfigDir().resolve("rosegoldequipment.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private ConfigFile() {}

    public static void load() {
        try {
            if (Files.exists(PATH)) {
                JsonObject json = JsonParser.parseString(Files.readString(PATH)).getAsJsonObject();
                if (json.has("sword_attack_damage")) {
                    RgeConfig.swordAttackDamage = Math.max(RgeConfig.MIN_SWORD_ATTACK_DAMAGE,
                            Math.min(RgeConfig.MAX_SWORD_ATTACK_DAMAGE, json.get("sword_attack_damage").getAsDouble()));
                }
                if (json.has("diamond_durability")) RgeConfig.diamondDurability = json.get("diamond_durability").getAsBoolean();
                if (json.has("food_effects")) RgeConfig.foodEffects = json.get("food_effects").getAsBoolean();
            }
        } catch (Exception e) {
            rosegoldequipment.LOGGER.warn("Couldn't read " + PATH + ", using defaults", e);
        }
        save();   // writes the file the first time, and adds any settings that are missing
    }

    public static void save() {
        JsonObject json = new JsonObject();
        json.addProperty("_comment", "Rose Gold Equipment settings. Restart Minecraft after changing them; use the same values on a server and its players.");
        json.addProperty("sword_attack_damage", RgeConfig.swordAttackDamage);
        json.addProperty("diamond_durability", RgeConfig.diamondDurability);
        json.addProperty("food_effects", RgeConfig.foodEffects);
        try {
            Files.createDirectories(PATH.getParent());
            Files.writeString(PATH, GSON.toJson(json));
        } catch (Exception e) {
            rosegoldequipment.LOGGER.warn("Couldn't write " + PATH, e);
        }
    }
}
