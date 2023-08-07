package com.mtcleo05.qualitysdelight.integration.oceansdelight.item;

import com.mtcleo05.qualitysdelight.QualitysDelight;
import com.scouter.oceansdelight.items.ODFoods;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.mtcleo05.qualitysdelight.item.DelightItems.*;

public class OceanItems {

    public static final DeferredRegister<Item> OCEAN_QUALITY = DeferredRegister.create(ForgeRegistries.ITEMS, QualitysDelight.MODID);


    public static RegistryObject<Item>[] GUARDIAN_SOUP_BOWL = new RegistryObject[3];

    public static void register(IEventBus eventBus){

        registerExistingQuality("guardian", OCEAN_QUALITY, OceanCreativeTab.OCEAN_ITEMS);

        registerExistingQualityFood("tentacles", OCEAN_QUALITY, ODFoods.TENTACLES, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("cut_tentacles", OCEAN_QUALITY, ODFoods.CUT_TENTACLES, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("guardian_tail", OCEAN_QUALITY, ODFoods.GUARDIAN_TAIL, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("cooked_guardian_tail", OCEAN_QUALITY, ODFoods.COOKED_GUARDIAN_TAIL, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("elder_guardian_slab", OCEAN_QUALITY, ODFoods.ELDER_GUARDIAN_SLAB, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("elder_guardian_slice", OCEAN_QUALITY, ODFoods.ELDER_GUARDIAN_SLICE, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("cooked_elder_guardian_slice", OCEAN_QUALITY, ODFoods.COOKED_ELDER_GUARDIAN_SLICE, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("elder_guardian_roll", OCEAN_QUALITY, ODFoods.ELDER_GUARDIAN_ROLL, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("fugu_slice", OCEAN_QUALITY, ODFoods.FUGU_SLICE, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("fugu_roll", OCEAN_QUALITY, ODFoods.FUGU_ROLL, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("tentacle_on_a_stick", OCEAN_QUALITY, ODFoods.TENTACLE_ON_A_STICK, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("baked_tentacle_on_a_stick", OCEAN_QUALITY, ODFoods.BAKED_TENTACLE_ON_A_STICK, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("cabbage_wrapped_elder_guardian", OCEAN_QUALITY, ODFoods.CABBAGE_WRAPPED_ELDER_GUARDIAN, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("stuffed_cod", OCEAN_QUALITY, ODFoods.STUFFED_COD, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("cooked_stuffed_cod", OCEAN_QUALITY, ODFoods.COOKED_STUFFED_COD, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("honey_fried_kelp", OCEAN_QUALITY, ODFoods.HONEY_FRIED_KELP, false, OceanCreativeTab.OCEAN_ITEMS);
        registerExistingQualityFood("braised_sea_pickle", OCEAN_QUALITY, ODFoods.BRAISED_SEA_PICKLE, true, OceanCreativeTab.OCEAN_ITEMS);

        GUARDIAN_SOUP_BOWL = registerFeastItem(OCEAN_QUALITY, "bowl_of_guardian_soup", ODFoods.BOWL_OF_GUARDIAN_SOUP,OceanCreativeTab.OCEAN_ITEMS);

        OCEAN_QUALITY.register(eventBus);
    }

}
