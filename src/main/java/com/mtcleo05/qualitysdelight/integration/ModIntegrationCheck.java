package com.mtcleo05.qualitysdelight.integration;

import com.mtcleo05.qualitysdelight.integration.crabbersdelight.CrabbersDelightIntegration;
import com.mtcleo05.qualitysdelight.integration.endersdelight.EndersDelightIntegration;
import com.mtcleo05.qualitysdelight.integration.oceansdelight.OceansDelightIntegration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLLoader;

public class ModIntegrationCheck {
    public static boolean oceansDelightPresent = false;

    public static void preInit(IEventBus eventBus){
        if(checkMod("oceansdelight")){
            oceansDelightPreInit(eventBus);
        }

        if(checkMod("crabbersdelight")) {
            crabbersDelightPreInit(eventBus);
        }

        if(checkMod("endersdelight")){

        }
    }

    public static void oceansDelightPreInit(IEventBus eventBus){
        System.out.println("Ocean's Delight Found!");

        oceansDelightPresent = true;
        OceansDelightIntegration.register(eventBus);
    }

    public static void crabbersDelightPreInit(IEventBus eventBus){
        System.out.println("Crabber's Delight Found!");
        CrabbersDelightIntegration.register(eventBus);
    }

    public static void endersDelightPreInit(IEventBus eventBus){
        System.out.println("Ender's Delight Found!");
        EndersDelightIntegration.register(eventBus);
    }


    public static boolean checkMod(String id){
        return FMLLoader.getLoadingModList().getModFileById(id) != null;
    }

}
