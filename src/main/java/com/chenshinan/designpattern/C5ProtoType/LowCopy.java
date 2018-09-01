package com.chenshinan.designpattern.C5ProtoType;

/**
 * @author shinan.chen
 * @date 2018/9/1
 */
public class LowCopy implements Cloneable{
    private String name;
    private String description;
    private LowCopySon lowCopySon;

    public LowCopy() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LowCopySon getLowCopySon() {
        return lowCopySon;
    }

    public void setLowCopySon(LowCopySon lowCopySon) {
        this.lowCopySon = lowCopySon;
    }

    /**
     * 浅拷贝1，SonarLint不推荐使用
     * @return
     */
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    /**
     * 浅拷贝2，通过构造函数拷贝
     * @param lowCopy
     */
    public LowCopy(LowCopy lowCopy){
        this.name = lowCopy.name;
        this.description = lowCopy.description;
        this.lowCopySon = lowCopy.lowCopySon;
    }
}
