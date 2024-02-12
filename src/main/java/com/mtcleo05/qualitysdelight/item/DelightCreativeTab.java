package com.mtcleo05.qualitysdelight.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.mtcleo05.qualitycrops.utils.Utils.getItemFromID;

public class DelightCreativeTab {

    public static final CreativeModeTab ITEMS = new CreativeModeTab( "qualitysdelight_items") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(getItemFromID("qualitysdelight:tomato_iron"));
        }

        @Override
        public @NotNull Component getDisplayName() {
            return Component.translatable("itemGroup.qualitysdelight.items");
        }
    };



}
