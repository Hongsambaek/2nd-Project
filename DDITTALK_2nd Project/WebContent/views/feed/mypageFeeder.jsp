<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%
MemberVO mv20022 = (MemberVO) session.getAttribute("LOGIN_USER");

String memberList20000 = (String) session.getAttribute("MEMBER_LIST");

String myStre = (String) session.getAttribute("stre");

System.out.println("jsp\n"+myStre+"\n");

%>

<link href="/css/testCss.css" rel="stylesheet" />


<div class="modal fade" id="editMyPageModal" tabindex="-1"
   aria-labelledby="editMyPageModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header" style="background-color: #9AC5F4;">
            <h5 class="modal-title" id="editMyPageModalLabel" style="color:white; background-color: #9AC5F4; font-weight: bold;">내 정보 수정</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal"
               aria-label="Close"></button>
         </div>
         <div class="modal-body">
            <%@ include file="../../views/member/updateMember.jsp"%>
         </div>
      </div>
   </div>
</div>

<div class="modal fade" id="feed-update-modal" tabindex="-1"
   aria-labelledby="feed-update-modal" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header" style="background-color:#9AC5F4;">
            <h5 class="modal-title" id="feed-update-modal-lable" style="color:white; background-color: #9AC5F4; font-weight: bold;">피드 수정</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal"
               aria-label="Close"></button>
         </div>
         <div class="modal-body">
            <%@ include file="/views/feed/feedUpdate.jsp"%>
         </div>
      </div>
   </div>
</div>

<div class="container d-flex justify-content-center align-items-center"
   style="min-height: 50vh;">
   <div id="my-profile" class="text-center">
      <div class="row content justify-content-center" >
         <div class="col-sm-7" >
            <!-- <div class="d-flex flex-column align-items-center"> -->
            <div class="d-flex flex-column align-items-center" style="margin-top:80px; " >
                  <img id="profileImage" src="/img/<%=myStre %>" alt="Profile Image"
                  class="img-circle" style="width: 140px; height: 140px;  border-radius: 100%;""> <input
                  type="file" id="imageInput" style="display: none; " >
               <div id="profile">
                  <h4 style="font-size: 24px;"><%=mv20022.getMemTag()%></h4>
                  <p style="font-size: 18px;"><%=mv20022.getMemEmail()%></p>
                  <a data-bs-toggle="modal" data-bs-target="#editMyPageModal"></a>
               </div>

            </div>

<div class="d-flex justify-content-center mt-3">
    <label class="btn btn-outline-primary btn-lg mx-2" id="btn-my-list">
        <i class="bi bi-chat-left-text"></i>
    </label>
    <label class="btn btn-outline-primary btn-lg mx-2" id="btn-book-list">
        <i class="bi bi-book-half"></i>
    </label>
    <label class="btn btn-outline-primary btn-lg mx-2" id="btn-book-list" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
        <i class="bi bi-people"></i>
    </label>
</div>
         </div>
      </div>
   </div>
</div>


<div class="container" style="margin-left: 850px;">
   <div id="my-profile"></div>
</div>


<main id="main">
   <div id="feed-container">
      <hr id="profile-feed" style="margin-top:-10px;">
      <h4 style='color:purple; margin-left:30px' id='feed-tag'></h4>
      <section class="section site-portfolio">
         <div class="container">
            <div id="portfolio-grid" class="row no-gutter" data-aos="fade-up"
               data-aos-delay="200"></div>
         </div>
      </section>
   </div>
   <div id="fin-my" ></div>
</main>


<div id="feed-write-modal" class="modal fade" tabindex="-1"
   aria-labelledby="exampleModalLabel" aria-hidden="true">
   <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
         <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Feed Insert</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal"
               aria-label="Close"></button>
         </div>
      </div>
   </div>
</div>

<div class="modal fade" id="feedRegistrationModal" tabindex="-1"
   aria-labelledby="feedRegistrationModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header"style="color:white; background-color: #9AC5F4; font-weight: bold;">
            <h5 class="modal-title" id="feedRegistrationModalLabel" style="color:white; background-color: #9AC5F4; font-weight: bold;">피드 등록</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal"
               aria-label="Close"></button>
         </div>
         <div class="modal-body">
            <%@ include file="/views/feed/feedInsert.jsp"%>
         </div>
      </div>
   </div>
</div>


