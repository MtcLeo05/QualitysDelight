package com.mtcleo05.qualitysdelight.integration.nethersdelight.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

import static com.mtcleo05.qualitysdelight.item.DelightFoods.createFoodMapWithComfort;
import static com.mtcleo05.qualitysdelight.item.DelightFoods.createFoodMapWithNourishment;

public class NetherFood {

    public static final FoodProperties[] WARPED_MOLDY_MEAT = createFoodMapWith2Effects(9, 0.8f, 200, 0, 0.3f, MobEffects.BLINDNESS, MobEffects.CONFUSION);
    public static final FoodProperties[] GRILLED_STRIDER = createFoodMapWithNourishmentAndEffect(10, 0.9f, 600, 0, 0.3f, MobEffects.FIRE_RESISTANCE);
    public static final FoodProperties[] STRIDER_MOSS_STEW = createFoodMapWithComfort(8, 0.6f, 2400, 0, 1f);
    public static final FoodProperties[] MAGMA_GELATIN = createFoodMap(8, 0.6f);
    public static final FoodProperties[] STUFFED_HOGLIN_ROAST = createFoodMapWithNourishment(8, 0.6f, 2400, 0, 1.0f);
    public static final FoodProperties[] STUFFED_HOGLIN_SNOUT = createFoodMapWithNourishment(14, 0.9f, 4800, 0, 1.0f);
    public static final FoodProperties[] STUFFED_HOGLIN_HAM = createFoodMapWithNourishment(10, 0.75f, 4800, 0, 1.0f);

    public static FoodProperties[] createFoodMapWith2Effects(int nutrition, float saturation, int duration, int amplifier, float probability, MobEffect mobEffect, MobEffect mobEffect1) {
        FoodProperties[] foodMap = new FoodProperties[3];


        FoodProperties IRON = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.25f))
                .saturationMod(saturation * 1.25f)
                .effect(() ->
                        new MobEffectInstance(mobEffect, Math.round(duration * 1.25f), amplifier), probability
                )
                .effect(() ->
                        new MobEffectInstance(mobEffect1, Math.round(duration * 1.25f), amplifier), probability
                )
                .build();

        FoodProperties GOLD = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.5f))
                .saturationMod(saturation * 1.5f)
                .effect(() ->
                        new MobEffectInstance(mobEffect, Math.round(duration * 1.5f), amplifier), probability
                )
                .effect(() ->
                        new MobEffectInstance(mobEffect1, Math.round(duration * 1.5f), amplifier), probability
                )
                .build();

        FoodProperties DIAMOND = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 2f))
                .saturationMod(saturation * 2f)
                .effect(() ->
                        new MobEffectInstance(mobEffect, Math.round(duration * 2f), amplifier), probability
                )
                .effect(() ->
                        new MobEffectInstance(mobEffect1, Math.round(duration * 2f), amplifier), probability
                )
                .build();

        foodMap[0] = IRON;
        foodMap[1] = GOLD;
        foodMap[2] = DIAMOND;

        return foodMap;
    }
    public static FoodProperties[] createFoodMap(int nutrition, float saturation) {
        FoodProperties[] foodMap = new FoodProperties[3];


        FoodProperties IRON = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.25f))
                .saturationMod(saturation * 1.25f)
                .build();

        FoodProperties GOLD = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.5f))
                .saturationMod(saturation * 1.5f)
                .build();

        FoodProperties DIAMOND = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 2f))
                .saturationMod(saturation * 2f)
                .build();

        foodMap[0] = IRON;
        foodMap[1] = GOLD;
        foodMap[2] = DIAMOND;

        return foodMap;
    }

    public static FoodProperties[] createFoodMapWithNourishmentAndEffect(int nutrition, float saturation, int duration, int amplifier, float probability, MobEffect mobEffect) {
        // Create a map to store the calculated nutrition values for different food properties
        FoodProperties[] foodMap = new FoodProperties[3];


        FoodProperties IRON = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.25f))
                .saturationMod(saturation * 1.25f)
                .effect(() ->
                        new MobEffectInstance(ModEffects.NOURISHMENT.get(), Math.round(duration * 1.25f), amplifier), probability
                )
                .effect(() ->
                        new MobEffectInstance(mobEffect, Math.round(duration * 1.25f), amplifier), probability
                )
                .build();

        FoodProperties GOLD = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.5f))
                .saturationMod(saturation * 1.5f)
                .effect(() ->
                        new MobEffectInstance(ModEffects.NOURISHMENT.get(), Math.round(duration * 1.5f), amplifier), probability
                )
                .effect(() ->
                        new MobEffectInstance(mobEffect, Math.round(duration * 1.25f), amplifier), probability
                )
                .build();

        FoodProperties DIAMOND = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 2f))
                .saturationMod(saturation * 2f)
                .effect(() ->
                        new MobEffectInstance(ModEffects.NOURISHMENT.get(), Math.round(duration * 2f), amplifier), probability
                )
                .effect(() ->
                        new MobEffectInstance(mobEffect, Math.round(duration * 1.25f), amplifier), probability
                )
                .build();

        // Calculate the nutrition for each food property and put it into the map
        foodMap[0] = IRON;
        foodMap[1] = GOLD;
        foodMap[2] = DIAMOND;

        return foodMap;
    }

}
