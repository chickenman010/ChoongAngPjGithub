<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
    function sendNumber(){
        $("#mail_number").css("display","block");
        $.ajax({
            url:"send_save_mail",
            type:"post",
            dataType:"json",
            data:{"user_email" : $("#user_email").val()},
            success: function(data){
                alert("인증번호 발송");
                $("#Confirm").attr("value",data);
            }
        });
    }

    function confirmNumber(){
        var number1 = $("#number").val();
        var number2 = $("#Confirm").val();
        alert(number1);
        alert(number2");

        if(number1 == number2){
            alert("인증되었습니다.");
        }else{
            alert("인증 번호가 다릅니다.");
        }
    }
</script>
<body>
  <div id="mail_input" name="mail_input">
      <input type="text" name="user_email" id="user_email" placeholder="이메일 입력">
      <button type="button" id="sendBtn" name="sendBtn" onclick="sendNumber()">인증번호</button>
  </div>
      <br>
  <div id="mail_number" name="mail_number" style="display: none">
    <input type="text" name="number" id="number" placeholder="인증번호 입력">
    <button type="button" name="confirmBtn" id="confirmBtn" onclick="confirmNumber()">이메일 인증</button>
  </div>
  <br>
    <input type="text" id="Confirm" name="Confirm" style="display: none" value="">
</body>
</html>