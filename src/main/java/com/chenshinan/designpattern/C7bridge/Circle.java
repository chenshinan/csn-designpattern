package com.chenshinan.designpattern.C7bridge;

/**
 * @author shinan.chen
 * @date 2018/9/2
 */
public class Circle extends Shape{
    @Override
    public void draw() {
        color.bepaint("圆形");
    }
}
