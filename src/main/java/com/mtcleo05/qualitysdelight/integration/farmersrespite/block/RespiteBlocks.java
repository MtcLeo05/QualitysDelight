package com.mtcleo05.qualitysdelight.integration.farmersrespite.block;

import com.mtcleo05.qualitysdelight.QualitysDelight;
import com.mtcleo05.qualitysdelight.integration.farmersrespite.item.RespiteCreativeTab;
import com.mtcleo05.qualitysdelight.integration.farmersrespite.item.RespiteItems;
import com.mtcleo05.qualitysdelight.integration.nethersdelight.item.NetherCreativeTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import umpaz.farmersrespite.FarmersRespite;

import java.util.Objects;
import java.util.function.Supplier;

public class RespiteBlocks {

    public static final DeferredRegister<Block> RESPITE_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, QualitysDelight.MODID);



    private static <T extends Block> void registerBlock(String name, Supplier<T> block, Rarity rarity){
        RegistryObject<T> toReturn = RESPITE_BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, rarity);
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, Rarity rarity){
        RespiteItems.RESPITE_QUALITY.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .rarity(rarity)
                .tab(RespiteCreativeTab.RESPITE_ITEMS)));
    }


    public static void register(IEventBus eventBus){

        RESPITE_BLOCKS.register(eventBus);
    }
}
