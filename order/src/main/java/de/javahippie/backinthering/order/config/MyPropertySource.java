package de.javahippie.backinthering.order.config;


import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

public class MyPropertySource extends PropertySource<Map<String, String>> {

    Map<String, String> myMap = new HashMap<>();

    public MyPropertySource() {
        super("myProperties");
    }

    @Override
    public Object getProperty(String name) {
        return myMap.get(name);
    }
}
