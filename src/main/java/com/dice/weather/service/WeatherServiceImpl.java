package com.dice.weather.service;

import com.dice.weather.service.provider.Weather;
import com.dice.weather.service.provider.Wettercom;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${client.id}")
    private String cliendId;

    @Value("${client.secret}")
    private String clientSecret;

    @Override
    public String getCliendId() {
        return cliendId;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public Map<String, Object> wettercom(String type, String location) {
        Map<String, Object> json = new HashMap<String, Object>();
        String url = String.format("https://forecast9.p.rapidapi.com/rapidapi/forecast/%s/%s/",
                location, type);
        HttpHeaders headers = createWettercomHeaders();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<>(headers);
        try {
            ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, request, Object.class);
            Weather weather = new Wettercom();
            json = weather.parseData(response);
        } catch (Exception exc) {
            json.put("wettercom", exc.toString());
        }
        return json;
    }




    private static HttpHeaders createWettercomHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-host", "forecast9.p.rapidapi.com");
        headers.set("x-rapidapi-key", "ed9cf8174fmshf7a2994357ad698p140ee4jsnbb8409709b73");
        return headers;
    }
}
