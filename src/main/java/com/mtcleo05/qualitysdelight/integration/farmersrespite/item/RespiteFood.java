package com.mtcleo05.qualitysdelight.integration.farmersrespite.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import umpaz.farmersrespite.common.registry.FREffects;
import vectorwing.farmersdelight.common.registry.ModEffects;

import static com.mtcleo05.qualitysdelight.item.DelightFoods.createFoodMapWithComfort;
import static com.mtcleo05.qualitysdelight.item.DelightFoods.createFoodMapWithNourishment;

public class RespiteFood {

    public static final FoodProperties[] COFFEE_BERRIES = createFoodMapWithCaffeinatedAndEffect(2, 0.4f, 100, 0, 1f, MobEffects.WITHER);

    public static final FoodProperties[] BLACK_COD = createFoodMapWithCaffeinatedAndNourishment(10, 0.4f, 3600, 600, 0);
    public static final FoodProperties[] TEA_CURRY = createFoodMapWithEffect(10, 0.8f, 3600, 600, 0, MobEffects.DAMAGE_RESISTANCE);
    public static final FoodProperties[] BLAZING_CHILI = createFoodMapWithCaffeinatedAndEffect(10, 0.9f, 120, 0, 1f, MobEffects.FIRE_RESISTANCE);

    public static final FoodProperties[] GREEN_TEA = createFoodMapWithEffectAlwaysEat(0, 0.0f, 3600, 0, 1f, MobEffects.DIG_SPEED);
    public static final FoodProperties[] YELLOW_TEA = createFoodMapWithEffectAlwaysEat(0, 0.0f, 3600, 0, 1f, MobEffects.DAMAGE_RESISTANCE);
    public static final FoodProperties[] BLACK_TEA = createFoodMapWithCaffeinatedAlwaysEat(0, 0.0f, 600, 0, 1f);
    public static final FoodProperties[] DANDELION_TEA = createFoodMapWithComfortAlwaysEat(0, 0.0f, 3600, 0, 1f);
    public static final FoodProperties[] COFFEE = createFoodMapWithCaffeinatedAlwaysEat(0, 0.0f, 6000, 1, 1f);

