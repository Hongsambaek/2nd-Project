<%-- <%@page import="com.itextpdf.text.log.SysoCounter"%> --%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="VO.FriendVO"%>
<%@page import="VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%
	MemberVO mv3 = (MemberVO) session.getAttribute("LOGIN_USER");
	String memList = (String) session.getAttribute("MEMBER_LIST");
%>
<style>
.feed-container {
  max-height: 200px; /* 원하는 높이로 조정 */
  overflow-y: auto;
}

.feed-container .feed-item {
  display: none;
}

.feed-container .feed-item:nth-child(-n+5) {
  display: block;
}


#chatHeader {
   height: 50px;
   background-color: #9AC5F4;
   display: flex;
   justify-content: center;
   align-items: center;
   color: white;
   font-weight: bold;
   font-size: 18px;
   margin-bottom: 10px;
   border-radius: 10px;
   margin-left: 0;
   margin-right: 0;
}
.chat_ib p {
/*   width: 50px; */
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
</style>

<aside class="col-sm-3 sidebar fixed-sidebar right-sidebar col" style="background-color: #F2F2F2">
   <div class="card profile-completion mb-3" style="margin-top: 4rem;">
      <div class="card-header" style="align-items: center; display: flex; background-color: #9AC5F4; color: white;">
         <h5 class="card-title" style="margin-top: 10px; font-weight: bold;">친구목록</h5>
         <button class="btn btn-primary d-inline-flex float-end btn-sm"
            id="match_vld_num"
            style="position: absolute; right: 13px; margin-top: auto; background-color: #478CCF; border-color: #478CCF; font-weight: bold;"
            data-bs-toggle="modal" data-bs-target="#frdManagementModal">친구목록 관리</button>
      </div>

      <div class="card-body">
         <div class="feed-container mb-3" id="friendList"> </div>

      </div>
      <div class="card-body"></div>

   </div>


  <div id="container1" class="active"> 
	  <div id="chatHeader">채팅</div>

</div>
<!-- 1:1 메시지창 -->
<div id="container2">
	<div id="pheader">
		<button type="button" id="backButton" style="border: 0px;">
			<img src="<%=request.getContextPath()%>/images/whiteTriangle.png" style="width:30px;height:30px;"/>
		</button>
		<div id="headerEmail">test 1</div>
	</div>
	<div id="msgBox"></div>
	<div id="send">
		<input type="text" class="post1" name="msgContent" placeholder="Send your message.." />
		<button type="button" id="btn2">Send</button>     
	</div>
</div>
   
   
</aside>
<div class="modal fade" id="frdManagementModal" tabindex="-1"
   aria-labelledby="frdManagementModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header" style="color:white; background-color: #9AC5F4; font-weight: bold;">
            <h5 class="modal-title" id="frdManagementModalLabel"style="font-weight: bold;">친구목록 관리</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal"
               aria-label="Close"></button>
         </div>
         
         
         
         <div class="modal-body">
         	<div class="row">
                <div class="col-md-9">
                	<input class="form-control" type="text" name="memTag" id="pTags" placeholder="Search member..." >
                </div>
                <div class="col-md-3">
					<button class="btn btn-primary d-inline-flex float-end btn-md d-flex justify-content-center align-items-center" 
        style="width:100px; position: absolute; right: 13px; margin-top: auto; background-color: #478CCF; border-color: #478CCF; font-weight: bold;" 
        type="button" id="btn10">찾기</button>
                </div>
         	</div>
			<div id="searchFndList"> </div>    
         </div>
      </div>
   </div>
</div>

<!-- Include Bootstrap CSS and JS -->
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
   rel="stylesheet">

<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="script.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>




function enterKey(event) {	
	if (event.keyCode == 13) {
		getFnd();
	}
}

$('#pTags').on('keyup', enterKey);


$('#btn10').on('click',function(){
	getFnd();
});

$('#searchFndList').on('click','#memTagList',function(){
	
	var memTag2 = $(this).data('memtag');
	var memEmail2 = $(this).data('mememail');
	console.log('memTag2 --> ', memTag2, 'memEmail2 --> ', memEmail2);
	$.ajax({
		type: 'post',
		url: '<%=request.getContextPath()%>/insertfnd.do',
		data: {
			memTag2 : memTag2,
			memEmail2 : memEmail2,
		} 
	});
	
});



function getFnd() {
    var memTag = $('#pTags').val();
    $('#searchFndList').empty();
    $.ajax({
        type: 'get',
        url: '<%=request.getContextPath()%>/memtagsearch.do',
        data: {
            memTag: memTag,
        },
        success: function(mem) {
            console.log('mem --> ', mem);
            if (mem.length == 0) {

            } else {
                for (let i = 0; i < mem.length; i++) {
                    var $memTagList = $('<div id="memTagList" data-memtag="' + mem[i].memTag + '" data-mememail="' + mem[i].memEmail + '">' + mem[i].memName + ', ' + mem[i].memTag + ', ' + mem[i].memProfile + '</div>');
                    var $sendTagBtn = $('<button class="btn btn-primary d-inline-flex float-end btn-xs d-flex justify-content-center align-items-center" style="width:auto; position: absolute; right: 15px; font-size: 12px; margin-top: 2px; background-color: #478CCF; border-color: #478CCF;" type="button" id="sendTagBtn">추가</button>');
                    $sendTagBtn.click(function() {
                        alert("친구요청을 보냈습니다.");
                    });
                    $memTagList.append($sendTagBtn);
                    $('#searchFndList').append($memTagList);
                }
            }
        }
    });
}




$(document).ready(function() {
   let member_json = JSON.parse('<%=memList %>');
   let my_email = '<%=mv3.getMemEmail()%>';
   let my_tag = '<%=mv3.getMemTag()%>';
   $.ajax({
      type:'get',
      url:'<%=request.getContextPath()%>/friendlist.do',
         data : {
            'memEmail' : my_email,
         },
         success : function(res) {
			console.log(res);
			let friend_list = res.friendList;
			let file_list = res.fileList;
        	displayFriendList(friend_list, file_list);
         },
         error : function(xhr) {
            console.log(xhr);
         },
         dataType : 'json'
			
      });
   
	let friend_tag;
	let friend_div;
		function displayFriendList(friend_list, file_list) {
	   		console.log(friend_list, " + ", file_list);
			for(let i = 0; i < friend_list.length; i++) {
				for(let j = 0; j < member_json.length; j++) {
					if(friend_list[i].memEmail2 == member_json[j].memEmail) {
						friend_tag = member_json[j].memTag;
						for(let l = 0; l < file_list.length; l++) {
							if(file_list[l].atchFileId == member_json[j].memProfile) {
								friend_div ="<div class='badge d-flex align-items-center p-1 pe-2 text-primary-emphasis bg-primary-subtle rounded-pill' id='friend-list-"+i+"' style='color:purple'>"+
												"<img src='/img/" + file_list[l].streFileNm + "'>@" + friend_tag + 
												"</div>";
							} else {
								friend_div ="<div class='friend-list' id='friend-list-"+i+"' style='color:purple'>@" + friend_tag + "</div>";
							}
						}
						document.querySelector('#friendList').insertAdjacentHTML("beforeend", friend_div);
					} 
				}
			}
		}
   });
   
   
   
   
   $(document).ready(function() {
		container1();
		function container1() {
			$.ajax({
				type: 'get',
				url: '<%=request.getContextPath()%>/msg/mem.do',
				success: function(jsonMem){
					if (jsonMem.length === 0) {
						$('#container1').append('<div> NobodyKnows..</div>');
					} else {
						for (let i = 0; i < jsonMem.length; i++) {
							$('#container1').append(
									  '<div class="chat_list">' +
			                            '<div class="chat_people">' +
			                                '<div class="chat_img">' +
			                                    '<img src="<%=request.getContextPath()%>/images/person.png" alt="Profile" >' +
			                                '</div>' +
			                                '<div class="chat_ib" data-email="' + jsonMem[i].email + '" data-name="' + jsonMem[i].name + '">' +
			                                    '<h5>' + jsonMem[i].name + ' <span class="chat_date">' + jsonMem[i].date + '</span></h5>' +
			                                    '<p>' + jsonMem[i].content + '</p>' +
			                                '</div>' +
			                            '</div>' +
			                        '</div>'
							);
						}
					}
				},
				error: function(xhr, status, error) {
					console.error('Error fetching container1 data:', error);
				}
			});
		}
		
		
		var header = $('#container1 #chatHeader');
		var lastDate = '';
		var currentEmail = '';
		
//	 	var LastMsgDate = '';
		// 친구를 클릭했을 때 바로 메시지를 가져옴
		$('#container1').on('click', '.chat_ib', function() {
			
			$('#msgBox').empty();
	        var email = $(this).data('email');
	        var name = $(this).data('name');
	        
	   
			
			currentEmail = email; // 전역 변수에 저장
			
			// #header의 내용을 업데이트
			$('#headerEmail').text(name);
		
			
			showContainer2(); // container2로 전환
			fetchMessages(); // 친구를 클릭했을 때 즉시 메시지를 가져옴

		});

		// 일정 간격으로 메시지 가져오기
		setInterval(function() {
			if (currentEmail !== '' && $('#container2').hasClass('active')) {
				fetchMessages();
			}
		}, 2000); // 2초마다 실행
		
		
		
		
		
		function fetchMessages() {
			if (!$('#container2').hasClass('active')) return;
		
			$.ajax({
				type: 'get',
				url: '<%=request.getContextPath() %>/msg/receiver.do', 
				data: { 
					memEmail2: currentEmail,
					lastDate : lastDate,
				
				},
				
				success: function(jsonData) {
					console.log('memEmail2 :', currentEmail);
					console.log('json response:', jsonData);
					
//	 				$('#msgBox').empty(); // 이전 메시지 초기화
					if (jsonData.length == 0) {
//	 					$('#msgBox').append("<div class='first'> 새로운 채팅을 시작해보세요! </div>");
					} else {
						for (let i = 0; i < jsonData.length; i++) {
							
							if (jsonData[i].memEmail === currentEmail) { // myEmail = memEmail, email = memEmail2 임.                        
								$('#msgBox').append("<div class='tttt'>" + jsonData[i].msgContent + "</div>");
							console.log(1);
							} else {
								$('#msgBox').append("<div id='tttt'>" + jsonData[i].msgContent + "</div>");
							console.log(2);
							}
							
						}
						
						const date = jsonData[jsonData.length - 1].msgDate.date;
						const time = jsonData[jsonData.length - 1].msgDate.time;
						
						console.log('date', date);
						console.log('time', time);
						
						console.log(date.year + '@' + date.month + '@' +date.day + '@' + time.hour + '@' + time.minute + '@' + time.second);
						lastDate = date.year + '@' + date.month + '@' +date.day + '@' + time.hour + '@' + time.minute + '@' + time.second;
						console.log('lastDate >> ',lastDate);
						$('#msgBox').scrollTop($('#msgBox')[0].scrollHeight);
					}
				},
				error: function(xhr, status, error) {
					console.error('Error fetching messages:', error);
				}
			});
		}

		// 컨테이너 전환 함수
		function showContainer1() {
			$('#container1').addClass('active');
			$('#container2').removeClass('active');
		}

		function showContainer2() {
			$('#container1').removeClass('active');
			$('#container2').addClass('active');
		}

		// 엔터로 데이터 전송 function
		function enterKey(event) {
			if (event.keyCode == 13) {
				sendMsg();
			}
		}

		$('.post1').on('keyup', enterKey);

		$('#btn2').click(function() {
			sendMsg();
		});

		function sendMsg() {  
			var msgContent = $('.post1').val();
			if (msgContent.trim() === '') {
				return; // 빈 메시지는 보내지 않음
			}

			if (!$('#container2').hasClass('active')) return;

			$.ajax({
				type: "post",
				url: "<%=request.getContextPath() %>/msg/receiver.do",
				data: {
					msgContent: msgContent,
					memEmail2: currentEmail
				},
				dataType: 'json',
				success: function(result) {
					$('.post1').val('');
					console.log('Message sent successfully:', result);

					// 새로운 메시지를 #msgBox에 추가
//	 				$('#msgBox').append("<div class='tttt'>" + msgContent + "</div>");
					$('#msgBox').scrollTop($('#msgBox')[0].scrollHeight);
					fetchMessages(); // 메시지 보내기 후 최신 메시지 가져오기
				},
				error: function(xhr, status, error) {
					console.error('Error sending message:', error);
				}
			});
		}

		$('#backButton').click(function() {
			 lastDate = '';
			
			 
			 $('#container1').empty().append(header);
			showContainer1(); // container1으로 전환
			container1(); // container1 호출
		}); 


	});
   
   
</script>
