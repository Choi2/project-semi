<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/movie/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function() {
		
		$("#signInUser").find("input[type=button]").click(function() {
			$("#signInUser").attr({
				"action" : "/movie/user/doSignIn",
				"method" : "post"
			});
			
			$("#signInUser").submit();
			
		});
		
	});
</script>

<title>로그인</title>
</head>
<body>
	<form id ="signInUser">
		<input type ="text" id="userId" name="userId" placeholder="아이디를 입력하세요^^"/> <br/>
		<input type ="password" id="userPassword" name="userPassword" placeholder="비밀번호를 입력하세요^^"/> <br/>
		<input type="button" value = "로그인"/>
	</form>
</body>
</html>