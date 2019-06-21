package com.ass.web;

import com.ass.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmailCheck",urlPatterns = "/EmailCheck")
public class EmailCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String email = request.getParameter("email");
        UserService service = new UserService();
        boolean b =service.findEmail(email);
        response.getWriter().print(b);
    }
}
