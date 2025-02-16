package com.portmods.ccrail.data.passengers;

import com.portmods.ccrail.data.PassengerData;
import net.minecraft.world.entity.player.Player;

public class PlayerData extends PassengerData {

    public PlayerData(Player player) {
        super("Player");
        data.put("Name", player.getDisplayName().getString());
        data.put("ID", player.getUUID().toString());
    }

}
