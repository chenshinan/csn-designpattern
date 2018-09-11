package com.chenshinan.designpattern.C11Facade;

/**
 * @author shinan.chen
 * @date 2018/9/11
 */
public class FacadeModule{
    static void doWork(){
        AModuleApi amod = new AModuleImpl();
        BModuleApi bmod = new BModuleImpl();
        CModuleApi cmod = new CModuleImpl();
        amod.testA();
        bmod.testB();
        cmod.testC();
    }
}

interface AModuleApi {
    void testA();
}

class AModuleImpl implements AModuleApi{
    @Override
    public void testA() {
        System.out.println("启动CPU");
    }
}

interface BModuleApi{
    void testB();
}

class BModuleImpl implements BModuleApi{
    @Override
    public void testB() {
        System.out.println("启动磁盘");
    }
}

interface CModuleApi{
    void testC();
}

class CModuleImpl implements CModuleApi{
    @Override
    public void testC() {
        System.out.println("启动显示器");
    }
}
