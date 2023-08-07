package com.mtcleo05.qualitysdelight.integration.oceansdelight;

import com.mtcleo05.qualitysdelight.integration.oceansdelight.block.OceanBlocks;
import com.mtcleo05.qualitysdelight.integration.oceansdelight.item.OceanItems;
import net.minecraftforge.eventbus.api.IEventBus;

public class OceansDelightIntegration {

    public static void register(IEventBus eventBus){
        OceanItems.register(eventBus);
        OceanBlocks.register(eventBus);
    }

}
