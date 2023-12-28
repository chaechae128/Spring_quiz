package com.quiz.weather_history;

import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherBO;
import com.quiz.weather_history.domain.Weather;

@RequestMapping("weather-history")
@Controller
public class WeatherHistoryContoller {
	@Autowired 
	private WeatherBO weatherBO;
	
		@GetMapping("/weather-list-view") 
		public String historyWeatherView(Model model) {
		
		List<Weather> weathers = weatherBO.getWeather();
		model.addAttribute("weathers", weathers);
		return "weather_history/historyView";
	}
	
	//@PostMpaaing("/weather-list-view")
	
	@GetMapping("/add-weather-view") 
	public String addWeatherView(Model model) {
		
		
		return "weather_history/addWeather";
	}
	
	
	@PostMapping("/add-weather") 
	public String addWeater(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			//@RequestParam("date") Date date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed) {
		weatherBO.addWeather(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		return "weather_history/historyView";
	}
}
