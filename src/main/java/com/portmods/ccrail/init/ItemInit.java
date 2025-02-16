package com.portmods.ccrail.init;

import com.portmods.ccrail.CCRail;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    private static DeferredRegister<Item> deferredRegister = DeferredRegister.create(Registries.ITEM, CCRail.MODID);

    public static final RegistryObject<BlockItem> TRAIN_READER = deferredRegister.register("train_reader", () -> new BlockItem(BlockInit.TRAIN_READER.get(), new Item.Properties()));

    public static void init(IEventBus modEventBus) {
        deferredRegister.register(modEventBus);
    }

}