    public static FoodProperties[] createFoodMapWithCaffeinatedAndEffect(int nutrition, float saturation, int duration, int amplifier, float probability, MobEffect mobEffect) {
        // Create a map to store the calculated nutrition values for different food properties
        FoodProperties[] foodMap = new FoodProperties[3];


        FoodProperties IRON = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.25f))
                .saturationMod(saturation * 1.25f)
                .effect(() ->
                        new MobEffectInstance(FREffects.CAFFEINATED.get(), Math.round(duration * 1.25f), amplifier), probability
                )
                .effect(() ->
                        new MobEffectInstance(mobEffect, Math.round(duration * 1.25f), amplifier), probability
                )
                .build();

        FoodProperties GOLD = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.5f))
                .saturationMod(saturation * 1.5f)
                .effect(() ->
                        new MobEffectInstance(FREffects.CAFFEINATED.get(), Math.round(duration * 1.5f), amplifier), probability
                )
                .effect(() ->
                        new MobEffectInstance(mobEffect, Math.round(duration * 1.25f), amplifier), probability
                )
                .build();

        FoodProperties DIAMOND = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 2f))
                .saturationMod(saturation * 2f)
                .effect(() ->
                        new MobEffectInstance(FREffects.CAFFEINATED.get(), Math.round(duration * 2f), amplifier), probability
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
    public static FoodProperties[] createFoodMapWithCaffeinatedAndNourishment(int nutrition, float saturation, int duration, int duration1, int amplifier) {
        // Create a map to store the calculated nutrition values for different food properties
        FoodProperties[] foodMap = new FoodProperties[3];


        FoodProperties IRON = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.25f))
                .saturationMod(saturation * 1.25f)
                .effect(() ->
                        new MobEffectInstance(FREffects.CAFFEINATED.get(), Math.round(duration * 1.25f), amplifier), 1
                )
                .effect(() ->
                        new MobEffectInstance(ModEffects.NOURISHMENT.get(), Math.round(duration1 * 1.25f), amplifier), 1
                )
                .build();

        FoodProperties GOLD = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.5f))
                .saturationMod(saturation * 1.5f)
                .effect(() ->
                        new MobEffectInstance(FREffects.CAFFEINATED.get(), Math.round(duration * 1.5f), amplifier), 1
                )
                .effect(() ->
                        new MobEffectInstance(ModEffects.NOURISHMENT.get(), Math.round(duration1 * 1.25f), amplifier), 1
                )
                .build();

        FoodProperties DIAMOND = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 2f))
                .saturationMod(saturation * 2f)
                .effect(() ->
                        new MobEffectInstance(FREffects.CAFFEINATED.get(), Math.round(duration * 2f), amplifier), 1
                )
                .effect(() ->
                        new MobEffectInstance(ModEffects.NOURISHMENT.get(), Math.round(duration1 * 1.25f), amplifier), 1
                )
                .build();

        // Calculate the nutrition for each food property and put it into the map
        foodMap[0] = IRON;
        foodMap[1] = GOLD;
        foodMap[2] = DIAMOND;

        return foodMap;
    }

    public static FoodProperties[] createFoodMapWithEffect(int nutrition, float saturation, int duration, int amplifier, float probability, MobEffect mobEffect) {
        FoodProperties[] foodMap = new FoodProperties[3];


        FoodProperties IRON = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.25f))
                .saturationMod(saturation * 1.25f)
                .effect(() ->
                        new MobEffectInstance(mobEffect, Math.round(duration * 1.25f), amplifier), probability
                )
                .build();

        FoodProperties GOLD = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.5f))
                .saturationMod(saturation * 1.5f)
                .effect(() ->
                        new MobEffectInstance(mobEffect, Math.round(duration * 1.5f), amplifier), probability
                )
                .build();

        FoodProperties DIAMOND = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 2f))
                .saturationMod(saturation * 2f)
                .effect(() ->
                        new MobEffectInstance(mobEffect, Math.round(duration * 2f), amplifier), probability
                )
                .build();

        foodMap[0] = IRON;
        foodMap[1] = GOLD;
        foodMap[2] = DIAMOND;

        return foodMap;
    }

    public static FoodProperties[] createFoodMapWithEffectAlwaysEat(int nutrition, float saturation, int duration, int amplifier, float probability, MobEffect mobEffect) {
        FoodProperties[] foodMap = new FoodProperties[3];


        FoodProperties IRON = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.25f))
                .saturationMod(saturation * 1.25f)
                .effect(() ->
                        new MobEffectInstance(mobEffect, Math.round(duration * 1.25f), amplifier), probability
                )
                .alwaysEat()
                .build();

        FoodProperties GOLD = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.5f))
                .saturationMod(saturation * 1.5f)
                .effect(() ->
                        new MobEffectInstance(mobEffect, Math.round(duration * 1.5f), amplifier), probability
                )
                .alwaysEat()
                .build();

        FoodProperties DIAMOND = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 2f))
                .saturationMod(saturation * 2f)
                .effect(() ->
                        new MobEffectInstance(mobEffect, Math.round(duration * 2f), amplifier), probability
                )
                .alwaysEat()
                .build();

        foodMap[0] = IRON;
        foodMap[1] = GOLD;
        foodMap[2] = DIAMOND;

        return foodMap;
    }

    public static FoodProperties[] createFoodMapWithCaffeinatedAlwaysEat(int nutrition, float saturation, int duration, int amplifier, float probability) {
        FoodProperties[] foodMap = new FoodProperties[3];


        FoodProperties IRON = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.25f))
                .saturationMod(saturation * 1.25f)
                .effect(() ->
                        new MobEffectInstance(FREffects.CAFFEINATED.get(), Math.round(duration * 1.25f), amplifier), probability
                )
                .alwaysEat()
                .build();

        FoodProperties GOLD = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.5f))
                .saturationMod(saturation * 1.5f)
                .effect(() ->
                        new MobEffectInstance(FREffects.CAFFEINATED.get(), Math.round(duration * 1.5f), amplifier), probability
                )
                .alwaysEat()
                .build();

        FoodProperties DIAMOND = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 2f))
                .saturationMod(saturation * 2f)
                .effect(() ->
                        new MobEffectInstance(FREffects.CAFFEINATED.get(), Math.round(duration * 2f), amplifier), probability
                )
                .alwaysEat()
                .build();

        foodMap[0] = IRON;
        foodMap[1] = GOLD;
        foodMap[2] = DIAMOND;

        return foodMap;
    }

    public static FoodProperties[] createFoodMapWithComfortAlwaysEat(int nutrition, float saturation, int duration, int amplifier, float probability) {
        FoodProperties[] foodMap = new FoodProperties[3];


        FoodProperties IRON = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.25f))
                .saturationMod(saturation * 1.25f)
                .effect(() ->
                        new MobEffectInstance(ModEffects.COMFORT.get(), Math.round(duration * 1.25f), amplifier), probability
                )
                .alwaysEat()
                .build();

        FoodProperties GOLD = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.5f))
                .saturationMod(saturation * 1.5f)
                .effect(() ->
                        new MobEffectInstance(ModEffects.COMFORT.get(), Math.round(duration * 1.5f), amplifier), probability
                )
                .alwaysEat()
                .build();

        FoodProperties DIAMOND = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 2f))
                .saturationMod(saturation * 2f)
                .effect(() ->
                        new MobEffectInstance(ModEffects.COMFORT.get(), Math.round(duration * 2f), amplifier), probability
                )
                .alwaysEat()
                .build();

        foodMap[0] = IRON;
        foodMap[1] = GOLD;
        foodMap[2] = DIAMOND;

        return foodMap;
    }
}
