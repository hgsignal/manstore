package com.man.store.model.prdBoard.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.man.store.model.prdBoard.PrdBoardVO;

@Repository
public class PrdBoardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 상품번호
	public PrdBoardVO getPrdId(PrdBoardVO vo) {
		return (PrdBoardVO) mybatis.selectOne("PrdBoardDAO.getPrdId", vo);
	}
	
	// 상품정보
	public PrdBoardVO infoProduct(PrdBoardVO vo) {
		return (PrdBoardVO) mybatis.selectOne("PrdBoardDAO.infoProduct", vo);
	}
	
	// 상품보기
	public PrdBoardVO readPrdBoard(PrdBoardVO vo) {
		return (PrdBoardVO) mybatis.selectOne("PrdBoardDAO.readPrdBoard", vo);
	}
	
	// 게시물 목록
	public List<PrdBoardVO> listPrdBoard(PrdBoardVO vo, int start, int end) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product", vo);
		map.put("start", start);
		map.put("end", end);
		return mybatis.selectList("PrdBoardDAO.listPrdBoard", map);
	}
	
	// 상품갯수
	public int countPrdBoard(PrdBoardVO vo) throws Exception {
		return mybatis.selectOne("PrdBoardDAO.countPrdBoard", vo);
	}
	
}
