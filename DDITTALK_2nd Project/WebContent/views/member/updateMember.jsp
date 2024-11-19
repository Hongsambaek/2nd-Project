<%@page import="VO.AtchFileVO"%>
<%@page import="VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	AtchFileVO atchFileVO = (AtchFileVO) request.getAttribute("atchFileVO");
MemberVO mv20020 = (MemberVO) session.getAttribute("LOGIN_USER");
%>

<div class="container">
	<form class="form-feed-insert" method="post" onsubmit="valid(event)"
		enctype="multipart/form-data"
		action="<%=request.getContextPath()%>/updatemember.do">
		<div class="mb-3">
			<div id="mypageProfileDisp" class="border border-danger">이미지를
				선택하세요</div>
			<input id="mypageProfileBtn" type="file" class="form-control mt-2"
				value="파일 선택" name="atchFileId">
		</div>

		<div class="input-group has-validation">
			<span class="input-group-text col-sm-3">Password</span> <input type="text"
				value="<%=mv20020.getMemPass()%>" class="form-control"
				name="memPass" id="memPass" placeholder="(특수문자를 포함한 8자 이상)" required
				pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$" />
			<div class="invalid-feedback">비밀번호는 특수문자를 포함한 8자 이상이어야 합니다.</div>
		</div>

		<div class="input-group has-validation">
			<span class="input-group-text col-sm-3">Tag</span> <input type="text"
				value="<%=mv20020.getMemTag()%>" class="form-control" name="memTag"
				id="tag" placeholder="Tag(가입 후 변경 가능)" required
				pattern="^[a-zA-Z0-9._]{1,30}$" />
			<div class="invalid-feedback">유효한 태그를 입력하세요.</div>
		</div>

		<div class="input-group has-validation">
			<span class="input-group-text col-sm-3">Nickname</span> <input type="text"
				value="<%=mv20020.getMemNickname()%>" class="form-control"
				name="memNickname" id="memNickname" placeholder="닉네임 입력" required />
			<div class="invalid-feedback">닉네임을 입력하세요.</div>
		</div>

		<div class="input-group has-validation">
			<span class="input-group-text col-sm-3">Tel</span> <input type="text"
				value="<%=mv20020.getMemTel()%>" class="form-control" name="memTel"
				id="memTel" placeholder="010-XXXX-XXXX 형식" required
				pattern="[0-9]{2,3}-\d{3,4}-[0-9]{4}" />
			<div class="invalid-feedback">유효한 전화번호를 입력하세요.</div>
		</div>

		<div class="input-group has-validation">
			<span class="input-group-text col-sm-3">Post</span> <input type="text"
				value="<%=mv20020.getMemPost()%>" class="form-control"
				name="memPost" id="memPost" placeholder="우편번호 검색하기" />
			<div class="invalid-feedback">우편번호를 입력하세요.</div>
		</div>

		<div class="input-group has-validation">
			<span class="input-group-text col-sm-3">Addr</span> <input type="text"
				value="<%=mv20020.getMemAddr()%>" class="form-control"
				name="memAddr" id="memAddr" placeholder="우편번호 검색시 자동입력" />
			<div class="invalid-feedback">주소를 입력하세요.</div>
		</div>

		<div class="input-group has-validation">
			<span class="input-group-text col-sm-3">School</span> <input type="text"
				value="<%=mv20020.getMemSchool()%>" class="form-control"
				name="memSchool" id="memSchool" placeholder="출신 학교 입력" />
			<div class="invalid-feedback">학교를 입력하세요.</div>
		</div>

		<hr class="input-group has-validation">

		<div class="input-group has-validation">
			<span class="input-group-text col-sm-3">E-mail</span> <input type="text"
				value="<%=mv20020.getMemEmail()%>" class="form-control"
				name="memEmail" id="memEmail"
				placeholder="<%=mv20020.getMemEmail()%>" required readonly />
			<div class="invalid-feedback">이메일을 입력하세요.</div>
		</div>

		<div class="input-group has-validation">
			<span class="input-group-text col-sm-3">가입일</span> <input type="text"
				value="<%=mv20020.getMemDate()%>" class="form-control"
				name="memDate" id="memDate" placeholder="처음 가입한 날짜" required
				readonly />
			<div class="invalid-feedback">가입일을 입력하세요.</div>
		</div>

		<div class="input-group has-validation">
			<span class="input-group-text col-sm-3">보유코인</span> <input type="text"
				value="<%=mv20020.getMemCoin()%>" class="form-control"
				name="memCoin" id="memCoin" placeholder="현재 보유량" required readonly />
			<div class="invalid-feedback">보유코인을 입력하세요.</div>
		</div>

		<div class="input-group has-validation">
			<span class="input-group-text col-sm-3">이름</span> <input type="text"
				value="<%=mv20020.getMemName()%>" class="form-control"
				name="memName" id="memName" placeholder="이름" required readonly />
			<div class="invalid-feedback">이름을 입력하세요.</div>
		</div>

		<div class="feed-insert-btn text-end">
			<button type="submit" class="btn btn-primary btn-sm" id="insertFeed">수정하기</button>
		</div>
	</form>
</div>
