<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<script>
    function getXMLHttpRequest(){
        var xmlhttp;
        if(window.XMLHttpRequest){
            xmlhttp = new XMLHttpRequest();
        }else if (window.ActiveXObject) {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        return xmlhttp;
    }

    window.onload=function(){
        var emailNode = document.f1.email;
        alert(emailNode.value);
        emailNode.onblur = function(){
            var val = this.value;
            var emailmsg = document.getElementById("emailmsg");
            emailmsg.innerHTML = "";
            if(val == ""){
                emailmsg.innerHTML="email不能为空";
            }

            var xhr = getXMLHttpRequest();
            xhr.onreadystatechange = function(){
                if(xhr.readyState = 4){
                    if(xhr.status == 200){
                        if(xhr.responseText == "true"){
                            emailmsg.innerHTML="<div style='color:red'>邮箱使用中！</div>";
                        }else{
                            emailmsg.innerHTML="<div>可以使用</div>";
                        }
                    }
                }
            };

            xhr.open("get", "${pageContext.request.contextPath}/EmailCheck?email="+val+"&v="+new Date().getMilliseconds());
            xhr.send(null);
        }

    }
</script>
<div id="emailmsg"></div>
<form name="f1" >
    邮箱名:<input type="text" name="email" >
    <input type="submit" value="submit">
</form>

</body>
</html>
