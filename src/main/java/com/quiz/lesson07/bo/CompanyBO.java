package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {
	@Autowired
	private CompanyRepository companyRepository;
	
	public CompanyEntity addCompany(String name, String business, String scale, int headcount) {
		CompanyEntity company = CompanyEntity.builder()
								.name(name)
								.business(business)
								.scale(scale)
								.headcount(headcount)
								.build();
		
		return companyRepository.save(company);
	}
	
	public CompanyEntity updateCompanyScalehHeadcount(int id, String scale, int headcount) {
		//select
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		
		if(company != null) {
			company = company.toBuilder()
							.scale(scale)
							.headcount(headcount)
							.build();
		}
		
		company = companyRepository.save(company);
		
		return company;
	}
	
	public void deleteCompanyById(int id) {
		//select
		Optional<CompanyEntity> compnayOptional = companyRepository.findById(id);
		compnayOptional.ifPresent(c -> companyRepository.delete(c));
	}
 }
