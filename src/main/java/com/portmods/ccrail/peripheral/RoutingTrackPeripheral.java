package com.portmods.ccrail.peripheral;

import com.mojang.authlib.GameProfile;
import com.mojang.logging.LogUtils;
import dan200.computercraft.api.lua.IArguments;
import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.MethodResult;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IDynamicPeripheral;
import dan200.computercraft.api.peripheral.IPeripheral;
import mods.railcraft.world.item.TicketItem;
import mods.railcraft.world.level.block.entity.track.RoutingTrackBlockEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public class RoutingTrackPeripheral extends RoutingBookPeripheral {

    private final RoutingTrackBlockEntity blockEntity;

    private static final Logger LOGGER = LogUtils.getLogger();

    private final String[] methods = new String[] {
            "getDestination",
            "setDestination",
    };

    public RoutingTrackPeripheral(RoutingTrackBlockEntity blockEntity) {
        this.blockEntity = blockEntity;
    }

    @Override
    public String getType() {
        return "Routing-Track";
    }

    @Override
    public boolean equals(@Nullable IPeripheral iPeripheral) {
        return hashCode() == iPeripheral.hashCode();
    }

    @Override
    public String[] getMethodNames() {
        return methods;
    }

    @Override
    public MethodResult callMethod(IComputerAccess iComputerAccess, ILuaContext iLuaContext, int i, IArguments iArguments) throws LuaException {

        switch (i){
            case 0: return MethodResult.of(getDestination());
            case 1: return MethodResult.of(setDestination(iArguments));
        }

        return MethodResult.of();
    }

    private boolean setDestination(IArguments iArguments) throws LuaException {

        String dest = iArguments.getString(0);

        ItemStack i = blockEntity.container().getItem(0);

        if(i.getItem() instanceof TicketItem){
            GameProfile owner = TicketItem.getOwner(i);
            TicketItem.setTicketData(i, dest, owner);
            return true;
        }

        throw new LuaException("No ticket found");

    }

    private String getDestination() {

        ItemStack i = blockEntity.container().getItem(0);

        if(i.getItem() instanceof TicketItem){
            return TicketItem.getDestination(i);
        }

        return "";
    }

}
