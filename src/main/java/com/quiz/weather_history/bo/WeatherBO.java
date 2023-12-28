package com.quiz.weather_history.bo;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather_history.domain.Weather;
import com.quiz.weather_history.mapper.WeatherMapper;

@Service
public class WeatherBO {
	@Autowired
	private WeatherMapper weatherMapper;
	
	
	public List<Weather> getWeather() {
		return weatherMapper.selectWeather();
	}
	public void addWeather(Date date, String weather, String microDust, double temperatures, double precipitation, double windSpeed) {
		weatherMapper.insertWeather(date, weather, microDust, temperatures, precipitation, windSpeed);
	}
}
