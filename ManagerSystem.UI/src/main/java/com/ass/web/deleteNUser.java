package com.ass.web;

import com.ass.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteNUser",urlPatterns = "/deleteNUser")
public class deleteNUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String[] users =request.getParameterValues("users");
        UserService service =new UserService();
        for (String s:users
             ) {
            service.deleteNUser(s);

        }
        request.getRequestDispatcher("/delete").forward(request,
                response);
    }
}
