package com.mtcleo05.qualitysdelight.item;

import com.mtcleo05.qualitycrops.quality.QualityBowlFoodItem;
import com.mtcleo05.qualitycrops.quality.QualityItem;
import com.mtcleo05.qualitycrops.rarities.ModRarities;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import com.mtcleo05.qualitysdelight.block.DelightBlocks;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;

import java.util.Objects;
import java.util.function.Supplier;

public class DelightItems {

    public static final DeferredRegister<Item> QUALITY_DELIGHT = DeferredRegister.create(ForgeRegistries.ITEMS, QualitysDelight.MODID);

    public static RegistryObject<Item>[] ROAST_CHICKEN = new RegistryObject[3];
    public static RegistryObject<Item>[] STUFFED_PUMPKIN = new RegistryObject[3];
    public static RegistryObject<Item>[] SHEPHERDS_PIE = new RegistryObject[3];
    public static RegistryObject<Item>[] HONEY_GLAZED_HAM = new RegistryObject[3];

    public static RegistryObject<Item>[] KELP_ROLL_SLICE = new RegistryObject[3];
    public static RegistryObject<Item>[] COD_ROLL = new RegistryObject[3];
    public static RegistryObject<Item>[] SALMON_ROLL = new RegistryObject[3];
    public static void registerQualityItem(String id, DeferredRegister<Item> register){
        register.register(id, () ->
                new Item(
                        new Item.Properties()
                ));

        register.register(id + "_iron", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.IRON),
                        1
                ));

        register.register(id + "_gold", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.GOLD),
                        2
                ));

        register.register(id + "_diamond", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.DIAMOND),
                        3
                ));
    }

    public static void registerExistingQuality(String id, DeferredRegister<Item> register){
        register.register(id + "_iron", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.IRON),
                        1
                ));

        register.register(id + "_gold", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.GOLD),
                        2
                ));

        register.register(id + "_diamond", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.DIAMOND),
                        3
                ));

    }

    public static void registerQualityFood(String id, DeferredRegister<Item> register, FoodProperties foodProperties, boolean isSoup){
        register.register(id, () -> {
            if(isSoup){
                return new BowlFoodItem(
                        new Item.Properties()
                                .stacksTo(1)
                                .food(new FoodProperties.Builder()
                                        .nutrition(foodProperties.getNutrition())
                                        .saturationMod(foodProperties.getSaturationModifier())
                                        .build())
                );
            }else{
                return new Item(
                        new Item.Properties()
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

    public static void registerExistingQualityFoodWithEffects(String id, DeferredRegister<Item> register, FoodProperties[] foodProperties){
        register.register(id + "_iron", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.IRON)
                                .food(foodProperties[0]),
                        1));

        register.register(id + "_gold", () -> new QualityItem(
                new Item.Properties()
                        .rarity(ModRarities.GOLD)
                        .food(foodProperties[1]),
                2
        ));

        register.register(id + "_diamond", () -> new QualityItem(
                new Item.Properties()
                        .rarity(ModRarities.DIAMOND)
                        .food(foodProperties[2]),
                3
        ));
    }

    public static void registerExistingQualityFoodBowlWithEffects(String id, DeferredRegister<Item> register, FoodProperties[] foodProperties){
        register.register(id + "_iron", () ->
                new QualityBowlFoodItem(
                        new Item.Properties()
                                .rarity(ModRarities.IRON)
                                .food(foodProperties[0]),
                        1));

        register.register(id + "_gold", () ->
                new QualityBowlFoodItem(
                    new Item.Properties()
                            .rarity(ModRarities.GOLD)
                            .food(foodProperties[1]),
                    2
        ));

        register.register(id + "_diamond", () ->
                new QualityBowlFoodItem(
                    new Item.Properties()
                            .rarity(ModRarities.DIAMOND)
                            .food(foodProperties[2]),
                    3
        ));
    }

    //I TRIED TO AUTOMATE THIS BUT WASN'T ABLE TO...
    public static void register(IEventBus eventBus){
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
        registerExistingQualityFood("ham", QUALITY_DELIGHT, FoodValues.HAM, false);
        registerExistingQualityFood("smoked_ham", QUALITY_DELIGHT, FoodValues.SMOKED_HAM, false);
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
        registerExistingQualityFood("kelp_roll", QUALITY_DELIGHT, FoodValues.KELP_ROLL, false);
        registerExistingQualityFood("dumplings", QUALITY_DELIGHT, FoodValues.DUMPLINGS, false);
        registerExistingQualityFood("cabbage_rolls", QUALITY_DELIGHT, FoodValues.CABBAGE_ROLLS, false);
        registerExistingQualityFood("tomato_sauce", QUALITY_DELIGHT, FoodValues.TOMATO_SAUCE, true);

        //Start of the item with effects
        registerExistingQualityFoodWithEffects("raw_pasta", QUALITY_DELIGHT, DelightFoods.RAW_PASTA);
        registerExistingQualityFoodWithEffects("chicken_cuts", QUALITY_DELIGHT, DelightFoods.CHICKEN_CUTS);
        registerExistingQualityFoodBowlWithEffects("mixed_salad", QUALITY_DELIGHT, DelightFoods.MIXED_SALAD);
        registerExistingQualityFoodBowlWithEffects("fruit_salad", QUALITY_DELIGHT, DelightFoods.FRUIT_SALAD);
        registerExistingQualityFoodBowlWithEffects("grilled_salmon", DelightItems.QUALITY_DELIGHT, DelightFoods.GRILLED_SALMON);
        registerExistingQualityFoodBowlWithEffects("bacon_and_eggs", DelightItems.QUALITY_DELIGHT, DelightFoods.BACON_AND_EGGS);
        registerExistingQualityFoodBowlWithEffects("cooked_rice", DelightItems.QUALITY_DELIGHT, DelightFoods.COOKED_RICE);
        registerExistingQualityFoodBowlWithEffects("steak_and_potatoes", DelightItems.QUALITY_DELIGHT, DelightFoods.STEAK_AND_POTATOES);
        registerExistingQualityFoodBowlWithEffects("roasted_mutton_chops", DelightItems.QUALITY_DELIGHT, DelightFoods.ROASTED_MUTTON_CHOPS);
        registerExistingQualityFoodBowlWithEffects("bone_broth", DelightItems.QUALITY_DELIGHT, DelightFoods.BONE_BROTH);
        registerExistingQualityFoodBowlWithEffects("beef_stew", QUALITY_DELIGHT, DelightFoods.BEEF_STEW);
        registerExistingQualityFoodBowlWithEffects("chicken_soup", QUALITY_DELIGHT, DelightFoods.CHICKEN_SOUP);
        registerExistingQualityFoodBowlWithEffects("vegetable_soup", QUALITY_DELIGHT, DelightFoods.VEGETABLE_SOUP);
        registerExistingQualityFoodBowlWithEffects("fish_stew", DelightItems.QUALITY_DELIGHT, DelightFoods.FISH_STEW);
        registerExistingQualityFoodBowlWithEffects("fried_rice", DelightItems.QUALITY_DELIGHT, DelightFoods.FRIED_RICE);
        registerExistingQualityFoodBowlWithEffects("pumpkin_soup", QUALITY_DELIGHT, DelightFoods.PUMPKIN_SOUP);
        registerExistingQualityFoodBowlWithEffects("baked_cod_stew", QUALITY_DELIGHT, DelightFoods.BAKED_COD_STEW);
        registerExistingQualityFoodBowlWithEffects("noodle_soup", QUALITY_DELIGHT, DelightFoods.NOODLE_SOUP);
        registerExistingQualityFoodBowlWithEffects("pasta_with_meatballs", QUALITY_DELIGHT, DelightFoods.PASTA_WITH_MEATBALLS);
        registerExistingQualityFoodBowlWithEffects("pasta_with_mutton_chop", DelightItems.QUALITY_DELIGHT, DelightFoods.PASTA_WITH_MUTTON_CHOP);
        registerExistingQualityFoodBowlWithEffects("mushroom_rice", DelightItems.QUALITY_DELIGHT, DelightFoods.MUSHROOM_RICE);
        registerExistingQualityFoodBowlWithEffects("vegetable_noodles", QUALITY_DELIGHT, DelightFoods.VEGETABLE_NOODLES);
        registerExistingQualityFoodBowlWithEffects("squid_ink_pasta", QUALITY_DELIGHT, DelightFoods.SQUID_INK_PASTA);
        registerExistingQualityFoodBowlWithEffects("ratatouille", QUALITY_DELIGHT, DelightFoods.RATATOUILLE);


        //Must do this way, as the FeastBlock requires access to the registry object
        ROAST_CHICKEN = registerFeastItem(QUALITY_DELIGHT, "roast_chicken", DelightFoods.ROAST_CHICKEN);
        STUFFED_PUMPKIN = registerFeastItem(QUALITY_DELIGHT, "stuffed_pumpkin", DelightFoods.STUFFED_PUMPKIN);
        SHEPHERDS_PIE = registerFeastItem(QUALITY_DELIGHT, "shepherds_pie", DelightFoods.SHEPHERDS_PIE);
        HONEY_GLAZED_HAM = registerFeastItem(QUALITY_DELIGHT, "honey_glazed_ham", DelightFoods.HONEY_GLAZED_HAM);
        COD_ROLL = registerFeastItem(QUALITY_DELIGHT, "cod_roll", FoodValues.COD_ROLL);
        SALMON_ROLL = registerFeastItem(QUALITY_DELIGHT, "salmon_roll", FoodValues.SALMON_ROLL);
        KELP_ROLL_SLICE = registerFeastItem(QUALITY_DELIGHT, "kelp_roll_slice", FoodValues.KELP_ROLL_SLICE);

        QUALITY_DELIGHT.register(eventBus);

    }

    public static RegistryObject<Item>[] registerFeastItem(DeferredRegister<Item> register, String id, FoodProperties foodProperties){

        RegistryObject<Item>[] toReturn = new RegistryObject[3];

        toReturn[0] = register.register(id + "_iron", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.IRON)
                                .craftRemainder(Items.BOWL)
                                .food(new FoodProperties.Builder()
                                        .nutrition(Math.round(foodProperties.getNutrition() * 1.25f))
                                        .saturationMod(foodProperties.getSaturationModifier() * 1.25f)
                                        .build()),
                        1
                ));

        toReturn[1] = register.register(id + "_gold", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.GOLD)
                                .craftRemainder(Items.BOWL)
                                .food(new FoodProperties.Builder()
                                        .nutrition(Math.round(foodProperties.getNutrition() * 1.5f))
                                        .saturationMod(foodProperties.getSaturationModifier() * 1.5f)
                                        .build()),
                        2
                ));

        toReturn[2] = register.register(id + "_diamond", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.DIAMOND)
                                .craftRemainder(Items.BOWL)
                                .food(new FoodProperties.Builder()
                                        .nutrition(Math.round(foodProperties.getNutrition() * 2f))
                                        .saturationMod(foodProperties.getSaturationModifier() * 2f)
                                        .build()),
                        3
                ));

        return toReturn;
    }
    public static RegistryObject<Item>[] registerFeastItem(DeferredRegister<Item> register, String id, FoodProperties[] foodProperties){

        RegistryObject<Item>[] toReturn = new RegistryObject[3];

        toReturn[0] = register.register(id + "_iron", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.IRON)
                                .craftRemainder(Items.BOWL)
                                .food(foodProperties[0]),
                        1
                ));

        toReturn[1] = register.register(id + "_gold", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.GOLD)
                                .craftRemainder(Items.BOWL)
                                .food(foodProperties[1]),
                        2
                ));

        toReturn[2] = register.register(id + "_diamond", () ->
                new QualityItem(
                        new Item.Properties()
                                .rarity(ModRarities.DIAMOND)
                                .craftRemainder(Items.BOWL)
                                .food(foodProperties[2]),
                        3
                ));

        return toReturn;
    }
}
