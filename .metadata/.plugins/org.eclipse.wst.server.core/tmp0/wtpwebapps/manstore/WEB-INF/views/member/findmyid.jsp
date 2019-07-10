<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<a href="#" onclick="location.href='findmyid'">아이디 찾기</a><a href="#" onclick="location.href='findmypwd'">패스워드 찾기</a>

<br/><br/>
이름 이메일로 찾기<br/>
이름: <input type="text" id="user_name1" /><br/>
이메일: <input type="text" id="email" /><br/>
<input type="button" onclick="findmyidemail()" value="아이디 찾기" /><br/>
<br/><br/>

<script>
function findmyidemail() {
	var user_name1 = $("#user_name1").val();
	var email = $("#email").val();
	$.ajax({
		type : "POST",
		url : "findmyidemail",
		data : {
			"user_name" : user_name1,
			"email" : email
		}, success : function(data) {
			swal("회원님의 아이디는 " + data + " 입니다.", "", "info");
		}
	});
}
</script>

이름 핸드폰으로 찾기<br/>
이름: <input type="text" id="user_name2" /><br/>
핸드폰: <input type="text" id="phone" /><br/>
<input type="button" onclick="findmyidphone()" value="아이디 찾기" />

<script>
function findmyidphone() {
	var user_name2 = $("#user_name2").val();
	var phone = $("#phone").val();
	$.ajax({
		type : "POST",
		url : "findmyidphone",
		data : {
			"user_name" : user_name2,
			"phone" : phone
		}, success : function(data) {
			swal("회원님의 아이디는 " + data + " 입니다.", "", "info");
		}
	});
}
</script>
</body>
</html>