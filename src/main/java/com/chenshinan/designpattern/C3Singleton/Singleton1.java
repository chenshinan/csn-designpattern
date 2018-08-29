package com.chenshinan.designpattern.C3Singleton;

/**
 * @author shinan.chen
 * @date 2018/8/28
 */
public class Singleton1 {
    private static Singleton1 singleton = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return singleton;
    }
}
