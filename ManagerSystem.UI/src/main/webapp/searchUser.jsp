<%--
  Created by IntelliJ IDEA.
  User: Albert
  Date: 2019/6/21
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/search">
    <table>
        <tr>
            <td colspan="2"> 请输入您要查询的用户名：</td>

        </tr>
        <tr>
             <td colspan="2"><input type="text" name="userName"></td>
        </tr>
        <tr>
           <td><input type="submit" value="确定"></td>
            <td><input type="reset" value="取消"></td>
        </tr>
<tr>
    <td colspan="2"><textarea name="selfIntro" style="width:200px;height:80px;"><%=request.getAttribute("Search.msg")==null?"":request.getAttribute("Search.msg")%></textarea></td>
</tr>
    </table>
</form>
</body>
</html>
