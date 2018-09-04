package com.chenshinan.designpattern.C9composite;

import java.util.List;

/**
 * @author shinan.chen
 * @date 2018/9/4
 */
public abstract class Component {
    private Component parent;
    public void addChild(Component component){
        throw new UnsupportedOperationException("不支持添加子集");
    }

    public void removeChild(Component component){
        throw new UnsupportedOperationException("不支持删除子集");
    }

    public List<Component> getChild(){
        throw new UnsupportedOperationException("不支持获取子集");
    }

    public void setParent(Component parent){
        this.parent = parent;
    }

    public abstract void printName(String pre);
}
