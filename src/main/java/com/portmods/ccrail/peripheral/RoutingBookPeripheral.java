package com.portmods.ccrail.peripheral;

import dan200.computercraft.api.lua.IArguments;
import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.MethodResult;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IDynamicPeripheral;
import dan200.computercraft.api.peripheral.IPeripheral;
import mods.railcraft.util.container.AdvancedContainer;
import mods.railcraft.util.routing.RouterBlockEntity;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;

import java.util.*;

public abstract class RoutingBookPeripheral implements IPeripheral, IDynamicPeripheral {

    protected Container container;
    protected RouterBlockEntity blockEntity;

    private final String[] methods = new String[] {
            "getRoutes",
            "clearRoutes",
            "saveRoutes",
    };

    @Override
    public String[] getMethodNames() {
        return methods;
    }

    @Override
    public MethodResult callMethod(IComputerAccess iComputerAccess, ILuaContext iLuaContext, int i, IArguments iArguments) throws LuaException {
        switch (i){
            case 0: return MethodResult.of(getRoutes());
            case 1: return MethodResult.of(clearRoutes());
            case 2: return MethodResult.of(saveRoutes(iArguments));
        }

        return MethodResult.of();
    }

    private Object saveRoutes(IArguments iArguments) throws LuaException {

        try {
            var key = (Map<String, String>) iArguments.getTable(0);

            ArrayList<String> lines = new ArrayList<>();

            key.forEach( (k,v)->{
                lines.add(k + "=" + v);
            });

            if(container.getItem(0).isEmpty()) return false;

            ItemStack s = container.getItem(0);

            if(s.getTag() != null) {

                save(s,lines);

                return true;

            }
        } catch (Exception e) {}

        return false;

    }

    private Object clearRoutes() {

        if(blockEntity.container().getItem(0).isEmpty()) return false;

        ItemStack s = blockEntity.container().getItem(0);

        if(s.getTag() != null) {

            save(s, new ArrayList<String>());

            return true;

        }

        return false;
    }

    private Dictionary<String, String> getRoutes() {

        if(container.getItem(0).isEmpty()) return null;

        ItemStack s = container.getItem(0);

        if(s.getTag() != null && s.getTag().contains("pages")) {

            Deque<String> content = blockEntity.loadPages(s.getTag());
            Iterator<String> it = content.descendingIterator();

            Dictionary<String, String> list = new Hashtable<>();

            while(it.hasNext()) {
                String line = ((String)it.next()).trim();
                if (!line.startsWith("//") && !line.startsWith("#") && !line.isEmpty()) {
                    String[] split = line.split("=");
                    list.put(split[0], split[1]);
                }
            }

            return list;


        }

        return null;
    }

    public void save(ItemStack s, ArrayList<String> strings){

        ListTag listtag = new ListTag();

        strings.forEach(line -> listtag.add(StringTag.valueOf(line)));

        s.removeTagKey("pages");
        s.addTagElement("pages", listtag);

        blockEntity.resetLogic();

    }

}
