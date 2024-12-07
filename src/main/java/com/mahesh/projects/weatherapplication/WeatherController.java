package com.mahesh.projects.weatherapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WeatherController {
	
	private WeatherService weatherService;

	public WeatherController(WeatherService weatherService) {
		super();
		this.weatherService = weatherService;
	}
	
	 @GetMapping("/")
	    public String showWeatherForm() {
	        return "index"; // Render weather.html without weatherResponse
	    }
	

	@GetMapping("/weather")
    public String getCityWeather(@RequestParam String city, Model model) {
        if (city != null && !city.isEmpty()) {
            WeatherResponse weatherResponse = weatherService.getWeather(city);
            model.addAttribute("weatherResponse", weatherResponse);
        }
        return "weather"; // Render weather.html with or without weatherResponse
    }
}
