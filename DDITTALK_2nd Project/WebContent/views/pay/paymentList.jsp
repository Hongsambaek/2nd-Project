<%@page import="VO.PaymentVO"%>
<%@page import="VO.MemberVO"%>
<%@page import="VO.CredditVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO mv = (MemberVO)session.getAttribute("LOGIN_USER");
	String credit = (String)request.getAttribute("credit");
	int credditMoney = Integer.parseInt(credit)*10;

%>
<%-- <%@include file="/layout/header.jsp" %> --%>
<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/checkout/">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">

<!-- 포트원 결제 -->
    <script src="https://cdn.iamport.kr/v1/iamport.js"></script>
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <!-- iamport.payment.js -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<!-- 포트원 결제 -->


<style>
  
</style>
    
<%--   <link href="<%=request.getContextPath()%>/css/lectureDetail.css" rel="stylesheet"> --%>


<div class="container">
  
  	<h1>결제하기</h1>
    <div class="bg-body-tertiary p-5 rounded">
    	<h2>크래딧</h2>
    	<hr>
	   	<p class="lead">크래딧 항목</p>
	   	<p id="CreNum"><%=credit %> 크래딧</p>

<%-- 	   	 <input type="hidden" id="CreNum" name="CreNum" value="<%=pv.getCredditNum()%>"> --%>
	   	
 	</div>
 	
 	
    <div class="bg-body-tertiary p-5 rounded">
    	<h2>고객 정보</h2>
    	<hr>
	   	<p class="lead">이름</p>
	   	<p id="memNm"><%=mv.getMemName() %></p>
	   	
	   	<p class="lead">이메일</p>
	   	<p id="memEmail"><%=mv.getMemEmail()%></p>
	   	
	   	<p class="lead">전화번호</p>
	   	<p id="memTel"><%=mv.getMemTel()%></p>
	   	
	   	<p class="lead">주소</p>
	   	<p id="memAddr"><%=mv.getMemAddr()%> </p>
	   	
 	</div>
 	<br>
 	<div class="bg-body-tertiary p-5 rounded">
 		
	 	<h2>결제 정보</h2>
	 	<p class="lead">총 결제 금액 : <%=credditMoney %>원 </p>
	 	<input type="hidden" id="credditMoney" name="credditMoney" value="<%=credditMoney %>">
	   	
	   	<div id="createPtModal">
        <div id="ptContent">
          
          <br>
          <button id="savePtModal" style="background: #fee500; color:#000; border-radius: 12px; padding: 10px 20px;">
                        카카오페이 결제하기</button>
        </div>
      </div>
	</div>
</div>

<%-- <%@include file="/layout/footer.jsp" %> --%>

<script src="<%=request.getContextPath() %>/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>


 <script>    
$("#savePtModal").click(function() {       
	  var IMP = window.IMP; // 생략가능        
	  IMP.init('imp66648541');         
	  
	  IMP.request_pay({            
	    pg: 'kakaopay', // version 1.1.0부터 지원.            
	    pay_method: 'card',            
	    merchant_uid: 'merchant_' + new Date().getTime(),            
	    name: 'Creddit',            //결제창에서 보여질 이름            
	    amount: $('#credditMoney').val(),             //가격             
	    buyer_email: $('#memEmail').text(),            
	    buyer_name:  $('#memNm').text(),            
	    buyer_tel: $('#memTel').text(),           
	    buyer_addr:  $('#memAddr').text(),         
	    buyer_postcode: '123-456',            
	    m_redirect_url: '<%=request.getContextPath() %>/mainpage.do'      //페이지갈곳      
	           
	  }, function (rsp) {            
	    console.log(rsp);            
	    if (rsp.success) {     
	      location.href = "<%=request.getContextPath() %>/payinsert.do?memEmail=<%=mv.getMemEmail()%>&credditMoney=<%=credditMoney%>";  // DB저장하는곳 서블릿	
	  	alert("결제 성공했습니다.")
	  	window.close();
	    } else {
			alert("결제 실패했습니다.");
		}                     
	  });
	});


</script> 

