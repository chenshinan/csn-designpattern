package com.chenshinan.designpattern.C6Adapter;

/**
 * @author shinan.chen
 * @date 2018/9/1
 */
public class TypecComputer implements Itypec {
    @Override
    public void doingWithTypec() {
        System.out.println("只接受type-c");
    }
}
