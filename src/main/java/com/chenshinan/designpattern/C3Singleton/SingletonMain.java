package com.chenshinan.designpattern.C3Singleton;

import com.chenshinan.designpattern.C2AbstractFactory.*;

/**
 * @author shinan.chen
 * @date 2018/8/28
 */
public class SingletonMain {
    public static void main(String[] args){

        /**
         * 简单模式，加载类时就加载出实例，多线程安全，没有加锁
         */
        Singleton1 singleton1 = Singleton1.getInstance();

        /**
         * 静态内部类模式：静态内部类会被延迟加载，只有通过显式调用
         * getInstance方法时，才会显式装载SingletonHolder类，
         * 从而实例化instance，同样多线程安全，没有加锁
         */
        Singleton2 singleton2 = Singleton2.getInstance();

        /**
         * 双重锁模式：实例延迟加载，通过使用volatile修饰实例，保证多线程安全，
         * 在getInstance中使用synchronized的对象锁，保证创建
         * 实例时的同步锁
         */
        Singleton3 singleton3 = Singleton3.getInstance();

        /**
         * 在使用单例模式创建实例时，推荐使用1，若明确需求要延迟加载再考虑2、3
         */
    }
}
