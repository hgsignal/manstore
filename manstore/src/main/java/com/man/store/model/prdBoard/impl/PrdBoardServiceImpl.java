package com.man.store.model.prdBoard.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.man.store.model.prdBoard.PrdBoardService;
import com.man.store.model.prdBoard.PrdBoardVO;
import com.man.store.model.product.ProductVO;

@Service("prdBoardService")
public class PrdBoardServiceImpl implements PrdBoardService {
	@Autowired
	private PrdBoardDAO prdBoardDAO;
	
	// 상품보기
	public PrdBoardVO readPrdBoard(PrdBoardVO vo) throws Exception {
		return prdBoardDAO.readPrdBoard(vo);
	}
	
	// 상품목록
	public List<PrdBoardVO> listPrdBoard(PrdBoardVO vo, int start, int end) throws Exception {
		return prdBoardDAO.listPrdBoard(vo, start, end);
	}
	
	// 상품갯수
	public int countPrdBoard(PrdBoardVO vo) throws Exception {
		return prdBoardDAO.countPrdBoard(vo);
	}
}
