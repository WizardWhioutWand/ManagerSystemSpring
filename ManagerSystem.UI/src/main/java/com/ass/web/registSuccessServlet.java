package com.ass.web;

import com.ass.service.UserService;
import com.ass.web.been.NUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.IOException;

@WebServlet(name = "registSuccessServlet",urlPatterns = "/registersuccess.jsp")
public class registSuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
              String userInf = (String) request.getAttribute("mag");
        NUser user = (NUser)  request.getAttribute("user");
        UserService service =new UserService();
        response.getWriter().append("<html><body>");
                if(service.addUser(user)){
                    response.getWriter().append("<p>注册成功了。</p>");
                    System.out.println("success");
                }
        response.getWriter().append("</body></html>");
    }
}
