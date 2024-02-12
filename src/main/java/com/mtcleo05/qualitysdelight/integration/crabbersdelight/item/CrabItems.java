package com.mtcleo05.qualitysdelight.integration.crabbersdelight.item;

import alabaster.crabbersdelight.common.CDFoodValues;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.mtcleo05.qualitysdelight.item.DelightItems.*;

public class CrabItems {

    public static final DeferredRegister<Item> CRAB_QUALITY = DeferredRegister.create(ForgeRegistries.ITEMS, QualitysDelight.MODID);

    public static void register(IEventBus eventBus){

        registerExistingQuality("clam", CRAB_QUALITY, CrabCreativeTab.CRAB_ITEMS);

        registerExistingQualityFood("crab", CRAB_QUALITY, CDFoodValues.RAW_CRAB, false, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFood("cooked_crab", CRAB_QUALITY, CDFoodValues.COOKED_CRAB, false, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFood("clawster", CRAB_QUALITY, CDFoodValues.RAW_CLAWSTER, false, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFood("cooked_clawster", CRAB_QUALITY, CDFoodValues.COOKED_CLAWSTER, false, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFood("shrimp", CRAB_QUALITY, CDFoodValues.RAW_SHRIMP, false, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFood("cooked_shrimp", CRAB_QUALITY, CDFoodValues.COOKED_SHRIMP, false, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFood("raw_clam_meat", CRAB_QUALITY, CDFoodValues.RAW_CLAM_MEAT, false, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFood("cooked_clam_meat", CRAB_QUALITY, CDFoodValues.COOKED_CLAM_MEAT, false, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFood("cooked_tropical_fish", CRAB_QUALITY, CDFoodValues.COOKED_TROPICAL_FISH, false, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFood("crab_leg", CRAB_QUALITY, CDFoodValues.CRAB_LEGS, false, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFood("tropical_fish_slice", CRAB_QUALITY, CDFoodValues.TROPICAL_FISH_SLICE, false, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFood("cooked_tropical_fish_slice", CRAB_QUALITY, CDFoodValues.COOKED_TROPICAL_FISH_SLICE, false, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFood("shrimp_skewer", CRAB_QUALITY, CDFoodValues.COOKED_CLAM_MEAT, false, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFood("fish_stick", CRAB_QUALITY, CDFoodValues.COOKED_TROPICAL_FISH, false, CrabCreativeTab.CRAB_ITEMS);

        registerExistingQualityFoodWithEffects("stuffed_nautilus_shell", CRAB_QUALITY, CrabFood.STUFFED_NAUTILUS_SHELL, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFoodWithEffects("clam_bake", CRAB_QUALITY, CrabFood.CLAM_BAKE, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFoodWithEffects("seafood_gumbo", CRAB_QUALITY, CrabFood.SEAFOOD_GUMBO, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFoodWithEffects("bisque", CRAB_QUALITY, CrabFood.BISQUE, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFoodWithEffects("crab_cakes", CRAB_QUALITY, CrabFood.CRAB_CAKES, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFoodWithEffects("clam_chowder", CRAB_QUALITY, CrabFood.CLAM_CHOWDER, CrabCreativeTab.CRAB_ITEMS);
        registerExistingQualityFoodWithEffects("surf_and_turf", CRAB_QUALITY, CrabFood.SURFNTURF, CrabCreativeTab.CRAB_ITEMS);

        CRAB_QUALITY.register(eventBus);
    }

}
