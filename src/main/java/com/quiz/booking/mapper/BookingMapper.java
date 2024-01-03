package com.quiz.booking.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.booking.domain.Booking;

@Repository
public interface BookingMapper {
	//예약 목록 보가
	public List<Booking> selectBookingList();
}
