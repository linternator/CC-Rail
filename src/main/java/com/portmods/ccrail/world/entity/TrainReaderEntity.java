package com.portmods.ccrail.world.entity;

import com.mojang.logging.LogUtils;
import com.portmods.ccrail.data.TrainData;
import com.portmods.ccrail.init.BlockEntityInit;
import com.portmods.ccrail.peripheral.TrainReaderPeripheral;
import com.portmods.ccrail.util.TickableBlockEntity;
import mods.railcraft.api.carts.RollingStock;
import mods.railcraft.util.EntitySearcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;

import java.util.List;

public class TrainReaderEntity extends BlockEntity implements TickableBlockEntity {

    private static final Logger LOGGER = LogUtils.getLogger();

    private int tick, readState = 0;
    private TrainReaderPeripheral peripheral = null;

    public TrainData lastTrainData = null;

    public TrainReaderEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(BlockEntityInit.TRAIN_READER.get(), p_155229_, p_155230_);
    }

    @Override
    public void tick(Level level0, BlockPos pos0, BlockState state0, BlockEntity blockEntity) {

        if (!(blockEntity instanceof TrainReaderEntity)) {
            return;
        }

        TrainReaderEntity trainReaderEntity = (TrainReaderEntity) blockEntity;

        trainReaderEntity.tick++;

        if (trainReaderEntity.tick % 4 == 0) {

            var carts = EntitySearcher.findMinecarts().at(pos0).upTo(0.2f).list(level0);

            if(carts.isEmpty()) {

                readState = 0;

            } else if(readState == 0) {

                readState = 1;

                sendEvent(carts);

            }

            trainReaderEntity.tick = 0;

        }

    }

    private void sendEvent(List<AbstractMinecart> carts) {

        LOGGER.info("TrainReaderEntity sendEvent");

        var train = RollingStock.getOrThrow(carts.get(0)).train();

        lastTrainData = new TrainData(train);

        LOGGER.info(lastTrainData.toString());

        if(peripheral != null){
            peripheral.sendEvent();
        }


    }

    public void SetPeripheral(TrainReaderPeripheral peripheral) {
        this.peripheral = peripheral;
    }
}
