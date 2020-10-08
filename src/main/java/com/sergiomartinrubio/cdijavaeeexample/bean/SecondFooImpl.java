package com.sergiomartinrubio.cdijavaeeexample.bean;

import com.sergiomartinrubio.cdijavaeeexample.bean.qualifier.SecondFoo;

import javax.enterprise.context.ApplicationScoped;

@SecondFoo
@ApplicationScoped
public class SecondFooImpl implements Foo {

    @Override
    public String getName() {
        return "Second Foo";
    }
}
