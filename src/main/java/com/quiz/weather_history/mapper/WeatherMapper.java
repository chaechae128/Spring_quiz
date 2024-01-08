package com.quiz.weather_history.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.weather_history.domain.Weather;

@Mapper
public interface WeatherMapper {
	public List<Weather> selectWeatherHistoryList();
	
	public void insertWeather(
			@Param("date")Date date, 
			@Param("weather")String weather, 
			@Param("microDust")String microDust, 
			@Param("temperatures")double temperatures, 
			@Param("precipitation")double precipitation, 
			@Param("windSpeed")double windSpeed);
}
