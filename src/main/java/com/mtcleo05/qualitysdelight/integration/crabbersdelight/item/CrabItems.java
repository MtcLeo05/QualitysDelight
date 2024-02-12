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

        registerExistingQuality("clam", CRAB_QUALITY);

        registerExistingQualityFood("crab", CRAB_QUALITY, CDFoodValues.RAW_CRAB, false);
        registerExistingQualityFood("cooked_crab", CRAB_QUALITY, CDFoodValues.COOKED_CRAB, false);
        registerExistingQualityFood("clawster", CRAB_QUALITY, CDFoodValues.RAW_CLAWSTER, false);
        registerExistingQualityFood("cooked_clawster", CRAB_QUALITY, CDFoodValues.COOKED_CLAWSTER, false);
        registerExistingQualityFood("shrimp", CRAB_QUALITY, CDFoodValues.RAW_SHRIMP, false);
        registerExistingQualityFood("cooked_shrimp", CRAB_QUALITY, CDFoodValues.COOKED_SHRIMP, false);
        registerExistingQualityFood("raw_clam_meat", CRAB_QUALITY, CDFoodValues.RAW_CLAM_MEAT, false);
        registerExistingQualityFood("cooked_clam_meat", CRAB_QUALITY, CDFoodValues.COOKED_CLAM_MEAT, false);
        registerExistingQualityFood("cooked_tropical_fish", CRAB_QUALITY, CDFoodValues.COOKED_TROPICAL_FISH, false);
        registerExistingQualityFood("crab_leg", CRAB_QUALITY, CDFoodValues.CRAB_LEGS, false);
        registerExistingQualityFood("tropical_fish_slice", CRAB_QUALITY, CDFoodValues.TROPICAL_FISH_SLICE, false);
        registerExistingQualityFood("cooked_tropical_fish_slice", CRAB_QUALITY, CDFoodValues.COOKED_TROPICAL_FISH_SLICE, false);
        registerExistingQualityFood("shrimp_skewer", CRAB_QUALITY, CDFoodValues.COOKED_CLAM_MEAT, false);
        registerExistingQualityFood("fish_stick", CRAB_QUALITY, CDFoodValues.COOKED_TROPICAL_FISH, false);

        registerExistingQualityFoodWithEffects("stuffed_nautilus_shell", CRAB_QUALITY, CrabFood.STUFFED_NAUTILUS_SHELL);
        registerExistingQualityFoodWithEffects("clam_bake", CRAB_QUALITY, CrabFood.CLAM_BAKE);
        registerExistingQualityFoodWithEffects("seafood_gumbo", CRAB_QUALITY, CrabFood.SEAFOOD_GUMBO);
        registerExistingQualityFoodWithEffects("bisque", CRAB_QUALITY, CrabFood.BISQUE);
        registerExistingQualityFoodWithEffects("crab_cakes", CRAB_QUALITY, CrabFood.CRAB_CAKES);
        registerExistingQualityFoodWithEffects("clam_chowder", CRAB_QUALITY, CrabFood.CLAM_CHOWDER);
        registerExistingQualityFoodWithEffects("surf_and_turf", CRAB_QUALITY, CrabFood.SURFNTURF);

        CRAB_QUALITY.register(eventBus);
    }

}
