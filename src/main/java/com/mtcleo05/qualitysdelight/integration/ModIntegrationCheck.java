package com.mtcleo05.qualitysdelight.integration;

import com.mtcleo05.qualitysdelight.integration.nethersdelight.NethersDelightIntegration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLLoader;

public class ModIntegrationCheck {

    public static boolean nethersDelightPresent = false;

    public static void preInit(IEventBus eventBus){
        if(checkMod("nethersdelight")){
            nethersDelightPreInit(eventBus);
        }
    }

    public static void nethersDelightPreInit(IEventBus eventBus){
        System.out.println("Nether's Delight Found!");

        nethersDelightPresent = true;
        NethersDelightIntegration.register(eventBus);
    }


    public static boolean checkMod(String id){
        return FMLLoader.getLoadingModList().getModFileById(id) != null;
    }

}
