package com.portmods.ccrail.data;

import com.portmods.ccrail.data.carts.ChestData;
import com.portmods.ccrail.data.carts.EnergyData;
import com.portmods.ccrail.data.carts.LocomotiveData;
import com.portmods.ccrail.data.carts.TankData;
import com.portmods.ccrail.data.passengers.MobData;
import com.portmods.ccrail.data.passengers.PlayerData;
import mods.railcraft.api.carts.Train;
import mods.railcraft.world.entity.vehicle.EnergyMinecart;
import mods.railcraft.world.entity.vehicle.TankMinecart;
import mods.railcraft.world.entity.vehicle.locomotive.Locomotive;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.MinecartChest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TrainData {

    public List<Object> Carts = new ArrayList<>();
    public List<Object> Passengers = new ArrayList<>();

    public TrainData(Train train) {

        var trainCarts = train.entities().toList();

        for(AbstractMinecart cart : trainCarts){

            if(cart instanceof Locomotive locomotive){
                Carts.add(new LocomotiveData(locomotive).data);
            } else if(cart instanceof TankMinecart tankMinecart){
                Carts.add(new TankData(tankMinecart).data);
            } else if(cart instanceof MinecartChest chestMinecart){
                Carts.add(new ChestData(chestMinecart).data);
            } else if(cart instanceof EnergyMinecart energyMinecart){
                Carts.add(new EnergyData(energyMinecart).data);
            } else {
                Carts.add(new BaseCartData(cart.getMinecartType().name()).data);
            }

        }

        for(var p : train.passengers().toList()){

            if(p instanceof Player player){
                Passengers.add(new PlayerData(player).data);
            } else if(p instanceof Mob mob){
                Passengers.add(new MobData(mob).data);
            } else {
                Passengers.add(new PassengerData(p.getType().getDescription().getString()).data);
            }

        }

    }

}
