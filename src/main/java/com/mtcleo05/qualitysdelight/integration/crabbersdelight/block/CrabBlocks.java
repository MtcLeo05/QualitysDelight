package com.mtcleo05.qualitysdelight.integration.crabbersdelight.block;

import com.mtcleo05.qualitycrops.rarities.ModRarities;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import com.mtcleo05.qualitysdelight.integration.crabbersdelight.item.CrabCreativeTab;
import com.mtcleo05.qualitysdelight.integration.crabbersdelight.item.CrabItems;
import com.scouter.oceansdelight.blocks.GuardianSoupBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class CrabBlocks {

    public static final DeferredRegister<Block> CRAB_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, QualitysDelight.MODID);

    public static void registerQualityBlock(String id, Material material, RegistryObject<Item>[] feastItem){
        registerBlock(id + "_iron", () ->
                new GuardianSoupBlock(
                        BlockBehaviour.Properties.of(material),
                        () -> feastItem[0].get(),
                        true
                ),
                ModRarities.IRON
                );

        registerBlock(id + "_gold", () ->
                new GuardianSoupBlock(
                        BlockBehaviour.Properties.of(material),
                        () -> feastItem[1].get(),
                        true
                ),
                ModRarities.GOLD
        );

        registerBlock(id + "_diamond", () ->
                new GuardianSoupBlock(
                        BlockBehaviour.Properties.of(material),
                        () -> feastItem[2].get(),
                        true
                ),
                ModRarities.DIAMOND);
    }

    private static <T extends Block> void registerBlock(String name, Supplier<T> block, Rarity rarity){
        RegistryObject<T> toReturn = CRAB_BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, rarity);
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, Rarity rarity){
        CrabItems.CRAB_QUALITY.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .rarity(rarity)
                .tab(CrabCreativeTab.CRAB_ITEMS)));
    }


    public static void register(IEventBus eventBus){
        //registerQualityBlock("guardian_soup", Material.METAL, CrabItems.GUARDIAN_SOUP_BOWL);

        CRAB_BLOCKS.register(eventBus);
    }
}
