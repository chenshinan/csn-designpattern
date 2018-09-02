package com.chenshinan.designpattern.C7bridge;

/**
 * @author shinan.chen
 * @date 2018/9/2
 */
public abstract class Shape {
    Color color;

    public void setColor(Color color) {
        this.color = color;
    }
    
    public abstract void draw();
}