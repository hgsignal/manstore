<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script type="text/javascript" src="" charset="UTF-8"></script>
		<script type="text/javascript" src="" charset="UTF-8"></script>
		<link rel="stylesheet" type="text/css" href="">
		<title>::MANSTORE::</title>
	</head>
	<body>
		<script>
			$("#buy_quantity").keyup(function(e){
				var regNumber = /^([0-9]{2})$/;
				var str = $(this).val();
				if(!regNumber.test(str)) {
					var res = str.substring(0, str.length-1);
					$(this).val(res);
				}
			});

			function buyProduct() {
				var user_num = $("#user_num").val();
				var prd_id = $("#prd_id").val();
				var quantity = $("#quantity").val();
				var select_opt = $("#select_opt").val();
				
				if (!user_num) {
					swal("", "비회원은 이용하실 수 없습니다.", "warning");
				} else if (quantity == 0) {
					swal("", "수량을 선택해주세요", "warning");
				} else {
					$.ajax({
						type : "POST",
						url : "wishlist",
						data : {
							"user_num" : user_num,
							"prd_id" : prd_id,
							"quantity" : quantity,
							"select_opt" : select_opt,
						},
						success : function(data) {
							//window.location.href="payment";
						}, error : function(data) {
							console.log(data);
						}
					});
				}
				
			}
		</script>
		<%@ include file="../include/menu.jsp" %>
		<div class="productdetail">
			<form>
			<h1 align="left" class="">${prd.b_title}</h1>
				<img class="productLeft" src="${prd.prd_img}">
				<div class="productRight">
					<p align="left" class="p1">상품이름: ${prd.prd_name}</p>
					<p align="left" class="p2">가격: <fmt:formatNumber value="${prd.prd_price}" pattern="#,###"/>원</p>
					<p align="left">상품번호: ${prd.prd_id}</p>
					<p align="left">재고: <b>${prd.stock}</b></p>
					<p align="left">수량: <input type="number" id="quantity" min="1" maxlength="2" max="99" value="1" oninput="mxNum(this)" /></p>
					<script>
						function mxNum(object) {
							if (object.value.length > object.maxLength) {
								object.value = object.value.slice(0, object.maxLength)
							}
						}
					</script>
					<p align="left">옵션: 
						<select id="select_opt">
							<c:forEach items="${fn:split(prd.prd_option, ',')}" var="opt">
								<option value="${opt}">${opt}</option>
							</c:forEach>
						</select>
					</p>
					<p align="left">본 상품은 서울배송만 가능합니다.</p><br><br><br>
					<input type="hidden" name="prd_b_img" id="prd_b_img" value="${prd.prd_b_img}" />
					<input type="hidden" name="user_id" id="user_id" value="${user.user_id}" />
					<input type="hidden" name="prd_id" id="prd_id" value="${prd.prd_id}" />
					<p align="left">
						<input type="button" name="buy" id="buy" onClick="buyProduct()" value="구매하기" />&nbsp;&nbsp;&nbsp;
						<input type="button" name="cart" id="cart" onClick="insertCart()" value="장바구니" />
					</p>
				</div>
			</form>
		</div>
		<div class="detail">
			<table style="width: 700px;">
				<tr>
					<th>상품 설명</th>
				</tr>
				<tr>
					<td>${prd.b_content}</td>
				</tr>
			</table>
		</div>
		<div class="danger">
			<table style="width: 700px; text-align: left;">
				<tr>
					<th>주의 사항</th>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;13시 이전 결제 완료시 당일 배송</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;반품 및 교환 요청은 배송비 고객 부담</td>
				</tr>
			</table>
		</div>
		<%@ include file="../include/footer.jsp" %>
	</body>
</html>