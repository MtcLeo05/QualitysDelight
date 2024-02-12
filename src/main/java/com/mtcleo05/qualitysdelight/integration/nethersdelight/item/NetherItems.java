package com.mtcleo05.qualitysdelight.integration.nethersdelight.item;

import com.mtcleo05.qualitycrops.rarities.ModRarities;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import com.nethersdelight.common.item.MagmaGelatinItem;
import com.nethersdelight.core.utility.NDFoods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.mtcleo05.qualitysdelight.item.DelightItems.*;

public class NetherItems {

    public static final DeferredRegister<Item> NETHER_QUALITY = DeferredRegister.create(ForgeRegistries.ITEMS, QualitysDelight.MODID);


    public static RegistryObject<Item>[] HOGLIN_EAR = new RegistryObject[3];
    public static RegistryObject<Item>[] HOGLIN_SNOUT = new RegistryObject[3];
    public static RegistryObject<Item>[] HOGLIN_ROAST = new RegistryObject[3];
    public static RegistryObject<Item>[] HOGLIN_HAM = new RegistryObject[3];

    public static void register(IEventBus eventBus){

        registerExistingQuality("raw_stuffed_hoglin", NETHER_QUALITY, NetherCreativeTab.NETHER_ITEMS);

        registerExistingQualityFood("hoglin_loin", NETHER_QUALITY, NDFoods.HOGLIN_LOIN, false, NetherCreativeTab.NETHER_ITEMS);
        registerExistingQualityFood("hoglin_sirloin", NETHER_QUALITY, NDFoods.HOGLIN_SIRLOIN, false, NetherCreativeTab.NETHER_ITEMS);
        registerExistingQualityFood("strider_slice", NETHER_QUALITY, NDFoods.STRIDER_SLICE, false, NetherCreativeTab.NETHER_ITEMS);
        registerExistingQualityFood("ground_strider", NETHER_QUALITY, NDFoods.GROUND_STRIDER, false, NetherCreativeTab.NETHER_ITEMS);
        registerExistingQualityFood("propelpearl", NETHER_QUALITY, NDFoods.PROPELPEARL, false, NetherCreativeTab.NETHER_ITEMS);
        registerExistingQualityFood("nether_skewer", NETHER_QUALITY, NDFoods.NETHER_SKEWER, false, NetherCreativeTab.NETHER_ITEMS);

        registerExistingQualityFoodBowlWithEffects("warped_moldy_meat", NETHER_QUALITY, NetherFood.WARPED_MOLDY_MEAT, NetherCreativeTab.NETHER_ITEMS);
        registerExistingQualityFoodBowlWithEffects("grilled_strider", NETHER_QUALITY, NetherFood.GRILLED_STRIDER, NetherCreativeTab.NETHER_ITEMS);
        registerExistingQualityFoodBowlWithEffects("strider_moss_stew", NETHER_QUALITY, NetherFood.STRIDER_MOSS_STEW, NetherCreativeTab.NETHER_ITEMS);

        NETHER_QUALITY.register("magma_gelatin_iron", () ->
                new MagmaGelatinItem(
                        new Item.Properties()
                                .food(NetherFood.MAGMA_GELATIN[0])
                                .stacksTo(1)
                                .craftRemainder(Items.BUCKET)
                                .tab(NetherCreativeTab.NETHER_ITEMS)
                                .rarity(ModRarities.IRON)
                ));

        NETHER_QUALITY.register("magma_gelatin_gold", () ->
                new MagmaGelatinItem(
                        new Item.Properties()
                                .food(NetherFood.MAGMA_GELATIN[1])
                                .stacksTo(1)
                                .craftRemainder(Items.BUCKET)
                                .tab(NetherCreativeTab.NETHER_ITEMS)
                                .rarity(ModRarities.GOLD)
                ));

        NETHER_QUALITY.register("magma_gelatin_diamond", () ->
                new MagmaGelatinItem(
                        new Item.Properties()
                                .food(NetherFood.MAGMA_GELATIN[2])
                                .stacksTo(1)
                                .craftRemainder(Items.BUCKET)
                                .tab(NetherCreativeTab.NETHER_ITEMS)
                                .rarity(ModRarities.DIAMOND)
                ));


        HOGLIN_EAR = registerFeastItem(NETHER_QUALITY, "hoglin_ear", NDFoods.HOGLIN_EAR, NetherCreativeTab.NETHER_ITEMS);
        HOGLIN_SNOUT = registerFeastItem(NETHER_QUALITY, "plate_of_stuffed_hoglin_snout", NetherFood.STUFFED_HOGLIN_SNOUT, NetherCreativeTab.NETHER_ITEMS);
        HOGLIN_ROAST = registerFeastItem(NETHER_QUALITY, "plate_of_stuffed_hoglin_roast", NetherFood.STUFFED_HOGLIN_ROAST, NetherCreativeTab.NETHER_ITEMS);
        HOGLIN_HAM = registerFeastItem(NETHER_QUALITY, "plate_of_stuffed_hoglin_ham", NetherFood.STUFFED_HOGLIN_HAM, NetherCreativeTab.NETHER_ITEMS);

        NETHER_QUALITY.register(eventBus);
    }

}
