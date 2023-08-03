package com.mtcleo05.qualitysdelight.integration.nethersdelight.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class NetherCreativeTab {

    public static final CreativeModeTab NETHER_ITEMS = new CreativeModeTab( "qualitysdelight_nether_items") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(getItemFromID("hoglin_loin_iron", NetherItems.NETHER_QUALITY));
        }

        @Override
        public @NotNull Component getDisplayName() {
            return Component.translatable("itemGroup.qualitysdelight.nether_items");
        }
    };

    public static Item getItemFromID(String id, DeferredRegister<Item> register){
        Iterable<Item> qualityCrops = register.getEntries().stream().map(RegistryObject::get)::iterator;
        for (Item item : qualityCrops) {
            if (getItemName(item).equals(id)) {
                return item;
            }
        }
        return null;
    }

    private static String getItemName(Item item){
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }

}
