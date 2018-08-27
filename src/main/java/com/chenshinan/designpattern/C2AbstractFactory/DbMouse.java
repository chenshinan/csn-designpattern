package com.chenshinan.designpattern.C2AbstractFactory;

/**
 * @author shinan.chen
 * @date 2018/8/27
 */
public class DbMouse implements Mouse{
    @Override
    public void sayHi(){
        System.out.println("db mouse hello");
    }
}
