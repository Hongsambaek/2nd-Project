<%@page import="VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
MemberVO mv1 = (MemberVO) session.getAttribute("LOGIN_USER");

%>
<div class="container-fluid">
   <div class="row">
      <aside class="col-sm-3 sidebar fixed-sidebar left-sidebar">
      </aside>
   </div>
</div>

<!-- Include Bootstrap CSS and JS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
