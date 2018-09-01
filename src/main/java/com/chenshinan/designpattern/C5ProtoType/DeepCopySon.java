package com.chenshinan.designpattern.C5ProtoType;

import java.io.Serializable;

/**
 * @author shinan.chen
 * @date 2018/9/1
 */
public class DeepCopySon implements Serializable {
    private String name;

    public DeepCopySon() {
    }

    public DeepCopySon(DeepCopySon lowCopySon) {
        this.name = lowCopySon.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
