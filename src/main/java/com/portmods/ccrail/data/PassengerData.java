package com.portmods.ccrail.data;

import java.util.HashMap;
import java.util.Map;

public class PassengerData {

    public Map<String, Object> data = new HashMap<String, Object>();

    public PassengerData(String type) {
        data.put("Type", type );
    }

}
