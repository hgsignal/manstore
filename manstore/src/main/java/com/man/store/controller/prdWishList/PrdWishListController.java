package com.man.store.controller.prdWishList;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.man.store.Pager;
import com.man.store.model.prdBoard.PrdBoardVO;
import com.man.store.model.prdWishList.PrdWishListService;
import com.man.store.model.prdWishList.PrdWishListVO;

@Controller
public class PrdWishListController {

	@Autowired
	PrdWishListService prdWish;
	
	// 위시리스트에 담기
	@RequestMapping("/wishlist")
	public String prdWish(@RequestParam(defaultValue = "1") int curPage, 
			PrdWishListVO vo, Model model) throws Exception {
		
		int count = prdWish.countWish(vo);	// 해당 카테고리 상품 갯수
		
		// 페이징 처리
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		// 상품글 리스트
		List<PrdWishListVO> list = prdWish.listWish(vo, start, end);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("pager", pager);
		model.addAttribute("map", map);
		
		return "product/wish";
	}
}
