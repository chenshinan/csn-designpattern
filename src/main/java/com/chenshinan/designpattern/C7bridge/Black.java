package com.chenshinan.designpattern.C7bridge;

/**
 * @author shinan.chen
 * @date 2018/9/2
 */
public class Black implements Color {
    @Override
    public void bepaint(String shape) {
        System.out.println("黑色的" + shape);
    }
}
