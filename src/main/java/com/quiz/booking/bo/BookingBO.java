package com.quiz.booking.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	@Autowired
	private BookingMapper bookingMapper;
	//예약 목록 보기
	//input:x output:List<Booking>
	public List<Booking> getBookingList(){
		return bookingMapper.selectBookingList();
	}
	
	//예역하기
	//input: 파라미터들 output:x
	public void setBooking(String name, Date date, int day, int headcount,String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	//예약 삭제하기
	//input:id output:성공 행
	public int deleteBooking(int id) {
		return bookingMapper.deleteBooking(id);
	}
}
