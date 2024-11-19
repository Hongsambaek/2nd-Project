<%@page import="VO.ComplainVO"%>
<%@page import="VO.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<% 
	MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");

	ComplainVO cv = (ComplainVO) request.getAttribute("cv");
// 	String msg = session.getAttribute("msg") == null ? "" 
// 			: (String)session.getAttribute("msg");
	
// 	session.removeAttribute("msg");
%>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<title>Document</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/css.css">
   <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            padding: 20px;
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
        }
        form {
            width: 80%;
            margin: 0 auto;
            border: 1px solid #ccc;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        input[type="text"], textarea, select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        textarea {
            height: 150px;
        }
        #mail {
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            background-color: #f9f9f9;
        }
        .buttons {
            text-align: center;
        }
        .buttons button {
            padding: 10px 20px;
            margin: 0 10px;
            border: none;
            background-color: #007bff;
            color: white;
            cursor: pointer;
            border-radius: 4px;
        }
        .buttons button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<h2>문의하기</h2>
<form action="<%=request.getContextPath() %>/cominsert.do" method="POST" enctype="multipart/form-data">
    <label for="email">ID</label>
    <div id="mail"><%=mv.getMemEmail() %></div>

    <label for="title">제목</label>
    <input type="text" name="comTitle" required>

    <label for="subject">내용</label>
    <input type="text" name="comContent" required>

    <label for="menu">유형</label>
    <select id="menu" name="comMenu" required>
        <option value="지원요청">지원요청</option>
        <option value="계정관련신고">계정관련신고</option>
        <option value="문제신고">문제신고</option>
        <option value="Creddit 관련신고">Creddit 관련신고</option>
    </select>

    <div class="buttons">
        <button type="submit">제출하기</button>
        <button type="button" onclick="history.back()">취소</button>
    </div>
</form>

</body>
</html>
      
