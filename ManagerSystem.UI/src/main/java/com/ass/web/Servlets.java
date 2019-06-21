package com.ass.web;

import com.ass.web.been.NUser;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet(name = "Servlets",urlPatterns = "/regist.do")
public class Servlets extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1：给 responset里面的content赋值的设置编码
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        // 2: 告诉浏览器以什么编码进行显示
        response.setContentType("text/html;charset=UTF-8");

        String userkeyconfirm = request.getParameter("userkeyconfirm");
        // 处理特殊数据类型
        String[] hobbies = request.getParameterValues("hobby");


        NUser user = new NUser();
        try {
            ConvertUtils.register(new Converter() {

                public Object convert(Class type, Object value) {

                    //判断是不是String类型的数据，不是则抛出异常
                    if(!(value instanceof String)){
                        throw new ConversionException("不是String数据类型！");
                    }
                    //是String的话，把Object的value强转成String
                    String strValue = (String) value;
                    //判断是不是一个空字符串
                    if(strValue.trim().equals("")){
                        return null;

                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        return sdf.parse(strValue);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, Date.class);

            BeanUtils.populate(user, request.getParameterMap());
            String hobby = Arrays.toString(hobbies).substring(1, Arrays.toString(hobbies).length() - 1);
            user.setHobby(hobby);

            if(user.getUserKey().equals(userkeyconfirm) == false){
                request.setAttribute("errormsg", "密码不一致！");
                request.getRequestDispatcher("/regist.jsp").forward(request,
                        response);
                return;
            }
            // 2.验证验证码是否正确
            String checkcode = request.getParameter("checkcode"); // 得以输入的难码
            String msg = (String) request.getSession().getAttribute("msg");
            request.getSession().removeAttribute("msg"); // 从session中将验证码获取后立即从session中移除
            if (msg == null || checkcode == null || !msg.equals(checkcode)) { // 验证码错误
                request.setAttribute("errormsg", "验证码不一致！");
                request.getRequestDispatcher("/regist.jsp").forward(request,
                        response);
                return;
            }
            System.out.println(user.toString());
            request.setAttribute("user",user);
            request.setAttribute("msg", user.toString());
            request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
