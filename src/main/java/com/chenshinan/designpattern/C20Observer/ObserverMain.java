package com.chenshinan.designpattern.C20Observer;

import com.chenshinan.designpattern.C20Observer.custom.NewsPaper;
import com.chenshinan.designpattern.C20Observer.custom.Reader;
import com.chenshinan.designpattern.C20Observer.java.JNewsPaper;
import com.chenshinan.designpattern.C20Observer.java.JReader;

/**
 * @author shinan.chen
 * @date 2018/10/16
 */
public class ObserverMain {
    public static void main(String[] args){
        System.out.println("————————————第一种：用类实现的观察者模式————————————");
        //创建一个报纸，作为被观察者
        NewsPaper subject = new NewsPaper();
        //创建阅读者，也就是观察者
        Reader reader1 = new Reader();
        reader1.setName("张三");
        Reader reader2 = new Reader();
        reader2.setName("李四");
        Reader reader3 = new Reader();
        reader3.setName("王五");

        //注册阅读者
        subject.attach(reader1);
        subject.attach(reader2);
        subject.attach(reader3);

        //要出报纸啦
        subject.setContent("本期内容是观察者模式");
        
        System.out.println("————————————第二种：用Java自带的接口实现的观察者模式————————————");
        //创建一个报纸，作为被观察者
        JNewsPaper jsubject = new JNewsPaper();
        //创建阅读者，也就是观察者
        JReader jreader1 = new JReader();
        jreader1.setName("张三");
        JReader jreader2 = new JReader();
        jreader2.setName("李四");
        JReader jreader3 = new JReader();
        jreader3.setName("王五");

        //注册阅读者
        jsubject.addObserver(jreader1);
        jsubject.addObserver(jreader2);
        jsubject.addObserver(jreader3);

        //要出报纸啦
        subject.setContent("本期内容是观察者模式");
    }
}
