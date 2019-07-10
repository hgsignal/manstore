package com.man.store.model.prdWishList.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.man.store.model.prdWishList.PrdWishListService;
import com.man.store.model.prdWishList.PrdWishListVO;

@Service("prdWish")
public class PrdWishListServiceImpl implements PrdWishListService {

	@Autowired
	private PrdWishListDAO prdWishListDAO;
	
	// 위시리스트에 담기
	public List<PrdWishListVO> listWish(PrdWishListVO vo, int start, int end) throws Exception {
		return prdWishListDAO.listWish(vo, start, end);
	}
	
	// 상품을 추가한 갯수
	public int countWish(PrdWishListVO vo) throws Exception {
		return prdWishListDAO.countWish(vo);
	}
}
