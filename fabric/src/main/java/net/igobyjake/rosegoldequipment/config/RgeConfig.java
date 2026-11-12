package net.igobyjake.rosegoldequipment.config;

/**
 * Rose Gold Equipment's settings, as plain values the rest of the mod reads.
 *
 * The loader fills these in at the very start of mod loading (NeoForge: the "startup" config,
 * config/rosegoldequipment-startup.toml; Fabric: config/rosegoldequipment.json), before any item
 * is created - so they need a game RESTART to take effect, and a server and its players should
 * use the same values.
 *
 * Vanilla-only (same file on Fabric and NeoForge).
 */
public final class RgeConfig {
    public static final double DEFAULT_SWORD_ATTACK_DAMAGE = 6.0;
    public static final double MIN_SWORD_ATTACK_DAMAGE = 1.0;
    public static final double MAX_SWORD_ATTACK_DAMAGE = 50.0;

    /** Rose golden sword attack damage, as shown in its tooltip (iron 6, diamond 7, netherite 8). */
    public static double swordAttackDamage = DEFAULT_SWORD_ATTACK_DAMAGE;
    /** Give rose gold tools and armor diamond durability (tools 1561 instead of 466, armor x33 instead of x20). */
    public static boolean diamondDurability = false;
    /** Rose gold foods give their potion effects (off = they only fill hunger). */
    public static boolean foodEffects = true;

    private RgeConfig() {}

    /**
     * The number the sword's registration needs. The tooltip shows 1 (base hand damage) +
     * the rose gold material bonus (1) + this.
     */
    public static float swordBaseDamage() {
        return (float) (swordAttackDamage - 1.0 - 1.0);
    }

    public static int toolDurability() {
        return diamondDurability ? 1561 : 466;
    }

    /** Armor durability = this x 11 (helmet), 16 (chestplate), 15 (leggings), 13 (boots). */
    public static int armorDurabilityMultiplier() {
        return diamondDurability ? 33 : 20;
    }
}
