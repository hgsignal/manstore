package com.man.store.model.member;

public interface UserService {
	// 아이디 중복검사
	int checkID(UserVO vo);
	
	// 회원가입
	void insertUserData(UserVO vo);
	
	// 회원 체크
	int checkUser(UserVO vo);
	
	// 로그인
	UserVO login(UserVO vo);
	
	// 아이디 찾기 이메일
	String findmyidemail(UserVO vo);
	
	// 아이디 찾기 전화번호
	String findmyidphone(UserVO vo);
	
	// 임시 비밀번호 발급
	String findmypwd(UserVO vo);
}