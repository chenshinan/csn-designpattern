package com.chenshinan.designpattern.C3Singleton;

/**
 * @author shinan.chen
 * @date 2018/8/28
 */
public class Singleton3 {
    private static volatile Singleton3 singleton;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if(singleton==null){
            synchronized (Singleton3.class){
                singleton = new Singleton3();
            }
        }
        return singleton;
    }
}
