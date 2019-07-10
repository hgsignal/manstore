<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../include/header.jsp"%>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" type="text/css" href="${path}/include/css/menu.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<title>남성의류쇼핑몰:MANSTORE</title>
<script>
	function loginView() { location.href = "login"; }
	function signup() { location.href = "signup"; }
	function logout() { location.href = "logout"; }
	function findmypwd() { location.href = "findmypwd"; }
</script>
<div class="nav">
	<div id="topH">
		<a id="maa" href="main">MAN STORE</a>&nbsp;&nbsp;
	</div>
	<div id="topS">
		<div id="topS2">
			<form>
				<input type="text" id="" name="" /> <input type="submit" value="검색" />
			</form>
		</div>
	</div>
	<div class="nav2">
		<div class="mCa">
			<ul>
				<c:if test="${userInfo == null}">
					<li id="log" onClick="loginView()">로그인</li>
				</c:if>
				<li onClick="">랭킹</li>
				<li onClick="">신상품
					<ul id="ca1">
						<li onclick="location.href='prdlist?menu_id=1'">아우터</li>
						<li onclick="location.href=''">상의</li>
						<li onclick="location.href=''">하의</li>
					</ul>
				</li>
				<li>아우터
					<ul id="ca1">
						<li onclick="location.href=''">가디건/집업</li>
						<li onclick="location.href=''">자켓/블레이저</li>
						<li onclick="location.href=''">코트</li>
						<li onclick="location.href=''">점퍼/패딩</li>
					</ul>
				</li>
				<li onclick="location.href=''">상의
					<ul id="ca1">
						<li onclick="location.href=''">티셔츠
							<ul id="ca2">
								<li onclick="location.href=''">긴팔티</li>
								<li onclick="location.href=''">맨투맨</li>
								<li onclick="location.href=''">후드티</li>
								<li onclick="location.href=''">니트</li>
							</ul>
						</li>
						<li onclick="location.href=''">셔츠
							<ul id="ca2">
								<li class="a" onclick="location.href=''">7부/반팔셔츠</li>
								<li onclick="location.href=''">베이직/기본</li>
								<li onclick="location.href=''">체크/패턴셔츠</li>
							</ul>
						</li>
					</ul>
				</li>
				<li onclick="location.href='board'">하의
					<ul id="ca1">
						<li onclick="location.href=''">청바지</li>
						<li onclick="location.href=''">면바지</li>
						<li onclick="location.href=''">슬렉스</li>
						<li onclick="location.href=''">트레이닝
							<ul id="ca2">
								<li class="a" onclick="location.href=''">긴바지</li>
								<li onclick="location.href=''">7부/반바지</li>
							</ul>
						</li>
					</ul>
				</li>
				<li onclick="location.href=''">신발
					<ul id="ca1">
						<li onclick="location.href=''">운동화</li>
						<li onclick="location.href=''">스니커즈</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>
<br>
<br>
<br>
<c:choose>
	<c:when test="${userInfo == null}">
		<span onclick="signup()">| 회원가입</span> | 
		<span onclick="findmypwd()">비밀번호찾기</span> |
	</c:when>
	<c:when test="${userInfo != null}">
		<span onclick="logout()">로그아웃</span> |
	</c:when>
</c:choose> 
<span onclick="">주문배송조회</span> |
<span onclick="">문의사항</span> |
<c:choose>
	<c:when test="${userInfo.user_div == 'user'}">
		<span id="udiv" onclick="location.href=''">장바구니</span>
	</c:when>
	<c:when test="${userInfo.user_div == 'admin'}">
		<span id="udiv" onclick="location.href=''">상품등록</span>
	</c:when>
</c:choose>
<br>
<br>
<br>