package com.chenshinan.designpattern.C20Observer;

import com.chenshinan.designpattern.C20Observer.custom.NewsPaper;
import com.chenshinan.designpattern.C20Observer.custom.Reader;
import com.chenshinan.designpattern.C20Observer.java.JNewsPaper;
import com.chenshinan.designpattern.C20Observer.java.JReader;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.omg.CORBA.ObjectHelper;

/**
 * @author shinan.chen
 * @date 2018/10/16
 */
public class ObserverMain {
    public static void main(String[] args) {
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
        jsubject.setContent("本期内容是观察者模式");

        System.out.println("————————————第三种：用RxJava实现的观察者模式————————————");
        Observable.just("本期内容是观察者模式")//创建上游 observable
        .subscribe(new Observer<String>() {//创建下游 observer

            private String name = "小明";
            @Override
            public void onSubscribe(Disposable disposable) {
            }

            @Override
            public void onNext(String value) {
                System.out.println(name + "收到报纸了，阅读内容是：" +value);
            }

            @Override
            public void onComplete() {
                System.out.println("完成");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("error");
            }
        });
    }
}
