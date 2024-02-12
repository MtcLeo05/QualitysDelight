package com.mtcleo05.qualitysdelight.integration.farmersrespite.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import static com.mtcleo05.qualitycrops.utils.Utils.getItemFromID;

public class RespiteCreativeTab {

    public static final CreativeModeTab RESPITE_ITEMS = new CreativeModeTab( "qualitysdelight_respite_items") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(getItemFromID("qualitysdelight:coffee_beans_iron"));
        }

        @Override
        public @NotNull Component getDisplayName() {
            return Component.translatable("itemGroup.qualitysdelight.respite_items");
        }
    };

}
