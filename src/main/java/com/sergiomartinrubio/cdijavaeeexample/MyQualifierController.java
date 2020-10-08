package com.sergiomartinrubio.cdijavaeeexample;

import com.sergiomartinrubio.cdijavaeeexample.bean.Foo;
import com.sergiomartinrubio.cdijavaeeexample.bean.qualifier.FirstFoo;
import com.sergiomartinrubio.cdijavaeeexample.bean.qualifier.SecondFoo;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/qualifier")
public class MyQualifierController extends HttpServlet {

    private final Foo secondFoo;

    @Inject
    public MyQualifierController(@SecondFoo Foo secondFoo) {
        this.secondFoo = secondFoo;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1>" + secondFoo.getName() + "</h1>");
    }
}
