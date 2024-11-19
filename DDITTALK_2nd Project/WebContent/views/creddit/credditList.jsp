<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="VO.CredditVO"%>

<%
	List<CredditVO> creList = (List<CredditVO>) request.getAttribute("creList");
%>
<html lang="ko">
<head>
<meta charSet="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>결제 위젯</title>
<script src="https://js.tosspayments.com/v1/payment-widget"></script>
<style>
#payment-button {
	width: 100%;
	padding: 15px;
	background-color: #3065AC;
	color: white;
	border-radius: 3px;
	font-size: 16px;
	border: none;
	margin-top: 10px
}

.title {
	margin: 0 0 4px;
	font-size: 24px;
	font-weight: 600;
	color: #4e5968;
}
</style>
</head>
<body>
	<!-- 상품 정보 영역-->
	<div class="title">크래딧 구매</div>
	<form method="get" action="<%=request.getContextPath()%>/pay.do"
		onsubmit="return validateForm()">
		<%
			int creSize = creList.size();
		if (creSize > 0) {
			for (CredditVO cv : creList) {
		%>
		<input type="radio" name="credit" id="credit"
			value="<%=cv.getCredditQty()%>">
		<%=cv.getCredditQty()%>크래딧<br>
		<%
			} //for
		} //if
		%>
		<button id="payment-button" type="submit">구매하기</button>
	</form>
	<hr>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		function validateForm() {
			if ($('input[name="credit"]:checked').length === 0) {
				alert("목록을 선택하세요.");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>