package com.mtcleo05.qualitysdelight.integration.nethersdelight.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.mtcleo05.qualitycrops.utils.Utils.getItemFromID;

public class NetherCreativeTab {

    public static final CreativeModeTab NETHER_ITEMS = new CreativeModeTab( "qualitysdelight_nether_items") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(getItemFromID("qualitysdelight:hoglin_loin_iron"));
        }

        @Override
        public @NotNull Component getDisplayName() {
            return Component.translatable("itemGroup.qualitysdelight.nether_items");
        }
    };

}
