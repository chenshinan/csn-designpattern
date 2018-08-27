package com.chenshinan.designpattern.C2AbstractFactory;

/**
 * @author shinan.chen
 * @date 2018/8/27
 */
public class AbstractFactoryMain {
    public static void main(String[] args){
        
        //Db工厂，生产鼠标和键盘
        AbstractFactory dbFactory = new DbFactory();
        Keybo dbKeybo = dbFactory.createKeybo();
        Mouse dbMouse = dbFactory.createMouse();
        dbKeybo.sayHi();
        dbMouse.sayHi();
        //Hp工厂，生产鼠标和键盘
        AbstractFactory hpFactory = new HpFactory();
        Keybo hpKeybo = hpFactory.createKeybo();
        Mouse hpMouse = hpFactory.createMouse();
        hpKeybo.sayHi();
        hpMouse.sayHi();

        /**
         * 抽象工厂模式，应用于模板一样的一系列产品的构建
         * 抽象工厂：品牌：Hp、Db
         * 产品：Hp鼠标、Hp键盘、Db鼠标、Db键盘
         * 易于拓展：
         * 当增加一个品牌QQ时，只需要增加一个QQ工厂实现类、QQ鼠标、QQ键盘
         * 当增加一个产品耳机Head时，只需要增加Head接口及不同厂家的实现类DbHead、DbHead，及在抽象工厂中增加创建新产品的方法createHead
         */
    }
}
