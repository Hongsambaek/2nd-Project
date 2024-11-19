<%@page import="VO.MemberVO"%>
<%@page import="VO.MessageVO"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%

   List<MessageVO> msgList = (List<MessageVO>)request.getAttribute("msgList"); 
%>   
	<div id="container">
	
	<div id="header">
			<button type="button" onclick="alert('클릭!')" style="border: 0px;">
  				<img src="<%=request.getContextPath()%>/images/back.png" style="width:30px;height:30px;"/>
			</button>
			<div> test ,..</div>

   		</div>
   		<div id="msgBox">
      		
    	</div>
    	<div id="send">
			<input type="text" class="post1" name="msgContent" placeholder="Send your message.." />
   			<button type="button" id="btn2">Send</button>		
    	</div>
    </div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

$(function(){
   getMsg();
	//엔터로 데이터전송 function
	function enterKey(event){
		if(event.keyCode == 13){
			sendMsg();
		}
	}
	$('.post1').on('keyup', enterKey);
	
	
	
	function getMsg(){
      $.ajax({
              type: 'get',
              url: '<%=request.getContextPath() %>/msg/receiver.do',       
              dataType: 'json',
              success: function(jsonData) {
                 console.log('jsonData:', jsonData);
                 if(jsonData.length == 0){
                    $('#msgBox').append("<div class='first'> 새로운 채팅을 시작해보세요! </div>");
                 }
                 for(let i = 0; i < jsonData.length; i++){
                    var email = jsonData[i].memEmail; 
                    if(email == <%=request.getParameter("memEmail")%> ) { // "test1"에 request.getParameter("memEmail") 담기                          
                       $('#msgBox').append("<div id='tttt'>" + jsonData[i].msgContent + "</div>");
                    } else {
                       $('#msgBox').append("<div class='tttt'>" + jsonData[i].msgContent + "</div>");
                       } //$('#msgBox').append("<hr>");
                    }
                 $('#msgBox').scrollTop($('#msgBox')[0].scrollHeight);

                 }
              
                 
          });
      
    }

   
   
      $('#btn2').click(function (){
			sendMsg();    	  
       });
	  
    function sendMsg() {  
    	
    	$.ajax({
         type : "post",
         url : "<%=request.getContextPath() %>/msg/sender.do",
         data : {
            msgContent : $('.post1').val()
            
            },
         dataType : 'json',
         success: function(result) {
        	 
        	   $('div').remove('.tttt');
        	   $('div').remove('#tttt');
        	   $('.post1').val('');
               getMsg();

              }
         });
      }
      
    
});  

  

    
</script>
