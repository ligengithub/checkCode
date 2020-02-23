package com.demo.servlet.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author ligen
 * @description: 动态生成验证码
 * @date 2019/12/2513:54
 */

@WebServlet("/checkCode")
public class CheckCodeDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1 创建图片
        int width = 200;
        int height = 100;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 2 梅花图片
        Graphics graphics = img.getGraphics();
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0, 0, width, height);

        // 画边框
        graphics.setColor(Color.black);
        graphics.drawRect(0, 0, width - 1, height - 1);

        // 画字符串
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghighlmnopqrstuvwxyz1234567890";
        Random random = new Random();
        int length = 4;

        for (int i1 = 0; i1 < length; i1++) {
            int i = random.nextInt(str.length());
            char c = str.charAt(i);
            graphics.drawString(String.valueOf(c), 20 + 40 * i1, 50);
        }


        // 画干扰线
        graphics.setColor(Color.YELLOW);
        int lineCnt = 10;
        for (int i = 0; i < lineCnt; i++) {

            int x1 = random.nextInt(200);
            int x2 = random.nextInt(200);
            int y1 = random.nextInt(100);
            int y2 = random.nextInt(100);

            graphics.drawLine(x1, y1, x2, y2);
        }


        // 3 输出
        ImageIO.write(img,"jpg",resp.getOutputStream());


    }
}
