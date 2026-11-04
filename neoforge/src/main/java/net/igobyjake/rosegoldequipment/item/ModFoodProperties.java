package net.igobyjake.rosegoldequipment.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoodProperties {
  public static final FoodProperties ROSE_GILDED_BEETROOT = new FoodProperties.Builder().nutrition(6).saturationModifier(.6f)
          .alwaysEdible().build();
    public static final FoodProperties ROSEY_BEETROOT_STEW = new FoodProperties.Builder().nutrition(14).saturationModifier(1.0f)
            .alwaysEdible().build();
    public static final FoodProperties ROSE_MUSHROOM_OMELETTE = new FoodProperties.Builder().nutrition(5).saturationModifier(.4f)
            .alwaysEdible().build();
    public static final FoodProperties ROSE_MUSHROOM_PARTIAL = new FoodProperties.Builder().nutrition(5).saturationModifier(.4f)
            .alwaysEdible().build();
    public static final FoodProperties ROSE_MUSHROOM_CRUMBS = new FoodProperties.Builder().nutrition(5).saturationModifier(.4f)
            .alwaysEdible().build();
    public static final FoodProperties ROSE_FULL_JELLY = new FoodProperties.Builder().nutrition(8).saturationModifier(1.2f)
            .alwaysEdible().build();
    public static final FoodProperties ROSE_HALF_JELLY = new FoodProperties.Builder().nutrition(8).saturationModifier(1.2f)
            .alwaysEdible().build();
    public static final FoodProperties ROSE_GILDED_MUSHROOM = new FoodProperties.Builder().nutrition(2).saturationModifier(.2f)
            .alwaysEdible().build();
    public static final FoodProperties ROSE_GILDED_COOKIE = new FoodProperties.Builder().nutrition(2).saturationModifier(.4f)
            .alwaysEdible().build();

    public static final Consumable ROSE_GILDED_BEETROOT_EFFECT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 6, 10), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.STRENGTH, 400, 0), 1.0F))
            .build();
    public static final Consumable ROSEY_BEETROOT_STEW_EFFECT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.INSTANT_HEALTH, 1, 2), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.STRENGTH, 1200, 1), 1.0F))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HASTE, 1200, 1), 1.0F))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F))
            .build();
    public static final Consumable ROSE_MUSHROOM_OMELETTE_EFFECT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 6, 10), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HASTE, 800, 1), 1.0F))
            .build();
    public static final Consumable ROSE_FULL_JELLY_EFFECT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 6, 10), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 800, 1), 1.0F))
            .build();
    public static final Consumable ROSE_GILDED_MUSHROOM_EFFECT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 2, 10), 1.0f))
            .consumeSeconds(0.8F).build();

    public static final Consumable ROSE_GILDED_COOKIE_EFFECT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 2, 10),1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 300, 0), 1.0F))
            .consumeSeconds(0.8F).build();
}
