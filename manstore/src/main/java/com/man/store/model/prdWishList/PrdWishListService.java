package com.man.store.model.prdWishList;

import java.util.List;

public interface PrdWishListService {
	
	// 위시리스트에 담기
	List<PrdWishListVO> listWish(PrdWishListVO vo, int start, int end) throws Exception;
	
	// 상품을 추가한 갯수
	int countWish(PrdWishListVO vo) throws Exception;
}
