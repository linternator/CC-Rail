package com.portmods.ccrail.peripheral;

import com.portmods.ccrail.world.entity.TrainReaderEntity;
import dan200.computercraft.api.lua.IArguments;
import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.MethodResult;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IDynamicPeripheral;
import dan200.computercraft.api.peripheral.IPeripheral;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TrainReaderPeripheral implements IDynamicPeripheral {

    private final TrainReaderEntity blockEntity;

    private final List<IComputerAccess> computers = new ArrayList<>();

    private final String[] methods = new String[] {
            "getCarts",
            "getPassengers",
    };

    public TrainReaderPeripheral(TrainReaderEntity blockEntity) {
        this.blockEntity = blockEntity;
        blockEntity.SetPeripheral(this);
    }

    @Override
    public String[] getMethodNames() {
        return methods;
    }

    @Override
    public MethodResult callMethod(IComputerAccess iComputerAccess, ILuaContext iLuaContext, int i, IArguments iArguments) throws LuaException {
        switch (i){
            case 0: return MethodResult.of(blockEntity.lastTrainData.Carts.toArray());
            case 1: return MethodResult.of(blockEntity.lastTrainData.Passengers.toArray());
        }

        return MethodResult.of();
    }

    @Override
    public String getType() {
        return "Train-Reader";
    }

    @Override
    public boolean equals(@Nullable IPeripheral iPeripheral) {
        return hashCode() == iPeripheral.hashCode();
    }

    @Override
    public void attach(IComputerAccess computer) {
        computers.add(computer);
    }

    @Override
    public void detach(IComputerAccess computer) {
        computers.remove(computer);
    }

    public void sendEvent() {

        for(IComputerAccess computer : computers) {
            computer.queueEvent("train_read_event");
        }

    }
}
