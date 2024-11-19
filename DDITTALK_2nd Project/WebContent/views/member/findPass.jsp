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
	align-items: header;
	text-align: center; /* 텍스트 중앙정렬 */
}

.space {
	margin-right: 10px;
}
</style>
</head>

<body class="bg-body-tertiary">
	<span></span>
	<div>
		<main>
			<div class="inline-block py-5 text-center">
				<img class="d-block mx-auto mb-4" src="./images/Logo.png"
					width="auto" height="400" />
				<p class="lead">비밀번호를 잃어버리셨군요!</p>
			</div>
			<div class="container">
				<div class="col-md-5 col-lg-4 order-md-last">
					<ul class="list-group mb-3">

						<div class="col-12">
<!-- 							<form class="needs-validation" method="post" -->
<%-- 								action="<%=request.getContextPath()%>/rpdeadb.do" --%>
<!-- 								enctype="multipart/form-data"> -->
								<div class="row g-3">
									<div class="col-12">
										<label for="email" class="form-label">Email</label> <input
											type="email" class="form-control" name="memEmail" id="email"
											placeholder="E-mail form" required
											pattern="[0-9a-zA-Z]+@[0-9a-zA-Z]+(\.[a-z]+){1,2}" />
									</div>

									<div class="col-sm-6">
										<label for="text" class="form-label">Name</label> <input
											type="text" class="form-control" name="memName" id="name"
											placeholder="이름" required pattern="[가-힣]{2,8}" />
									</div>

									<div class="col-sm-6">
										<label for="userTel" class="form-label">Tel</label> <input
											type="text" class="form-control" name="memTel" id="tel"
											placeholder="(010-0000-0000 형식)" required
											pattern="[0-9]{2,3}-\d{3,4}-[0-9]{4}" />
									</div>


									<hr class="my-4" />

<!--  									<button class="w-100 btn btn-primary btn-lg" type="submit" -->
<!--  										id="send_pass_btn">Find PW</button> -->
 									 <input type="button" id="send_pass_btn" class="w-100 btn btn-primary btn-lg" value="Find pw"/>
<!-- 							</form> -->
						</div>
				</div>
		</main>
	</div>

	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
    
	 $('#send_pass_btn').click(function() {
         $.ajax({
			            type: 'post',
			            url: '<%=request.getContextPath()%>/rpdeadb.do',
						data : {
							"memName" : $("#name").val(),
							"memTel" : $("#tel").val(),
							"to":$('#email').val()
						},
						dataType : 'json',
						success : function(res) {
							console.log("응답>>", res.memEmail);
							if (res.memEmail == 'null' || res.memName == 'null' || res.memTel == 'null') {
								alert("찾는 정보가 없습니다.");
							} else {
								alert('이메일로 비밀번호를 전송했습니다.');
								location.href = "<%=request.getContextPath()%>/login.do";
							}
						},
						error : function(xhr) {
							alert('실패');
<%-- 							location.href = "<%=request.getContextPath()%>/login.do"; --%>
						}
						
					})

				});
	 
	 
	</script>
</body>
</html>
