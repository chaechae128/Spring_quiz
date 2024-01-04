package com.quiz.booking.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.booking.domain.Booking;

@Repository
public interface BookingMapper {
	//예약 목록 보가
	public List<Booking> selectBookingList();
	
	//예약하기
	public void insertBooking(
			@Param("name")String name, 
			@Param("date")Date date, 
			@Param("day")int day, 
			@Param("headcount")int headcount,
			@Param("phoneNumber")String phoneNumber);
	
	//예약 삭제하기
	public int deleteBooking(int id);
	
	//이름, 전화번호로 조회하기
	public Booking selectBookingByNamePhoneNumber(
			@Param("name")String name, 
			@Param("phoneNumber")String phoneNumber);
}
