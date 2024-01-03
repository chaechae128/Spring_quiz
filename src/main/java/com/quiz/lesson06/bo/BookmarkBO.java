package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {
	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	
	public void setBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
	
	public List<Bookmark> getBookmark() {
		return bookmarkMapper.selectBookmark();
	}
	
	public boolean isDuplicationByUrl(String url) {
		return bookmarkMapper.isDuplicationByUrl(url);
	}
	
	public int deleteBookmark(String name) {
		return bookmarkMapper.deleteBookmark(name);
	}
	
	//중복 없음: [] , 중복이면 리스트는 채워진
	public boolean isDuplicationUrl(String url) {
		List<Bookmark> bookmarkList = bookmarkMapper.selectBookmarkList(url);
		return bookmarkList.isEmpty() ?  false : true;
		//return bookmarkList.isEmpty();
	}
}
