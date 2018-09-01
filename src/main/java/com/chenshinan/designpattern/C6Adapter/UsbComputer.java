package com.chenshinan.designpattern.C6Adapter;

/**
 * @author shinan.chen
 * @date 2018/9/1
 */
public class UsbComputer implements Iusb {
    @Override
    public void doingWithUsb() {
        System.out.println("只接受usb");
    }
}
