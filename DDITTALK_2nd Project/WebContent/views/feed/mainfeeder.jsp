<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

	MemberVO mv10000 = (MemberVO)session.getAttribute("LOGIN_USER");

	String memberList10000 = (String)session.getAttribute("MEMBER_LIST");

%>
<style>
/* #loading { */
/*  width: 100%;    */
/*  height: 100%;    */
/*  top: 0px; */
/*  left: 0px; */
/*  position: fixed;    */
/*  display: block;    */
/*  opacity: 0.7;    */
/*  background-color: #fff;    */
/*  z-index: 99;    */
/*  text-align: center; }   */
 
/* #loading-image {    */
/*  position: absolute;    */
/*  top: 50%;    */
/*  left: 50%;   */
/*  z-index: 100; }  */

/* #loading { */
/*   width: 100%; */
/*   height: 100%; */
/*   top: 0px; */
/*   left: 0px; */
/*   position: fixed; */
/*   display: flex; */
/*   justify-content: center; */
/*   align-items: center; */
/*   opacity: 0.7; */
/*   background-color: #fff; */
/*   z-index: 99; */
/* } */

/* #loading-image { */
/*   z-index: 100; */
/*   opacity: 1; /* 추가된 부분 */ */
/*   transition: opacity 1s ease-in-out; /* 추가된 부분 */ */
/* } */
</style>

<div id="feed-container"></div>
<div id="fin" ></div>

<div id="feed-write-modal" class="modal fade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Feed Insert</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="form-feed-insert" action="<%=request.getContextPath()%>/insertfeed.do" method="post">
                    <textarea id="feedContent" name="feedContent" class="form-control" rows="3"></textarea>
                    <input type="file" id="inputBtn" name="file" class="form-control-file">
                    <div id="dispp" class="mt-2"></div>
                    <button type="submit" class="btn btn-primary mt-3">등록</button>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="feedRegistrationModal" tabindex="-1" aria-labelledby="feedRegistrationModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background-color: #9AC5F4">
                <h5 class="modal-title" id="feedRegistrationModalLabel" style="color:white; background-color: #9AC5F4; font-weight: bold;">피드 등록</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" style="background-color: #ffffff">
                <%@ include file="/views/feed/feedInsert.jsp"%>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="acceptListModal" tabindex="-1" aria-labelledby="acceptListModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background-color: #9AC5F4">
                <h5 class="modal-title" id="acceptListModalLabel" style="color:white; background-color: #9AC5F4; font-weight: bold;">받은 친구요청</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" id="reqFriList" style="background-color: #ffffff">
                	
            </div>
        </div>
    </div>
</div>









<div id="spinner" class="d-flex justify-content-center">
  <div class="spinner-border" role="status">
    <span class="visually-hidden">Loading...</span>
  </div>
</div>


