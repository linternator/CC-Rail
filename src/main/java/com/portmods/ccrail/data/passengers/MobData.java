package com.portmods.ccrail.data.passengers;

import com.portmods.ccrail.data.PassengerData;
import net.minecraft.world.entity.Mob;

public class MobData extends PassengerData {

    public MobData(Mob mob) {

        super("Mob");

        this.data.put("Name", mob.getName().getString());

    }

}
