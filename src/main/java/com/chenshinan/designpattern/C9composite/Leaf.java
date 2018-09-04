package com.chenshinan.designpattern.C9composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shinan.chen
 * @date 2018/9/4
 */
public class Leaf extends Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void printName(String pre) {
        System.out.println(pre+name);
    }
}
