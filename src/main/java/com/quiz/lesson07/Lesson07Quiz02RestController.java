package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {

	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/1")
	public RecruitEntity getRecruitListById(){
		return recruitRepository.findById(8).orElse(null);
	}
	
	@GetMapping("/2")
	public List<RecruitEntity> getRecruitListByCompnayId(
			@RequestParam("companyId") int companyId){
		return recruitRepository.findByCompanyId(companyId);
	}
	
	@GetMapping("/3")
	public List<RecruitEntity> getRecruitByPositionAndType(){
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}

	@GetMapping("/4")
	public List<RecruitEntity> getRecruitByTypeOrSalary(){
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}
	
//	5. 정렬 제한 조건(/lesson07/quiz02/5)
//	계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회하세요.
//	조회 결과를 아래와 같이 출력하세요.
	
	@GetMapping("/5")
	public List<RecruitEntity> getRecruitByType(){
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	
//	6. 범위 조회 (/lesson07/quiz02/6)
//	성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고를 조회하고 아래와 같이 출력하세요.
	@GetMapping("/6")
	public List<RecruitEntity> getRecruitByRegionSalary(){
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	@GetMapping("/7")
	public List<RecruitEntity> getRecruit(){
		return recruitRepository.findByDeadlineAfterAndSalaryGreaterThanEqualAndTypeOrderBySalaryDesc("2026-04-10", 8100, "정규직");
	}
	
}
