<%@page import="VO.MemberVO"%>
<%@page import="org.omg.CORBA.portable.CustomValue"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MemberVO mv10010 = (MemberVO) session.getAttribute("LOGIN_USER");
%>

<div class="container">
	<form class="form-feed-insert" method="post"
		enctype="multipart/form-data"
		action="<%=request.getContextPath()%>/feedupdate.do">
		<div class="mb-3">
			<div id="dispp-update" class="dispp border border-danger">이미지를 선택하세요</div>
			<input id="inputBtn2" type="file" class="form-control mt-2"
				value="파일 선택" name="fileId">
		</div>
		<div class="mb-3">
			<textarea placeholder="내용을 입력하세요(검색어는 해시태그(#)로 입력하세요)"
				class="form-control" id="feed-content-update" name="feedContent"></textarea>
		</div>
		<input id="insertSpan" name="memEmail" value="<%=mv10010.getMemEmail()%>"
			style="display: none"></input>
		<input id="update-input" name="feedNum" value="" style="display: none"></input>
		<div class="mb-3">
			<div class="row">
				<div class="col feed-insert-radio">
					<label class="form-label" >공개 여부</label><br> <input
						type="radio" class="btn-check" name="feedDisplay" id="public"
						value="공개" checked autocomplete="off"> <label
						class="btn btn-outline-primary" for="public">공개</label> <input
						type="radio" class="btn-check" name="feedDisplay" id="friends"
						value="친구" autocomplete="off"> <label
						class="btn btn-outline-success" for="friends">친구</label> <input
						type="radio" class="btn-check" name="feedDisplay" id="private"
						value="비공개" autocomplete="off"> <label
						class="btn btn-outline-danger" for="private">비공개</label>
				</div>
				<div class="col feed-insert-radio">
					<label class="form-label">광고 여부</label><br> <input
						type="radio" class="btn-check" name="feedAdv" id="nonAdv"
						value="N" checked autocomplete="off"> <label
						class="btn btn-outline-secondary" for="nonAdv">비광고성</label> <input
						type="radio" class="btn-check" name="feedAdv" id="adv" value="Y"
						autocomplete="off"> <label class="btn btn-outline-warning"
						for="adv">광고</label>
				</div>
			</div>
			<div class="feed-insert-btn">
				<button type="submit" class="btn btn-primary" id="insertFeed">등록하기</button>
			</div>
		</div>
	</form>
</div>

<script src="mainfeeder.jsp">
	
</script>
