package com.mtcleo05.qualitysdelight.integration.oceansdelight.item;

import com.mtcleo05.qualitysdelight.QualitysDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

import static com.mtcleo05.qualitycrops.utils.Utils.getItemFromID;

public class OceanCreativeTab {

    public static final DeferredRegister<CreativeModeTab> OCEAN_CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, QualitysDelight.MODID);

    public static final RegistryObject<CreativeModeTab> OCEAN_ITEMS = OCEAN_CREATIVE_TABS.register("qualitysdelight_ocean_items", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.qualitysdelight.ocean_items"))
                    .icon(() -> new ItemStack(Objects.requireNonNull(getItemFromID("qualitysdelight:guardian_soup_iron"))))
                    .displayItems((idk, output) -> {
                        Iterable<Item> items = OceanItems.OCEAN_QUALITY.getEntries().stream().map(RegistryObject::get)::iterator;
                        for (Item item : items) {
                            output.accept(item);
                        }
                    })
                    .build()
    );

    public static void register(IEventBus eventBus){
        OCEAN_CREATIVE_TABS.register(eventBus);
    }

}
