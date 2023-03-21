package com.dice.weather.controller;

import com.dice.weather.dto.AuthRequest;
import com.dice.weather.dto.Response;
import com.dice.weather.security.ClientInfoDetailsService;
import com.dice.weather.service.JwtService;
import com.dice.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/getweather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    ClientInfoDetailsService clientInfoDetailsService;


    @GetMapping("/wettercom")
    public Response wettercomWeather(@RequestParam("forecast_type") String type, @RequestParam("location_name") String location) {
        return Response.ok().setPayload(weatherService.wettercom(type, location));
    }


    @GetMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        boolean isAuthenticated = false;
        if ( clientInfoDetailsService.clientMap.containsKey(authRequest.getUsername())) {
            if ( clientInfoDetailsService.clientMap.get(authRequest.getUsername()).
                    getPassword().equals(authRequest.getPassword()) ) {
                isAuthenticated = true;
            }

        }

        if (isAuthenticated) {
            return jwtService.generateJwtToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }


}
