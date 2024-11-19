<%@page import="VO.ComplainVO"%>
<%@page import="VO.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<% 
	List<ComplainVO> comList = (List<ComplainVO>)request.getAttribute("comList"); 

// 	String msg = session.getAttribute("msg") == null ? "" 
// 			: (String)session.getAttribute("msg");
	
// 	session.removeAttribute("msg");

	MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");

%>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 문의내역</title>
    <style>
          body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            padding: 20px;
        }
        #comHead {
            color: #777;
            margin-bottom: 10px;
        }
        h2#comHead {
            color: #333;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f9f9f9;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        .pagination {
            text-align: center;
            margin-top: 20px;
        }
        .pagination a {
            margin: 0 5px;
            padding: 10px 20px;
            border: 1px solid #ccc;
            background-color: #f9f9f9;
            text-decoration: none;
            color: #333;
        }
        .pagination a:hover {
            background-color: #ddd;
        }
        .buttons {
            text-align: center;
            margin-top: 20px;
        }
        .buttons button {
            padding: 10px 20px;
            margin: 0 10px;
            border: none;
            background-color: #007bff;
            color: white;
            cursor: pointer;
        }
        .buttons button:hover {
            background-color: #0056b3;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<h2 id="comHead">문의 관리</h2>
	<form method="get" action="<%= request.getContextPath() %>/comadmin.do">
        <label for="memEmail">이메일로 검색:</label>
        <input type="text" id="memEmail" name="memEmail" placeholder="find complains..">
        <button type="submit">검색</button>
    </form>



<%
	int comSize = comList != null ? comList.size() : 0;    int itemsPerPage = 10;
    int pageCount = (int) Math.ceil((double) comSize / itemsPerPage);
    int currentPage = 1;
    if (request.getParameter("page") != null) {
        currentPage = Integer.parseInt(request.getParameter("page"));
    }
    int startIndex = (currentPage - 1) * itemsPerPage;
    int endIndex = Math.min(startIndex + itemsPerPage, comSize);
%>

<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>이메일</th>
        <th>날짜</th>
        <th>처리상태</th>
    </tr>
    <%
        if (comSize > 0) {
            for (int i = startIndex; i < endIndex; i++) {
                ComplainVO cv = comList.get(i);
    %> 
    <tr>
        <td><%= i + 1 %></td>
        <td><a href="<%= request.getContextPath() %>/comdetail.do?comNum=<%= cv.getComNum() %>"><%= cv.getComTitle() %></a></td>
        <td><%=cv.getMemEmail() %></td>
        <td><%= cv.getComDate() %></td>
        <td>
            <%
                if (cv.getComDyn().equals("N")) {
                    out.print("처리중");
                } else {
                    out.print("상담완료");
                }
            %>
        </td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="5">문의내용이 존재하지 않습니다.</td>
    </tr>
    <%
        }
    %>
</table>

<div class="pagination">
    <%
        for (int i = 1; i <= pageCount; i++) {
            if (i == currentPage) {
    %>
        <a href="?page=<%= i %>" style="font-weight: bold;"><%= i %></a>
    <%
            } else {
    %>
        <a href="?page=<%= i %>"><%= i %></a>
    <%
            }
        }
    %>
</div>


</body>
</html>