package com.portmods.ccrail.init;

import com.portmods.ccrail.CCRail;
import com.portmods.ccrail.world.block.TrainReader;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.client.model.obj.ObjMaterialLibrary;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {

    private static DeferredRegister<Block> deferredRegister = DeferredRegister.create(Registries.BLOCK, CCRail.MODID);

    public static final RegistryObject<Block> TRAIN_READER = deferredRegister.register("train_reader", () -> new TrainReader(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static void init(IEventBus modEventBus) {
        deferredRegister.register(modEventBus);
    }

}
