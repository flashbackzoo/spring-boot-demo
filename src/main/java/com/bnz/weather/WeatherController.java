package com.bnz.weather;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    @RequestMapping(
        value = "/",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String getWeather() {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=-41.29&longitude=174.78&hourly=temperature_2m";
        RestTemplate restTemplate = new RestTemplate();

        Object forcast = restTemplate.getForObject(url,Object.class);
        return forcast.toString();
    }
}
