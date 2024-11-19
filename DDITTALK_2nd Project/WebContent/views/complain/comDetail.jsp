<%@page import="VO.ComplainVO"%>
<%@page import="VO.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<% 
// 	List<ComplainVO> comList = (List<ComplainVO>)request.getAttribute("comList"); 
	ComplainVO cv = (ComplainVO) request.getAttribute("cv");
// 	String msg = session.getAttribute("msg") == null ? "" 
// 			: (String)session.getAttribute("msg");
	
// 	session.removeAttribute("msg");
		HttpSession httpSession = request.getSession();
		MemberVO mv85 = (MemberVO)httpSession.getAttribute("LOGIN_USER");
		
%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문의 관리</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            background-color: #f4f4f9;
            color: #333;
        }
        .container {
            width: 80%;
            margin: 50px auto;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
            padding: 20px;
        }
        .header, .footer {
            margin-bottom: 20px;
        }
        .header p, .footer p {
            margin: 0;
            color: #777;
        }
        .content {
            margin: 20px 0;
        }
        .content table {
            width: 100%;
            border-collapse: collapse;
        }
        .content table, .content th, .content td {
            border: 1px solid #ccc;
        }
        .content th, .content td {
            padding: 10px;
            text-align: left;
        }
        .content th {
            background-color: #f9f9f9;
            width: 70px;
            text-align: center;
        }
        .underline {
            border-bottom: 1px solid #ccc;
            padding-bottom: 10px;
            margin-bottom: 10px;
        }
        .buttons {
            text-align: center;
            margin-top: 20px;
        }
        .buttons button {
            padding: 10px 20px;
            margin: 0 10px;
            border: none;
            background-color: #007bff;
            color: white;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }
        .buttons button:hover {
            background-color: #0056b3;
        }
        .answer-form {
            margin-top: 20px;
        }
        .answer-form textarea {
            width: 100%;
            height: 150px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
            transition: border-color 0.3s ease;
        }
        .answer-form textarea:focus {
            border-color: #007bff;
            outline: none;
            margin-right: 20px;
        }
        .answer-form button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }
        .answer-form button:hover {
            background-color: #218838;
        }

    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <p>최근 6개월 동안 접수하신 1:1문의내역 및 답변 내용을 확인하실 수 있습니다.</p> <br>
            <p>* 문의 내용 중 개인정보가 포함되어있거나 중복된 문의인 경우 삭제될 수 있습니다.</p>
        </div>
        <div class="content">
            <table>
                <tr>
                    <th>등록일</th>
                    <td><%=cv.getComDate() %></td>
                </tr>
                <tr>
                    <th>처리상태</th>
                    <td><%
         					if(cv.getComDyn().equals("N")) { %> 처리중
         				<% }
         					else { %> 상담완료 
         				<%
         					} 
         				%></td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td><%=cv.getComTitle() %>
                    
                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td class="underline"><%=cv.getComContent() %> </td>
                </tr>
                <tr>
                    <th>답변</th>
                    <td class="underline">
                    <%
                            if(cv.getComAns() != null && !cv.getComAns().isEmpty()) {
                        %>
                            <p><%=cv.getComAns() %></p>
                        <%
                            } else if (mv85 != null && mv85.getMemEmail().equals("admin") ) {
                        %>
                            <div class="answer-form" style="padding: 10px 0; width: 100%;">
                                <form action="<%= request.getContextPath() %>/comdetail.do" method="post" style="display: flex; flex-direction: column;">
                                    <textarea name="comAns" placeholder="답변을 작성하세요..." style="width: 100%; box-sizing: border-box;"></textarea>
                                    <input type="hidden" name="comNum" value="<%=cv.getComNum()%>">
                                    <button type="submit" style="align-self: flex-start; margin-top: 10px;">답변 제출</button>
                                </form>
                            </div>
                            
                        <%
                            } else {
                        %>
                            <p>답변이 없습니다.</p>
                        <%
                            }
                        %>
                      
                    </td>
                </tr>
            </table>
        </div>
        <div class="footer">
            <p>답변에 만족스럽지 않으시거나 외의 다른 문의사항이 있으실 경우 다시 문의 주시면 최대한 빠르게 답변 드리겠습니다.</p>
        </div>
        <div class="buttons"> 
        <%	if(!(mv85.getMemEmail().equals("admin"))){ %>
        	<button onclick="window.location.href='<%=request.getContextPath()%>/cominsert.do'">다시 문의하기</button>
        <%
        	}
        %>
            
            <button type="button" onclick="history.back()">목록</button>
        </div>
    </div>
</body>
</html>

      
