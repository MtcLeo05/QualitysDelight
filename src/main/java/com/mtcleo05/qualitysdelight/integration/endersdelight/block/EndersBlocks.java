package com.mtcleo05.qualitysdelight.integration.endersdelight.block;

import com.axedgaming.endersdelight.block.StuffedShulkerBlock;
import com.mtcleo05.qualitycrops.rarities.ModRarities;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import com.mtcleo05.qualitysdelight.integration.endersdelight.item.EndersItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
public class EndersBlocks {

    public static final DeferredRegister<Block> ENDERS_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, QualitysDelight.MODID);



    private static <T extends Block> void registerBlock(String name, Supplier<T> block, Rarity rarity){
        RegistryObject<T> toReturn = ENDERS_BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, rarity);
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, Rarity rarity){
        EndersItems.ENDERS_QUALITY.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .rarity(rarity)));
    }


    public static void register(IEventBus eventBus){

        registerBlock("stuffed_shulker_iron", () ->
            new StuffedShulkerBlock(
                    BlockBehaviour.Properties.copy(Blocks.PUMPKIN),
                    EndersItems.STUFFED_SHULKER_BOWL[0],
                    false
            ),
            ModRarities.IRON
        );

        registerBlock("stuffed_shulker_gold", () ->
            new StuffedShulkerBlock(
                    BlockBehaviour.Properties.copy(Blocks.PUMPKIN),
                    EndersItems.STUFFED_SHULKER_BOWL[1],
                    false
            ),
            ModRarities.GOLD
        );

        registerBlock("stuffed_shulker_diamond", () ->
            new StuffedShulkerBlock(
                    BlockBehaviour.Properties.copy(Blocks.PUMPKIN),
                    EndersItems.STUFFED_SHULKER_BOWL[2],
                    false
            ),
            ModRarities.DIAMOND
        );

        ENDERS_BLOCKS.register(eventBus);
    }
}
