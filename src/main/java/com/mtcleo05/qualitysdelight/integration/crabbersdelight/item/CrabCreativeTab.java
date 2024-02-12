package com.mtcleo05.qualitysdelight.integration.crabbersdelight.item;

import com.mtcleo05.qualitysdelight.QualitysDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

import static com.mtcleo05.qualitycrops.utils.Utils.getItemFromID;

public class CrabCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CRAB_CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, QualitysDelight.MODID);

    public static final RegistryObject<CreativeModeTab> CRAB_ITEMS = CRAB_CREATIVE_TABS.register("qualitysdelight_crab_items", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.qualitysdelight.crab_items"))
                    .icon(() -> new ItemStack((getItemFromID("qualitysdelight:clawster_iron"))))
                    .displayItems((idk, output) -> {
                        Iterable<Item> items = CrabItems.CRAB_QUALITY.getEntries().stream().map(RegistryObject::get)::iterator;
                        for (Item item : items) {
                            output.accept(item);
                        }
                    })
                    .build()
    );

    public static void register(IEventBus eventBus){
        CRAB_CREATIVE_TABS.register(eventBus);
    }


}
