package com.mtcleo05.qualitysdelight.loot;

import com.mojang.serialization.Codec;
import com.mtcleo05.qualitysdelight.QualitysDelight;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DelightLootModifiers {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, QualitysDelight.MODID);


    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_QUALITY = LOOT_MODIFIER_SERIALIZERS.register("add_quality", AddQualityModifier.CODEC);

    public static void register(IEventBus eventBus){
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }

}
