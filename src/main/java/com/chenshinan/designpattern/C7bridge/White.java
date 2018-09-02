package com.chenshinan.designpattern.C7bridge;

/**
 * @author shinan.chen
 * @date 2018/9/2
 */
public class White implements Color {
    @Override
    public void bepaint(String shape) {
        System.out.println("白色的"+shape);
    }
}
