package com.quiz.lesson03;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
@RestController
public class Lesson03Quiz04RestController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	//url: http://localhost:8008/lesson03/quiz04/1?id=21
	@RequestMapping("lesson03/quiz04/1")
	public String quiz04(
			@Param("id") int id) {
		int rowCount = realEstateBO.deleteRealEstateByID(id);
		return "삭제 성공 : " + rowCount;
	}
	
}
