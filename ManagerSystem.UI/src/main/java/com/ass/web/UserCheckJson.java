package com.ass.web;

import com.ass.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "UserCheckJson",urlPatterns = "/UserCheckServlet")
public class UserCheckJson extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("username");
        UserService service = new UserService();
        boolean b =service.findUser(userName);
        boolean s=false;
        int f=1;
        if (!b){
          s=true;
        }
        String msg = "{\"F\":"+f+", \"M\":"+s+"}";
        System.out.println(msg);
        System.out.println( "{\"F\":1, \"M\":\"OK\"}");
        OutputStream out = response.getOutputStream();
        out.write(msg.getBytes("UTF-8"));
        out.flush();

    }
}
