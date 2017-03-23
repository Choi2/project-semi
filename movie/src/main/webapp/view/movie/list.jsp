<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화 리스트</title>
<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/movie/static/css/common_list.css">

</head>
<body>
	
	
	<div class="login">
	
			<c:if test="${empty sessionScope._USER_}">
				 <a href="/movie/user/signin">로그인</a> 	
			</c:if>
			
			<c:if test="${not empty sessionScope._USER_}">
				 ${sessionScope._USER_.userName}님 , 환영합니다!
			</c:if>
		
	</div>
	
	<div class ="grid" >
		<p>총 ${count}건의 영화가 검색되었습니다.</p>
		
	 <table>
	 	<tr>
	 		<th>번호</th>
	 		<th>영화제목</th>
	 		<th>작성자</th>
	 		<th>작성일</th>
	 		<th>좋아요</th>
	 		<th>조회수</th>	 		 		 	
	 	</tr>
	 	<c:forEach items="${movieList}" var="movie">
	 		<tr>
	 			<td>${movie.movieId}</td>
	 			<td><a href="/movie/detail?movieId=${moive.movieId}">${movie.movieTitle}</a>
	 			</td>
	 			<td>${movie.userVO.userName}</td>
	 			<td>${movie.movieDate}</td>
	 			<td>${movie.movieLikeCount}</td>
	 			<td>${movie.movieCheck}</td>
	 		</tr>
	 	</c:forEach>
	 
	 </table>
	 <a href="/movie/write">글 작성</a>
	 
		<div>
			<form id="searchForm">${pager}</form>
		</div>
	</div>
	 
		
		

</body>
</html>