package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//jsp파일로 보낼 때는 @Controller만 사용
@Controller //@ResponseBody없음
public class Lesson01Quiz03Controller {
	// url: http://localhost:8008/lesson01/quiz03
	@RequestMapping("/lesson01/quiz03")
	public String quiz03() {
		return "lesson01/quiz03";
	}
}
