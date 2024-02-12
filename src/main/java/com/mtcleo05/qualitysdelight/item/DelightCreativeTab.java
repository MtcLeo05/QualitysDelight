package com.mtcleo05.qualitysdelight.item;

import com.mtcleo05.qualitysdelight.QualitysDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class DelightCreativeTab {

    public static final DeferredRegister<CreativeModeTab> QUALITY_CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, QualitysDelight.MODID);

    public static final RegistryObject<CreativeModeTab> ITEMS = QUALITY_CREATIVE_TABS.register("qualitysdelight_items", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.qualitysdelight.items"))
                    .icon(() -> new ItemStack(Objects.requireNonNull(getItemFromID("tomato_iron", DelightItems.QUALITY_DELIGHT))))
                    .displayItems((idk, output) -> {
                        Iterable<Item> items = DelightItems.QUALITY_DELIGHT.getEntries().stream().map(RegistryObject::get)::iterator;
                        for (Item item : items) {
                            output.accept(item);
                        }
                    })
                    .build()
    );

    public static void register(IEventBus eventBus){
        QUALITY_CREATIVE_TABS.register(eventBus);
    }

    public static Item getItemFromID(String id, DeferredRegister<Item> register){
        Iterable<Item> qualityCrops = register.getEntries().stream().map(RegistryObject::get)::iterator;
        for (Item item : qualityCrops) {
            if (getItemName(item).equals(id)) {
                return item;
            }
        }
        return Items.BARRIER;
    }

    private static String getItemName(Item item){
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }

}
