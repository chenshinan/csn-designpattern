package com.chenshinan.designpattern.C6Adapter;

/**
 * @author shinan.chen
 * @date 2018/9/1
 */
public class NormalComputer extends TypecAdapter3 {
    @Override
    public void method1() {
        System.out.println("只实现一个方法就行");
    }
}
