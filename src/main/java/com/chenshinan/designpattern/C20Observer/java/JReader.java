package com.chenshinan.designpattern.C20Observer.java;

import java.util.Observable;
import java.util.Observer;

/**
 * @author shinan.chen
 * @date 2018/10/17
 */
public class JReader implements Observer {
    /**
     * 读者的姓名
     */
    private String name;

    @Override
    public void update(Observable o, Object obj) {
        //这是采用推的方式
        System.out.println(name + "【推】收到报纸了，阅读内容是：" + obj);

        //这是获取拉的数据
        System.out.println(name + "【拉】收到报纸了，阅读内容是：" + ((JNewsPaper) o).getContent());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}