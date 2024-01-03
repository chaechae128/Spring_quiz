package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private BookmarkBO bookmarkBO;
	@GetMapping("/quiz01/add-bookMark-view")
	public String addBookMarkView() {
		return "lesson06/addBookMark";
	}
	//중복확인 - AJAX요청
	@ResponseBody
	@PostMapping("/quiz01/is-duplication-url")
	public Map<String, Object> isDuplicationUrl(
			@RequestParam("url") String url){
		//boolean isDuplication = bookmarkBO.isDuplicationByUrl(url);
		boolean isDuplication = bookmarkBO.isDuplicationUrl(url);
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		//result.put("is_duplication", isDuplication);
		result.put("is_duplication", isDuplication);
		
		return result;
	}
	
	// 입력 수행 - AJAX 통신 요청 => 응답값은 무조건 JSON String 
	@ResponseBody //꼭 있어야됨
	@PostMapping("/quiz01/add-bookMark")
	public Map<String, Object> addBookMark(
			@RequestParam("name") String name,
			@RequestParam("url") String url
			) {
		
		//insert DB
		bookmarkBO.setBookmark(name, url);
		
		//{"code":200, "result":"성공"}  <- 이게 하나의 뭉텅이인 String 이게 뭐 key-value로 이루어진거다 이런거 모름  <- 이걸 나중에 ajax에서 파싱
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result; //map => JSON String
	}
	
	//성공화면
	@GetMapping("/quiz01/after-add-bookMark-view")
	public String afterAddBookMarkView(Model model) {
		//select
		
		List<Bookmark> bookmarkList = bookmarkBO.getBookmark();
		model.addAttribute("bookmarkList", bookmarkList);
		
		return "/lesson06/afterAddBookMark";
	}
	
	//delete 수행 
	@ResponseBody
	@DeleteMapping("/quiz01/delete-bookmark")
	public Map<String, Object> deleteBookmark(
			@RequestParam("name")String name){
		
		
		int rowCount = bookmarkBO.deleteBookmark(name);
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "실패");
		}
		
		return result; //map => JSON String
		
	}
	
}
