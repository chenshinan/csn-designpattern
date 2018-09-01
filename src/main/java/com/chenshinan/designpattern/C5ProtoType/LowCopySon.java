package com.chenshinan.designpattern.C5ProtoType;

/**
 * @author shinan.chen
 * @date 2018/9/1
 */
public class LowCopySon implements Cloneable{
    private String name;

    public LowCopySon() {
    }

    public LowCopySon(LowCopySon lowCopySon) {
        this.name = lowCopySon.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
