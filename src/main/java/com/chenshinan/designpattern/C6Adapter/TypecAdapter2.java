package com.chenshinan.designpattern.C6Adapter;

/**
 * @author shinan.chen
 * @date 2018/9/1
 */
public class TypecAdapter2 implements Iusb {

    private Itypec typec;

    public TypecAdapter2(Itypec typec) {
        this.typec = typec;
    }

    @Override
    public void doingWithUsb() {
        /**
         * 通过接受usb，此处转成type-c
         */
        typec.doingWithTypec();
    }
}
