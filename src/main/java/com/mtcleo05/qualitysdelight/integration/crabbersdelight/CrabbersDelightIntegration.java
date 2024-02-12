package com.mtcleo05.qualitysdelight.integration.crabbersdelight;

import com.mtcleo05.qualitysdelight.integration.crabbersdelight.block.CrabBlocks;
import com.mtcleo05.qualitysdelight.integration.crabbersdelight.item.CrabItems;
import net.minecraftforge.eventbus.api.IEventBus;

public class CrabbersDelightIntegration {

    public static void register(IEventBus eventBus){
        CrabItems.register(eventBus);
        CrabBlocks.register(eventBus);
    }

}
