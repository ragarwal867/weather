package com.dice.weather.service;

import java.util.Map;

public interface WeatherService {

    public Map<String, Object> wettercom(String type, String location);

    public String getCliendId();

    public String getClientSecret();
}
