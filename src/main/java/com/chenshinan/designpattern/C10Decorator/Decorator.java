package com.chenshinan.designpattern.C10Decorator;

/**
 * @author shinan.chen
 * @date 2018/9/5
 */
public abstract class Decorator implements Hero {
    protected Hero hero;
    public Decorator(Hero hero){
        this.hero = hero;
    }

    @Override
    public void doSomething() {
        this.hero.doSomething();
    }

    @Override
    public int helpPeople() {
        return this.hero.helpPeople();
    }
}
