package com.chenshinan.designpattern.C9composite;

import com.chenshinan.designpattern.C7bridge.*;

/**
 * @author shinan.chen
 * @date 2018/9/4
 */
public class CompositeMain {
    public static void main(String[] args) {

        Component root = new Composite("服装");
        Component p1 = new Composite("男装");
        Component p2 = new Composite("女装");
        Component c1 = new Leaf("毛衣");
        Component c2 = new Leaf("夹克");
        Component c3 = new Leaf("裙子");
        Component c4 = new Leaf("连衣");
        root.addChild(p1);
        root.addChild(p2);
        p1.addChild(c1);
        p1.addChild(c2);
        p2.addChild(c3);
        p2.addChild(c4);

        root.printName("");

        System.out.println(">>>>>>");
        root.removeChild(p1);
        root.printName("");

        /**
         * 组合模式通过把叶子对象当成特殊的组合对象看待，从而对叶子对象和组合对象一视同仁，统统当成了Component对象，有机的统一了叶子对象和组合对象。
         *
         * 正是因为统一了叶子对象和组合对象，在将对象构建成树形结构的时候，才不需要做区分，反正是组件对象里面包含其它的组件对象，如此递归下去；也才使得对于树形结构的操作变得简单，不管对象类型，统一操作。
         *
         */
    }
}
