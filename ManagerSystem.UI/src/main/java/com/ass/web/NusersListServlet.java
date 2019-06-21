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

@WebServlet(name = "NusersListServlet",urlPatterns = "/showNusers")
public class NusersListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service =new UserService();
      List<NUser> users = service.getNusers();
      int usersCount =service.getNusersCount();
        request.setAttribute("usersCount",usersCount);
       request.setAttribute("users",users);
       request.getRequestDispatcher("/ShowListServlet").forward(request,response);
    }
}
