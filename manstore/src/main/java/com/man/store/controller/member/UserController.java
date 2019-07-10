package com.man.store.controller.member;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.man.store.model.member.UserService;
import com.man.store.model.member.UserVO;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginView(UserVO vo) { return "member/login"; }
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signupView(UserVO vo) { return "member/signup"; }
	
	@RequestMapping("/logout")
	public String logout(UserVO vo, HttpSession session) {
		session.invalidate();
		return "main";
	}
	
	// 아이디 중복검사
	@ResponseBody
	@RequestMapping("/checkID")
	public int checkID(UserVO vo) {
		int checkID = userService.checkID(vo);
		return checkID;
	}
	
	// 회원가입
	@RequestMapping(value="signup", method=RequestMethod.POST)
	public String insertUserData(UserVO vo) {
		userService.insertUserData(vo);
		return "main";
	}
	
	// 로그인 회원 유무 체크
	@ResponseBody
	@RequestMapping("/checkUser")
	public int checkUser(UserVO vo) {
		int checkUser = userService.checkUser(vo);
		return checkUser;
	}
	
	// 로그인
	@RequestMapping("/login")
	public String login(UserVO vo, HttpSession session) {
		UserVO user = userService.login(vo);
		if (user != null) {
			session.setAttribute("userInfo", user);
		}
		return "main";
	}
	
	// 비밀번호 찾기
	@RequestMapping("/findmypwd")
	public String findmypwd(UserVO vo) {
		return "member/findmypwd";
	}
	
	// 아이디
	@RequestMapping("/findmyid")
	public String findmyid(UserVO vo) {
		return "member/findmyid";
	}
	
	// 아이디 찾기 이메일
	@ResponseBody
	@RequestMapping("/findmyidemail")
	public String findmyidemail(UserVO vo) {
		String id = userService.findmyidemail(vo);
		return id;
	}
	
	// 아이디 찾기 전화번호
	@ResponseBody
	@RequestMapping("/findmyidphone")
	public String findmyidphone(UserVO vo) {
		String id = userService.findmyidphone(vo);
		return id;
	}
	
	// 임시 비밀번호 발급
	@ResponseBody
	@RequestMapping("/findmyimsipwd")
	public String findmyimsipwd(UserVO vo) {
		String pwd = userService.findmypwd(vo);
		return pwd;
	}
}
