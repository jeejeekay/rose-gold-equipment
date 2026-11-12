package net.igobyjake.rosegoldequipment.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/** The in-game settings screen on Fabric, drawn by Cloth Config. Only loaded when Cloth Config is installed. */
public final class ClothConfigScreen {
    private ClothConfigScreen() {}

    public static Screen create(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Component.translatable("rosegoldequipment.configuration.title"))
                .setSavingRunnable(ConfigFile::save);
        ConfigEntryBuilder entries = builder.entryBuilder();
        ConfigCategory general = builder.getOrCreateCategory(Component.translatable("rosegoldequipment.configuration.section.general"));

        general.addEntry(entries.startDoubleField(Component.translatable("rosegoldequipment.configuration.sword_attack_damage"), RgeConfig.swordAttackDamage)
                .setDefaultValue(RgeConfig.DEFAULT_SWORD_ATTACK_DAMAGE)
                .setMin(RgeConfig.MIN_SWORD_ATTACK_DAMAGE).setMax(RgeConfig.MAX_SWORD_ATTACK_DAMAGE)
                .setTooltip(Component.translatable("rosegoldequipment.configuration.sword_attack_damage.tooltip"))
                .setSaveConsumer(value -> RgeConfig.swordAttackDamage = value)
                .requireRestart()
                .build());
        general.addEntry(entries.startBooleanToggle(Component.translatable("rosegoldequipment.configuration.diamond_durability"), RgeConfig.diamondDurability)
                .setDefaultValue(false)
                .setTooltip(Component.translatable("rosegoldequipment.configuration.diamond_durability.tooltip"))
                .setSaveConsumer(value -> RgeConfig.diamondDurability = value)
                .requireRestart()
                .build());
        general.addEntry(entries.startBooleanToggle(Component.translatable("rosegoldequipment.configuration.food_effects"), RgeConfig.foodEffects)
                .setDefaultValue(true)
                .setTooltip(Component.translatable("rosegoldequipment.configuration.food_effects.tooltip"))
                .setSaveConsumer(value -> RgeConfig.foodEffects = value)
                .requireRestart()
                .build());
        return builder.build();
    }
}
