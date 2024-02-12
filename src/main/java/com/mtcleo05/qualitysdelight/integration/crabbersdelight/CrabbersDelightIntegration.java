package com.mtcleo05.qualitysdelight.integration.crabbersdelight;

import com.mtcleo05.qualitysdelight.integration.crabbersdelight.item.CrabCreativeTab;
import com.mtcleo05.qualitysdelight.integration.crabbersdelight.item.CrabItems;
import net.minecraftforge.eventbus.api.IEventBus;

public class CrabbersDelightIntegration {

    public static void register(IEventBus eventBus){
        CrabItems.register(eventBus);
        CrabCreativeTab.register(eventBus);
    }

}
