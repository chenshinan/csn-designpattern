package com.chenshinan.designpattern.C10Decorator;

/**
 * @author shinan.chen
 * @date 2018/9/5
 */
public class FlyDecorator extends Decorator {
    //新增加的字段
    private String gongneng2;

    public FlyDecorator(Hero hero) {
        super(hero);
    }
    @Override
    public void doSomething() {
        System.out.println("我会飞");
        super.doSomething();
    }

    @Override
    public int helpPeople() {
        int count = super.helpPeople();
        return count+10;
    }

    public String getGongneng2() {
        return gongneng2;
    }

    public void setGongneng2(String gongneng2) {
        this.gongneng2 = gongneng2;
    }
}
