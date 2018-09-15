package com.chenshinan.designpattern.C13Proxy;

/**
 * @author shinan.chen
 * @date 2018/9/15
 */
public class ProxyMain {

    public static void main(String[] args){
        People myself = new Myself();
        /**
         * 通常把自己实现的代理模式，称为Java的静态代理
         */
        StaticProxy staticProxy = new StaticProxy(myself);
        staticProxy.takeDelivery();

        /**
         * 使用Java内建的对代理模式支持的功能来实现的代理称为Java的动态代理
         */
        DynamicProxy dynamicProxy = new DynamicProxy();
        People proxyPeople = (People) dynamicProxy.getProxyInterface(myself);
        proxyPeople.takeDelivery();
    }
}
