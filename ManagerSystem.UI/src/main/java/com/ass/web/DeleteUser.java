package com.ass.web;

import com.ass.service.UserService;
import com.ass.web.been.NUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteUser",urlPatterns = "/delete")
public class DeleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1：给 responset里面的content赋值的设置编码
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        // 2: 告诉浏览器以什么编码进行显示
        response.setContentType("text/html;charset=UTF-8");
        UserService service =new UserService();
        List<NUser> users = service.getNusers();
        response.getWriter().append("<html><body>");
        response.getWriter().append(" <form name=\"form1\" method=\"post\" action=\"/deleteNUser\">");
        for (NUser user:users
        ) {
            response.getWriter().append("<p><input type=\"checkbox\" name=\"users\" / value="+user.getUserName()+">"+user.toString()+"</p><br>");
        }
        response.getWriter().append("  <div class=\"col2\">\n" +
                "                <input type=\"submit\" value=\"删除\" style=\"width:80px;\">\n" +
                "                <input type=\"reset\" value=\"重置\" style=\"width:80px;\">\n" +
                "            </div>");
      response.getWriter().append("</form>");
        response.getWriter().append("</body></html>");
    }
    }

