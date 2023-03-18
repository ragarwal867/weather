package com.dice.weather.exception;

public class WeatherDataNotFoundException extends RuntimeException{
    public WeatherDataNotFoundException(String message) {
        super(message);
    }

    public WeatherDataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherDataNotFoundException(Throwable cause) {
        super(cause);
    }
}
