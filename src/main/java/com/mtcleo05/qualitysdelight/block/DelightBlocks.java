package com.mtcleo05.qualitysdelight.block;

import com.mtcleo05.qualitycrops.rarities.ModRarities;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import com.mtcleo05.qualitysdelight.item.DelightCreativeTab;
import com.mtcleo05.qualitysdelight.item.DelightItems;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.Objects;
import java.util.function.Supplier;

public class DelightBlocks {

    public static final DeferredRegister<Block> DELIGHT_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, QualitysDelight.MODID);

    public static void registerQualityBlock(String id, BlockBehaviour blockBehaviour, RegistryObject<Item>[] item, boolean hasLeftovers){
        registerBlock(id + "_iron", () ->
                new FeastBlock(
                        BlockBehaviour.Properties.copy(blockBehaviour),
                        item[0],
                        hasLeftovers
                ),
                ModRarities.IRON
                );

        registerBlock(id + "_gold", () ->
                new FeastBlock(
                        BlockBehaviour.Properties.copy(blockBehaviour),
                        item[1],
                        hasLeftovers
                ),
                ModRarities.GOLD
        );

        registerBlock(id + "_diamond", () ->
                new FeastBlock(
                        BlockBehaviour.Properties.copy(blockBehaviour),
                        item[2],
                        hasLeftovers
                ),
                ModRarities.DIAMOND);
    }

    public static void registerQualityRiceMedley(String id, BlockBehaviour blockBehaviour, RegistryObject<Item>[] item1, RegistryObject<Item>[] item2, RegistryObject<Item>[] item3){
        registerBlock(id + "_iron", () ->
                        new IronRiceRollMedleyBlock(
                                BlockBehaviour.Properties.copy(blockBehaviour)
                        ),
                ModRarities.IRON
        );

        registerBlock(id + "_gold", () ->
                        new GoldRiceRollMedleyBlock(
                                BlockBehaviour.Properties.copy(blockBehaviour)
                        ),
                ModRarities.GOLD
        );

        registerBlock(id + "_diamond", () ->
                        new DiamondRiceRollMedleyBlock(
                                BlockBehaviour.Properties.copy(blockBehaviour)
                        ),
                ModRarities.DIAMOND
        );
    }

    private static <T extends Block> void registerBlock(String name, Supplier<T> block, Rarity rarity){
        RegistryObject<T> toReturn = DELIGHT_BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, rarity);
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, Rarity rarity){
        DelightItems.QUALITY_DELIGHT.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .rarity(rarity)
                .tab(DelightCreativeTab.ITEMS)));
    }


    public static void register(IEventBus eventBus){

        registerQualityBlock("roast_chicken_block", Blocks.WHITE_WOOL, DelightItems.ROAST_CHICKEN, true);
        registerQualityBlock("stuffed_pumpkin_block",  Blocks.PUMPKIN, DelightItems.STUFFED_PUMPKIN, true);
        registerQualityBlock("shepherds_pie_block",  Blocks.CAKE, DelightItems.SHEPHERDS_PIE, true);
        registerQualityBlock("honey_glazed_ham_block", Blocks.WHITE_WOOL, DelightItems.HONEY_GLAZED_HAM, true);
        registerQualityRiceMedley("rice_roll_medley_block", Blocks.CAKE, DelightItems.SHEPHERDS_PIE, DelightItems.SHEPHERDS_PIE, DelightItems.SHEPHERDS_PIE);

        DELIGHT_BLOCKS.register(eventBus);
    }
}
