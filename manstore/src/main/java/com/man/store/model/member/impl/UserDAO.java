package com.man.store.model.member.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.man.store.model.member.UserVO;

@Repository
public class UserDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 아이디 중복검사
	public int checkID(UserVO vo) {
		return sqlSession.selectOne("UserDAO.checkID", vo);
	}
	
	// 회원가입
	public void insertUserData(UserVO vo) {
		sqlSession.insert("UserDAO.insertUserData", vo);
	}
	
	// 회원 체크
	public int checkUser(UserVO vo) {
		return sqlSession.selectOne("UserDAO.checkUser", vo);
	}
	
	// 로그인
	public UserVO login(UserVO vo) {
		return sqlSession.selectOne("UserDAO.login", vo);
	}
	
	// 아이디 찾기 이메일
	public String findmyidemail(UserVO vo) {
		return sqlSession.selectOne("UserDAO.findmyidemail", vo);
	}
	
	// 아이디 찾기 전화번호
	public String findmyidphone(UserVO vo) {
		return sqlSession.selectOne("UserDAO.findmyidphone", vo);
	}
	
	public void findmyimsipwd(UserVO vo) {
		sqlSession.update("UserDAO.findmyimsipwd", vo);
	}
}
