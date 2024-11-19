<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<title>모두의 띳톡!</title>
<style>
body {
	display: flex;
	flex-direction: column;
	min-height: 100vh;
	margin: 0;
}

footer {
	background-color: #f5f5f5;
	font-weight: bold;
	font-size: 10pt;
	padding: 20px 0;
	text-align: center;
	margin-top: auto;
}

a {
	text-decoration: none;
}

img {
	height: 80px;
	width: 80px;
}

body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	padding-top: 50px;
}

.navbar-brand img {
	margin-right: 30px;
	height: 50px;
	width: 50px;
}

.navbar-brand1 img {
	margin-right: 30px;
	height: 30px;
	width: 30px;
}

.navbar {
	display: flex;
	align-items: center;
	justify-content: space-between;
	position: fixed;
	height: 100px;
	top: 0;
	left: 0;
	right: 0;
	background-color: white;
	z-index: 1000;
}

.navbar-header {
	display: flex;
	align-items: center;
	height: 100px;
}

.navbar-center {
	flex-grow: 1;
	display: flex;
	justify-content: center;
}

.navbar-form {
	display: flex;
	align-items: center;
}

.navbar-nav {
	display: flex;
	align-items: center;
	list-style: none;
	margin: 0;
	padding: 0;
}

.navbar-nav>li {
	margin-left: 10px;
}

.navbar-nav .btn {
	margin: 0;
}

.fixed-sidebar {
	position: fixed;
	top: 50px;
	bottom: 0;
	overflow-y: auto;
	width: 25%;
	padding-right: 15px;
}

.left-sidebar {
	left: 0;
}

.right-sidebar {
	right: 0;
}

.activity-feed {
	margin-top: 70px;
	margin-left: 25%;
	margin-right: 25%;
}

.following img, .active-members img {
	width: 40px;
	height: 40px;
	margin-right: 10px;
}

.activity-feed .post-box {
	margin-bottom: 20px;
}

.activity-feed .post {
	margin-bottom: 20px;
}

.profile-info .panel {
	margin-bottom: 20px;
}

.profile-completion .progress {
	margin-bottom: 10px;
}

@media ( max-width : 767px) {
	.fixed-sidebar {
		position: relative;
		top: auto;
		bottom: auto;
		overflow-y: visible;
		width: 100%;
		padding-right: 0;
	}
	.activity-feed {
		margin: 0;
	}
	.navbar-center {
		flex-grow: 0;
		width: 100%;
	}
	.navbar-form {
		width: 100%;
	}
}

* {
	box-sizing: border-box;
}

#toggle-bookmark {
	display: inline-flex;
	float: right;
	margin-top: 10px;
}

label {
	display: inline-flex;
	align-items: center;
	gap: 0.5rem;
	cursor: pointer;
}

.form-feed-insert {
	background: white;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.form-feed-insert .mb-3 {
	margin-bottom: 1.5rem;
}

#dispp1 {
	background-color: #e9ecef;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 1.2rem;
	color: #6c757d;
	height: 400px;
}

.feed-insert-radio {
	margin-bottom: 1rem;
}

.feed-insert-radio label {
	
}

.feed-insert-btn {
	text-align: center;
	margin-top: 20px;
}

.feed-insert-btn button {
	padding: 10px 20px;
	font-size: 1rem;
}

#feed-content-none {
	color: rgb(226, 226, 226);
	width: 100%;
	text-align: center;
}

#feed-content-h4 {
	display: flex;
}

[type="checkbox"] {
	appearance: none;
	position: relative;
	border: max(2px, 0.1em) solid gray;
	border-radius: 1.25em;
	width: 2.25em;
	height: 1.25em;
}

[type="checkbox"]::before {
	content: "";
	position: absolute;
	left: 0;
	width: 1em;
	height: 1em;
	border-radius: 50%;
	transform: scale(0.8);
	background-color: gray;
	transition: left 250ms linear;
}

