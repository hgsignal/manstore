package com.man.store.model.prdWishList.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.man.store.model.prdWishList.PrdWishListVO;

@Repository
public class PrdWishListDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 위시리스트에 담기
	public List<PrdWishListVO> listWish(PrdWishListVO vo, int start, int end) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("wish", vo);
		map.put("start", start);
		map.put("end", end);
		return mybatis.selectList("PrdWishDAO.listWish", map);
	}
	
	// 상품을 추가한 갯수
	public int countWish(PrdWishListVO vo) throws Exception {
		return mybatis.selectOne("PrdWishDAO.countWish", vo);
	}
}
