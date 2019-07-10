package com.man.store.model.prdBoard;

import java.util.List;

public interface PrdBoardService {

	/*
	// 상품글 등록
	void createPrdBoard(PrdBoardVO vo) throws Exception;	
	// 상품글 삭제
	void deletePrdBoard(int bno) throws Exception;	
	// 상품글 수정
	void modifyPrdBoard(PrdBoardVO vo) throws Exception;
	*/
	
	// 상품글 보기
	PrdBoardVO readPrdBoard(PrdBoardVO vo) throws Exception;
	
	// 상품글 목록
	List<PrdBoardVO> listPrdBoard(PrdBoardVO vo, int start, int end) throws Exception;
	
	// 상품글 갯수
	int countPrdBoard(PrdBoardVO vo) throws Exception;
	
	/*
	// 이전글
	PrdBoardVO previousB(int bno) throws Exception;
	// 다음글
	PrdBoardVO nextB(int bno) throws Exception;
	*/
}