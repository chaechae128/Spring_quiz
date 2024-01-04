package com.quiz.booking;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingBO bookingBO;
	//예약 목록
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		return "booking/bookingList";
	}
	
	//예약 하기
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> makeBooking(
			@RequestParam("name") String name,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-mm-dd")Date date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber
			){
		
		//insert
		bookingBO.setBooking(name, date, day, headcount, phoneNumber);

		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result; //map => JSON String
	}
	
	
	
	//예약 조회
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		
		return "booking/checkBooking";
	}
	
	//이름, 전화번호로 예약 조회
	@ResponseBody
	@PostMapping("/search-booking")
	public Map<String, Object> searchBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber,
			Model model){
		Booking booking = bookingBO.getBookingByNamePhoneNumber(name, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		if(booking != null) {
			result.put("code", 200);
			result.put("result", "조회 성공");
			result.put("booking", booking);
			/*
			 * result.put("name", booking.getName()); result.put("date", booking.getDate());
			 * result.put("day", booking.getDay()); result.put("headcount",
			 * booking.getHeadcount()); result.put("state", booking.getState());
			 */
		} else {
			result.put("code", 500);
			result.put("error_message", "예약 내역이 없습니다");
		}
		//model.addAttribute("bookingList", bookingList);
		return result;
	}
	
	//예약 삭제
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id){
		
		int rowCount = bookingBO.deleteBooking(id);
		
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "실패");
		}

		return result;
	}
}
