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

        registerExistingQualityFood("mite_crust", ENDERS_QUALITY, ModFoods.DIET, false, EndersCreativeTab.ENDER_ITEMS);
        registerExistingQualityFood("shulker_mollusk", ENDERS_QUALITY, ModFoods.DIET, false, EndersCreativeTab.ENDER_ITEMS);
        registerExistingQualityFood("shulker_filet", ENDERS_QUALITY, ModFoods.DIET, false, EndersCreativeTab.ENDER_ITEMS);
        registerExistingQualityFood("uncanny_cookies", ENDERS_QUALITY, ModFoods.UNCANNY_COOKIES, false, EndersCreativeTab.ENDER_ITEMS);
        registerExistingQualityFood("strange_eclair", ENDERS_QUALITY, ModFoods.STRANGE_ECLAIR, false, EndersCreativeTab.ENDER_ITEMS);
        registerExistingQualityFood("crispy_skewer", ENDERS_QUALITY, ModFoods.STRANGE_ECLAIR, false, EndersCreativeTab.ENDER_ITEMS);
        registerExistingQualityFood("crawling_sandwich", ENDERS_QUALITY, ModFoods.CRAWLING_SANDWICH, false, EndersCreativeTab.ENDER_ITEMS);
        registerExistingQualityFood("endermite_stew", ENDERS_QUALITY, ModFoods.CRAWLING_SANDWICH, false, EndersCreativeTab.ENDER_ITEMS);

        registerExistingQualityFoodWithEffects("pearl_pasta", ENDERS_QUALITY, EndersFood.PEARL_PASTA, EndersCreativeTab.ENDER_ITEMS);
        registerExistingQualityFoodWithEffects("ender_paella", ENDERS_QUALITY, EndersFood.ENDER_PAELLA, EndersCreativeTab.ENDER_ITEMS);

        STUFFED_SHULKER_BOWL = registerFeastItem(ENDERS_QUALITY, "stuffed_shulker_bowl", ModFoods.STUFFED_SHULKER, EndersCreativeTab.ENDER_ITEMS);

        ENDERS_QUALITY.register(eventBus);
    }

}
