package com.mtcleo05.qualitysdelight.integration.nethersdelight.block;

import com.mtcleo05.qualitycrops.rarities.ModRarities;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import com.mtcleo05.qualitysdelight.integration.nethersdelight.item.NetherCreativeTab;
import com.mtcleo05.qualitysdelight.integration.nethersdelight.item.NetherItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.function.Supplier;

public class NetherBlocks {

    public static final DeferredRegister<Block> NETHER_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, QualitysDelight.MODID);

    public static void registerQualityBlock(String id, BlockBehaviour blockBehaviour){
        registerBlock(id + "_iron", () ->
                new IronStuffedHoglinBlock(
                        BlockBehaviour.Properties.copy(blockBehaviour)
                ),
                ModRarities.IRON
                );

        registerBlock(id + "_gold", () ->
                new GoldStuffedHoglinBlock(
                        BlockBehaviour.Properties.copy(blockBehaviour)
                ),
                ModRarities.GOLD
        );

        registerBlock(id + "_diamond", () ->
                new DiamondStuffedHoglinBlock(
                        BlockBehaviour.Properties.copy(blockBehaviour)
                ),
                ModRarities.DIAMOND);
    }

    private static <T extends Block> void registerBlock(String name, Supplier<T> block, Rarity rarity){
        RegistryObject<T> toReturn = NETHER_BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, rarity);
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, Rarity rarity){
        NetherItems.NETHER_QUALITY.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .rarity(rarity)
                .tab(NetherCreativeTab.NETHER_ITEMS)));
    }


    public static void register(IEventBus eventBus){

        registerQualityBlock("stuffed_hoglin", Blocks.CAKE);

        NETHER_BLOCKS.register(eventBus);
    }
}
