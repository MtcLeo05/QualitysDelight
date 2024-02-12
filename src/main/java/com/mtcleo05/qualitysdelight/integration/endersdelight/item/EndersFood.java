package com.mtcleo05.qualitysdelight.integration.endersdelight.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import umpaz.farmersrespite.common.registry.FREffects;
import vectorwing.farmersdelight.common.registry.ModEffects;

import static com.mtcleo05.qualitysdelight.integration.nethersdelight.item.NetherFood.createFoodMapWithNourishmentAndEffect;
import static com.mtcleo05.qualitysdelight.item.DelightFoods.createFoodMapWithNourishment;

public class EndersFood {

    public static final FoodProperties[] PEARL_PASTA = createFoodMapWithNourishment(4, 0.4f, 6000, 0, 1);
    public static final FoodProperties[] ENDER_PAELLA = createFoodMapWithNourishmentAndEffect(4, 0.4f, 6000, 0, 1, MobEffects.DAMAGE_RESISTANCE);

}
