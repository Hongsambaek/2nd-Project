<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	System.out.println(">>>>>>>>");
	
    String uPass = request.getParameter("pass");
    String passRegex = "^(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    if (!uPass.matches(passRegex)) {
%>
		{ "rst" : "fail", "msg": "불가능한 비밀번호입니다." }
<%
	}else{
    	%>

		{"rst" : "ok", "msg": "사용가능한 비밀번호입니다."}
<%
	}
%>