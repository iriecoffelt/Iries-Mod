package net.irie.iriesmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
            .alwaysEat()
            .nutrition(2)
            .saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 12000), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 12000), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 12000), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 12000), 1.0f)
            .build();

    public static final FoodProperties CORN = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 100), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1000), 0.5f)
            .build();
}
