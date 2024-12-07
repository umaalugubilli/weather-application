package com.mahesh.projects.weatherapplication;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
	
	private final String API_KEY = "1345734acd95d5447b06159ac7a73a19";
	private final String base_url = "https://api.openweathermap.org/data/2.5/weather?q=";
	
	
	public WeatherResponse getWeather(String city) {
		
		String url = base_url + city + "&appId=" + API_KEY + "&units=metric";

		
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, Object> response = restTemplate.getForObject(url, Map.class);
		
		WeatherResponse weatherResponse = new WeatherResponse();
		
		weatherResponse.setCityName((String) response.get("name"));
		
		Map<String, Object> main = (Map<String, Object>) response.get("main");
        weatherResponse.setTemperature((Double) main.get("temp"));
        
        List<Map<String, Object>> weatherList = (List<Map<String, Object>>) response.get("weather");
        weatherResponse.setDescription((String) weatherList.get(0).get("description"));

        return weatherResponse;
		
	}



	

}
