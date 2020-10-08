package com.sergiomartinrubio.cdijavaeeexample;

import com.sergiomartinrubio.cdijavaeeexample.bean.Foo;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/inject-list")
public class MyInjectListController extends HttpServlet {

    private final Instance<Foo> foos;

    @Inject
    public MyInjectListController(@Any Instance<Foo> foos) {
        this.foos = foos;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        foos.forEach(foo -> out.println("<h1>" + foo.getName() + "</h1>"));
    }

}
