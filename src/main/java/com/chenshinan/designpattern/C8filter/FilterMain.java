package com.chenshinan.designpattern.C8filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shinan.chen
 * @date 2018/9/4
 */
public class FilterMain {
    public static void main(String[] args) {
        List<Fruit> allfruit = new ArrayList<Fruit>();

        allfruit.add(new Fruit("苹果", "甜的", "圆形"));
        allfruit.add(new Fruit("橘子", "酸的", "圆形"));
        allfruit.add(new Fruit("菠萝", "甜的", "椭圆"));
        allfruit.add(new Fruit("西瓜", "甜的", "椭圆"));
        allfruit.add(new Fruit("枣子", "酸的", "圆形"));

        Criteria circle = new CriteriaShape();
        Criteria sweet = new CriteriaTaste();
        Criteria orange = new CriteriaName();
        Criteria sweetorange = new AndCriteria(sweet, orange);
        Criteria circleOrsweet = new OrCriteria(circle, sweet);

        System.out.println("橘子: ");
        printFruit((orange.meetCriteria(allfruit)));

        System.out.println("\n甜的: ");
        printFruit((sweet.meetCriteria(allfruit)));

        System.out.println("\n圆形: ");
        printFruit((circle.meetCriteria(allfruit)));

        System.out.println("\n甜的橘子: ");
        printFruit((sweetorange.meetCriteria(allfruit)));

        System.out.println("\n圆的或甜的：");
        printFruit(circleOrsweet.meetCriteria(allfruit));

        /**
         * 过滤器模式只是一种设计思路，使得代码结构更清晰更好维护，
         * 就目前这些功能来说java8提供的stream处理起来更方便
         */
    }

    public static void printFruit(List<Fruit> allfruit) {
        for (Fruit fruit : allfruit) {
            System.out.println("Fruit:[ Name :" + fruit.getName() + ",Taste: " + fruit.getTaste() + ",Shape:" + fruit.getShape() + "]");
        }
    }
}
