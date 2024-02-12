package com.mtcleo05.qualitysdelight.integration.farmersrespite;

import com.mtcleo05.qualitysdelight.integration.farmersrespite.block.RespiteBlocks;
import com.mtcleo05.qualitysdelight.integration.farmersrespite.item.RespiteItems;
import com.mtcleo05.qualitysdelight.integration.nethersdelight.block.NetherBlocks;
import com.mtcleo05.qualitysdelight.integration.nethersdelight.item.NetherItems;
import net.minecraftforge.eventbus.api.IEventBus;

public class FarmersRespiteIntegration {

    public static void register(IEventBus eventBus){
        RespiteItems.register(eventBus);
        RespiteBlocks.register(eventBus);
    }

}
