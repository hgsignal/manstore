package com.man.store.controller.prdBoard;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.man.store.Pager;
import com.man.store.model.prdBoard.PrdBoardService;
import com.man.store.model.prdBoard.PrdBoardVO;

@Controller
public class PrdBoardController {
	@Autowired
	private PrdBoardService prdBoardService;
	
	
	// 카테고리 품목 출력 + 페이징
	@RequestMapping("/prdlist")
	public String listPrdBoard(@RequestParam(defaultValue = "1") int curPage, 
			PrdBoardVO vo, Model model) throws Exception {
		
		int count = prdBoardService.countPrdBoard(vo);	// 해당 카테고리 상품 갯수
		
		// 페이징 처리
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		// 상품글 리스트
		List<PrdBoardVO> list = prdBoardService.listPrdBoard(vo, start, end);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("menu_id", vo.getMenu_id());
		map.put("list", list);
		map.put("count", count);
		map.put("pager", pager);
		model.addAttribute("map", map);
		return "product/list";
	}
	
	// 제품 상세페이지
	@RequestMapping("/productpage")
	public String productPage(PrdBoardVO vo, Model model) throws Exception {
		
		model.addAttribute("prd", prdBoardService.readPrdBoard(vo));
		return "product/page";
	}
	
}
