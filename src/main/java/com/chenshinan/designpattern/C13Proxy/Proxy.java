package com.chenshinan.designpattern.C13Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author shinan.chen
 * @date 2018/9/15
 */
interface People{
    void takeDelivery();
}

class Myself implements People{
    @Override
    public void takeDelivery() {
        System.out.println("取外卖");
    }
}

class StaticProxy implements People{
    private People people;
    public StaticProxy(People people){
        this.people = people;
    }

    @Override
    public void takeDelivery() {
        System.out.println("代跑小哥出发");
        this.people.takeDelivery();
        System.out.println("代跑小哥完成取外面");
    }
}

class DynamicProxy implements InvocationHandler{
    //被代理的对象
    private Object o;
    public Object getProxyInterface(Object o){
        this.o = o;
        //返回代理对象
        return Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代跑小哥出发");
        Object result = method.invoke(o,args);
        System.out.println("代跑小哥完成取外面");
        return result;
    }
}