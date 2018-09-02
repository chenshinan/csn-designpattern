package com.chenshinan.designpattern.C7bridge;

import com.chenshinan.designpattern.C6Adapter.*;

/**
 * @author shinan.chen
 * @date 2018/9/1
 */
public class BridgeMain {
    public static void main(String[] args) {

        Color white = new White();
        Color black = new Black();

        Shape circle = new Circle();
        Shape square = new Square();

        circle.setColor(white);
        circle.draw();
        circle.setColor(black);
        circle.draw();

        square.setColor(white);
        square.draw();
        square.setColor(black);
        square.draw();

        /**
         * 桥接模式中的所谓脱耦，就是指在一个软件系统的抽象化和实现化之间使用关联关系（组合或者聚合关系）
         * 而不是继承关系，从而使两者可以相对独立地变化，这就是桥接模式的用意
         *
         * 例子中：可以使用相同的抽象类方法但是不同的桥接实现类，来画出不同颜色的图形
         */
    }
}
