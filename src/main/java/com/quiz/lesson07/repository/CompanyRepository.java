package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.CompanyEntity;


public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{
	//Spring data JPA
	
	//save메소드가 있는데 insert를 해주고 return 은 entity 객체
}
