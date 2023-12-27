package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weather_history.bo.WeatherBO;
import com.quiz.weather_history.domain.Weather;

@RequestMapping("weather-history")
@Controller
public class WeatherHistoryContoller {
	@Autowired 
	private WeatherBO weatherBO;
	
	@GetMapping("/history-view") 
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
}
