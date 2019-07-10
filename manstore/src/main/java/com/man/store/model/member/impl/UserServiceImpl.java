package com.man.store.model.member.impl;

import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.man.store.model.member.UserService;
import com.man.store.model.member.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	// 패스워드 SHA3-512암호화
	public void securityPWD(UserVO vo) {
		SHA3.DigestSHA3 digestSHA3 = new SHA3.DigestSHA3(512);
		byte[] digest = digestSHA3.digest(vo.getUser_pwd().getBytes());
		String securitypwd = Hex.toHexString(digest);
		vo.setUser_pwd(securitypwd);
	}
	
	// 임시비밀번호발급
	public void imsipwd(UserVO vo) {
		char[] charSet = new char[] { 
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
				'U', 'V', 'W', 'X', 'Y', 'Z' };
		int idx = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			idx = (int) (charSet.length * Math.random());
			sb.append(charSet[idx]);
		}
		String imPW = sb.toString();
		vo.setUser_pwd(imPW);
	}
	
	// 아이디 중복검사
	public int checkID(UserVO vo) {
		return userDAO.checkID(vo);
	}
	
	// 회원가입
	public void insertUserData(UserVO vo) {
		securityPWD(vo);
		userDAO.insertUserData(vo);
	}
	
	// 회원 체크
	public int checkUser(UserVO vo) {
		securityPWD(vo);
		return userDAO.checkUser(vo);
	}
	
	// 로그인
	public UserVO login(UserVO vo) {
		securityPWD(vo);
		return userDAO.login(vo);
	}
	
	// 아이디 찾기 이메일
	public String findmyidemail(UserVO vo) {
		return userDAO.findmyidemail(vo);
	}
	
	// 아이디 찾기 전화번호
	public String findmyidphone(UserVO vo) {
		return userDAO.findmyidphone(vo);
	}
	
	// 임시 비밀번호 발급
	public String findmypwd(UserVO vo) {
		imsipwd(vo);
		String imsi = vo.getUser_pwd();
		securityPWD(vo);
		userDAO.findmyimsipwd(vo);
		return imsi;
	}
}
