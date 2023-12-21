package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	@Autowired
	private SellerMapper sellerMapper;
	//input :  파라미터들  output: x
	public void addSeller(String nickname, String profileImageUrl, double temperature) {
		sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	//input : x output:Seller(or null)
	public Seller getLatestSeller() {
		return sellerMapper.selectLatestSeller();
	}
	//input :id   output:Seller(or null)
	public Seller getSellerById(int id) {
		return sellerMapper.selectSellerById(id);
	}

}
