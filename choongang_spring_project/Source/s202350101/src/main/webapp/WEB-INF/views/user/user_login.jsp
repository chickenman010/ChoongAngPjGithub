<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function chkInfo() {
		var id = $('#user_id').val();
		var pw = $('#user_pw').val();
	    var oInput = $("#user_id");
		
		if (id == "") {
			​​​​​​​​showErrorMsg(oMsg,"필수 정보입니다.");
		}
		
	}

</script>

<style type="text/css">
.login-wrapper{
    width: 400px;
    height: 450px;
    padding: 40px;
    box-sizing: border-box;
    border: 2px solid lightgrey;
    border-radius: 10px;
    
    /* 가로 중앙 정렬을 위한 추가된 스타일 */
    margin: 0 auto; 
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.login-wrapper > h2{
    font-size: 30px;
    padding-bottom: 40px;
    color: #A6A6A6;
    margin-bottom: 40px;
}
#login-form > input{
    width: 100%;
    height: 48px;
    padding: 0 10px;
    box-sizing: border-box;
    border: 2px solid white;
    margin-bottom: 16px;
    border-radius: 6px;
    background-color: #F8F8F8;
}
#login-form > input::placeholder{
    color: #D2D2D2;
}
#login-form > input[type="submit"]{
    color: #fff;
    font-size: 16px;
    background-color: #A6A6A6;
    margin-top: 20px;
}
#login-form > input[type="button"]{
    color: #A6A6A6;
    font-size: 10px;
    margin-top: 0px;
    margin-bottom: -50px;
    background-color: #FFFFFF;
    margin: 10;
}
﻿
</style>
</head>
<body>
    <div class="login-wrapper">
        <h2>ChoongAng</h2>
        <form action="user_login_check" id="login-form" method="post">
            <input type="text" 	   name="user_id" id="user_id" placeholder="ID" value="${userInfo.user_id }">
            <input type="password" name="user_pw" id="user_pw" placeholder="Password">
            <label for="remember-check">
                <input type="checkbox" id="remember-check">아이디 저장하기
            </label>
            
            <input type="submit" value="Login" onclick="chkInfo()">
        </form>
        <a href="user_find_pw"><input type="button" value="비밀번호 찾기"></a>
   	    <a href="user_find_id"><input type="button" value="아이디 찾기"></a>
   	    <a href="user_join_agree"><input type="button" value="회원가입"></a>
    </div>
</body>
</html>