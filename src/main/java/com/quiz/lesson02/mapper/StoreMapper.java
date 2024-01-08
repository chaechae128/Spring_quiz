package com.quiz.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson02.domain.Store;
import com.quiz.store.domain.NewReview;



@Mapper
public interface StoreMapper {
	
	//input: x
	//output:DB로부터 받은 List<Store>
	public List<Store> selectStoreList();
	
	public List<NewReview> getNewReviewList(int storeId);
}

