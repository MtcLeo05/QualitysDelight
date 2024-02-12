package com.mtcleo05.qualitysdelight.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class DelightFoods {
    public static final FoodProperties[] RAW_PASTA = createFoodMapWithEffect(2, 0.3f, 600, 0, 0.3f, MobEffects.HUNGER);
    public static final FoodProperties[] CHICKEN_CUTS = createFoodMapWithEffect(1, 0.3f, 600, 0, 0.3f, MobEffects.HUNGER);
    public static final FoodProperties[] FRUIT_SALAD = createFoodMapWithEffect(6, 0.6f, 600, 0, 1f, MobEffects.REGENERATION);
    public static final FoodProperties[] MIXED_SALAD = createFoodMapWithEffect(6, 0.6f, 600, 0, 1f, MobEffects.REGENERATION);

    //Forced to do so, any other way breaks the NOURISHMENT / COMFORT effect...
    public static final FoodProperties[] GRILLED_SALMON = createFoodMapWithNourishment(14, 0.75f, 3600, 0, 1.0f);
    public static final FoodProperties[] BACON_AND_EGGS = createFoodMapWithNourishment(10, 0.6f, 1200, 0, 1.0f);
    public static final FoodProperties[] STEAK_AND_POTATOES = createFoodMapWithNourishment(12, 0.8f, 3600, 0, 1.0f);
    public static final FoodProperties[] ROASTED_MUTTON_CHOPS = createFoodMapWithNourishment(14, 0.75f, 6000, 0, 1.0f);
    public static final FoodProperties[] HONEY_GLAZED_HAM = createFoodMapWithNourishment(14, 0.75f, 6000, 0, 1.0f);
    public static final FoodProperties[] PASTA_WITH_MEATBALLS = createFoodMapWithNourishment(12, 0.8f, 3600, 0, 1.0f);
    public static final FoodProperties[] PASTA_WITH_MUTTON_CHOP = createFoodMapWithNourishment(12, 0.8f, 3600, 0, 1.0f);
    public static final FoodProperties[] MUSHROOM_RICE = createFoodMapWithNourishment(12, 0.8f, 3600, 0, 1.0f);
    public static final FoodProperties[] VEGETABLE_NOODLES = createFoodMapWithNourishment(14, 0.75f, 6000, 0, 1.0f);
    public static final FoodProperties[] SQUID_INK_PASTA = createFoodMapWithNourishment(14, 0.75f, 6000, 0, 1.0f);
    public static final FoodProperties[] RATATOUILLE = createFoodMapWithNourishment(10, 0.6f, 1200, 0, 1.0f);
    public static final FoodProperties[] ROAST_CHICKEN = createFoodMapWithNourishment(14, 0.75f, 6000, 0, 1.0f);
    public static final FoodProperties[] STUFFED_PUMPKIN = createFoodMapWithNourishment(14, 0.75f, 6000, 0, 1.0f);
    public static final FoodProperties[] SHEPHERDS_PIE = createFoodMapWithNourishment(14, 0.75f, 6000, 0, 1.0f);
    public static final FoodProperties[] COOKED_RICE = createFoodMapWithComfort(6, 0.4f, 600, 0, 1.0f);
    public static final FoodProperties[] BONE_BROTH = createFoodMapWithComfort(8, 0.75f, 1200, 0, 1.0f);
    public static final FoodProperties[] BEEF_STEW = createFoodMapWithComfort(12, 0.8f, 3600, 0, 1.0f);
    public static final FoodProperties[] CHICKEN_SOUP = createFoodMapWithComfort(14, 0.75f, 6000, 0, 1.0f);
    public static final FoodProperties[] VEGETABLE_SOUP = createFoodMapWithComfort(12, 0.8f, 3600, 0, 1.0f);
    public static final FoodProperties[] FISH_STEW = createFoodMapWithComfort(12, 0.8f, 3600, 0, 1.0f);
    public static final FoodProperties[] FRIED_RICE = createFoodMapWithComfort(14, 0.75f, 6000, 0, 1.0f);
    public static final FoodProperties[] PUMPKIN_SOUP = createFoodMapWithComfort(14, 0.75f, 6000, 0, 1.0f);
    public static final FoodProperties[] BAKED_COD_STEW = createFoodMapWithComfort(14, 0.75f, 6000, 0, 1.0f);
    public static final FoodProperties[] NOODLE_SOUP = createFoodMapWithComfort(14, 0.75f, 6000, 0, 1.0f);

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

    public static FoodProperties[] createFoodMapWithNourishment(int nutrition, float saturation, int duration, int amplifier, float probability) {
        // Create a map to store the calculated nutrition values for different food properties
        FoodProperties[] foodMap = new FoodProperties[3];


        FoodProperties IRON = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.25f))
                .saturationMod(saturation * 1.25f)
                .effect(() ->
                        new MobEffectInstance(ModEffects.NOURISHMENT.get(), Math.round(duration * 1.25f), amplifier), probability
                )
                .build();

        FoodProperties GOLD = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.5f))
                .saturationMod(saturation * 1.5f)
                .effect(() ->
                        new MobEffectInstance(ModEffects.NOURISHMENT.get(), Math.round(duration * 1.5f), amplifier), probability
                )
                .build();

        FoodProperties DIAMOND = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 2f))
                .saturationMod(saturation * 2f)
                .effect(() ->
                        new MobEffectInstance(ModEffects.NOURISHMENT.get(), Math.round(duration * 2f), amplifier), probability
                )
                .build();

        // Calculate the nutrition for each food property and put it into the map
        foodMap[0] = IRON;
        foodMap[1] = GOLD;
        foodMap[2] = DIAMOND;

        return foodMap;
    }

    public static FoodProperties[] createFoodMapWithComfort(int nutrition, float saturation, int duration, int amplifier, float probability) {
        // Create a map to store the calculated nutrition values for different food properties
        FoodProperties[] foodMap = new FoodProperties[3];


        FoodProperties IRON = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.25f))
                .saturationMod(saturation * 1.25f)
                .effect(() ->
                        new MobEffectInstance(ModEffects.COMFORT.get(), Math.round(duration * 1.25f), amplifier), probability
                )
                .build();

        FoodProperties GOLD = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 1.5f))
                .saturationMod(saturation * 1.5f)
                .effect(() ->
                        new MobEffectInstance(ModEffects.COMFORT.get(), Math.round(duration * 1.5f), amplifier), probability
                )
                .build();

        FoodProperties DIAMOND = new FoodProperties.Builder()
                .nutrition(Math.round(nutrition * 2f))
                .saturationMod(saturation * 2f)
                .effect(() ->
                        new MobEffectInstance(ModEffects.COMFORT.get(), Math.round(duration * 2f), amplifier), probability
                )
                .build();

        // Calculate the nutrition for each food property and put it into the map
        foodMap[0] = IRON;
        foodMap[1] = GOLD;
        foodMap[2] = DIAMOND;

        return foodMap;
    }
}
