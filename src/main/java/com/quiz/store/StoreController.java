package com.quiz.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;
import com.quiz.store.domain.NewReview;


@RequestMapping("store")
@Controller
public class StoreController {
	@Autowired
	private StoreBO storeBO;
	@RequestMapping("/store-list-view")
	public String storeListView(Model model) {
		
		List<Store> storeList = storeBO.getStoreList();
		model.addAttribute("storeList", storeList);
		return "store/storeList";
	}
	
	@RequestMapping("/review-list-view")
	public String reviewListView(
			Model model,
			@RequestParam("storeId") int storeId,
			@RequestParam("storeName") String storeName) {
		
		List<NewReview> newReview =storeBO.getNewReviewList(storeId);
		
		model.addAttribute("newReviewList", newReview);
		model.addAttribute("storeName", storeName);
		model.addAttribute("storeId", storeId);
		
		return "store/reviewList";
	}
	
	
	
}
