package com.klef.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class WeatherApiController {
	@Autowired WeatherService service;
	@RequestMapping("/now/{country}/{city}")
	public Weather getWeather(@PathVariable String country, @PathVariable String city)
	{
		return this.service.getWeather(country, city);
	}
	@RequestMapping("/weekly/{country}/{city}")
	public WeatherForecast getWeatherForecast(@PathVariable String country,
			@PathVariable String city) {
		return this.service.getWeatherForecast(country, city);
	}
	
	

}
