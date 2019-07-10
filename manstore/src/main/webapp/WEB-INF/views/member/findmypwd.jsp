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

비밀번호 찾기<br/>
이름: <input type="text" id="user_name" /><br/>
아이디: <input type="text" id="user_id" /><br/>
<input type="button" onclick="findmyimsipwd()" value="비밀번호 찾기" />

<script>
function findmyimsipwd() {
	var user_name = $("#user_name").val();
	var user_id = $("#user_id").val();
	$.ajax({
		type : "POST",
		url : "findmyimsipwd",
		data : {
			"user_name" : user_name,
			"user_id" : user_id
		}, success : function(data) {
			swal("회원님의 임시비밀번호는 " + data + " 입니다.", " ", "info");
		}
	});
}
</script>
</body>
</html>