package com.chenshinan.designpattern.C11Facade;

/**
 * @author shinan.chen
 * @date 2018/9/11
 */
public class FacadeMain {
    public static void main(String[] args){
        /**
         * 外观模式：封装内部复杂的方法调用，给客户端提供一个简单调用入口，
         * 松散了客户端与子系统的耦合关系，让子系统内部的模块能更容易扩展和维护，
         * 对于一个子系统而言，外观类不需要很多，通常可以实现成为一个单例，
         * Facade的方法本身并不进行功能的处理，Facade的方法的实现只是实现一个功能的组合调用
         * 外观模式很好的体现了“最少知识原则”
         */
        FacadeModule.doWork();
    }
}
