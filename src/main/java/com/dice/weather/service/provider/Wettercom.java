package com.dice.weather.service.provider;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Wettercom implements Weather{
    @Override
    public Map<String, Object> parseData(ResponseEntity<Object> response) {
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("wettercom", response.getBody());
            return json;
    }
}
