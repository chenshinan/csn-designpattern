package com.chenshinan.designpattern.C12Flyweight;

/**
 * @author shinan.chen
 * @date 2018/9/12
 */
public class FlyweightMain {
    public static void main(String[] args){
        SecurityManager securityManager = SecurityManager.getManager();
        securityManager.login("陈一");
        securityManager.login("陈二");
        securityManager.login("陈三");
        securityManager.login("陈四");
        securityManager.login("陈五");
        securityManager.login("陈六");

        securityManager.showMemory();

        /**
         * 享元模式，真正应该被缓存的数据是那些不变且重复出现的数据，把它们称为对象的`内部状态`，
         * 而那些变化的数据就不缓存了，把它们称为对象的`外部状态`。
         *
         * 在享元模式中，为了创建和管理共享的享元部分，引入了享元工厂，享元工厂中一般都包含有享元对象的实例池，
         * 享元对象就是缓存在这个实例池中的。
         *
         * 内部状态和外部状态是独立的，外部状态的变化不应该影响到内部状态，但可以和内部状态封装成一个新的对象。
         * 在享元模式中，通常是在第一次向享元工厂请求获取共享对象的时候，进行共享对象的初始化，
         * 而且多半都是在享元工厂内部实现，不会从外部传入共享对象。
         *
         * 加入了缓存的引用次数和垃圾回收
         */
    }
}
