package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {
	
	@Autowired
	private BookmarkBO bookmarkBO;
	@GetMapping("add-bookMark-view")
	public String addBookMarkView() {
		return "lesson06/addBookMark";
	}
	
	@ResponseBody
	@PostMapping("/add-bookMark")
	public String addBookMark(
			@RequestParam("name") String name,
			@RequestParam("url") String url
			) {
		
		//insert DB
		bookmarkBO.setBookmark(name, url);
		
		return"성공";
	}
	
	//성공화면
	@GetMapping("/after-add-bookMark-view")
	public String afterAddBookMarkView(Model model) {
		//select
		
		List<Bookmark> bookmarkList = bookmarkBO.getBookmark();
		model.addAttribute("bookmarkList", bookmarkList);
		
		return "/lesson06/afterAddBookMark";
	}
	
}
