package com.portmods.ccrail.data.carts;

import com.portmods.ccrail.data.BaseCartData;
import mods.railcraft.world.entity.vehicle.EnergyMinecart;

public class EnergyData extends BaseCartData {

    public EnergyData(EnergyMinecart energyMinecart) {

        super("Energy");
        data.put("MaxEnergy", energyMinecart.getCartBattery().getMaxEnergyStored());
        data.put("StoredEnergy", energyMinecart.getCartBattery().getEnergyStored());

    }

}
