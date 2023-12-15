package com.quiz.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.domain.Store;



@Repository
public interface StoreMapper {
	
	//input: x
	//output:DB로부터 받은 List<Store>
	public List<Store> selectStoreList();
}

