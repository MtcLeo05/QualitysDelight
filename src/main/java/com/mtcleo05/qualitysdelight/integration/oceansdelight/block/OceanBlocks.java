package com.mtcleo05.qualitysdelight.integration.oceansdelight.block;

import com.mtcleo05.qualitycrops.rarities.ModRarities;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import com.mtcleo05.qualitysdelight.integration.oceansdelight.item.OceanCreativeTab;
import com.mtcleo05.qualitysdelight.integration.oceansdelight.item.OceanItems;
import com.scouter.oceansdelight.blocks.GuardianSoupBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.Properties;
import java.util.function.Supplier;

public class OceanBlocks {

    public static final DeferredRegister<Block> OCEAN_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, QualitysDelight.MODID);

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
        RegistryObject<T> toReturn = OCEAN_BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, rarity);
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, Rarity rarity){
        OceanItems.OCEAN_QUALITY.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .rarity(rarity)
                .tab(OceanCreativeTab.OCEAN_ITEMS)));
    }


    public static void register(IEventBus eventBus){
        registerQualityBlock("guardian_soup", Material.METAL, OceanItems.GUARDIAN_SOUP_BOWL);

        OCEAN_BLOCKS.register(eventBus);
    }
}
