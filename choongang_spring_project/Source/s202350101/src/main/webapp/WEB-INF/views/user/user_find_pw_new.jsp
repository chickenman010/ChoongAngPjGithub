<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    margin-top: -30px;
}
select {
    width: 250px; /* 원하는 가로 크기로 조정 (예: 200px) */
    padding: 5px; /* 내용과 경계 사이의 간격을 조절 (옵션) */
}

</style>
<script type="text/javascript" src="../js/httpRequest.js"></script>
<script type="text/javascript">
	function updatePW() {
		if(frm.user_pw1.value != frm.user_pw1.value){
			alert("비밀번호가 일치하지 않습니다!");
			frm.user_pw1.focus();
			return false;
		} else location.href="user_find_pw_update?user_pw="+frm.user_pw1.value;

	}

</script>

</head>
<body>
	<div class="login-wrapper">
        <h2>비밀번호 찾기</h2>
        <form method="post" action="" id="login-form">
           새 비밀번호 : 	 <input type="password" name="user_pw1" value="" required="required" placeholder="PW"><p>
           새 비밀번호 확인 : <input type="password" name="user_pw2" value="" required="required" placeholder="PW2"><p>
        <input type="submit" value="확인" onclick="updatePW()">
  		</form>
        
    </div>
</body>
</html>