package com.portmods.ccrail.init;

import com.portmods.ccrail.CCRail;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabInit {

    private static DeferredRegister<CreativeModeTab> deferredRegister = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CCRail.MODID);

    public static final RegistryObject<CreativeModeTab> RAIL_TAB = deferredRegister.register("ccrail_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("item.group.ccrail"))
                    .icon(ItemInit.TRAIN_READER.get()::getDefaultInstance)
                    .displayItems((itemDisplayParameters, output) -> output.accept(ItemInit.TRAIN_READER.get()))
                    .build()
    );

    public static void init(IEventBus modEventBus) {
        deferredRegister.register(modEventBus);
    }

}
