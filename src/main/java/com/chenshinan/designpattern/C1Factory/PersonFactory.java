package com.chenshinan.designpattern.C1Factory;

/**
 * @author shinan.chen
 * @date 2018/8/27
 */

public class PersonFactory {
    public Person getPerson(String claName) {
        if (claName == null ) {
            return null;
        }
        Person obj  = null;
        try {
            obj = (Person)Class.forName(claName).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * 用工厂模式来替代new的主要原因是：
         * 1、创建对象统一用工厂创建，方便修改
         * 2、子类易于拓展
         * 3、当构建一个对象需要附带一系列的动作、逻辑代码等，
         * 而这些大量代码尽量不放到构造函数中，把要做的事情解藕出来，
         * 因此在此处执行额外要做的事情
         */
        System.out.println("doing extra code");

        return obj;
    }
}
