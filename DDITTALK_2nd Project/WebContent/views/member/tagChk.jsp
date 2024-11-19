<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	System.out.println(">>>>>>>>");
	
    String uTag = request.getParameter("tag");
    String TagRegex = "^[a-zA-Z0-9._]{1,30}$";
    if (!uTag.matches(TagRegex)) {
%>
    	{
	    	"rst" : "fail",
	     	"msg": "올바르지 않은 태그 형식입니다."
     	}
<%
    }else{
    	
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   String url = "jdbc:oracle:thin:@112.220.114.130:1521:xe";
	   Connection conn =DriverManager.getConnection(url, "team3_202404M", "java");
	   Statement stmt = conn.createStatement();
	   String sql = "select mem_tag from member where mem_tag = '" + uTag + "'";
	   ResultSet rs = stmt.executeQuery(sql);
	   
	   if(rs.next()){
	      // id가 존재하므로 사용 불가
	%>
	      {"rst" : "fail",
	       "msg": "중복된 태그입니다."}
	<%
	   }else{
	      // 사용가능
	%>
	      {"rst" : "ok",
	       "msg": "사용가능한 태그입니다."}
	<%
	   }
	   rs.close();
	   stmt.close();
	   conn.close();
    }	  
%>