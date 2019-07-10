<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script text="text/javascript" src="resources/js/signup.js" charset="UTF-8"></script>
		<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%@ include file="../include/menu.jsp" %>
		<c:set var="toYear" value="2020" />
		<section>
			<h1>회원가입</h1>
			<div>
				<div>
					<label>아이디</label>
					<input type="text" id="user_id" placeholder="ID" />
					<label id="idchk"></label>
				</div>
				<div>
					<label>이름</label>
					<input type="text" id="user_name" placeholder="NAME" />
					<label id="namechk"></label>
				</div>
				<div>
					<label>비밀번호</label>
					<input type="password" id="user_pwd" placeholder="PASSWD" />
					<label id="pw1chk"></label>
					<label>비밀번호 확인</label>
					<input type="password" id="user_pwd_chk" placeholder="PASSWD" />
					<label id="pw2chk"></label>
				</div>
				<div>
					<label>생년월일</label>
					<select id="birth_year">
						<option value="">::년::</option>
						<c:forEach var="i" begin="0" end="${toYear-1900}">
							<c:set var="yearOption" value="${toYear-i}" />
							<option value="${yearOption}">${yearOption}</option>
						</c:forEach>
					</select>
					<select id="birth_month">
						<option value="">::월::</option>
						<c:forEach var="j" begin="0" end="${12-1}">
							<c:set var="monthOption" value="${12-j}" />
							<option value="${monthOption}">${monthOption}</option>
						</c:forEach>
					</select>
					<input type="text" id="birth_day" size="3" maxlength="2" placeholder="일" />
					<label id="birchk"></label>
				</div>
				<div>
					<label>이메일</label>
					<input type="text" id="email_id" placeholder="EmailID" /> @ 
					<input type="text" id="email_addr" disabled />
					<select id="email_select">
						<option value="">::선택하세요::</option>
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="1">직접입력</option>
					</select>
					<label id="emchk"></label>
				</div>
				<div>
					<label>주소</label>
					<input type="text" id="zipcode" class="postcodify_postcode5" placeholder="우편번호" readonly />
					<input type="button" id="postcodify_search_button" value="검색" /><br>
					<input type="text" id="address1" class="postcodify_address" readonly /><br>
					<input type="text" id="address2" class="postcodify_details" placeholder="상세주소" />
					<label id="adchk"></label>
				</div>
				<script>
					$(function() {
						$("#postcodify_search_button").postcodifyPopUp();
					});
				</script>
				<div>
					<label>연락처</label>
					<select id="phone_1">
						<option value="">::선택::</option>
						<option value="010">010</option>
						<option value="011">011</option>
					</select> - 
					<input type="text" id="phone_2" size="4" maxlength="4" onkeypress="onlyNumber()"/> - 
					<input type="text" id="phone_3" size="4" maxlength="4" onkeypress="onlyNumber()"/>
					<label id="phonechk"></label>
				</div>
				<div>
					<label>관심분야(최대 3개)</label>
					<div>
						<input type="checkbox" name="interest" value="outer"> 아우터
						<input type="checkbox" name="interest" value="top"> 상의
						<input type="checkbox" name="interest" value="bluejeans"> 청바지
						<input type="checkbox" name="interest" value="slacks"> 슬랙스
						<input type="checkbox" name="interest" value="shoes"> 신발
					</div>
					<label id="interchk"></label>
				</div>
				<div>
					<input type="button" id="signup" onClick="signupFn()" value="회원가입" />
				</div>
			</div>
		</section>
		<script>
		</script>
	</body>
</html>