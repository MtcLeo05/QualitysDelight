package com.mtcleo05.qualitysdelight.integration.endersdelight.item;

import com.axedgaming.endersdelight.item.ModFoods;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.mtcleo05.qualitysdelight.item.DelightItems.*;

public class EndersItems {

    public static final DeferredRegister<Item> ENDERS_QUALITY = DeferredRegister.create(ForgeRegistries.ITEMS, QualitysDelight.MODID);


    public static RegistryObject<Item>[] STUFFED_SHULKER_BOWL = new RegistryObject[3];

    public static void register(IEventBus eventBus){

        registerExistingQualityFood("mite_crust", ENDERS_QUALITY, ModFoods.DIET, false);
        registerExistingQualityFood("shulker_mollusk", ENDERS_QUALITY, ModFoods.DIET, false);
        registerExistingQualityFood("shulker_filet", ENDERS_QUALITY, ModFoods.DIET, false);
        registerExistingQualityFood("uncanny_cookies", ENDERS_QUALITY, ModFoods.UNCANNY_COOKIES, false);
        registerExistingQualityFood("strange_eclair", ENDERS_QUALITY, ModFoods.STRANGE_ECLAIR, false);
        registerExistingQualityFood("crispy_skewer", ENDERS_QUALITY, ModFoods.STRANGE_ECLAIR, false);
        registerExistingQualityFood("crawling_sandwich", ENDERS_QUALITY, ModFoods.CRAWLING_SANDWICH, false);
        registerExistingQualityFood("endermite_stew", ENDERS_QUALITY, ModFoods.CRAWLING_SANDWICH, false);

        registerExistingQualityFoodWithEffects("pearl_pasta", ENDERS_QUALITY, EndersFood.PEARL_PASTA);
        registerExistingQualityFoodWithEffects("ender_paella", ENDERS_QUALITY, EndersFood.ENDER_PAELLA);

        STUFFED_SHULKER_BOWL = registerFeastItem(ENDERS_QUALITY, "stuffed_shulker_bowl", ModFoods.STUFFED_SHULKER);

        ENDERS_QUALITY.register(eventBus);
    }

}