[type="checkbox"]:checked {
	background-color: tomato;
	border-color: tomato;
}

[type="checkbox"]:checked::before {
	background-color: white;
	left: 1em;
}

[type="checkbox"]:disabled {
	border-color: lightgray;
	opacity: 0.7;
	cursor: not-allowed;
}

[type="checkbox"]:disabled:before {
	background-color: lightgray;
}

[type="checkbox"]:disabled+span {
	opacity: 0.7;
	cursor: not-allowed;
}

[type="checkbox"]:focus-visible {
	outline-offset: max(2px, 0.1em);
	outline: max(2px, 0.1em) solid tomato;
}

[type="checkbox"]:enabled:hover {
	box-shadow: 0 0 0 max(4px, 0.2em) lightgray;
}

------


 


pbj --------
.chat_people {
	overflow: hidden;
	clear: both;
}

.chat_list {
	border-bottom: 1px solid #c4c4c4;
	margin: 0;
	padding: 18px 16px 10px;
}

.chat_ib {
	cursor: pointer;
}

.chat_img {
	float: left;
	width: 11%;
	margin-right: 25px;
}

.chat_img img {
	border-radius: 50%;
	width: 40px;
	height: 40px;
}

.chat_ib h5 {
	font-size: 15px;
	color: #464646;
	margin: 0 0 8px 0;
}

.chat_ib h5 span {
	font-size: 13px;
	float: right;
}

.chat_ib p {
	font-size: 14px;
	color: #989898;
	margin: auto;
}

/* 위에건 테스트  */
#pheader {
	background-color: #6495ED;
	height: 70px;
	color: white;
	display: flex;
	align-items: center;
	font-size: 20px;
	font-weight: bold;
}

#pheader button {
	background: none;
	border: none;
	margin-right: 10px;
}

#msgBox {
	flex: 1;
	background-color: white;
	overflow-y: auto;
	padding: 10px;
	display: flex;
	flex-direction: column;
	gap: 10px;
}

#send {
	background-color: white;
	height: 70px;
	display: flex;
	align-items: center;
	padding: 10px;
}

#send input {
	flex: 1;
	padding: 10px;
	font-size: 12px;
	border: 1px solid #ddd;
	border-radius: 5px;
	margin-right: 10px;
	background-color: #f1f1f1;
}

#send button {
	background-color: #6495ED;
	color: white;
	border: none;
	padding: 10px 20px;
	margin: 0 10px 0 0;
	font-size: 12px;
	border-radius: 5px;
	cursor: pointer;
}

#send button:hover {
	background-color: #6495ED;
}

#tttt {
	text-align: right;
	color: white;
	background-color: #6495ED;
	padding: 10px;
	border-radius: 10px;
	align-self: flex-end;
	max-width: 80%;
	margin-bottom: 10px;
}

.tttt {
	text-align: left;
	color: black;
	background-color: #f1f1f1;
	padding: 10px;
	border-radius: 10px;
	align-self: flex-start;
	max-width: 80%;
	border: 1px solid #ddd;
	margin-bottom: 10px;
}

.first {
	text-align: center;
	color: #777;
	font-style: italic;
}

#container1, #container2 {
	display: flex;
	flex-direction: column;
	height: 400px;
	width: 300px;
	position: fixed;
	bottom: 40px;
	right: 40px;
	z-index: 1;
	border-radius: 10px !important;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	background-color: white;
}

#container1 {
	padding: 10px;
	overflow-y: auto;
}

.message {
	display: flex;
	flex-direction: column;
	border-bottom: 1px solid #ddd;
	padding: 10px;
	align-items: center;
	background-color: #e8f5e9;
	margin-bottom: 10px;
	border-radius: 10px;
}

.message:last-child {
	border-bottom: none;
}

.message img {
	border-radius: 50%;
	width: 50px;
	height: 50px;
	margin-bottom: 10px;
}

