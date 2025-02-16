package com.portmods.ccrail.peripheral;

import com.mojang.logging.LogUtils;
import dan200.computercraft.api.lua.IArguments;
import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.MethodResult;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IDynamicPeripheral;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.core.apis.TableHelper;
import mods.railcraft.world.level.block.entity.SwitchTrackRouterBlockEntity;
import mods.railcraft.world.level.block.entity.detector.DetectorBlockEntity;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.*;

public class SwitchTrackRouterPeripheral extends RoutingBookPeripheral {

    public SwitchTrackRouterPeripheral(SwitchTrackRouterBlockEntity blockEntity) {
        this.container = blockEntity.container();
        this.blockEntity = blockEntity;
    }

    @Override
    public String getType() {
        return "Router-Switch";
    }

    @Override
    public boolean equals(@Nullable IPeripheral iPeripheral) {
        return hashCode() == iPeripheral.hashCode();
    }
}
