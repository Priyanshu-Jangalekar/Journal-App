package com.journalapp.journalApp.service;

import com.journalapp.journalApp.api.responce.WeatherResponce;
import com.journalapp.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${Weather.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;
    @Autowired
    private RedisService redisService;
    public WeatherResponce getWeather(String city){
        WeatherResponce weatherResponce = redisService.get("Weather of_" + city ,WeatherResponce.class);
        if(weatherResponce != null){
            return weatherResponce;
        }else{
            String finalApi = appCache.AppCache.get("weather_api").replace("<city>" ,city).replace("<apiKey>" , apiKey);
            ResponseEntity<WeatherResponce> responce = restTemplate.exchange(finalApi , HttpMethod.GET , null , WeatherResponce.class);
            WeatherResponce body = responce.getBody();
            if(body != null){
                redisService.set("Weather of_" + city , body , 300l);
            }
            return body;
        }

    }
}
