package com.portmods.ccrail.peripheral;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.PeripheralType;
import mods.railcraft.world.level.block.entity.detector.RoutingDetectorBlockEntity;
import org.jetbrains.annotations.Nullable;

public class RoutingDetectorPeripheral extends RoutingBookPeripheral{

    public RoutingDetectorPeripheral(RoutingDetectorBlockEntity blockEntity) {
        this.blockEntity = blockEntity;
        this.container = blockEntity.container();
    }

    @Override
    public String getType() {
        return "Routing-Detector";
    }

    @Override
    public boolean equals(@Nullable IPeripheral iPeripheral) {
        return hashCode() == iPeripheral.hashCode();
    }
}
