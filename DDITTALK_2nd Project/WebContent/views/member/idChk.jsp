<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	System.out.println(">>>>>>>>");
	
    String uId = request.getParameter("email");
//     String emailRegex = "/^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$/";
    String emailRegex = "[0-9a-zA-Z]+@[0-9a-zA-Z]+(\\.[a-z]+){1,2}";
    if (!uId.matches(emailRegex)) {
%>
    	{
	    	"rst" : "fail",
	     	"msg": "유효하지 않은 이메일 형식입니다."
     	}
<%
    }else{
    	
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   String url = "jdbc:oracle:thin:@112.220.114.130:1521:xe";
	   Connection conn =DriverManager.getConnection(url, "team3_202404M", "java");
	   Statement stmt = conn.createStatement();
	   String sql = "select mem_email from member where mem_email = '" + uId + "'";
	   ResultSet rs = stmt.executeQuery(sql);
	   
	   if(rs.next()){
	      // id가 존재하므로 사용 불가
	%>
	      {"rst" : "fail",
	       "msg": "중복된 이메일입니다."}
	<%
	   }else{
	      // 사용가능
	%>
	      {"rst" : "ok",
	       "msg": "사용가능한 이메일입니다."}
	<%
	   }
	   rs.close();
	   stmt.close();
	   conn.close();
    }	  
%>