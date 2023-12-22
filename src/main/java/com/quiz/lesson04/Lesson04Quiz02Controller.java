package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {
	@Autowired
	private RealtorBO realtorBO;
	// url: http://localhost:8008/lesson04/quiz02/add-realtor-view
	@GetMapping("/add-realtor-view") 
	public String addRealtorView() {
		
		return "lesson04/addRealtor";
	}
	
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		//DB insert => 방금 추가된 pk 받아옴 => realtor에 세팅
		realtorBO.addRealtor(realtor);
		
		//realtor에 세팅된 id로 객체 다시 조회(방금 추가됨)
		realtor = realtorBO.getRealtor(realtor.getId());
		
		//그 가져온 데이터를 model에 담는다(jsp에서 사용하도록)
		model.addAttribute("realtor", realtor);
		model.addAttribute("title", "방금 추가된 공인중개사 정보");
		
		//화면뿌리기 => table로
		return "lesson04/afterAddRealtor";
	}
}
