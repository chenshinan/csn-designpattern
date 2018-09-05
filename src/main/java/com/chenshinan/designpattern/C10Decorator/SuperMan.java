package com.chenshinan.designpattern.C10Decorator;

/**
 * @author shinan.chen
 * @date 2018/9/5
 */
public class SuperMan implements Hero {
    String gongneng1;
    @Override
    public void doSomething() {
        System.out.println("我是个超人");
    }

    @Override
    public int helpPeople() {
        return 10;
    }
}
