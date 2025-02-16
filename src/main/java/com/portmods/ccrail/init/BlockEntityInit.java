package com.portmods.ccrail.init;

import com.portmods.ccrail.CCRail;
import com.portmods.ccrail.world.entity.TrainReaderEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {

    private static DeferredRegister<BlockEntityType<?>> deferredRegister = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, CCRail.MODID);

    public static final RegistryObject<BlockEntityType<?>> TRAIN_READER = deferredRegister.register("train_reader_entity", () -> BlockEntityType.Builder.of(TrainReaderEntity::new, BlockInit.TRAIN_READER.get()).build(null));

    public static void init(IEventBus modEventBus) {
        deferredRegister.register(modEventBus);
    }

}
