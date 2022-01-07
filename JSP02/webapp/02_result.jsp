<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP 2</title>
    </head>
    <body>
        <h1>사용자 이름 결과 페이지</h1>
        
        <% // scriptlet
        request.setCharacterEncoding("UTF-8"); // 요청 데이터의 문자열 인코딩 방식 설정
        String userName = request.getParameter("userName"); // form에서 userName으로 전달한 파라미터 값
        %>
        
        <h2>사용자 이름: <%= userName %></h2>
        
    </body>
</html>