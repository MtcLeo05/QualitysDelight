package com.mtcleo05.qualitysdelight.item;

import com.mtcleo05.qualitycrops.quality.QualityBowlFoodItem;
import com.mtcleo05.qualitycrops.quality.QualityItem;
import com.mtcleo05.qualitycrops.rarities.ModRarities;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;

import java.util.Objects;
import static vectorwing.farmersdelight.common.registry.ModEffects.COMFORT;
import static vectorwing.farmersdelight.common.registry.ModEffects.NOURISHMENT;

public class DelightItems {

    public static final DeferredRegister<Item> QUALITY_DELIGHT = DeferredRegister.create(ForgeRegistries.ITEMS, QualitysDelight.MODID);

    public static void registerQualityItem(String id, DeferredRegister<Item> register){
        register.register(id, () ->
                new Item(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                ));

        register.register(id + "_iron", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.IRON)
                                .tab(DelightCreativeTab.ITEMS),
                        1
                ));

        register.register(id + "_gold", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.GOLD)
                                .tab(DelightCreativeTab.ITEMS),
                        2
                ));

        register.register(id + "_diamond", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.DIAMOND)
                                .tab(DelightCreativeTab.ITEMS),
                        3
                ));
    }

    public static void registerExistingQuality(String id, DeferredRegister<Item> register){
        register.register(id + "_iron", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.IRON)
                                .tab(DelightCreativeTab.ITEMS),
                        1
                ));

        register.register(id + "_gold", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.GOLD)
                                .tab(DelightCreativeTab.ITEMS),
                        2
                ));

        register.register(id + "_diamond", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.DIAMOND)
                                .tab(DelightCreativeTab.ITEMS),
                        3
                ));

    }

    public static void registerQualityFood(String id, DeferredRegister<Item> register, FoodProperties foodProperties, boolean isSoup){
        register.register(id, () -> {
            if(isSoup){
                return new BowlFoodItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .stacksTo(1)
                                .food(new FoodProperties.Builder()
                                        .nutrition(foodProperties.getNutrition())
                                        .saturationMod(foodProperties.getSaturationModifier())
                                        .build())
                );
            }else{
                return new Item(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .food(new FoodProperties.Builder()
                                        .nutrition(foodProperties.getNutrition())
                                        .saturationMod(foodProperties.getSaturationModifier())
                                        .build())
                );
            }
        });

        register.register(id + "_iron", () -> {
            if(isSoup){
                return new QualityBowlFoodItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .stacksTo(1)
                                .rarity(ModRarities.IRON)
                                .food(new FoodProperties.Builder()
                                        .nutrition(Math.round(foodProperties.getNutrition() * 1.25f))
                                        .saturationMod(foodProperties.getSaturationModifier() * 1.25f)
                                        .build()),
                        1
                );
            }else{
                return new QualityItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .rarity(ModRarities.IRON)
                                .food(new FoodProperties.Builder()
                                        .nutrition(Math.round(foodProperties.getNutrition() * 1.25f))
                                        .saturationMod(foodProperties.getSaturationModifier() * 1.25f)
                                        .build()),
                        1
                );
            }
        });

        register.register(id + "_gold", () -> {
            if(isSoup){
                return new QualityBowlFoodItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .stacksTo(1)
                                .rarity(ModRarities.GOLD)
                                .food(new FoodProperties.Builder()
                                        .nutrition(Math.round(foodProperties.getNutrition() * 1.5f))
                                        .saturationMod(foodProperties.getSaturationModifier() * 1.5f)
                                        .build()),
                        2

                );
            }else{
                return new QualityItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .rarity(ModRarities.GOLD)
                                .food(new FoodProperties.Builder()
                                        .nutrition(Math.round(foodProperties.getNutrition() * 1.5f))
                                        .saturationMod(foodProperties.getSaturationModifier() * 1.5f)
                                        .build()),
                        2
                );
            }
        });

        register.register(id + "_diamond", () -> {
            if(isSoup){
                return new QualityBowlFoodItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .stacksTo(1)
                                .rarity(ModRarities.DIAMOND)
                                .food(new FoodProperties.Builder()
                                        .nutrition(foodProperties.getNutrition() * 2)
                                        .saturationMod(foodProperties.getSaturationModifier() * 2f)
                                        .build()),
                        3

                );
            }else{
                return new QualityItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .rarity(ModRarities.DIAMOND)
                                .food(new FoodProperties.Builder()
                                        .nutrition(foodProperties.getNutrition() * 2)
                                        .saturationMod(foodProperties.getSaturationModifier() * 2f)
                                        .build()),
                        3
                );
            }
        });
    }

    public static void registerExistingQualityFood(String id, DeferredRegister<Item> register, FoodProperties foodProperties, boolean isSoup){
        register.register(id + "_iron", () -> {
            if(isSoup){
                return new QualityBowlFoodItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .stacksTo(1)
                                .rarity(ModRarities.IRON)
                                .food(new FoodProperties.Builder()
                                        .nutrition(Math.round(foodProperties.getNutrition() * 1.25f))
                                        .saturationMod(foodProperties.getSaturationModifier() * 1.25f)
                                        .build()),
                        1
                );
            }else{
                return new QualityItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .rarity(ModRarities.IRON)
                                .food(new FoodProperties.Builder()
                                        .nutrition(Math.round(foodProperties.getNutrition() * 1.25f))
                                        .saturationMod(foodProperties.getSaturationModifier() * 1.25f)
                                        .build()),
                        1
                );
            }
        });

        register.register(id + "_gold", () -> {
            if(isSoup){
                return new QualityBowlFoodItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .stacksTo(1)
                                .rarity(ModRarities.GOLD)
                                .food(new FoodProperties.Builder()
                                        .nutrition(Math.round(foodProperties.getNutrition() * 1.5f))
                                        .saturationMod(foodProperties.getSaturationModifier() * 1.5f)
                                        .build()),
                        2

                );
            }else{
                return new QualityItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .rarity(ModRarities.GOLD)
                                .food(new FoodProperties.Builder()
                                        .nutrition(Math.round(foodProperties.getNutrition() * 1.5f))
                                        .saturationMod(foodProperties.getSaturationModifier() * 1.5f)
                                        .build()),
                        2
                );
            }
        });

        register.register(id + "_diamond", () -> {
            if(isSoup){
                return new QualityBowlFoodItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .stacksTo(1)
                                .rarity(ModRarities.DIAMOND)
                                .food(new FoodProperties.Builder()
                                        .nutrition(foodProperties.getNutrition() * 2)
                                        .saturationMod(foodProperties.getSaturationModifier() * 2f)
                                        .build()),
                        3
                );
            }else{
                return new QualityItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .rarity(ModRarities.DIAMOND)
                                .food(new FoodProperties.Builder()
                                        .nutrition(foodProperties.getNutrition() * 2)
                                        .saturationMod(foodProperties.getSaturationModifier() * 2f)
                                        .build()),
                        3
                );
            }
        });
    }

    public static void registerExistingQualityFoodWithOneEffect(String id, DeferredRegister<Item> register, FoodProperties foodProperties, MobEffect effect, int duration, int amplifier, float chance){
        register.register(id + "_iron", () ->
                new QualityItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .rarity(ModRarities.IRON)
                                .food(new FoodProperties.Builder()
                                        .nutrition(Math.round(foodProperties.getNutrition() * 1.25f))
                                        .saturationMod(foodProperties.getSaturationModifier() * 1.25f)
                                        .effect(() -> new MobEffectInstance(effect, Math.round(duration * 1.25f), Math.round(amplifier * 1.25f)), chance)
                                        .build()),
                        1));

        register.register(id + "_gold", () -> new QualityItem(
                new Item.Properties()
                        .tab(DelightCreativeTab.ITEMS)
                        .rarity(ModRarities.GOLD)
                        .food(new FoodProperties.Builder()
                                .nutrition(Math.round(foodProperties.getNutrition() * 1.5f))
                                .saturationMod(foodProperties.getSaturationModifier() * 1.5f)
                                .effect(() -> new MobEffectInstance(effect, Math.round(duration * 1.5f), Math.round(amplifier * 1.5f)), chance)
                                .build()),
                2
        ));

        register.register(id + "_diamond", () -> new QualityItem(
                new Item.Properties()
                        .tab(DelightCreativeTab.ITEMS)
                        .rarity(ModRarities.DIAMOND)
                        .food(new FoodProperties.Builder()
                                .nutrition(foodProperties.getNutrition() * 2)
                                .saturationMod(foodProperties.getSaturationModifier() * 2f)
                                .effect(() -> new MobEffectInstance(effect, Math.round(duration * 2f), Math.round(amplifier * 2f)), chance)
                                .build()),
                3
        ));
    }

    public static void registerExistingQualityFoodBowlWithOneEffect(String id, DeferredRegister<Item> register, FoodProperties foodProperties, MobEffect effect, int duration, int amplifier, float chance){
        register.register(id + "_iron", () ->
                new QualityBowlFoodItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .rarity(ModRarities.IRON)
                                .food(new FoodProperties.Builder()
                                        .nutrition(Math.round(foodProperties.getNutrition() * 1.25f))
                                        .saturationMod(foodProperties.getSaturationModifier() * 1.25f)
                                        .effect(() -> new MobEffectInstance(effect, Math.round(duration * 1.25f), Math.round(amplifier * 1.25f)), chance)
                                        .build()),
                        1));

        register.register(id + "_gold", () ->
                new QualityBowlFoodItem(
                    new Item.Properties()
                            .tab(DelightCreativeTab.ITEMS)
                            .rarity(ModRarities.GOLD)
                            .food(new FoodProperties.Builder()
                                    .nutrition(Math.round(foodProperties.getNutrition() * 1.5f))
                                    .saturationMod(foodProperties.getSaturationModifier() * 1.5f)
                                    .effect(() -> new MobEffectInstance(effect, Math.round(duration * 1.5f), Math.round(amplifier * 1.5f)), chance)
                                    .build()),
                    2
        ));

        register.register(id + "_diamond", () ->
                new QualityBowlFoodItem(
                    new Item.Properties()
                            .tab(DelightCreativeTab.ITEMS)
                            .rarity(ModRarities.DIAMOND)
                            .food(new FoodProperties.Builder()
                                    .nutrition(foodProperties.getNutrition() * 2)
                                    .saturationMod(foodProperties.getSaturationModifier() * 2f)
                                    .effect(() -> new MobEffectInstance(effect, Math.round(duration * 2f), Math.round(amplifier * 2f)), chance)
                                    .build()),
                    3
        ));
    }

    //I TRIED TO AUTOMATE THIS BUT WASN'T ABLE TO...
    public static void register(IEventBus eventBus){


        System.out.println("REGISTERING ITEMS");

        registerExistingQuality("rice_panicle", QUALITY_DELIGHT);
        registerExistingQuality("rice", QUALITY_DELIGHT);
        registerExistingQualityFood("cabbage", QUALITY_DELIGHT, FoodValues.CABBAGE, false);
        registerExistingQualityFood("cabbage_leaf", QUALITY_DELIGHT, FoodValues.CABBAGE_LEAF, false);
        registerExistingQualityFood("tomato", QUALITY_DELIGHT, FoodValues.TOMATO, false);
        registerExistingQualityFood("onion", QUALITY_DELIGHT, FoodValues.ONION, false);
        registerExistingQualityFood("fried_egg", QUALITY_DELIGHT, FoodValues.FRIED_EGG, false);
        registerExistingQualityFood("minced_beef", QUALITY_DELIGHT, FoodValues.MINCED_BEEF, false);
        registerExistingQualityFood("beef_patty", QUALITY_DELIGHT, FoodValues.BEEF_PATTY, false);
        registerExistingQualityFood("bacon", QUALITY_DELIGHT, FoodValues.BACON, false);
        registerExistingQualityFood("cooked_bacon", QUALITY_DELIGHT, FoodValues.COOKED_BACON, false);
        registerExistingQualityFood("cod_slice", QUALITY_DELIGHT, FoodValues.COD_SLICE, false);
        registerExistingQualityFood("cooked_cod_slice", QUALITY_DELIGHT, FoodValues.COOKED_COD_SLICE, false);
        registerExistingQualityFood("salmon_slice", QUALITY_DELIGHT, FoodValues.SALMON_SLICE, false);
        registerExistingQualityFood("cooked_salmon_slice", QUALITY_DELIGHT, FoodValues.COOKED_SALMON_SLICE, false);
        registerExistingQualityFood("mutton_chops", QUALITY_DELIGHT, FoodValues.MUTTON_CHOP, false);
        registerExistingQualityFood("cooked_mutton_chops", QUALITY_DELIGHT, FoodValues.COOKED_MUTTON_CHOP, false);
        registerExistingQualityFood("cooked_chicken_cuts", QUALITY_DELIGHT, FoodValues.COOKED_CHICKEN_CUTS, false);
        registerExistingQualityFood("bacon_sandwich", QUALITY_DELIGHT, FoodValues.BACON_SANDWICH, false);
        registerExistingQualityFood("hamburger", QUALITY_DELIGHT, FoodValues.HAMBURGER, false);
        registerExistingQualityFood("mutton_wrap", QUALITY_DELIGHT, FoodValues.MUTTON_WRAP, false);
        registerExistingQualityFood("chicken_sandwich", QUALITY_DELIGHT, FoodValues.CHICKEN_SANDWICH, false);
        registerExistingQualityFood("sweet_berry_cookie", QUALITY_DELIGHT, FoodValues.COOKIES, false);
        registerExistingQualityFood("honey_cookie", QUALITY_DELIGHT, FoodValues.COOKIES, false);
        registerExistingQualityFood("melon_popsicle", QUALITY_DELIGHT, FoodValues.POPSICLE, false);
        registerExistingQualityFood("barbecue_stick", QUALITY_DELIGHT, FoodValues.BARBECUE_STICK, false);
        registerExistingQualityFood("egg_sandwich", QUALITY_DELIGHT, FoodValues.EGG_SANDWICH, false);
        registerExistingQualityFood("stuffed_potato", QUALITY_DELIGHT, FoodValues.STUFFED_POTATO, false);
        registerExistingQualityFood("cod_roll", QUALITY_DELIGHT, FoodValues.COD_ROLL, false);
        registerExistingQualityFood("salmon_roll", QUALITY_DELIGHT, FoodValues.SALMON_ROLL, false);
        registerExistingQualityFood("kelp_roll", QUALITY_DELIGHT, FoodValues.KELP_ROLL, false);
        registerExistingQualityFood("kelp_roll_slice", QUALITY_DELIGHT, FoodValues.KELP_ROLL_SLICE, false);
        registerExistingQualityFood("grilled_salmon", DelightItems.QUALITY_DELIGHT, FoodValues.GRILLED_SALMON, true);
        registerExistingQualityFood("bacon_and_eggs", DelightItems.QUALITY_DELIGHT, FoodValues.BACON_AND_EGGS, true);
        registerExistingQualityFood("cooked_rice", DelightItems.QUALITY_DELIGHT, FoodValues.COOKED_RICE, true);
        registerExistingQualityFood("steak_and_potatoes", DelightItems.QUALITY_DELIGHT, FoodValues.STEAK_AND_POTATOES, true);
        registerExistingQualityFood("roasted_mutton_chops", DelightItems.QUALITY_DELIGHT, FoodValues.ROASTED_MUTTON_CHOPS, true);
        registerExistingQualityFood("bone_broth", DelightItems.QUALITY_DELIGHT, FoodValues.BONE_BROTH, true);
        registerExistingQualityFood("beef_stew", QUALITY_DELIGHT, FoodValues.BEEF_STEW, true);
        registerExistingQualityFood("tomato_sauce", QUALITY_DELIGHT, FoodValues.TOMATO_SAUCE, true);
        registerExistingQualityFood("chicken_soup", QUALITY_DELIGHT, FoodValues.CHICKEN_SOUP, true);
        registerExistingQualityFood("vegetable_soup", QUALITY_DELIGHT, FoodValues.VEGETABLE_SOUP, true);
        registerExistingQualityFoodWithOneEffect("raw_pasta", QUALITY_DELIGHT, FoodValues.RAW_PASTA, MobEffects.HUNGER, 600, 0, 0.3f);
        registerExistingQualityFoodWithOneEffect("chicken_cuts", QUALITY_DELIGHT, FoodValues.CHICKEN_CUTS, MobEffects.HUNGER, 600, 0, 0.3f);
        registerExistingQualityFoodBowlWithOneEffect("mixed_salad", QUALITY_DELIGHT, FoodValues.MIXED_SALAD, MobEffects.REGENERATION, 300, 0, 1f);
        registerExistingQualityFoodBowlWithOneEffect("fruit_salad", QUALITY_DELIGHT, FoodValues.FRUIT_SALAD, MobEffects.REGENERATION, 300, 0, 1f);
        /*
        TODO Understand why it doesn't work
            registerExistingQualityFoodBowlWithOneEffect("grilled_salmon", DelightItems.QUALITY_DELIGHT, FoodValues.GRILLED_SALMON, NOURISHMENT.get(), 3600, 0, 1f);
            registerExistingQualityFoodBowlWithOneEffect("bacon_and_eggs", DelightItems.QUALITY_DELIGHT, FoodValues.BACON_AND_EGGS, NOURISHMENT.get(), 1200, 0, 1f);
            registerExistingQualityFoodBowlWithOneEffect("cooked_rice", DelightItems.QUALITY_DELIGHT, FoodValues.COOKED_RICE, COMFORT.get(), 600, 0, 1f);
            registerExistingQualityFoodBowlWithOneEffect("steak_and_potatoes", DelightItems.QUALITY_DELIGHT, FoodValues.STEAK_AND_POTATOES, NOURISHMENT.get(), 3600, 0, 1f);
            registerExistingQualityFoodBowlWithOneEffect("roasted_mutton_chops", DelightItems.QUALITY_DELIGHT, FoodValues.ROASTED_MUTTON_CHOPS, NOURISHMENT.get(), 6000, 0, 1f);
            registerExistingQualityFoodBowlWithOneEffect("bone_broth", DelightItems.QUALITY_DELIGHT, FoodValues.BONE_BROTH, COMFORT.get(), 1200, 0, 1f);
         */
        QUALITY_DELIGHT.register(eventBus);
    }

    public static Item getItemFromID(String id, DeferredRegister<Item> register){
        Iterable<Item> qualityCrops = register.getEntries().stream().map(RegistryObject::get)::iterator;
        for (Item item : qualityCrops) {
            if (getItemName(item).equals(id)) {
                return item;
            }
        }
        return null;
    }

    private static String getItemName(Item item){
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }


}
