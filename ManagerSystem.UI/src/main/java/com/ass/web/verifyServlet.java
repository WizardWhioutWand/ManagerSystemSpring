package com.ass.web;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "verifyServlet",urlPatterns = "/imgcode")
public class verifyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int charNum = 6;
        int width = 30 * charNum;
        int height = 30;

        // 1. 创建一张内存图片
        BufferedImage bufferedImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        // 2.获得绘图对象
        Graphics graphics = bufferedImage.getGraphics();

        // 3、绘制背景颜色
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0, 0, width, height);

        // 4、绘制图片边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, width - 1, height - 1);

        // 5、输出验证码内容
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("宋体", Font.BOLD, 20));

        // 随机输出4个字符
        Graphics2D graphics2d = (Graphics2D) graphics;
        String s = "ABCDEFGHIGKLMNOPQRSTUVWXYZ01234567890";
        Random random = new Random();

        String msg = "";
        int x = 5;
        for (int i = 0; i < charNum; i++) {
            int index = random.nextInt(26);
            String content = String.valueOf(s.charAt(index));
            msg += content;
            double theta = random.nextInt(45) * Math.PI / 180;
            // 让字体旋转
            graphics2d.rotate(theta, x, 18);
            graphics2d.drawString(content, x, 18);
            // 让字体旋转
            graphics2d.rotate(-theta, x, 18);
            x += 30;
        }
          request.getSession().setAttribute("msg",msg);
        // 6、绘制干扰线
        for (int i = 0; i < 10; i++) {

            int r = random.nextInt(255);
            int g = random.nextInt(255);
            int b = random.nextInt(255);
            graphics.setColor(new Color(r, g, b));
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);

            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }

        // 7、释放资源
        graphics.dispose();
        // 8、图片输出 ImageIO
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
        response.getOutputStream().flush();
    }

}
