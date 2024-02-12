package com.mtcleo05.qualitysdelight.datagen;

import com.mtcleo05.qualitysdelight.QualitysDelight;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.data.BlockTags;

import java.io.IOException;

@Mod.EventBusSubscriber(modid = QualitysDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper efh = event.getExistingFileHelper();
        BlockTags blockTags = new BlockTags(gen, "qualitysdelight", efh);

        gen.addProvider(true, new ModRecipeProvider(gen));
        gen.addProvider(true, new ModLanguageProvider(gen, "en_us"));
        gen.addProvider(true, new ModItemTagProvider(gen, blockTags, efh));

        try {
            gen.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
