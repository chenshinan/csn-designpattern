package com.chenshinan.designpattern.C12Flyweight;

import java.util.Collection;

/**
 * @author shinan.chen
 * @date 2018/9/12
 */
public class User {
    private String username;

    private Collection<Flyweight> flyweights;

    public User(String username, Collection<Flyweight> flyweights) {
        this.username = username;
        this.flyweights = flyweights;
    }

    public void showMemory() {
        System.out.println(username+":拥有权限:");
        for(Flyweight flyweight:flyweights){
            System.out.print(flyweight.show()+"||"+flyweight);
        }
        System.out.println();
    }
}
