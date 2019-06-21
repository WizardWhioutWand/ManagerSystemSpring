package com.ass.web;

import com.ass.web.been.NUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowListServlet",urlPatterns = "/ShowListServlet")
public class ShowListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<NUser> users =( List<NUser>)request.getAttribute("users");
        response.getWriter().append("<html><body>");
        for (NUser user:users
             ) {
            response.getWriter().append("<p>"+user.toString()+"</p><br>");
        }
        response.getWriter().append("</body></html>");
        }

}
