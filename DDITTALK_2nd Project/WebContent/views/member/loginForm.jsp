<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
<head>
<title>DDITTALK</title>
<link href="css/bootstrap.css" rel="stylesheet" />
<style>
.video-bg {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: -1;
	overflow: hidden;
}

.video-bg video {
	min-width: 100%;
	min-height: 100%;
	width: auto;
	height: auto;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.btn-bd-primary { -
	-bd-violet-bg: #712cf9; -
	-bd-violet-rgb: 112.520718, 44.062154, 249.437846; -
	-bs-btn-font-weight: 600; -
	-bs-btn-color: var(- -bs-white); -
	-bs-btn-bg: var(- -bd-violet-bg); -
	-bs-btn-border-color: var(- -bd-violet-bg); -
	-bs-btn-hover-color: var(- -bs-white); -
	-bs-btn-hover-bg: #6528e0; -
	-bs-btn-hover-border-color: #6528e0; -
	-bs-btn-focus-shadow-rgb: var(- -bd-violet-rgb); -
	-bs-btn-active-color: var(- -bs-btn-hover-color); -
	-bs-btn-active-bg: #5a23c8; -
	-bs-btn-active-border-color: #5a23c8;
}
/* .form-signin { */
/*     display: none; */
/* } */
</style>

<link href="css/signin.css" rel="stylesheet" />
</head>
<body class="d-flex align-items-center py-4 bg-body-tertiary">



	<main class="form-signin w-100 m-auto">

		<form class="form-signin" method="post"
			action="<%=request.getContextPath()%>/login.do">
			<img class="mb-4" src="./images/Logo.png" width="auto" height="260" />
			<h1 class="h3 mb-3 fw-normal">Welcome, DDITTALK!</h1>

			<div class="form-floating">
				<input type="text" class="form-control" name="memEmail"
					id="username" placeholder="Username" required autofocus />
				<label for="username">이메일</label>
			</div>

			<div class="form-floating">
				<input type="password" class="form-control" id="password"
					name="memPass" placeholder="Password" required /> <label
					for="password">비밀번호</label>
			</div>

			<button class="btn btn-primary w-100 py-2" type="submit" id="login-btn"
				>로그인</button>
			<hr />
			<button class="btn btn-primary w-100 py-2" type="button"
				onclick="location.href='memberinsert.do'">회원가입</button>
			<hr />
			<div style="margin-left: 35px; margin-right: 20px">
				<button class="btn btn-primary11" type="button"
					style="text-align: left" onclick="location.href='findid.do'">
					Forgot ID</button>

				<button class="btn btn-primary11" type="button"
					style="text-align: right" onclick="location.href='rpdeadb.do'">
					Forgot PW</button>
			</div>
			<p class="mt-5 mb-3 text-body-secondary">&copy; 띳키타카</p>

		</form>

	</main>
</body>
<!-- <video id="bg-video" autoplay loop muted class="bg-video"> -->
<video id="bg-video" autoplay muted class="bg-video" onclick="showLoginForm()">
    <source src="./images/blue.mp4" type="video/mp4">
</video>

<script>
    let bgVideo = document.getElementById('bg-video');
    let frmSign = document.querySelector('.form-signin');
    frmSign.style.display = "none";

    function showLoginForm() {
        bgVideo.style.display = "none";
        frmSign.style.display = "block";
    }
</script>
</html>


