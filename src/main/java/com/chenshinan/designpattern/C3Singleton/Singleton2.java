package com.chenshinan.designpattern.C3Singleton;

/**
 * @author shinan.chen
 * @date 2018/8/28
 */
public class Singleton2 {
    private static class SingletonHolder {
        private static final Singleton2 singleton = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return SingletonHolder.singleton;
    }
}
