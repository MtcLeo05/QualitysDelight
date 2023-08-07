package com.mtcleo05.qualitysdelight.event;

import com.mtcleo05.qualitysdelight.QualitysDelight;
import com.mtcleo05.qualitysdelight.item.DelightItems;
import com.mtcleo05.qualitysdelight.loot.AddQualityModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = QualitysDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusSubscriber {

    @SubscribeEvent
    public static void registerModifierSerializers(RegistryEvent.Register<GlobalLootModifierSerializer<?>> event){
        event.getRegistry().register(
                new AddQualityModifier.Serializer().setRegistryName(
                        new ResourceLocation(QualitysDelight.MODID, "add_quality")
                )
        );
    }

}
