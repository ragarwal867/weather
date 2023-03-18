package com.dice.weather.service.provider;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface Weather {
    public Map<String, Object> parseData(ResponseEntity<Object> response);
}
