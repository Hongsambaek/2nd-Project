<%@page import="VO.FriendVO"%>
<%@page import="VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MemberVO mv20120 = (MemberVO) session.getAttribute("LOGIN_USER");
%>

<div class="container">
	<form class="form-feed-insert" method="post" onsubmit="valid(event)"
		enctype="multipart/form-data"
		action="<%=request.getContextPath()%>/insertfnd.do">
		<div class="card-body">
			<div class="feed-container mb-3" id="friendListDetail"></div>

		</div>
	</form>
</div>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="script.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>

$(document).ready(function() {
   
   let my_email = '<%=mv20120.getMemEmail()%>';
   let my_tag = '<%=mv20120.getMemTag()%>';
   $.ajax({
      type:'get',
      url:'<%=request.getContextPath()%>/friendlist.do',
			data : {
				'memEmail' : my_email,
			},
			success : function(res) {
				console.log(res);
				displayFriendList(res);
			},
			error : function(xhr) {
				alert(" err><<" + xhr.status);
			},
			dataType : 'json'

		});

	});

	function displayFriendList(friendListDetail) {
		var friendListElement = $('#friendListDetail');
		friendListElement.empty();

		$.each(friendListDetail, function(index, friend) {
			var friendElement = $('<div>').text(friend.memEmail2);
			friendListElement.append(friendElement);
		});
	}
</script>