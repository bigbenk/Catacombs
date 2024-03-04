package net.bbenk.catacombsofkarthus.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties MOLDY_BOTTLE = new FoodProperties.Builder().nutrition(6).saturationMod(4).saturationMod(2)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100), 0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 60), 0.5f).build();
}
