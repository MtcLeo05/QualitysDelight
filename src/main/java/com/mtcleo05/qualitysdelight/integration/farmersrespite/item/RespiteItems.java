package com.mtcleo05.qualitysdelight.integration.farmersrespite.item;

import com.farmersrespite.core.utility.FRFoods;
import com.mtcleo05.qualitycrops.rarities.ModRarities;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static com.mtcleo05.qualitysdelight.item.DelightItems.*;

public class RespiteItems {

    public static final DeferredRegister<Item> RESPITE_QUALITY = DeferredRegister.create(ForgeRegistries.ITEMS, QualitysDelight.MODID);


    public static void register(IEventBus eventBus){

        registerExistingQuality("green_tea_leaves", RESPITE_QUALITY, RespiteCreativeTab.RESPITE_ITEMS);
        registerExistingQuality("yellow_tea_leaves", RESPITE_QUALITY, RespiteCreativeTab.RESPITE_ITEMS);
        registerExistingQuality("black_tea_leaves", RESPITE_QUALITY, RespiteCreativeTab.RESPITE_ITEMS);
        registerExistingQuality("coffee_beans", RESPITE_QUALITY, RespiteCreativeTab.RESPITE_ITEMS);

        registerExistingQualityFoodWithEffects("coffee_berries", RESPITE_QUALITY, RespiteFood.COFFEE_BERRIES, RespiteCreativeTab.RESPITE_ITEMS);
        registerExistingQualityFood("green_tea_cookie", RESPITE_QUALITY, FRFoods.GREEN_TEA_COOKIE, false, RespiteCreativeTab.RESPITE_ITEMS);
        registerExistingQualityFood("nether_wart_sourdough", RESPITE_QUALITY, FRFoods.NETHER_WART_SOURDOUGH, false, RespiteCreativeTab.RESPITE_ITEMS);

        registerExistingQualityFoodBowlWithEffects("black_cod", RESPITE_QUALITY, RespiteFood.BLACK_COD, RespiteCreativeTab.RESPITE_ITEMS);
        registerExistingQualityFoodBowlWithEffects("tea_curry", RESPITE_QUALITY, RespiteFood.TEA_CURRY, RespiteCreativeTab.RESPITE_ITEMS);
        registerExistingQualityFoodBowlWithEffects("blazing_chili", RESPITE_QUALITY, RespiteFood.BLAZING_CHILI, RespiteCreativeTab.RESPITE_ITEMS);

        registerExistingQualityTea("green_tea", RESPITE_QUALITY, RespiteFood.GREEN_TEA, RespiteCreativeTab.RESPITE_ITEMS);
        registerExistingQualityTea("yellow_tea", RESPITE_QUALITY, RespiteFood.YELLOW_TEA, RespiteCreativeTab.RESPITE_ITEMS);
        registerExistingQualityTea("black_tea", RESPITE_QUALITY, RespiteFood.BLACK_TEA, RespiteCreativeTab.RESPITE_ITEMS);
        registerExistingQualityTea("dandelion_tea", RESPITE_QUALITY, RespiteFood.DANDELION_TEA, RespiteCreativeTab.RESPITE_ITEMS);
        registerExistingQualityTea("coffee", RESPITE_QUALITY, RespiteFood.COFFEE, RespiteCreativeTab.RESPITE_ITEMS);

        RESPITE_QUALITY.register(eventBus);
    }


    public static void registerExistingQualityTea(String id, DeferredRegister<Item> register, FoodProperties[] foodProperties, CreativeModeTab creativeModeTab){
        register.register(id + "_iron", () ->
                new DrinkableItem(
                        new Item.Properties()
                                .tab(creativeModeTab)
                                .rarity(ModRarities.IRON)
                                .food(foodProperties[0])
                                .craftRemainder(Items.GLASS_BOTTLE)
                                .stacksTo(16),
                        true,
                        false
                ));

        register.register(id + "_gold", () ->
                new DrinkableItem(
                        new Item.Properties()
                                .tab(creativeModeTab)
                                .rarity(ModRarities.GOLD)
                                .food(foodProperties[1])
                                .craftRemainder(Items.GLASS_BOTTLE)
                                .stacksTo(16),
                        true,
                        false

                ));

        register.register(id + "_diamond", () ->
                new DrinkableItem(
                        new Item.Properties()
                                .tab(creativeModeTab)
                                .rarity(ModRarities.DIAMOND)
                                .food(foodProperties[2])
                                .craftRemainder(Items.GLASS_BOTTLE)
                                .stacksTo(16),
                        true,
                        false
                ));
    }

}
