package com.portmods.ccrail.handler;

import com.portmods.ccrail.peripheral.RoutingDetectorPeripheral;
import com.portmods.ccrail.peripheral.RoutingTrackPeripheral;
import com.portmods.ccrail.peripheral.SwitchTrackRouterPeripheral;
import com.portmods.ccrail.peripheral.TrainReaderPeripheral;
import com.portmods.ccrail.world.entity.TrainReaderEntity;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import mods.railcraft.world.level.block.entity.SwitchTrackRouterBlockEntity;
import mods.railcraft.world.level.block.entity.detector.RoutingDetectorBlockEntity;
import mods.railcraft.world.level.block.entity.track.RoutingTrackBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.util.LazyOptional;

public class PeripheralHandler implements IPeripheralProvider {

    @Override
    public LazyOptional<IPeripheral> getPeripheral(Level level, BlockPos blockPos, Direction direction) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);

        if(blockEntity instanceof RoutingTrackBlockEntity) {
            return LazyOptional.of(() -> new RoutingTrackPeripheral((RoutingTrackBlockEntity)blockEntity));
        } else if(blockEntity instanceof SwitchTrackRouterBlockEntity) {
            return LazyOptional.of(() -> new SwitchTrackRouterPeripheral((SwitchTrackRouterBlockEntity)blockEntity));
        }else if(blockEntity instanceof RoutingDetectorBlockEntity) {
            return LazyOptional.of(() -> new RoutingDetectorPeripheral((RoutingDetectorBlockEntity)blockEntity));
        }else if(blockEntity instanceof TrainReaderEntity) {
            return LazyOptional.of(() -> new TrainReaderPeripheral((TrainReaderEntity)blockEntity));
        }

        return LazyOptional.empty();
    }

}
