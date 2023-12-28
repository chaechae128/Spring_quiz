package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;


@Service 
public class StoreBO {
	
	@Autowired
	private StoreMapper storeMapper;
	//input: X -> 컨트롤러로 부터 요청을 받음 
	//output: Repository로부터 받은 List<Store>
	public List<Store> getStoreList(){
		return storeMapper.selectStoreList();
	}
}
