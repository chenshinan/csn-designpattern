package com.chenshinan.designpattern.C6Adapter;

/**
 * @author shinan.chen
 * @date 2018/9/1
 */
public class TypecAdapter1 extends TypecComputer implements Iusb {

    @Override
    public void doingWithUsb() {
        /**
         * 通过接受usb，此处转成type-c
         */
        doingWithTypec();
    }
}
