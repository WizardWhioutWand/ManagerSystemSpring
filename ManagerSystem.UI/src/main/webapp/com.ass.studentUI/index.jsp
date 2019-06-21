<%--
  Created by IntelliJ IDEA.
  User: Albert
  Date: 2019/6/21
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        function addUser() {
            document.getElementById("if").src="/JSONregist.jsp";
        }
        function showUser() {
            document.getElementById("if").src="/showNusers";
        }
        function searchUser(){
            document.getElementById("if").src="/searchUser.jsp";
        }
        function deleteUser(){
            document.getElementById("if").src="/delete";
        }
    </script>
    <style type="text/css">
        .top{
            /* 设置宽度高度背景颜色 */
            height: auto; /*高度改为自动高度*/
            width:100%;
            margin-left: 0;
            background:rgb(189, 181, 181);

            top: 0;/*离顶部的距离为0*/
            margin-bottom: 5px;
        }
        .top ul{
            /* 清除ul标签的默认样式 */
            width: auto;/*宽度也改为自动*/
            list-style-type: none;
            white-space:nowrap;
            overflow: hidden;
            margin-left: 5%;
            /* margin-top: 0;          */
            padding: 0;

        }
        .top li {
            float:left; /* 使li内容横向浮动，即横向排列  */
            margin-right:2%;  /* 两个li之间的距离*/
            position: relative;
            overflow: hidden;
        }

        .top li a{
            /* 设置链接内容显示的格式*/
            display: block; /* 把链接显示为块元素可使整个链接区域可点击 */
            color:white;
            text-align: center;
            padding: 3px;
            overflow: hidden;
            text-decoration: none; /* 去除下划线 */

        }
        .top li a:hover{
            /* 鼠标选中时背景变为黑色 */
            background-color: #111;
        }


        body{
            background:#eff3f5;
        }

    </style>
<body>
<div>
<div class="top">
    <center>
        <ul>
            <li><a href="#" onclick="addUser()">添加用户</a></li>
            <li><a href="#" onclick="showUser()">用户列表</a></li>
            <li><a href="#" onclick="searchUser()">查询用户</a></li>
            <li><a href="#" onclick="deleteUser()"><b>删除用户</b></a></li>
        </ul>
    </center>
</div>
<div style="clear: both"></div>
<div class="main" >
    <iframe  id="if" src="/regist.jsp" style="width: 800px;height: 600px;margin-top: 20px;margin-left: 200px"></iframe>
</div>
</div>
</body>
</head>
</html>
