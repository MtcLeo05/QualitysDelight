package com.mtcleo05.qualitysdelight.integration.endersdelight.item;

import com.mtcleo05.qualitysdelight.QualitysDelight;
import com.mtcleo05.qualitysdelight.integration.crabbersdelight.item.CrabItems;
import com.mtcleo05.qualitysdelight.integration.endersdelight.block.EndersBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.mtcleo05.qualitycrops.utils.Utils.getItemFromID;

public class EndersCreativeTab {

    public static final DeferredRegister<CreativeModeTab> ENDER_CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, QualitysDelight.MODID);

    public static final RegistryObject<CreativeModeTab> END_ITEMS = ENDER_CREATIVE_TABS.register("qualitysdelight_ender_items", () ->
        CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.qualitysdelight.ender_items"))
            .icon(() -> new ItemStack((getItemFromID("qualitysdelight:mite_crust_iron"))))
            .displayItems((idk, output) -> {
                Iterable<Item> items = EndersItems.ENDERS_QUALITY.getEntries().stream().map(RegistryObject::get)::iterator;
                items.forEach(output::accept);

                Iterable<Block> blocks = EndersBlocks.ENDERS_BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
                blocks.forEach(output::accept);
            })
            .build()
    );

}
