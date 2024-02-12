package com.mtcleo05.qualitysdelight.integration.oceansdelight.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.mtcleo05.qualitycrops.utils.Utils.getItemFromID;

public class OceanCreativeTab {

    public static final CreativeModeTab OCEAN_ITEMS = new CreativeModeTab( "qualitysdelight_ocean_items") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(getItemFromID("qualitysdelight:guardian_soup_iron"));
        }

        @Override
        public @NotNull Component getDisplayName() {
            return Component.translatable("itemGroup.qualitysdelight.ocean_items");
        }
    };


}
