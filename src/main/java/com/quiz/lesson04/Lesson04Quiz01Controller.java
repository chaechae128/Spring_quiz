package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;
	//http://localhost:8008/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		
		return "lesson04/addSeller";
	}
	
	//DB insert => 입력 성공 화면
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required=false) String profileImageUrl,
			@RequestParam("temperature") double temperature ) {
		//db insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	@GetMapping("/seller-info-view")
	public String sellerInfoView(
			@RequestParam(value="id", required=false) Integer id,
			Model model ) {
		//db select
		Seller seller = null;
		if(id == null) { //id 없을 때 = 최신 가져옴
			seller = sellerBO.getLatestSeller();			
		} else {
			seller = sellerBO.getSellerById(id);	
		}
		//model에 담기
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		
		//응답 화면
		return "lesson04/sellerInfo";
	}
	
}
