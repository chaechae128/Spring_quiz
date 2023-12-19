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
	// quiz01/1
	public RealEstate getRealEstateById(int id) {

		return realEstateMapper.selectRealEstateById(id);
	}

	// quiz01/2 input: rentPrice output:List<RealEstate> ([ ] or 채워져 있거나) nullX
	public List<RealEstate> getRealEstateByrentPrice(int rentPrice) {

		return realEstateMapper.selectRealEstateByrentPrice(rentPrice);
	}

	// quiz01/3 input : area price output:List<RealEstate> ([ ] or 채워져 있거나) nullX
	public List<RealEstate> getRealEstateByAreaPrice(int area, int price) {

		return realEstateMapper.selectRealEstateByAreaPrice(area, price);
	}

	// quiz02/1
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	// quiz02/2
	//addrealEstateAsField("썅떼빌리버 오피스텔 814호", 45, "월세",100000, 120 );
	public int addRealEstateAsField(int realtorId, String address, int area, String type, int price, Integer rentPrice) {
		return realEstateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
}
