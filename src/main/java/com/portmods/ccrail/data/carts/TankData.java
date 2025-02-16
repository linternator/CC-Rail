package com.portmods.ccrail.data.carts;

import com.portmods.ccrail.data.BaseCartData;
import mods.railcraft.world.entity.vehicle.TankMinecart;

public class TankData extends BaseCartData {

    public TankData(TankMinecart tankMinecart) {
        super("Tank");

        data.put("FluidType", tankMinecart.getTankManager().getFluidType().getFluidType().toString());
        data.put("Space", tankMinecart.getTankManager().getSpace());
        data.put("CurrentStored", tankMinecart.getTankManager().getSpace() - tankMinecart.getTankManager().getRemainingSpace());

    }

}
