<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
<head>
<script src="../assets/js/color-modes.js"></script>

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="" />
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors" />
<meta name="generator" content="Hugo 0.122.0" />
<title>Checkout example · Bootstrap v5.3</title>



<link href="css/bootstrap.min.css" rel="stylesheet" />

<link href="css/signin.css" rel="stylesheet" />
<style>
* {
	box-sizing: border-box;
}

.container {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh; /* 전체 화면 높이 */
	text-align: center; /* 텍스트 중앙정렬 */
}

.boxleft {
	display: flex;
	align-items: center; /* 세로 정렬을 가운데로 맞춤 */
	padding-top: 20px
}

.textleft {
	display: flex;
	padding-top: 3px;
}

.rq {
	top: 50px;
	color: red;
}

.Obak {
	top: 10;
}
</style>
</head>

<body class="bg-body-tertiary">
	<div>
		<main>
			<div class="inline-block py-5 text-center">
				<img class="d-block mx-auto mb-4" src="./images/Logo.png" alt=""
					width="auto" height="400" />
				<p class="lead">DDITTALK에 오신 것을 환영합니다!</p>
			</div>

			<div class="h -300 container">
				<div class="col-md-5 col-lg-4 order-md-last">
					<ul class="list-group mb-3">
						<div class="form-group">
							<h4 class="form-group">Create DDTITALK account</h4>
							<form class="form-group" method="post"
								action="<%=request.getContextPath()%>/memberinsert.do"
								enctype="multipart/form-data">
								<div class="row g-3">

									<div class="col-sm-6">
										<label for="text" class="float-start">Name<span
											class="rq"> *</span></label> <input type="text" class="form-control"
											name="memName" id="name" placeholder="이름" required
											pattern="[가-힣]{2,8}" />
										<div class="invalid-feedback">유효한 이름을 입력해주세요.</div>
									</div>


									<div class="col-sm-6">
										<label for="userTel" class="float-start">Tel<span
											class="rq"> *</span></label> <input type="text" class="form-control"
											name="memTel" id="tel" placeholder="(010-0000-0000 형식)"
											required pattern="[0-9]{2,3}-\d{3,4}-[0-9]{4}" />
										<div class="invalid-feedback">전화번호 입력</div>
									</div>

									<div class="col-sm-12">
										<label for="email" class="float-start">Email<span
											class="rq"> *</span></label> <input type="email" class="form-control"
											name="memEmail" id="email" placeholder="E-mail form" required
											pattern="[0-9a-zA-Z]+@[0-9a-zA-Z]+(\.[a-z]+){1,2}" />
									</div>

									<div class="col-sm-12" style="text-align: left;">
										<span id="overlap-feedback"></span>
									</div>


									<div class="col-sm-4">
										<button class="btn btn-primary d-inline-flex float-start"
											id="get_vld_num">인증번호 받기</button>
									</div>

									<div class="col-sm-3 text-end">
										<input class="form-control d-inline-block w-auto" type="text"
											id="inpt_vld_num" placeholder="인증번호 입력">
									</div>

									<div class="col-sm-4 text-end">
										<button class="btn btn-primary d-inline-flex float-end"
											id="match_vld_num">번호확인</button>
									</div>

									<div class="row boxleft">
										<div class="invalid-feedback">유효한 이메일 주소를 입력해주세요.</div>
									</div>



									<div class="col-12">
										<label for="username" class="float-start">Tag<span
											class="rq"> *</span></label>
										<div class="input-group has-validation">
											<span class="input-group-text">@</span> <input type="text"
												class="form-control" name="memTag" id="tag"
												placeholder="Tag(가입 후 변경 가능)" required
												pattern="^[a-zA-Z0-9._]{1,30}$" />
											<div class="invalid-feedback">사용자 태그를 입력해주세요.</div>
										</div>
										<span class="float-start" id="overlap-tagfeedback"></span>
									</div>

									<div class="col-12">
										<label for="password" class="float-start">Pass<span
											class="rq"> *</span></label> <input type="password"
											class="form-control" name="memPass" id="pass"
											placeholder="(특수문자를 포함한 8자 이상 (!@#$%) )" required pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$" />
										<div class="invalid-feedback">유효한 비밀번호를 입력해주세요.</div>
									</div>
									
									<div class="col-sm-12" style="text-align: left;">
										<span id="overlap-passfeedback"></span>
									</div>



									<div class="boxleft">
										<div class="col-sm-4 text-end">
											<label for="address" class="float-start">Post<span></span></label>
											<input type="text" class="form-control d-inline-block w-auto"
												name="memPost" id="postAddr" placeholder="주소 입력" />
										</div>
										<div class="col-sm-4 text-end" style="text-align: left;">
											<button type="button" id="addrBtn" class="btn btn-primary" style="margin-top:20px;">주소검색</button>
										</div>
									</div>

									<div class="col-12">
										<label for="addr1" class="float-start">Address<span></span></label>
										<div class="col-12">
											<input type="text" class="form-control" id="memAddr1"
												name="memAddr">
										</div>
									</div>

									<div class="col-12">
										<label for="addr1" class="float-start">Detail Address<span></span></label>
										<div class="col-12">
											<input type="text" class="form-control" id="memAddr2"
												name="memDetailAddr">
										</div>
									</div>

									<div class="col-12">
										<label for="school" class="float-start">School</label> <input
											type="text" class="form-control" name="memSchool" id="school"
											placeholder="출신학교 입력" />
										<div class="invalid-feedback">출신학교를 입력해주세요.</div>
									</div>

									<div class="col-12">
										<label for="nickname" class="float-start">Nickname<span
											class="rq"> *</span></label> <input type="text" class="form-control"
											name="memNickname" id="nickname" placeholder="Nickname입력"
											required />
										<div class="invalid-feedback">닉네임을 입력해주세요.</div>
									</div>
								</div>

								<hr class="my-4" />

								<div class="textleft">
									<input type="checkbox" class="form-check-input"
										id="same-address" required /> <label class="form-check-label"
										for="same-address"> (필수) 개인정보 수집 동의 <span class="rq">
											*</span></label>
								</div>

								<div class="boxleft">
									<input type="checkbox" class="form-check-input" id="save-info"
										required /> <label class="form-check-label" for="save-info">
										(필수) 개인정보 이용 동의 <span class="rq"> *</span>
									</label>
								</div>

								<hr class="my-4" />

								<button class="w-100 btn btn-primary btn-lg" type="submit">
									Continue to checkout</button>
							</form>
						</div>
				</div>
		</main>
	</div>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
  
	let vld_num;
  $('#get_vld_num').on("click", function(){
		vld_num = Math.floor(Math.random()*899999)+100000
	$.ajax({
		type:'get',
		url:'<%=request.getContextPath()%>/mailsender.do',
		data:{
			  "to":$('#email').val(),
			  "num":vld_num
			  },
		success:function(res) {
			console.log(res)
			if(res == 1) {
				$('invalid-feedback').html("인증성공!").css('color', 'gold');
				alert("인증번호 발송!");
			} else {
				$('invalid-feedback').html("인증실패..").css('color', 'red');
				alert("인증번호 발송 실패..ToT");
			}
		},
		error:function(xhr) {
			alert(`상태확인 ${xhr.status}`);
			console.log(xhr);
		}
  });
  });
  
  $('#match_vld_num').on('click', function(val){
	  console.log("val : ", $('#inpt_vld_num').val());
	  console.log("vld_num : ", vld_num);
	  if($('#inpt_vld_num').val() == vld_num) {
		  alert("인증에 성공했습니다");
	  } else {
		  alert("인증에 실패했습니다");
	  }
  });
  </script>

	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
      $('#email').on('keyup', function() {
         $.ajax({
            url :'<%=request.getContextPath()%>/views/member/idChk.jsp',
										type : 'get',
										data : {
											"email" : $('#email').val(),
										},
										success : function(res) {
											if (res.rst == "ok") {
												$('#overlap-feedback').text(
														res.msg).css('color',
														"green");
											} else {
												$('#overlap-feedback').text(
														res.msg).css('color',
														"red");
											}
										},
										error : function(xhr) {
											alert("상태 : " + xhr.status);
										},
										dataType : 'json'
									});
						});
      
      $('#pass').on('keyup', function() {
         $.ajax({
            url :'<%=request.getContextPath()%>/views/member/passChk.jsp',
										type : 'get',
										data : {
											"pass" : $('#pass').val(),
										},
										success : function(res) {
											if (res.rst == "ok") {
												$('#overlap-passfeedback').text(
														res.msg).css('color',
														"green");
											} else {
												$('#overlap-passfeedback').text(
														res.msg).css('color',
														"red");
											}
										},
										error : function(xhr) {
											alert("상태 : " + xhr.status);
										},
										dataType : 'json'
									});
						});
      
      $('#tag').on('keyup', function() {
          $.ajax({
             url :'<%=request.getContextPath()%>/views/member/tagChk.jsp',
										type : 'get',
										data : {
											"tag" : $('#tag').val(),
										},
										success : function(res) {
											if (res.rst == "ok") {
												$('#overlap-tagfeedback').text(
														res.msg).css('color',
														"green");
											} else {
												$('#overlap-tagfeedback').text(
														res.msg).css('color',
														"red");
											}
										},
										error : function(xhr) {
											alert("상태 : " + xhr.status);
										},
										dataType : 'json'
									});
						});

		$('#addrBtn').on('click', addrApi);
		function addrApi() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							document.getElementById('postAddr').value = data.zonecode;
							document.querySelector("#memAddr1").value = data.roadAddress;
						}
					}).open();
		}

		function valid(e) {
			e.preventDefault();
			let formData = $('form').serialize();
			console.log(formData);
			$.ajax({
				type : 'post',
				url : '/login.do',
				data : formData,
				success : function(res) {
					console.log("응답>>", res);
					if (res == 1) {
						if (confirm("로그인 페이지로 이동하시겠습니까?"))
							location.href = "login.do"
						$('#joinspan').text("띳톡 가입성공!").css('color', 'gold');
					} else {
						$('#joinspan').text("가입실패..").css('color', 'gray');
					}
				},
				error : function(xhr) {
					alert("상태확인:" + xhr.status);
				}
			})

		}
	</script>


</body>
</html>
