package com.dice.weather.controller;

import com.dice.weather.dto.Response;
import com.dice.weather.dto.WeatherErrorResponse;
import com.dice.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/getweather")
public class WeatherController {

    private WeatherService weatherService;



    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/wettercom")
    public Response wettercomWeather(@RequestParam("forecast_type") String type, @RequestParam("location_name") String location,
                                     @RequestHeader("client_id") String clientId, @RequestHeader("client_secret") String clientSecret) {

        if (!clientId.equals(weatherService.getCliendId()) ||
            !clientSecret.equals(weatherService.getClientSecret())) {
            WeatherErrorResponse error = new WeatherErrorResponse(HttpStatus.UNAUTHORIZED.value(), "HEADER AUTHENTICATION FAILED", System.currentTimeMillis());
            return Response.unauthorized().setPayload(new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED));
        }
        return Response.ok().setPayload(weatherService.wettercom(type, location));
    }


}
