<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" type="text/css" href="${path}/css/main.css">
<title>ManStore</title>
</head>
<body>
<%@ include file="include/menu.jsp" %>

<!-- 추천 MD -->
<div>
</div>

<!-- 신상품 소개 -->
<div style="width:1600;height:500;">
<h2>N E W</h2>
</div>

<!-- 베스트 -->
<div>
<h2>B E S T</h2>
</div>

<!-- 아우터 소개 -->
<div>
<h2>O U T E R  B E S T</h2>
</div>

<!-- 상의 베스트 -->
<div>
<h2>T O P  B E S T</h2>
</div>

<!-- 바지 베스트 -->
<div>
<h2>B O T T O M  B E S T</h2>
</div>

<!-- 신발 베스트 -->
<div>
<H2>S H O E S B E S T</H2>
</div>

<%@ include file="include/footer.jsp" %>
</body>
</html>