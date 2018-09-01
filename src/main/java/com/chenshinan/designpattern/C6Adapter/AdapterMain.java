package com.chenshinan.designpattern.C6Adapter;

/**
 * @author shinan.chen
 * @date 2018/9/1
 */
public class AdapterMain {
    public static void main(String[] args) {

        Itypec typecComputer = new TypecComputer();
        typecComputer.doingWithTypec();

        Iusb usbComputer = new UsbComputer();
        usbComputer.doingWithUsb();

        /**
         * 1.类适配器：通过继承来实现适配器功能
         * 制作一个TypecComputer的适配器，当只接受usb时，也可以把usb数据转成typec
         */
        Iusb typecAdapter1 = new TypecAdapter1();
        typecAdapter1.doingWithUsb();

        /**
         * 2.对象适配器：通过组合来实现适配器功能
         */
        Iusb typecAdapter2 = new TypecAdapter2(new TypecComputer());
        typecAdapter2.doingWithUsb();

        /**
         * 3.接口适配器：通过抽象类来实现适配，只需用到接口中的部分方法
         */
        NormalComputer test = new NormalComputer();
        test.method2();
    }
}
