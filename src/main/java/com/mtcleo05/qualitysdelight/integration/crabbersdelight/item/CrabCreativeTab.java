package com.mtcleo05.qualitysdelight.integration.crabbersdelight.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.mtcleo05.qualitycrops.utils.Utils.getItemFromID;

public class CrabCreativeTab {

    public static final CreativeModeTab CRAB_ITEMS = new CreativeModeTab( "qualitysdelight_crab_items") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(getItemFromID("qualitysdelight:clawster_iron"));
        }

        @Override
        public @NotNull Component getDisplayName() {
            return Component.translatable("itemGroup.qualitysdelight.crab_items");
        }
    };


}
