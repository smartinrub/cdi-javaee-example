package com.sergiomartinrubio.cdijavaeeexample.bean;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyBean {

    public String getMessage() {
        return "Hello Bean";
    }
}
