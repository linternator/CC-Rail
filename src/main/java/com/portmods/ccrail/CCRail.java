package com.portmods.ccrail;

import com.mojang.logging.LogUtils;
import com.portmods.ccrail.init.BlockEntityInit;
import com.portmods.ccrail.init.BlockInit;
import com.portmods.ccrail.init.CreativeTabInit;
import com.portmods.ccrail.init.ItemInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CCRail.MODID)
public class CCRail
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "ccrail";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public CCRail()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockEntityInit.init(bus);
        BlockInit.init(bus);
        CreativeTabInit.init(bus);
        ItemInit.init(bus);

    }

}