<script type="text/javascript">
// $(window).load(function() {     
// 	 $('#loading').hide();   
// 	}); 
// $(window).on('load', function() {
//   $('#loading-image').css('opacity', '0'); // 추가된 부분
//   setTimeout(function() {
//     $('#loading').remove();
//   }, 1000); // 1초 후 제거
// });
</script>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
    let search = "";
	let searched = search;
    $(document).ready(function() {
	getFriList();
    	
    	
	$(document).on('click','.mola155', function(){
		var memEmail = $(this).data('mememail');
		console.log('memEmail', memEmail);
		$.ajax({
			type: 'post',
			url: '<%= request.getContextPath() %>/acceptfndlist.do',
			data : {
				memEmail : memEmail,
			},
			success : function(){
				alert('친구추가가 완료되었습니다.');
			}
		});
		
	});
//     받은 친구요청 띄우는 칸 
	function getFriList() {
		$.ajax({
			type: 'get',
			url: '<%=request.getContextPath()%>/acceptfndlist.do',
			dataType: 'json',
			success: function(acceptList) {
	            console.log('acceptList --> ', acceptList);
	            console.log('acceptList : ', acceptList.length);
	            if (acceptList.length == 0) {

	            } else {
	                for (let i = 0 ; i < acceptList.length; i++) {
	                    var $reqFndList = $('<div class="mola155" id="reqFndList" data-mememail="' + acceptList[i].memEmail + '" >' + acceptList[i].memEmail + '</div>');
	                    var $regBtn = $('<button class="btn btn-primary d-inline-flex float-end btn-xs d-flex justify-content-center align-items-center" style="width:auto; position: absolute; right: 15px; font-size: 12px; margin-top: 2px; background-color: #478CCF; border-color: #478CCF;" type="button" id="regBtn">승낙</button>');
	                    
	                    $reqFndList.append($regBtn);
	                    $('#reqFriList').append($reqFndList);
	                }
	            }
	        }		
		});
	}



// 		받은 친구요청 띄우는 칸     	
    	
    	
    	
    	
    	
    	
    let memberListString = '<%=memberList10000 %>';
    let memberJson = JSON.parse(memberListString);
    let my_email = '<%=mv10000.getMemEmail() %>';
    
    let feed_json;
    let file_json;
    let comment_json;
    let all_like_json;
    let like_sum_json;
    let book_mark_json;
    
    let curCnt = 0;
    let loading = false;

    let io = new IntersectionObserver(function(entries) {
        if (entries[0].isIntersecting && !loading) {
            	feedLoader(searched);
        }
    });
    
	$('#tag').on('keyup', enterSearch);
	
	function enterSearch(e){
		if(e.keyCode == 13){
			curCnt = 0;
			search = $('#tag').val();
            $('#tag').val('');
            $('#feed-container').html('');
			feedLoader(search);
			
		}
	}

        io.observe(document.querySelector('#fin'));

        function feedLoader(search) {
            loading = true;
            $('#spinner').show();
            let start = ((curCnt++) * 10) + 1;
            let end = (curCnt) * 10;
            let formData;

            if (search) {
                formData = {'start': start, 'end': end, 'search': search};
            } else {
                formData = {'start': start, 'end': end};
            }

            $.ajax({
                type: 'post',
                url: '<%=request.getContextPath()%>/mainpage.do',
                data: formData,
                dataType: 'json',
                success: function(res) {
                    feed_json = res.feedList;
                    file_json = res.fileList;
                    comment_json = res.commentList;
                    all_like_json = res.allLikeList;
                    like_sum_json = res.likeSumList;
                    book_mark_json = res.bookMarkList;
                    
                    let add_feed = "<div class='row'>" +
                    "<div class='col-sm-8 offset-sm-2'>" +
                    "<main class='activity-feed'>";

                    if (feed_json.length === 0) {
                        loading = false;
                    	$('#spinner').hide();
                        return;
                    }

                    for (let a = 0; a < feed_json.length; a++) {
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
							}
                        }

                        let atch_file_id = feed_json[a].atchFileId;
                        let feed_mem_num = feed_json[a].feedMemNum;
                        let feed_date = feed_json[a].feedDate;
                        let feed_content = feed_json[a].feedContent;
                        let image_have = false;
                        let feed_like = feed_json[a].feedLike;

                        add_feed += "<div class='card post my-4 feed-card' style='box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);' id='feed-" + feed_num + "'>" +
                        "<div class='card-header' data-bs-toggle='modal' data-bs-target='#modal-" + feed_num + "' style='color:purple;'> @"+ mem_tag +
                        "<div class='media' id='media'>" +
                        "<div class='media-left'>" +
                        "</div>" +
                        "</div>" +
                        "</div>" +
                        "<div class='item web'>" +
                        "<div class='card-body' style='background-color: white' data-bs-toggle='modal' data-bs-target='#modal-" + feed_num + "'>";

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

                        add_feed += "<h6 id='feed-content-h6' style='margin-left:13px; margin-right:13px;'>" + feed_content + "</h6>" +
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
                            add_feed += "<div style='margin:10px;'>" + feed_content + "</div>";
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
                                "<div class='card-body' style='width:100;'>" +
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
                        "<button class='btn btn-outline-secondary' type='button' id='button-addon2' onclick='addComment(" + feed_num + ")'>확인</button>" +
                        "</div>" +
                        "</div>" +
                        "</div>" +
                        "</div>" +
                        "</div>" +
                        "</div>" +
                        "</div>";

                        $('#feed-container').append(add_feed);

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

                        add_feed = "<div class='row'>" +
                        "<div class='col-sm-8 offset-sm-2'>" +
                        "<main class='activity-feed'>";
                    }
                    loading = false;
                    $('#spinner').hide();
                },
                error: function(xhr) {
                    console.log(xhr);
                    loading = false;
                    $('#spinner').hide();
                }
            });
        }

        window.addComment = function(feedNum) {
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
					
                    newComment.innerHTML = "<div class='card-header' style='color:purple; width:340px;'>" + '<%=mv10000.getMemTag() %>' + "</div>" +
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

	    $('.form-feed-insert').on('submit', function(e){
	        if(!$('#feedContent1').val()) {
	            e.preventDefault();
	            alert('공유하고 싶은 내용을 작성해주세요!');
	        }
	    });
	
	    $('#inputBtn1').on('change', function() {
	        let v_disp = document.querySelector('#dispp1');
	        let v_select = document.querySelector('#inputBtn1');
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
<!-- <div id="loading"><img id="loading-image" src="images/loading.gif" alt="Loading..." /></div> -->
<!-- <div id="loading"> -->
<!--   <img id="loading-image" src="images/loading.gif" alt="Loading..." /> -->
<!-- </div> -->
