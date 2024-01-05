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
	
	//이름, 전화번호로 예약 내역 조회
	//input:name, phoneNumber output: 성공 행
	public Booking getBookingByNamePhoneNumber(String name, String phoneNumber) {
		List<Booking> bookingList = bookingMapper.selectBookingByNamePhoneNumber(name, phoneNumber);
		Booking booking = new Booking();
		if(bookingList.size() > 1) {
			for(int i = 1; i < bookingList.size(); i++) {
				Date date1 = bookingList.get(0).getDate();
				Date date2 = bookingList.get(i).getDate();
				if(date1.before(date2)) {//date2가 date1보다 크다면 date2의 값을 저장
					booking.setId(bookingList.get(i).getId());
					booking.setName(bookingList.get(i).getName());
					booking.setDay(bookingList.get(i).getDay());
					booking.setDate(bookingList.get(i).getDate());
					booking.setHeadcount(bookingList.get(i).getHeadcount());
					booking.setPhoneNumber(bookingList.get(i).getPhoneNumber());
					booking.setState(bookingList.get(i).getState());
				}
			}
		} else {
			booking.setId(bookingList.get(0).getId());
			booking.setName(bookingList.get(0).getName());
			booking.setDay(bookingList.get(0).getDay());
			booking.setDate(bookingList.get(0).getDate());
			booking.setHeadcount(bookingList.get(0).getHeadcount());
			booking.setPhoneNumber(bookingList.get(0).getPhoneNumber());
			booking.setState(bookingList.get(0).getState());
		}
		return booking;
	}
}
