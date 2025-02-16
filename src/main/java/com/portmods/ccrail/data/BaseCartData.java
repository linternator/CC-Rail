package com.portmods.ccrail.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseCartData {

    public Map<String, Object> data = new HashMap<String, Object>();

    public BaseCartData(String type) {
        data.put("CartType", type );
    }
}
