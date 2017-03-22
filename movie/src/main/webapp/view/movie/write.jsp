<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/movie/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">

	$().ready(function() {
		
		$("#writeForm").find("input[type=button]").click(function() {
			
			$("#writeForm").attr({
				"action" : "/movie/write",
				"method" : "post"
 			});
			
			$("#writeForm").submit();
			
		});
		
	});

</script>
<title>글쓰기</title>
</head>
<body>
	<form id="writeForm" enctype="multipart/form-data">
		<input type="text" name="movieTitle" placeholder="영화제목 입력"/> <br/>
		<textarea name="movieContent"></textarea> <br/>
		<input type="button" value="글쓰기"/>
	</form>
</body>
</html>