<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/movie/static/js/jquery-3.1.1.min.js"></script>

<script type="text/javascript" >
	
	$().ready(function() {
	
			$("#userId").keyup(function() {
				$.post("/movie/user/checkDuplicate", 
					{
					"	userId" : $("#userId").val()
					},
				function(response) {
						
					var jsonObj = JSON.parse(response);
		
					if(jsonObj.duplicated) {
						$("#duplicateState").text("이미 사용중인 아이디입니다.");
					}
					else {
						$("#duplicateState").text("사용 가능 합니다.^^");
					}
				});
		});
	
	
	$("#signUpUser").find("input[type=button]").click(function() {
		
		if($("#userId").val() == "") {
			alert("아이디를 입력하세요!!!");
			$("#userId").focus();
			return ;
		}
		
		if($("#userPassword").val().length <= 7) {
			alert("비밀번호는 8자리 이상으로 입력하세요!!!");
			$("#userPassword").focus();
			return ;
		}
		
		if($("#userName").val() == "") {
			alert("이름을 입력하세요!!!");
			$("#userName").focus();
			return ;
		}
		
		$.post("/movie/user/checkDuplicate", {
			"userId" : $("#userId").val()
		}, function(response) {
			
			if(response.duplicated) {
				alert("입력한 id는 이미 사용 중입니다. \n다른 id를 사용해 주세요.");
				return ;
			}
			
			else {
				
				$("#signUpUser").attr({
					"action" : "/melon/user/doSignUp",
					"method" : "post"
				});
				
				$("#signUpUser").submit();
				
			}
		});
		
	});
	
	
});
	

</script>

<title>회원가입</title>
</head>
<body>
	<form id ="signUpUser">
		<input type ="text" id="userId" name="userId" placeholder="아이디를 입력하세요^^"/> <br/>
		<span id="duplicateState"></span>
		<input type ="password" id="userPassword" name="userPassword" placeholder="비밀번호를 입력하세요^^"/> <br/>
		<input type ="password" id="userPassword-check" name="userPassword-check" placeholder="비밀번호 확인 입력하세요^^"/> <br/>
		<input type ="text" id="userName" name="userName" placeholder="이름을 입력하세요^^"/> <br/>
		<input type="button" value = "가입"/>
	</form>
</body>
</html>