package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateMapper realEstateMapper;

	// input: id
	// output: Review
	//quiz01/1
	public RealEstate getRealEstateById(int id) {

		return realEstateMapper.selectRealEstateById(id);
	}
	
	//quiz01/2 input: rentPrice  output:List<RealEstate>  ([ ] or 채워져 있거나) nullX
	public List<RealEstate> getRealEstateByrentPrice(int rentPrice) {

		return realEstateMapper.selectRealEstateByrentPrice(rentPrice);
	}
	
	//quiz01/3
		public List<RealEstate> getRealEstateByAreaPrice(int area, int price) {

			return realEstateMapper.selectRealEstateByAreaPrice(area, price);
		}

}
