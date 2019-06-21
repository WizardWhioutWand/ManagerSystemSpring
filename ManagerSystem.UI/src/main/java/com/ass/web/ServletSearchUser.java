package com.ass.web;

import com.ass.service.UserService;
import com.ass.web.been.NUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletSearchUser",urlPatterns = "/search")
public class ServletSearchUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String userName =request.getParameter("userName");

        UserService service =new UserService();
       NUser user = service.searchNUser(userName);

       if (user==null){

           request.setAttribute("Search.msg","用户名不存在。");

           request.getRequestDispatcher("/searchUser.jsp").forward(request,
                   response);
           return;
       }else {
           System.out.println(user.toString());
           request.setAttribute("Search.msg",user.toString());
           request.getRequestDispatcher("/searchUser.jsp").forward(request,
                   response);
       }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
