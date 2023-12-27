package com.quiz.weather_history.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.weather_history.domain.Weather;

@Repository
public interface WeatherMapper {
	public List<Weather> selectWeather();
}
