package com.mtcleo05.qualitysdelight.integration.endersdelight.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.mtcleo05.qualitycrops.utils.Utils.getItemFromID;

public class EndersCreativeTab {

    public static final CreativeModeTab ENDER_ITEMS = new CreativeModeTab( "qualitysdelight_ender_items") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(getItemFromID("qualitysdelight:mite_crust_iron"));
        }

        @Override
        public @NotNull Component getDisplayName() {
            return Component.translatable("itemGroup.qualitysdelight.ender_items");
        }
    };

}
