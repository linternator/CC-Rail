package com.portmods.ccrail.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;

public interface TickableBlockEntity {

    static <T extends BlockEntity> BlockEntityTicker<T> getTickerHelper(Level level) {
        return getTickerHelper(level, false);
    }

    static <T extends BlockEntity> BlockEntityTicker<T> getTickerHelper(Level level, boolean allowClient) {
        return level.isClientSide() && !allowClient ? null : (level0, pos0, state0, blockEntity) -> ((TickableBlockEntity)blockEntity).tick(level0, pos0, state0, blockEntity);
    }

    void tick(Level level0, BlockPos pos0, BlockState state0, BlockEntity blockEntity);

}
