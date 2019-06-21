<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="scripts/jquery-3.4.1.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--    UTF-8//邮箱用户名效验--%>

    <script>
        // DOM 元素加载完毕就执行
        $(function(){
            $("#userName").blur(function(){
                var v1 = $("#userName").val();

                $.ajax({
                    type:"post",
                    datatype:"json",
                    contentType:"application/x-www-form-urlencoded;charset=UTF-8",
                    url: "/UserCheckServlet",
                    aync: true,
                    cache: false,
                    data:{username:v1},
                    success: function(data){
                        if(data.F == 0){
                            $("#usermsg").html("有错误信息：" + data.M);

                        }else{
                            if(data.M==true){
                                $("#usermsg").html("用户名可以使用");

                            }else{
                                $("#usermsg").html("有重名，请重新选择");

                            }
                        }

                    },
                    error: function(xhr, status, error){
                        alert(error);
                    }
                });

            });

        });
    </script>

<%--    <script>--%>
<%--        function getXMLHttpRequest(){--%>
<%--            var xmlhttp;--%>
<%--            if(window.XMLHttpRequest){--%>
<%--                xmlhttp = new XMLHttpRequest();--%>
<%--            }else if (window.ActiveXObject) {--%>
<%--                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");--%>
<%--            }--%>

<%--            return xmlhttp;--%>
<%--        }--%>

<%--        window.onload=function(){--%>
<%--            var emailNode = document.form1.email;--%>
<%--            var userName =document.form1.userName;--%>

<%--            userName.onblur=function(){--%>
<%--                {--%>
<%--                    var val = this.value;--%>
<%--                    var usermsg = document.getElementById("usermsg");--%>
<%--                    usermsg.innerHTML = "";--%>
<%--                    if(val == ""){--%>
<%--                        usermsg.innerHTML="用户名不能为空";--%>
<%--                    }--%>

<%--                    var xhr = getXMLHttpRequest();--%>
<%--                    xhr.open("POST", "${pageContext.request.contextPath}/UserCheck");--%>
<%--                    xhr.onreadystatechange = function(){--%>
<%--                        if(xhr.readyState = 4){--%>
<%--                            if(xhr.status == 200){--%>
<%--                                if(xhr.responseText == "true"){--%>
<%--                                    usermsg.innerHTML="<div style='color:red'>用户名使用中！</div>";--%>
<%--                                }else{--%>
<%--                                    usermsg.innerHTML="<div>可以使用</div>";--%>
<%--                                }--%>
<%--                            }--%>
<%--                        }--%>
<%--                    };--%>

<%--                    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");--%>
<%--                    xhr.send("userName="+val);--%>
<%--                }--%>
<%--            }--%>
<%--            emailNode.onblur = function(){--%>
<%--                var val = this.value;--%>
<%--                var emailmsg = document.getElementById("emailmsg");--%>
<%--                emailmsg.innerHTML = "";--%>
<%--                if(val == ""){--%>
<%--                    emailmsg.innerHTML="email不能为空";--%>
<%--                }--%>

<%--                var xhr = getXMLHttpRequest();--%>
<%--                xhr.open("POST", "${pageContext.request.contextPath}/EmailCheck");--%>
<%--                xhr.onreadystatechange = function(){--%>
<%--                    if(xhr.readyState = 4){--%>
<%--                        if(xhr.status == 200){--%>
<%--                            if(xhr.responseText == "true"){--%>
<%--                                emailmsg.innerHTML="<div style='color:red'>邮箱使用中！</div>";--%>
<%--                            }else{--%>
<%--                                emailmsg.innerHTML="<div>可以使用</div>";--%>
<%--                            }--%>
<%--                        }--%>
<%--                    }--%>
<%--                };--%>

<%--                xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");--%>
<%--                xhr.send("email="+val);--%>
<%--            }--%>

<%--        }--%>
<%--    </script>--%>
    <script>
        function fun() {
            document.getElementById("img").src="/imgcode?time="+new Date().getTime();
        }
    </script>
    <title>Insert title here</title>
    <%--    <%@ include file="header.jsp" %>--%>
    <style>
        body{font:bold 12px/30px 黑体;}
        .main{ margin:0 auto; width:500px; border: solid 1px; text-align: center;;}
        .line{border:solid 1px;}
        .line div{ display:inline-block; margin:3px;}
        .col1 {width: 80px; text-align: right;border:solid 0px;}
        .col2 {width: 200px; text-align: left;border:solid 0px;}
        .col2 input {width:200px;}
        .col2 textarea {width:200px;height:80px;}
    </style>

</head>
<body>
<div class="main">
    <div><p>注册用户</p></div>
    <form name="form1" method="post" action="${pageContext.request.contextPath}/regist.do">
        <div class="line">
            <div class="col1">用户名：</div><div class="col2"><input type="text" id="userName" name="userName"></div>
            <div class="col1" id="usermsg"></div>
        </div>
        <div class="line">
            <div class="col1">密码：</div><div class="col2"><input type="text" name="userKey"></div>
        </div>
        <div class="line">
            <div class="col1">确认密码：</div><div class="col2"><input type="text" name="userkeyconfirm"></div>
        </div>
        <div class="line">
            <div class="col1">邮箱：</div><div class="col2"><input type="text" name="email"></div>
            <div class="col1" id="emailmsg"></div>
        </div>
        <div class="line">
            <div class="col1">性别：</div>
            <div class="col2">
                <input type="radio" name="gender" value="1" checked="checked" style="width:30px;">男
                <input type="radio" name="gender" value="0" style="width:30px;">女
            </div>
        </div>
        <div class="line">
            <div class="col1">出生日期：</div><div class="col2"><input type="text" name="birthday"></div>
        </div>
        <div class="line">
            <div class="col1">爱好：</div>
            <div class="col2">
                <input type="checkbox" name="hobby" value="美女" checked="checked" style="width:30px;">美女
                <input type="checkbox" name="hobby" value="读书" style="width:30px;">读书
                <input type="checkbox" name="hobby" value="电影" style="width:30px;">电影
            </div>
        </div>
        <div class="line">
            <div class="col1" style="vertical-align: top;">自我介绍：</div>
            <div class="col2"><textarea name="selfIntro"></textarea></div>
        </div>
        <div class="line">
            <div class="col1" style="vertical-align: top;">验证码：</div>
            <div class="col2"><input type="text" name="checkcode"/></div>
        </div>
        <div class="line">
            <div class="col1" style="vertical-align: top;">点击图片刷新：</div>
            <div class="col2"><img src="/imgcode" onclick="fun()" id="img"></div>
        </div>
        <div class="line">
            <div class="col1"></div>
            <div class="col2">${errormsg}</div>
        </div>
        <div class="line">
            <div class="col1" style="vertical-align: top;"></div>
            <div class="col2">
                <input type="submit" value="注册" style="width:80px;">
                <input type="reset" value="重置" style="width:80px;">
            </div>
        </div>

    </form>
</div>
</body>
</html>