<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
  <div class="offcanvas-header">
    <h5 class="offcanvas-title" id="offcanvasRightLabel">친구목록</h5>
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>
  <div class="offcanvas-body" id='offcanvas-body'>
  	<!-- 친구가 없니? -->
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
    $(document).ready(function() {

    let friendflag = 0;
    	
    let memberListString = '<%=memberList20000 %>';
    let memberJson = JSON.parse(memberListString);
    let my_email = '<%=mv20022.getMemEmail() %>';
    
    let feed_json;
    let file_json;
    let comment_json;
    let all_like_json;
    let like_sum_json;
    let book_mark_json;
    
    let curCnt = 0;
    let loading = false;
    let booking = false;
    let mine = true;
    let friend = false;
    let AandD = true;

    let io = new IntersectionObserver(function(entries) {
		console.log('내가 보여?');

		if (entries[0].isIntersecting ) {
			if (booking) {
				curCnt = 0;
		        formData = {'start': start, 'end': end, 'book': my_email};
				myFeedLoader(formData);	
			} else if (mine) {
				curCnt = 0;
				formData = {'start': start, 'end': end, 'my': my_email};
				myFeedLoader(formData);		
			}
        }
    });
    
    $(document).on('click','.mola2' ,function(){
    	friend_email = $(this).data('mail');
    	$('#portfolio-grid').html('');
    	$('#feed-tag').html(friend_email + '님의 피드<hr>');
		curCnt = 0;
		friend = true;
		console.log(friend_email);
		formData = {'start': start, 'end': end, 'friend': friend_email};
		myFeedLoader(formData);
    });
    
    
    io.observe(document.querySelector('#fin-my'));
    

    $('#btn-book-list').on('click', function(){
    	$('#feed-tag').html('');
		AandD = false;
		booking = true;
		friend = false;
		curCnt = 0;
        formData = {'start': start, 'end': end, 'book': my_email};
        console.log('book ', my_email);
    	$('#portfolio-grid').html('');
		myFeedLoader(formData);		
    })
    
    $('#btn-my-list').on('click', function(){
    	$('#feed-tag').html('');
		AandD = true;
		friend = false;
    	$('#portfolio-grid').html('');
		mine = true;
		curCnt = 0;
		formData = {'start': start, 'end': end, 'my': my_email};
		console.log('my ', my_email);
		myFeedLoader(formData);		
    })
    
 	let start = ((curCnt++) * 15) + 1;
    let end = (curCnt) * 15;
    
	function myFeedLoader(formData){    
		console.log('feedloader start');
	    $.ajax({
	      type:'POST',
	      url:'<%=request.getContextPath()%>/myinformation.do',
	      data:formData,
	      async:false,
	      dataType:'JSON',
	      success:function(res){
		   friend_json = res.friendList;		   
	   	   feed_json = res.feedList;
	       file_json = res.fileList;
	       comment_json = res.commentList;
	       all_like_json = res.allLikeList;
	       like_sum_json = res.likeSumList;
	       book_mark_json = res.bookMarkList;
		   console.log(friend_json);
	       if(friendflag == 0) {
				let friend_tag;
				for(let y = 0; y<friend_json.length; y++) {
					for(let x = 0; x<memberJson.length; x++) {
						if(friend_json[y].memEmail2 == memberJson[x].memEmail)
							friend_tag = memberJson[x].memTag;
					}
					
					let friend_div =	"<div class='list-group mola1' data-mail='" +  friend_json[y].memEmail2 + "'>" +
										"<button type='button' data-mail='" +  friend_json[y].memEmail2 + "' class = 'list-group-item list-group-item-action mola2' style='color:purple'>@" + friend_tag + "</button></div>"
					$('#offcanvas-body').append(friend_div);
				}
				friendflag++;
	       }
	       
	       if (feed_json.length < 15) {
	           loading = false;
	           booking = false;
	           mine = false;
	       }
			console.log(1);
	       for (let a = 0; a < feed_json.length; a++) {
			if(feed_json[a].feedDyn == 'Y') {
				continue;
			}
	       console.log(feed_json[a].feedDyn);
	           let feed_num = feed_json[a].feedNum;
	           let feed_mem_tag;
	           for(let b = 0; b < memberJson.length; b++) {
	               if(my_email == memberJson[b].memEmail) {
	                   feed_mem_tag = memberJson[b].memTag;
	               }
	           }
	           let comment_cnt = 0;
	           for (let c = 0; c < comment_json.length; c++) {
	               if (comment_json[c].feedNum == feed_num) {
	                   comment_cnt++;
	               }
	           }
	           let like_sum = 0;
	           for (let d = 0; d < like_sum_json.length; d++) {
	               if(like_sum_json[d].feedNum == feed_num) {
	                   like_sum = parseInt(like_sum_json[d].likeSum);
	               }
	           }
	           let mem_email = feed_json[a].memEmail;
	           let mem_tag;
	           for(let j = 0; j < memberJson.length; j++) {
	          		if(memberJson[j].memEmail == mem_email) {
	            	 mem_tag = memberJson[j].memTag;
	            	 console.log(1);
	          			}
	           	}
					
	           	let atch_file_id = feed_json[a].atchFileId;
	           	let feed_mem_num = feed_json[a].feedMemNum;
	           	let feed_date = feed_json[a].feedDate;
	           	let feed_content = feed_json[a].feedContent;
	        	let image_have = false;
	    	    let feed_like = feed_json[a].feedLike;
	    	    

		
	           	let add_feed = '<div class="item web col-sm-6 col-md-4 col-lg-4 mb-4">' +
	           	"<div class='card post my-4 feed-card' id='feed-" + feed_num + "' >" +
	           	"<div class='card-header' style='display:flex;'>" +
	           	"<span id='span-tag' style='color:purple; margin-right:auto;'> @"+ mem_tag + "</span>";
	           	
	           	if(AandD && !friend){
	           		add_feed += "<button id=\"delete-" + feed_num + "\" name='feed_num' class=\"btn btn-outline-danger edit-feed-btn\" style='margin-right:10px'>삭제</button>"+
	           		"<button type=\"button\" id='update-"+ feed_num +"' data-bs-toggle=\"modal\" data-bs-target=\"#feed-update-modal\" class=\"btn btn-outline-secondary edit-feed-btn\" data-feed-num="+ feed_num +">수정</button>";
	           	}
	           	
	           add_feed += "</div>" +
	           "<div class='item web'>" +
	           "<div class='card-body' data-bs-toggle='modal' data-bs-target='#modal-" + feed_num + "'><div>";
				
	           for (let e = 0; e < file_json.length; e++) {
	               if (file_json[e].atchFileId == atch_file_id) {
	                   image_have = true;
	                   let file_name = file_json[e].streFileNm;
	                   let orginl_name = file_json[e].orignlFileNm;
	                   add_feed += "<img id='feed-" + feed_num + "' src='/img/" + file_name + "' alt='" + orginl_name + "' class='img-fluid' style='width: 100%;'>";
	               }
	           }
	           add_feed += "</div></div>";
				
	           if(!image_have && !feed_content) {
	               feed_content = "<span id='feed-content-none'>내용없음</span>";
	           }
	
	           add_feed += "<div style='padding:10px; margin:10px;'><h4 id='feed-content-h4' style='text'> " + feed_content + "</h4></div></div>" +
	           "<div class='card-footer'>" +
	           "<div class='container text-center'>" +
	           "<div class='row'>" +
	           "<div class='col'>";
	           let liked = false;
	           if(all_like_json != null) {
	               for(let f = 0; f < all_like_json.length; f++) {
	                   if(my_email == all_like_json[f].memEmail && all_like_json[f].feedNum == feed_num) {
	                       liked = true;
	                       break;
	                   }
	               }
	           }
	
	           if(liked) {
	               add_feed += "<input type=\"checkbox\" class=\"btn-check\" id=\"btn-like-" + feed_num + "\" checked autocomplete=\"off\">";
	           } else {
	               add_feed += "<input type=\"checkbox\" class=\"btn-check\" id=\"btn-like-" + feed_num + "\" autocomplete=\"off\">";
	           }
	
	           add_feed += "<label class=\"btn btn-outline-primary\" for=\"btn-like-"+feed_num+"\"><i class=\"bi bi-hand-thumbs-up\"></i> : <span id='like-span-" + feed_num + "'>" + like_sum + "</span></label><br>" +
               "</div>" +
               "<div class='col'>" +
               "<button type=\"button\" class=\"btn btn-outlined-dark btn-comment\" id='btn-comment-" + feed_num + "'><i class=\"bi bi-card-list\"></i> : " + comment_cnt + "</button><br>" +
               "</div>" + 
               "<div class='col'>";
	           
	           let marked = false;
               if(book_mark_json != null) {
                   for(let g = 0; g < book_mark_json.length; g++) {
                       if(my_email == book_mark_json[g].memEmail && book_mark_json[g].feedNum == feed_num) {
                           marked = true;
                           break;
                       }
                   }
               }

               if(marked) {
                   add_feed += "<input type=\"checkbox\" class=\"btn-check\" id=\"btn-book-"+feed_num+"\" checked autocomplete=\"off\">";
               } else {
                   add_feed += "<input type=\"checkbox\" class=\"btn-check\" id=\"btn-book-" + feed_num + "\" autocomplete=\"off\">";
               }
               
               
               add_feed += "<label class=\"btn btn-outline-info\" for=\"btn-book-"+feed_num+"\"><i class=\"bi bi-book-half\"></i></label><br>" +
               "</div>" + 
               "</div>" +
               "</div>" +
               "</div>" +
               "</div>" +
               "</div>";
	
	           
	           add_feed += "<div class='modal fade' id='modal-" + feed_num + "' tabindex='-1'" +
	           "aria-labelledby='modalLabel-" + feed_num + "' aria-hidden='true'>" +
	           "<div class='modal-dialog modal-xl modal-dialog-centered'>" +
	           "<div class='modal-content'>" +
	           "<div class='modal-header'>" +
	           "<h3 class='modal-title' id='modalLabel-" + feed_num + "'>" + mem_tag + "님의" +
	           feed_mem_num + "번째 피드" +
	           "</h3>" +
	           "<button type='button' class='btn-close' data-bs-dismiss='modal'" +
	           "aria-label='Close'></button>" +
	           "</div>" +
	           "<div class='modal-body'>" +
	           "<div class='container'>" +
	           "<div class='row'>" +
	           "<div class='col-md-8'>";
	           if(image_have) {
	               for (let h = 0; h < file_json.length; h++) {
	                   if (file_json[h].atchFileId == atch_file_id) {
	                       let file_name = file_json[h].streFileNm;
	                       let orginl_name = file_json[h].orignlFileNm;
	                       add_feed += "<img id='feed-" + feed_num + "' src='/img/" + file_name + "' alt='" + orginl_name + "' class='img-fluid' style='width: 100%;'>";
	                   }
	               }
	           } else {
	               add_feed += "<h4 id='feed-content-h4'>" + feed_content + "</h4>";
	           }
	
	           add_feed += "</div>" + 
	           "<div class='col-md-4 modal-dialog-scrollable' style='overflow-y: auto; max-height: 80vh;'>" +
	           "<div id='comments-section-" + feed_num + "'> ";
	
	           for (let i = 0; i < comment_json.length; i++) {
	               if (comment_json[i].feedNum == feed_num) {
	           		let mem_tag;
	                  for(let j = 0; j < memberJson.length; j++) {
	                if(memberJson[j].memEmail == comment_json[i].memEmail) {
	                   mem_tag = memberJson[j].memTag;
	                }
	                }
	                   add_feed += "<div class='card border-dark mb-3' style='width:340px;'>" +
	                   "<div class='card-header' style='color:purple;'>@" + mem_tag + "</div>" +
	                   "<div class='card-body'>" +
	                   "<p class='card-text'>" + comment_json[i].commentContent + "</p>" +
	                   "</div>" +
	                   "</div>";
	               }
	           }
	
	           add_feed += "</div>" +
	           "</div>" +
	           "</div>" +
	           "</div>" +
	           "</div>" +
	           "<div class='modal-footer d-flex'>" +
	           "<div class='row w-100'>" +
	           "<div class='col-8'>" +
	           "<h5>" + feed_json[a].feedDate + "</h5>" +
	           "</div>" +
	           "<div class='col-4'>" +
	           "<div class='input-group mb-3'>" +
	           "<input type='text' class='form-control' placeholder='댓글을 입력하세요!' id='comment-input-" + feed_num + "' aria-label='comment' aria-describedby='button-addon2'>" +
	           "<button class='btn btn-outline-secondary' type='button' id='button-addon2' onclick='addComment2(" + feed_num + ")'>확인</button>" +
	           "</div>" +
	           "</div>" +
	           "</div>" +
	           "</div>" +
	           "</div>" + 
	           "</div>" +
	           '</div>' +
	           "</div>";
				
	           $('#portfolio-grid').append(add_feed);    
	           
		           window.addComment2 = function(feedNum) {
		               let commentInput = document.getElementById('comment-input-' + feedNum);
		               let commentContent = commentInput.value;
		
		               if (!commentContent) {
		                   alert("내용을 입력하세요!");
		                   return;
		               }
		
		               $.ajax({
		                   type: 'POST',
		                   url: '<%=request.getContextPath()%>/insertcomment.do',
		                   data : JSON.stringify({
		                       feedNum : feedNum,
		                       commentContent : commentContent,
		                       memEmail : my_email
		                   }),
		                   contentType : 'application/json',
		                   success : function(response) {
		                       let commentsSection = document.getElementById('comments-section-' + feedNum);
		                       let newComment = document.createElement('div');
		                       newComment.className = 'card border-dark mb-3';
		                       newComment.style.width = '100%';
		   					
		                       newComment.innerHTML = "<div class='card-header' style='color:purple; width:340px;'>" + mem_tag + "</div>" +
		                       "<div class='card-body'>" + "<p class='card-text'>" +
		                       commentContent + "</p>" + "</div>";
		
		                       commentsSection.appendChild(newComment);
		
		                       commentInput.value = '';
		
		                   },
		                   error : function(xhr) {
		                       console.log(xhr);
		                       alert("댓글을 추가하는 데 실패했습니다.");
		                   }
		               });
		           }
		           
	                $('#update-' + feed_num).on('click', function(){
						let feedNum = feed_num;
						$('#update-input').val(feedNum);
	                })
	                
	                $('#delete-' + feed_num).on('click', function(){
						let feedNum = feed_num;
	                	if(confirm("피드를 삭제하시겠습니까?")) {
	
		                	$.ajax({
								type:'post',
								url:'<%=request.getContextPath() %>/feeddelete.do',
								data:{'feedNum':feedNum},
								success:function(res) {
									alert('피드가 삭제되었습니다.');
									location.reload(true);
								},
								error:function(xhr){
									alert('피드삭제 실패!');
								}
		                	});
	                	}
	                });
	                
	                
	                
	                $('#btn-like-' + feed_num).on('click', function() {
	                    let feedNum = feed_num;
	                    let feed_like = $('#like-span-' + feedNum).text();
	                    $.ajax({
	                        type: 'post',
	                        url: '<%=request.getContextPath() %>/likecontroller.do',
	                        data: { 'feedNum': feedNum, 'memEmail': my_email },
	                        success: function(res) {
	                            document.querySelector('#like-span-' + feedNum).textContent = parseInt(feed_like) + parseInt(res);
	                        },
	                        error: function(xhr) {
	                            console.log(xhr);
	                            alert('서버 오류 : ' + xhr + '\n잠시후 다시 시도해주세요.');
	                        }
	                    });
	                });
                    $('#btn-book-' + feed_num).on('click', function() {
                        let feedNum = feed_num;
                        $.ajax({
                            type: 'post',
                            url: '<%=request.getContextPath() %>/bookmarkcontroller.do',
                            data: { 'feedNum': feedNum, 'memEmail': my_email },
                            success: function() {
                            	console.log('성공');
                            },
                            error: function(xhr) {
                                console.log(xhr);
                                alert('서버 오류 : ' + xhr + '\n잠시후 다시 시도해주세요.');
                            }
                        });
                    });
	          }
	      
	      },
	      error:function(xhr){
	          console.log("fail ",xhr);
	   }
  });
}

   $('#mypageProfileBtn').on('change', function() {
       let v_disp = document.querySelector('#mypageProfileDisp');
       let v_select = document.querySelector('#mypageProfileBtn');
       v_disp.innerHTML = "";

       for (let i = 0; i < v_select.files.length; i++) {
           let v_file = v_select.files[i];
           let v_type = v_file.type.split('/')[0];
           let rd = new FileReader();
           if (v_type == 'text') {
               rd.onload = function() {
                   v_disp.innerText = rd.result;
               }
               rd.readAsText(v_file);
           } else if (v_type == 'image') {
               let v_img = document.createElement('img');
               v_img.style.width = "100%";
               v_img.style.height = "100%";
               v_img.style.objectFit = "cover";

               rd.onload = function() {
                   v_img.src = rd.result;
                   v_img.alt = v_file.name;
                   v_disp.append(v_img);
               }
               rd.readAsDataURL(v_file);
           }
       }
   });
   
   $('#inputBtn2').on('change', function() {
       let v_disp = document.querySelector('#dispp-update');
       let v_select = document.querySelector('#inputBtn2');
       v_disp.innerHTML = "";

       for (let i = 0; i < v_select.files.length; i++) {
           let v_file = v_select.files[i];
           let v_type = v_file.type.split('/')[0];
           let rd = new FileReader();
           if (v_type == 'text') {
               rd.onload = function() {
                   v_disp.innerText = rd.result;
               }
               rd.readAsText(v_file);
           } else if (v_type == 'image') {
               let v_img = document.createElement('img');
               v_img.style.width = "100%";
               v_img.style.height = "100%";
               v_img.style.objectFit = "cover";

               rd.onload = function() {
                   v_img.src = rd.result;
                   v_img.alt = v_file.name;
                   v_disp.append(v_img);
               }
               rd.readAsDataURL(v_file);
           }
       }
   });
});
   
</script>