.message-content {
	display: flex;
	flex-direction: column;
	width: 100%;
	text-align: right;
	cursor: pointer;
}

.message-content .msg-email {
	font-weight: bold;
	margin-bottom: 5px;
	color: #388e3c;
	text-align: center;
}

.message-content .msg-content {
	color: #2e7d32;
}

.message-content .msg-date {
	font-size: 0.85em;
	color: #616161;
	text-align: right;
	margin-top: 5px;
}

#container1, #container2 {
	display: none;
}

#container1.active, #container2.active {
	display: flex;
}

/* ---- pbj 건드는중 ----- */
#header-logo {
	font-size: 5em;
	animation: motion 0.3s /* 속도 */
               linear 0s /* 처음부터 끝까지 일정 속도로 진행 */
               infinite alternate; /* 무한 반복 */
}

@
keyframes motion { 0% {
	margin-top: 0px;
} /* 처음 위치 */
100




%
{
margin-top




:




10px


;
} /* 마지막 위치 */
}
</style>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />
</head>
<header class="fixed-top">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid" style="background-color: #9AC5F4">
			<div class="navbar-header">
				<a class="navbar-brand"
					href="<%=request.getContextPath()%>/mainpage.do"> <img
					id="header-logo" alt="DDITTALK Logo"
					src="<%=request.getContextPath()%>/images/Logo.png">
				</a>
				<div>
					<strong style="margin-right: 400px; color: white;">
						DDITTALK </strong>
				</div>
			</div>
			<div class="navbar-center">
				<div class="input-group">
					<input class="form-control" type="search" name="tag" id="tag"
						placeholder="검색" style="background-color: white;">
					<button class="btn btn-outline-success" id="search-btn"
						style="color: white; border-color: white; color: white; font-weight: bold;">검색</button>

				</div>
			</div>
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<!--             <li class="nav-item"> -->
				<!--                 <button type="button" class="btn btn-outline-info" id="feed-write" data-bs-toggle="modal" -->
				<!--                data-bs-target="#feedRegistrationModal">글쓰기</button> -->
				<!--             </li>         -->
				<!--             <li class="nav-item"> -->
				<!--                 <button type="button" class="btn btn-outline-info" id="msg-list">대화목록</button> -->
				<!--             </li> -->
				<!--             <li class="nav-item"> -->
				<!--                 <button type="button" class="btn btn-outline-info" id="friend-search">친구찾기</button> -->
				<!--             </li> -->
				<!--             <li class="nav-item"> -->
				<!--                 <button type="button" class="btn btn-outline-info" id="profile-update">프로필수정</button> -->
				<!--             </li> -->
				<li class="nav-item"><a class="navbar-brand1"
					data-bs-toggle="modal" data-bs-target="#feedRegistrationModal"
					style="margin-left: 300px;"> <img alt="insert"
						src="<%=request.getContextPath()%>/images/플러스.png">
				</a></li>
				<!--             <li class="nav-item"><a class="navbar-brand1" href="#"> <img -->
				<%--                   alt="talk" src="<%=request.getContextPath()%>/images/talk.png"> --%>
				<!--             </a></li> -->
				<li class="nav-item"><a class="navbar-brand1"
					data-bs-toggle="modal" data-bs-target="#acceptListModal"
					> <img alt="like"
						src="<%=request.getContextPath()%>/images/하트.png"
						style="color: #050C9C">
				</a></li>
				<li class="nav-item"><a class="navbar-brand1"
					href="<%=request.getContextPath()%>/myinformation.do"> <img
						alt="profile" src="<%=request.getContextPath()%>/images/사람.png">
				</a></li>
				<li class="nav-item"><a class="navbar-brand1"
					href="<%=request.getContextPath()%>/logout.do"> <img
						alt="logout" src="<%=request.getContextPath()%>/images/종료버튼.png">
				</a></li>
			</ul>
		</div>
	</nav>
</header>
<script src="../views/feed/mainfeeder.jsp"></script>