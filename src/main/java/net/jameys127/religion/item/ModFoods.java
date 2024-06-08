package net.jameys127.religion.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SWEET_FLESH = new FoodProperties.Builder().meat().nutrition(6).saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 500), 0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000), 1)
            .build();
}
