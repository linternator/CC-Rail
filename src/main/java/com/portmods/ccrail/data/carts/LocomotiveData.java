package com.portmods.ccrail.data.carts;

import com.portmods.ccrail.data.BaseCartData;
import mods.railcraft.world.entity.vehicle.locomotive.*;

import java.util.Map;

public class LocomotiveData extends BaseCartData {

    public LocomotiveData(Locomotive locomotive) {
        super("Locomotive");

        data.put("Destination", locomotive.getDestination());

        getType(locomotive);
        getFuel(locomotive);


    }

    private void getFuel(Locomotive locomotive) {

        data.put("NeedsFuel", locomotive.needsFuel());

        if(locomotive instanceof SteamLocomotive steamLocomotive) {

            data.put("FuelType", "Steam");

            data.put("WaterCapacity", steamLocomotive.getTankManager().getTankCapacity(0));
            data.put("SteamCapacity", steamLocomotive.getTankManager().getTankCapacity(1));

            data.put("CurrentWater", steamLocomotive.getTankManager().getFluidInTank(0).getAmount());
            data.put("SteamWater", steamLocomotive.getTankManager().getFluidInTank(1).getAmount());


        } else if(locomotive instanceof CreativeLocomotive){

            data.put("FuelType", "None");

        } else if(locomotive instanceof ElectricLocomotive electricLocomotive){

            data.put("FuelType", "Electric");

            data.put("ElectricCapacity", electricLocomotive.getBatteryCart().getMaxEnergyStored());
            data.put("ElectricStored", electricLocomotive.getBatteryCart().getEnergyStored());

        } else {
            data.put("FuelType", "Unknown");
        }

    }

    private void getType(Locomotive locomotive) {

        if(locomotive instanceof SteamLocomotive) {
            data.put("LocomotiveType", "Steam");
        } else if(locomotive instanceof CreativeLocomotive){
            data.put("LocomotiveType", "Creative");
        } else if(locomotive instanceof ElectricLocomotive){
            data.put("LocomotiveType", "Electric");
        } else {
            data.put("LocomotiveType" ,"Unknown");
        }

    }
}
