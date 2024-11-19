<%@page import="VO.PaymentVO"%>
<%@page import="VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%


MemberVO mv = (MemberVO) session.getAttribute("LOGIN_USER");
// PaymentVO pv = (PaymentVO) request.getAttribute("pv");
String myStre = (String) session.getAttribute("stre");



%>
<div class="container-fluid">
   <div class="row">
      <aside class="col-sm-3 sidebar fixed-sidebar left-sidebar" style="background-color: #F2F2F2">
          <div class="card blog-section mb-3" style="margin-top:4rem;">
            <div class="card-header" style="background-color: #9AC5F4">
               <h5 class="card-title" style="color: white; font-weight: bold;"><%=mv.getMemName()%>님의 프로필</h5>
            </div>
            <div class="card-body">
            <div class='row'>
            <div class='col-5'>
                  <img id="profileImage" src="/img/<%=myStre %>" alt="Profile Image"
                  class="img-circle" style="width: 100px; height: 100px;  border-radius: 100%; margin-left:20px;"> <input
                  type="file" id="imageInput" style="display: none; " >
            </div>
            <div class='col'>
               <ul class="list-unstyled">
               <h4 style="font-weight: bold; color: #478CCF;"><%=mv.getMemNickname() %></h4>
                  <li class="row" style="font-size:15px;">이메일 : <%=mv.getMemEmail() %></a><span class="text-muted ms-2"></span></li>
                  <li style="font-size:15px;">태그 : @<%=mv.getMemTag() %></a><span class="text-muted ms-2"></span></li>
<!--                   <li><a href="#" style='color:'>Lorem Ipsum is simply dummy context ...</a><span class="text-muted ms-2"></span></li> -->
<%--                   <li><img src="./images/coin.png" style="height: 30px; width: 30px;"> : <%=pv.getCredditQty() %>개<span class="text-muted ms-2"></span></li> --%>
               </ul>
            </div>
            </div>
            </div>
         </div>
         <div class="card following-section mb-3">
            <div class="card-header" style="background-color: #9AC5F4">
               <h5 class="card-title" style="color: white; font-weight: bold;">메뉴</h5>
            </div>
            <div class="card-body">
              <ul class="list-unstyled">
                  <li ><a href="javascript:void(0);" onclick="openCredditWindow();"> <img src="./images/coin.png" alt="코인" class="mr-2" style="width: 30px; height: 30px;">크래띳구매</a></li>
					<li><a href="javascript:void(0);" onclick="openComplainWindow();"> <img src="./images/answer.png" alt="코인" class="mr-2" style="width: 30px; height: 30px;">1:1 문의사항</a></li>
				
                  </ul>
                  </div>
                  </div>
<!--                <div class="following mb-3"> -->
<!--                   <strong>크레딧</strong><br> -->
<!--                   <span>111</span><br> -->
<!--                   <span>222</span><br> -->
<!--                     <button type="button" class="btn btn-primary mt-2"  -->
<%--                       onclick="location.href='<%=request.getContextPath()%>/complain.do?memEmail?=<%=mv.getMemEmail() %>'">문의</button>  --%>
                     
<%--                   <span><a href="#" onclick="window.open('<%=request.getContextPath()%>/complain.do?memEmail?=<%=mv.getMemEmail() %>', 'complain','width=800px, height=1000px'); return false">새창</a></span>  --%>
<!--                </div> -->
<!--                <img src="user3.jpg" alt="User 3" class="img-fluid rounded-circle"> -->
<!--             </div> -->
<!--          </div> -->
<%--          <div class="text-center mt-3">
            <a href="<%=request.getContextPath() %>/logout.do">
               <img alt="logout" src="./images/Logout.png" width="50px">
            </a>
         </div> --%>
      </aside>
   </div>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<!-- Include Bootstrap CSS and JS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script>
function openComplainWindow() {
	var email = '<%=mv.getMemEmail()%>';
	var url= '';
	if(email === "admin"){
		url = '<%=request.getContextPath()%>/comadmin.do';
	} else {
		url = '<%=request.getContextPath()%>/complain.do';
	}
	

    var width = 800;
    var height = 600;
    var left = (screen.width - width) / 2;
    var top = (screen.height - height) / 2;

    var popupWindow = window.open(url, '', 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top);
    if (popupWindow) {
        popupWindow.focus();
    }
}
function openCredditWindow() {
	var url= '<%=request.getContextPath()%>/creddit.do';
	
	

    var width = 800;
    var height = 600;
    var left = (screen.width - width) / 2;
    var top = (screen.height - height) / 2;

    var popupWindow = window.open(url, '', 'width=' + width + ', height=' + height + ', left=' + left + ', top=' + top);
    if (popupWindow) {
        popupWindow.focus();
    }
}
</script>
