package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	public RealEstate selectRealEstateById(int id);
	
	public List<RealEstate> selectRealEstateByrentPrice(int rentPrice);
	
	public List<RealEstate> selectRealEstateByAreaPrice(
			//mybatis 문법 상 파라미터는 단 한개만 xml로 보낼 수 있다.
			//그 파라미터들을 하나의 맵에 담아서 보낸다.
			//맵으로 만들어주는 어노테이션 : @Param
			@Param("area") int area, 
			@Param("price") int price); 
	//하나의 맵이어여함  맵으로 만들어주는 어노테이션 = >@Param("xml에 있는 변수명") 자료형 변수이름)

	//quiz02/1
	public int insertRealEstate(RealEstate realEstate);
	//quiz02/2
	public int insertRealEstateAsField(
			@Param("realtorId")int realtorId, 
			@Param("address")String address, 
			@Param("area")int area, 
			@Param("type")String type, 
			@Param("price")int price, 
			@Param("rentPrice")Integer rentPrice
			);
	
	//quiz03
	public int updateRealEstateById(
			@Param("id")int id, 
			@Param("type")String type, 
			@Param("price")int price);
	
	//quiz04
	public int deleteRealEstateByID(int id);
}
