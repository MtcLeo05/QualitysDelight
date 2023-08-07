package com.mtcleo05.qualitysdelight;

import com.mojang.logging.LogUtils;
import com.mtcleo05.qualitysdelight.block.DelightBlocks;
import com.mtcleo05.qualitysdelight.item.DelightItems;
import com.mtcleo05.qualitysdelight.integration.ModIntegrationCheck;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(QualitysDelight.MODID)
public class QualitysDelight {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "qualitysdelight";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public QualitysDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DelightBlocks.register(modEventBus);
        DelightItems.register(modEventBus);
        ModIntegrationCheck.preInit(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

        }
    }
}
