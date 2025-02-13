package com.portmods.ccrail.peripheral;

import dan200.computercraft.api.lua.IArguments;
import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.MethodResult;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IDynamicPeripheral;
import dan200.computercraft.api.peripheral.IPeripheral;
import mods.railcraft.world.level.block.entity.SwitchTrackRouterBlockEntity;
import org.jetbrains.annotations.Nullable;

public class SwitchTrackRouterPeripheral implements IPeripheral, IDynamicPeripheral {

    private final SwitchTrackRouterBlockEntity blockEntity;

    public SwitchTrackRouterPeripheral(SwitchTrackRouterBlockEntity blockEntity) {
        this.blockEntity = blockEntity;
    }

    @Override
    public String[] getMethodNames() {
        return new String[0];
    }

    @Override
    public MethodResult callMethod(IComputerAccess iComputerAccess, ILuaContext iLuaContext, int i, IArguments iArguments) throws LuaException {
        return null;
    }

    @Override
    public String getType() {
        return "Router-Switch";
    }

    @Override
    public boolean equals(@Nullable IPeripheral iPeripheral) {
        return false;
    }
}
