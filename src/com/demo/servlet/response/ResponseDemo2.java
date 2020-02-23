package com.demo.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ligen
 * @description: 重定向 demo  从response1 重定向到response2
 * @date 2019/12/2513:54
 */

@WebServlet("/response2")
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("response2");

        // 方式1
        //        resp.setCharacterEncoding("utf-8");
        //  resp.setHeader("content-type","text/html;charset=utf-8");

        // 方式2
        resp.setContentType("text/html;charset=utf-8");


        PrintWriter writer = resp.getWriter();
        writer.println("hello   你好啊啊啊");
    }
}
