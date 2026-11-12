package net.igobyjake.rosegoldequipment.config;

import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * NeoForge side of the settings: config/rosegoldequipment-startup.toml, also editable in game from
 * Mods -> Rose Gold Equipment -> Config (NeoForge draws that screen for us). "Startup" type = read
 * before items are created, so NeoForge's screen will say a restart is needed after changing them.
 */
public final class ModConfigs {
    public static final ModConfigSpec STARTUP_SPEC;
    private static final ModConfigSpec.DoubleValue SWORD_ATTACK_DAMAGE;
    private static final ModConfigSpec.BooleanValue DIAMOND_DURABILITY;
    private static final ModConfigSpec.BooleanValue FOOD_EFFECTS;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.comment("Rose Gold Equipment settings. Restart Minecraft after changing them,",
                "and use the same values on a server and on every player's game.");
        SWORD_ATTACK_DAMAGE = builder
                .comment("Attack damage of the rose golden sword, as shown in its tooltip (iron 6, diamond 7, netherite 8).")
                .translation("rosegoldequipment.configuration.sword_attack_damage")
                .defineInRange("sword_attack_damage", RgeConfig.DEFAULT_SWORD_ATTACK_DAMAGE,
                        RgeConfig.MIN_SWORD_ATTACK_DAMAGE, RgeConfig.MAX_SWORD_ATTACK_DAMAGE);
        DIAMOND_DURABILITY = builder
                .comment("Give rose gold tools and armor diamond durability (tools 1561 uses instead of 466).")
                .translation("rosegoldequipment.configuration.diamond_durability")
                .define("diamond_durability", false);
        FOOD_EFFECTS = builder
                .comment("Rose gold foods give their potion effects. Off = they only fill hunger.")
                .translation("rosegoldequipment.configuration.food_effects")
                .define("food_effects", true);
        STARTUP_SPEC = builder.build();
    }

    private ModConfigs() {}

    /** Call first thing in the mod constructor: startup configs are read the moment they're registered. */
    public static void register(ModContainer container) {
        container.registerConfig(ModConfig.Type.STARTUP, STARTUP_SPEC);
        try {
            RgeConfig.swordAttackDamage = SWORD_ATTACK_DAMAGE.get();
            RgeConfig.diamondDurability = DIAMOND_DURABILITY.get();
            RgeConfig.foodEffects = FOOD_EFFECTS.get();
        } catch (IllegalStateException e) {
            rosegoldequipment.LOGGER.warn("Couldn't read the Rose Gold Equipment config, using defaults", e);
        }
    }
}
