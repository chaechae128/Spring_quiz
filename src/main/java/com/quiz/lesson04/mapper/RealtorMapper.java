package com.quiz.lesson04.mapper;

import org.springframework.stereotype.Repository;

import com.quiz.lesson04.domain.Realtor;

@Repository
public interface RealtorMapper {

	public void insertRealtor(Realtor relator);
	public Realtor selectRealtor(int id);
}
