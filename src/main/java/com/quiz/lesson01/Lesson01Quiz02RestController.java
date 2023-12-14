package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Lesson01Quiz02RestController {
	
	@RequestMapping("/1")
	//url: http://localhost:8008/lesson01/quiz02/1
	public List<Map<String, Object>> quiz02_1(){
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("rate", 15);
		map.put("director", "봉준호");
		map.put("time", 131);
		map.put("title", "기생충");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 0);
		map.put("director", "로베르토 베니니");
		map.put("time", 116);
		map.put("title", "인생은 아름다워");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 12);
		map.put("director", "크리스토퍼 놀란");
		map.put("time", 147);
		map.put("title", "인셉션");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 19);
		map.put("director", "윤종빈");
		map.put("time", 133);
		map.put("title", "범죄와의 전쟁 :  나쁜놈들 전성시대");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 15);
		map.put("director", "프란시스 로렌스");
		map.put("time", 137);
		map.put("title", "헝거에임");
		list.add(map);
		
		return list; //list<map> JSON 응답
	}
	
	@RequestMapping("/2")
	//url: http://localhost:8008/lesson01/quiz02/2
	public List<Board> quiz02_2() {
		List<Board> list  = new ArrayList<>();
		Board Board = new Board();
		Board.setTitle("안녕하세요 가입인사 드립니다.");
		Board.setUser("marobiana");
		Board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동열심히 하겠습니다");
		list.add(Board);
		
		Board = new Board();
		Board.setTitle("헐 대박");
		Board.setUser("bada");
		Board.setContent("오늘 목요일이었어... 금요일인줄");
		list.add(Board);
		
		Board = new Board();
		Board.setTitle("오늘 데이트 한 이야기 해드릴게요.");
		Board.setUser("dulumary");
		Board.setContent("...");
		list.add(Board);
		
		return list;		
	}
	
	@RequestMapping("/3")
	//url: http://localhost:8008/lesson01/quiz02/3
	public ResponseEntity<Board> quiz02_3() {
		Board Board = new Board();
		Board.setTitle("안녕하세요 가입인사 드립니다.");
		Board.setUser("marobiana");
		Board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동열심히 하겠습니다");
		
		return new ResponseEntity<>(Board, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
