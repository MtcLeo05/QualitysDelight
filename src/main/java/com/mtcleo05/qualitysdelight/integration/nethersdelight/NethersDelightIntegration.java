package com.mtcleo05.qualitysdelight.integration.nethersdelight;

import com.mtcleo05.qualitysdelight.integration.nethersdelight.block.NetherBlocks;
import com.mtcleo05.qualitysdelight.integration.nethersdelight.item.NetherItems;
import net.minecraftforge.eventbus.api.IEventBus;

public class NethersDelightIntegration {

    public static void register(IEventBus eventBus){
        NetherItems.register(eventBus);
        NetherBlocks.register(eventBus);
    }

}
