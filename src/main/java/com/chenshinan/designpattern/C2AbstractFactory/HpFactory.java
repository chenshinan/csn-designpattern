package com.chenshinan.designpattern.C2AbstractFactory;

/**
 * @author shinan.chen
 * @date 2018/8/27
 */
public class HpFactory extends AbstractFactory {
    public HpMouse createMouse() {
        return new HpMouse();
    }

    public HpKeybo createKeybo() {
        return new HpKeybo();
    }
}
