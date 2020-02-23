package com.demo.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ligen
 * @description: 重定向 demo  从response1 重定向到response2
 * @date 2019/12/2513:54
 */

@WebServlet("/response1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("response1");
        resp.setStatus(302);  // 重定向
        // location  设置路径
        resp.setHeader("location","/servlet/response2");


        // 重定向方式2
        resp.sendRedirect("/servlet/response2");

    }
}
