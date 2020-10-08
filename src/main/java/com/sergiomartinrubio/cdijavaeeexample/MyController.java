package com.sergiomartinrubio.cdijavaeeexample;

import com.sergiomartinrubio.cdijavaeeexample.bean.MyBean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Stateless
@WebServlet(urlPatterns = "/bean")
public class MyController extends HttpServlet {

    //    @Inject
    private final MyBean myBean;

//    @Inject
//    public void setMyBean(MyBean myBean) {
//        this.myBean = myBean;
//    }

    @Inject
    public MyController(MyBean myBean) {
        this.myBean = myBean;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1>" + myBean.getMessage() + "</h1>");
    }
}
