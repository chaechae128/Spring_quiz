package com.quiz.weather_history;

import java.util.Date;
import java.util.List;

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

	//날씨 목룍 화면
	@GetMapping("/weather-list-view")
	public String historyWeatherView(Model model) {

		List<Weather> weathers = weatherBO.getWeatherHistoryList();
		model.addAttribute("weathers", weathers);
		return "weather_history/historyView";
	}

	@GetMapping("/add-weather-view")
	public String addWeatherView(Model model) {

		return "weather_history/addWeather";
	}
	//날씨 추가 수행=> 날씨 목록 화면으로 이동
	/*
	 * @PostMapping("/add-weather") public String addWeater(@ModelAttribute Weather
	 * weather) { weatherBO.addWeather(weather);
	 * 
	 * return "weather_history/historyView"; }
	 */
	
	@PostMapping("/add-weather")
	public String addWeather(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, //그냥 String으로 해도 무방
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed
			//HttpServletRequest request 후에 return에서 sendRedirect하면 됨
			) {
		
		//db insert
		weatherBO.addWeather(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		
		//결과 화면 => 리다이렉트 302 
		return "redirect:/weather-history/weather-list-view"; //컨트롤러가 메소드를 부를 수는 없음
	}
}
