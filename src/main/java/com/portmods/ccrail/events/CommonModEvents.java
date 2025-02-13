package com.portmods.ccrail.events;

import com.portmods.ccrail.CCRail;
import com.portmods.ccrail.handler.PeripheralHandler;
import dan200.computercraft.api.ComputerCraftAPI;
import dan200.computercraft.api.ForgeComputerCraftAPI;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = CCRail.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void commonSetup(final FMLCommonSetupEvent event) {

        ForgeComputerCraftAPI.registerPeripheralProvider(new PeripheralHandler());

    }

}
