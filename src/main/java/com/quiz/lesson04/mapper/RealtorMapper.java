package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson04.domain.Realtor;

@Mapper
public interface RealtorMapper {

	public void insertRealtor(Realtor relator);
	public Realtor selectRealtor(int id);
}
