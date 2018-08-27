package com.chenshinan.designpattern.C2AbstractFactory;

/**
 * @author shinan.chen
 * @date 2018/8/27
 */
public class DbFactory extends AbstractFactory {
    public Mouse createMouse() {
        return new DbMouse();
    }

    public Keybo createKeybo() {
        return new DbKeybo();
    }
}
