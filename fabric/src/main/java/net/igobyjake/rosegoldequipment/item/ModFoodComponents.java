package net.igobyjake.rosegoldequipment.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodComponents {

    public static final FoodComponent ROSE_GILDED_BEETROOT = new FoodComponent.Builder().nutrition(6).saturationModifier(.6f)
            .alwaysEdible().build();
    public static final FoodComponent ROSEY_BEETROOT_STEW = new FoodComponent.Builder().nutrition(14).saturationModifier(1.0f)
            .alwaysEdible().build();
    public static final FoodComponent ROSE_MUSHROOM_OMELETTE = new FoodComponent.Builder().nutrition(5).saturationModifier(.4f)
            .alwaysEdible().build();
    public static final FoodComponent ROSE_MUSHROOM_PARTIAL = new FoodComponent.Builder().nutrition(5).saturationModifier(.4f)
            .alwaysEdible().build();
    public static final FoodComponent ROSE_MUSHROOM_CRUMBS = new FoodComponent.Builder().nutrition(5).saturationModifier(.4f)
            .alwaysEdible().build();
    public static final FoodComponent ROSE_FULL_JELLY = new FoodComponent.Builder().nutrition(8).saturationModifier(1.2f)
            .alwaysEdible().build();
    public static final FoodComponent ROSE_HALF_JELLY = new FoodComponent.Builder().nutrition(8).saturationModifier(1.2f)
            .alwaysEdible().build();
    public static final FoodComponent ROSE_GILDED_MUSHROOM = new FoodComponent.Builder().nutrition(2).saturationModifier(.2f)
            .alwaysEdible().build();
    public static final FoodComponent ROSE_GILDED_COOKIE = new FoodComponent.Builder().nutrition(2).saturationModifier(.4f)
            .alwaysEdible().build();


    public static final ConsumableComponent ROSE_GILDED_BEETROOT_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 6, 10), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 400, 0), 1.0F))
            .build();
    public static final ConsumableComponent ROSEY_BEETROOT_STEW_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 2), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1200, 1), 1.0F))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 1200, 1), 1.0F))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), 1.0F))
            .build();
    public static final ConsumableComponent ROSE_MUSHROOM_OMELETTE_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 6, 10), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 800, 1), 1.0F))
            .build();
    public static final ConsumableComponent ROSE_FULL_JELLY_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 6, 10), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 800, 1), 1.0F))
            .build();
    public static final ConsumableComponent ROSE_GILDED_MUSHROOM_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 2, 10), 1.0f))
            .consumeSeconds(0.8F).build();

    public static final ConsumableComponent ROSE_GILDED_COOKIE_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 2, 10),1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 0), 1.0F))
            .consumeSeconds(0.8F).build();
}
