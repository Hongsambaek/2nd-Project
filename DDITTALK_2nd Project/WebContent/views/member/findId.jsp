<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	
%>

<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
<head>
<script src="../assets/js/color-modes.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

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
.modal {
	display: none;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgb(0, 0, 0);
	background-color: rgba(0, 0, 0, 0.4);
	padding-top: 60px;
}

.modal-content {
	background-color: #fefefe;
	margin: 5% auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
}

.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}

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
				<p class="lead">아이디를 잃어버리셨군요!</p>
			</div>
			<div class="container">
				<div class="col-md-5 col-lg-4 order-md-last">
					<ul class="list-group mb-3">

						<div class="col-12">
							<form id="findIdForm" class="needs-validation" method="post"
								action="<%=request.getContextPath()%>/findid.do"
								enctype="multipart/form-data">
								<div class="row g-3">

									<div class="col-sm-6">
										<label for="text" class="form-label">Name</label> <input
											type="text" class="form-control" name="memName" id="name"
											placeholder="이름" required pattern="[가-힣]{2,8}"/>
										<div class="invalid-feedback">이름 입력</div>
									</div>

									<div class="col-sm-6">
										<label for="userTel" class="form-label">Tel</label> <input
											type="text" class="form-control" name="memTel" id="tel"
											placeholder="(010-0000-0000 형식)" required pattern="[0-9]{2,3}-\d{3,4}-[0-9]{4}" />
										<div class="invalid-feedback">전화번호 입력</div>
									</div>

									<hr class="my-4" />

									<button class="w-100 btn btn-primary btn-lg" type="button" id="findIdBtn">
										Find Id</button>
							</form>
						</div>
				</div>
		</main>
	</div>






	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


	<script>
    document.addEventListener("DOMContentLoaded", function() {
        document.getElementById("logibGo").addEventListener("click", function() {
            window.location.href = "loginForm.jsp";///////////////
        });
        
    });
    
    
    
     document.querySelector('#findIdBtn').addEventListener('click',function(){
        
          $.ajax({
             type: 'post',
             url: '<%=request.getContextPath()%>/findid.do',
						data : {
							memName : $("input[name=memName]").val(),
							memTel : $("input[name=memTel]").val()
						}, 
						success : function(res) {
							console.log("응답>>", res.memEmail);

							if (res.memEmail == 'null') {
								alert("없는 유저입니다.");

							} else {
								alert(res.memEmail);
								location.href = "<%=request.getContextPath()%>/login.do";
							}
						},
						error : function(xhr) {
							alert("상태 확인: " + xhr.status);
						},
						dataType : 'json'
					})

				});
     
     
    
     
	</script>



</body>
</html>
