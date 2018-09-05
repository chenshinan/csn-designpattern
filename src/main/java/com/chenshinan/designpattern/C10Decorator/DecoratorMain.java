package com.chenshinan.designpattern.C10Decorator;

import com.chenshinan.designpattern.C9composite.Component;
import com.chenshinan.designpattern.C9composite.Composite;
import com.chenshinan.designpattern.C9composite.Leaf;

/**
 * @author shinan.chen
 * @date 2018/9/4
 */
public class DecoratorMain {
    public static void main(String[] args) {

        Hero superman = new SuperMan();
        Hero flyman = new FlyDecorator(superman);
        Hero runman = new RunDecorator(flyman);

        runman.doSomething();

        System.out.println("我救了"+runman.helpPeople()+"个人");

        /*
        装饰模式能够实现动态的为对象添加功能，是从一个对象外部来给对象增加功能，相当于是改变了对象的外观。
        当装饰过后，从外部使用系统的角度看，就不再是使用原始的那个对象了，而是使用被一系列的装饰器装饰过后的对象。
        这样就能够灵活的改变一个对象的功能，只要动态组合的装饰器发生了改变，那么最终所得到的对象的功能也就发生了改变。
        变相的还得到了另外一个好处，那就是装饰器功能的复用，可以给一个对象多次增加同一个装饰器，也可以用同一个装饰器装饰不同的对象。

        装饰器实现了对被装饰对象的某些装饰功能，可以在装饰器里面调用被装饰对象的功能，获取相应的值，这其实是一种递归调用。
        装饰器是用来装饰组件的，装饰器一定要实现和组件类一致的接口，保证它们是同一个类型，并具有同一个外观，这样组合完成的装饰才能够递归的调用下去。

        `装饰模式与适配器模式`（它们有一个共同的别名：Wrapper）：这两个模式功能上是不一样的，适配器模式是用来改变接口的，而装饰模式是用来改变对象功能的。

        一句话区别：`装饰模式是一个接口两个类，适配器模式是两个接口一个类`
         */
    }
}
