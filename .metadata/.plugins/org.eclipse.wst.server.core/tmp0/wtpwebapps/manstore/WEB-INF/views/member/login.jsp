<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%@ include file="../include/menu.jsp" %>
		<input type="text" id="user_id" placeholder="ID" />
		<input type="password" id="user_pwd" placeholder="PASSWORD" />
		<input type="button" id="loginbtn" onClick="login()" value="Login" />
		<script>
			function login() {
				var user_id=$("#user_id").val();
				var user_pwd=$("#user_pwd").val();
				if ($("#user_id").val() == "" || $("#user_pwd").val() == "") {
					swal("", "아이디와 패스워드를 확인해주세요.", "warning");
				} else {
					$.ajax({
						type : "POST",
						url : "checkUser",
						data : {
							"user_id" : user_id,
							"user_pwd" : user_pwd
						}, success : function(data) {
							if (data == 0) {
								swal("", "아이디와 패스워드를 확인해주세요.", "warning");
							} else {
								$.ajax({
									type : "POST",
									url : "login", 
									data : {
										"user_id" : user_id,
										"user_pwd" : user_pwd
									}, success : function() {
										location.href="main";
									}
								});
							}
						}
					});
				}
			}
		</script>
	</body>
</html>