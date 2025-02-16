package com.portmods.ccrail.data.carts;

import com.portmods.ccrail.data.BaseCartData;
import mods.railcraft.world.level.block.detector.DetectorBlock;
import mods.railcraft.world.level.block.manipulator.AdvancedItemLoaderBlock;
import net.minecraft.world.entity.vehicle.MinecartChest;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

import java.util.HashMap;
import java.util.Map;

public class ChestData extends BaseCartData {



    public ChestData(MinecartChest chestMinecart) {
        super("Chest");

        Map<String, Integer> Items = new HashMap<String, Integer>();

        LazyOptional<IItemHandler> cap = chestMinecart.getCapability(ForgeCapabilities.ITEM_HANDLER);
        if (cap.resolve().isPresent()) {

            IItemHandler itemHandler = (IItemHandler)cap.resolve().get();

            for (int i = 0; i < itemHandler.getSlots(); i++) {
                var itemStack = itemHandler.getStackInSlot(i);

                if(Items.containsKey(itemStack.getDisplayName())) {
                    Items.put(itemStack.getDisplayName().getString(), Items.get(itemStack.getDisplayName()) + itemStack.getCount());
                } else {
                    Items.put(itemStack.getDisplayName().getString(), itemStack.getCount());
                }

            }

        }

        this.data.put("Items", Items);

    }

}
