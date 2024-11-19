
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<div id="container1" class="active"> 


</div>
<!-- 1:1 메시지창 -->
<div id="container2">
	<div id="pheader">
		<button type="button" id="backButton" style="border: 0px;">
			<img src="<%=request.getContextPath()%>/images/back.png" style="width:30px;height:30px;"/>
		</button>
		<div id="headerEmail">test 1</div>
	</div>
	<div id="msgBox"></div>
	<div id="send">
		<input type="text" class="post1" name="msgContent" placeholder="Send your message.." />
		<button type="button" id="btn2">Send</button>     
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
$(document).ready(function() {
	container1();
	function container1() {
		$.ajax({
			type: 'get',
			url: '<%=request.getContextPath()%>/msg/mem.do',
			
			success: function(jsonMem){
				if (jsonMem.length === 0) {
// 					$('#container1').append('<div> NobodyKnows..</div>');
				} else {
					 $('#container1').empty();
					for (let i = 0; i < jsonMem.length; i++) {
						$('#container1').append(
								  '<div class="chat_list">' +
		                            '<div class="chat_people">' +
		                                '<div class="chat_img">' +
		                                    '<img src="<%=request.getContextPath()%>/images/Loop.jpg" alt="Profile" >' +
		                                '</div>' +
		                                '<div class="chat_ib" data-email="' + jsonMem[i].email + '" data-name="' + jsonMem[i].name + '">' +
		                                    '<h5>' + jsonMem[i].name + ' <span class="chat_date">' + jsonMem[i].date + '</span></h5>' +
		                                    '<p>' + jsonMem[i].content + '</p>' +
		                                '</div>' +
		                            '</div>' +
		                        '</div>'
						);
					}
					
					console.log('lastDate >> ',lastDate);
					console.log('new Message arrived ');
				}
			},
			error: function(xhr, status, error) {
				console.error('Error fetching container1 data:', error);
			}
		});
	}
	
	
	
	var lastDate = '';
	var currentEmail = '';
	
// 	var LastMsgDate = '';
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
	
// 	setInterval(function() {
// 		if ($('#container1').hasClass('active')) {
// 			container1();
// 		}
// 	}, 2000); //
	
	
	
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
				
// 				$('#msgBox').empty(); // 이전 메시지 초기화
				if (jsonData.length == 0) {
// 					$('#msgBox').append("<div class='first'> 새로운 채팅을 시작해보세요! </div>");
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
					container1();
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
// 				$('#msgBox').append("<div class='tttt'>" + msgContent + "</div>");
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
		
		 $('#container1').empty();
		showContainer1(); // container1으로 전환
		container1(); // container1 호출
	}); 


});
</script>
