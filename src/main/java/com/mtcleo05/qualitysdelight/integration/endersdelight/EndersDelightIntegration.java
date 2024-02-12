package com.mtcleo05.qualitysdelight.integration.endersdelight;

import com.mtcleo05.qualitysdelight.integration.endersdelight.block.EndersBlocks;
import com.mtcleo05.qualitysdelight.integration.endersdelight.item.EndersItems;
import net.minecraftforge.eventbus.api.IEventBus;

public class EndersDelightIntegration {

    public static void register(IEventBus eventBus){
        EndersItems.register(eventBus);
        EndersBlocks.register(eventBus);
    }

}
