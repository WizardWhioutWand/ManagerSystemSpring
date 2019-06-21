package com.ass.web;

import com.ass.service.UserService;
import com.ass.web.been.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = "/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前页
        response.setContentType("text/html;charset=UTF-8");
        //获取分页数量
        int pageSize =0;
        int totalPage=0;
        int currentPage=1;
        UserService service = new UserService();
        if(request.getParameter("pageSize")!=null){
            if (request.getParameter("pageSize")!="请输入单页存储数目"){
                pageSize = Integer.parseInt(request.getParameter("pageSize"));
            }

        }
        if(request.getParameter("indexPage")!=null){
            currentPage = Integer.parseInt(request.getParameter("indexPage"));
        }

        if(pageSize>0){


            int totalusername = 0;
            try {


                totalusername = service.getCount();

            } catch (Exception e) {
                e.printStackTrace();
            }
            if (totalusername%pageSize==0) {
                totalPage = totalusername / pageSize;
            }
            if (totalusername%pageSize!=0){
                totalPage = totalusername / pageSize+1;
            }
            response.getWriter().append("<html><body>");
            response.getWriter().append("<form  name = 'f' action='Servlet' method='get'><input type = 'text' name = 'pageSize' value = '请输入单页存储数目'><input type='submit'></form>");
            if (currentPage<=0){
                currentPage=1;
                response.getWriter().append("    <script>\n" +
                        "        alert(\"已经是第一页了。\");\n" +
                        "    </script>");

            }else if (currentPage>totalPage){
                currentPage=totalPage;
                response.getWriter().append("    <script>\n" +
                        "        alert(\"已经是最后一页了。\");\n" +
                        "    </script>");
            }
            if(currentPage>0&&currentPage<=totalPage){
                response.getWriter().append("<table>");
                response.getWriter().append("<tr><td span='2'>姓名</td><td></td><td span='2'>密码</td><td></td></tr>");
                try {

                    List<User> users = service.getUsers(currentPage, pageSize);
                    for (User user : users
                    ) {
                        response.getWriter().append("<tr>");
                        response.getWriter().append("<td span='2'><p>");
                        response.getWriter().append(user.getName());
                        response.getWriter().append("</p></td><td></td>");
                        response.getWriter().append("<td span='2'><p>");
                        response.getWriter().append(user.getPasswd());
                        response.getWriter().append("</p></td><td></td>");
                        response.getWriter().append("</tr>");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                response.getWriter().append("<tr>");
                response.getWriter().append("<td><a href='Servlet?indexPage=1&pageSize="+pageSize+"'>首页</a></td>");
                response.getWriter().append("<td>");
                response.getWriter().append("<a href='Servlet?indexPage="+(currentPage+1)+"&pageSize="+pageSize+"'>下一页</a>");
                response.getWriter().append("</td>");
                //currentPage = Integer.parseInt(request.getParameter("indexPage"));
                response.getWriter().append("<td>");
                response.getWriter().append("<a href='Servlet?indexPage="+(currentPage-1)+"&pageSize="+pageSize+"'>上一页</a>");
                response.getWriter().append("</td>");
                response.getWriter().append("<td>");
                response.getWriter().append("<a  href='Servlet?indexPage="+totalPage+"&pageSize="+pageSize+"'>尾页</a>");
                response.getWriter().append("</td>");
                response.getWriter().append("</tr>");
                response.getWriter().append("</body></html>");
            }else {

            }

        }
        else{
            response.getWriter().append("<html><body>");
            response.getWriter().append("<form  name = 'f' action='Servlet' method='get'><input type = 'text' name = 'pageSize' value = '请输入单页存储数目'><input type='submit'></form>");

            response.getWriter().append("</body></html>");
        }
    }
}
