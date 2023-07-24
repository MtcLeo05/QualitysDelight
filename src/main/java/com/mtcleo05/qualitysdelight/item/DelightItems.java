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
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.List;
import java.util.Objects;

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

    public static void registerExistingQualityFoodWithThreeEffect(String id, DeferredRegister<Item> register, FoodProperties foodProperties, MobEffect effect1, int duration1, int amplifier1, MobEffect effect2, int duration2, int amplifier2, MobEffect effect3, int duration3, int amplifier3, float chance){
        register.register(id + "_iron", () ->
                new QualityItem(
                        new Item.Properties()
                                .tab(DelightCreativeTab.ITEMS)
                                .rarity(ModRarities.IRON)
                                .food(new FoodProperties.Builder()
                                        .nutrition(Math.round(foodProperties.getNutrition() * 1.25f))
                                        .saturationMod(foodProperties.getSaturationModifier() * 1.25f)
                                        .effect(() -> new MobEffectInstance(effect1, Math.round(duration1 * 1.25f), Math.round(amplifier1 * 1.25f)), chance)
                                        .effect(() -> new MobEffectInstance(effect2, Math.round(duration2 * 1.25f), Math.round(amplifier2 * 1.25f)), chance)
                                        .effect(() -> new MobEffectInstance(effect3, Math.round(duration3 * 1.25f), Math.round(amplifier3 * 1.25f)), chance)
                                        .build()),
                        1));

        register.register(id + "_gold", () -> new QualityItem(
                new Item.Properties()
                        .tab(DelightCreativeTab.ITEMS)
                        .rarity(ModRarities.GOLD)
                        .food(new FoodProperties.Builder()
                                .nutrition(Math.round(foodProperties.getNutrition() * 1.5f))
                                .saturationMod(foodProperties.getSaturationModifier() * 1.5f)
                                .effect(() -> new MobEffectInstance(effect1, Math.round(duration1 * 1.5f), Math.round(amplifier1 * 1.5f)), chance)
                                .effect(() -> new MobEffectInstance(effect2, Math.round(duration2 * 1.5f), Math.round(amplifier2 * 1.5f)), chance)
                                .effect(() -> new MobEffectInstance(effect3, Math.round(duration3 * 1.5f), Math.round(amplifier3 * 1.5f)), chance)
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
                                .effect(() -> new MobEffectInstance(effect1, Math.round(duration1 * 2f), Math.round(amplifier1 * 2f)), chance)
                                .effect(() -> new MobEffectInstance(effect2, Math.round(duration2 * 2f), Math.round(amplifier2 * 2f)), chance)
                                .effect(() -> new MobEffectInstance(effect3, Math.round(duration3 * 2f), Math.round(amplifier3 * 2f)), chance)
                                .build()),
                3
        ));
    }


    //I TRIED TO AUTOMATE THIS BUT WASN'T ABLE TO...
    public static void register(IEventBus eventBus){
        registerExistingQuality("cabbage", QUALITY_DELIGHT);
        registerExistingQuality("tomato", QUALITY_DELIGHT);
        registerExistingQuality("onion", QUALITY_DELIGHT);
        registerExistingQuality("rice_panicle", QUALITY_DELIGHT);
        registerExistingQuality("rice", QUALITY_DELIGHT);
        registerExistingQualityFood("fried_egg", QUALITY_DELIGHT, FoodValues.FRIED_EGG, false);
        registerExistingQualityFood("minced_beef", QUALITY_DELIGHT, FoodValues.MINCED_BEEF, false);
        registerExistingQualityFood("bacon", QUALITY_DELIGHT, FoodValues.BACON, false);
        registerExistingQualityFood("cod_slice", QUALITY_DELIGHT, FoodValues.COD_SLICE, false);
        registerExistingQualityFood("salmon_slice", QUALITY_DELIGHT, FoodValues.SALMON_SLICE, false);
        registerExistingQualityFood("mutton_chops", QUALITY_DELIGHT, FoodValues.MUTTON_CHOP, false);
        registerExistingQualityFood("ham", QUALITY_DELIGHT, FoodValues.HAM, false);
        registerExistingQualityFoodWithOneEffect("raw_pasta", QUALITY_DELIGHT, FoodValues.RAW_PASTA, MobEffects.HUNGER, 600, 0, 0.3f);
        registerExistingQualityFoodWithOneEffect("chicken_cuts", QUALITY_DELIGHT, FoodValues.CHICKEN_CUTS, MobEffects.HUNGER, 600, 0, 0.3f);

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
