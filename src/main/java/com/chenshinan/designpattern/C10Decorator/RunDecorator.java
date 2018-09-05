package com.chenshinan.designpattern.C10Decorator;

/**
 * @author shinan.chen
 * @date 2018/9/5
 */
public class RunDecorator extends Decorator {
    //新增加的字段
    private String gongneng3;

    public RunDecorator(Hero hero) {
        super(hero);
    }
    @Override
    public void doSomething() {
        System.out.println("我会跑");
        super.doSomething();
    }

    @Override
    public int helpPeople() {
        int count = super.helpPeople();
        return count+10;
    }

    public String getGongneng3() {
        return gongneng3;
    }

    public void setGongneng3(String gongneng3) {
        this.gongneng3 = gongneng3;
    }
}
