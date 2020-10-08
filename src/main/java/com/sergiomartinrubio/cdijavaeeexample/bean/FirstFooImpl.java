package com.sergiomartinrubio.cdijavaeeexample.bean;

import com.sergiomartinrubio.cdijavaeeexample.bean.qualifier.FirstFoo;

import javax.enterprise.context.ApplicationScoped;

@FirstFoo
@ApplicationScoped
public class FirstFooImpl implements Foo {

    @Override
    public String getName() {
        return "First Foo";
    }
}
