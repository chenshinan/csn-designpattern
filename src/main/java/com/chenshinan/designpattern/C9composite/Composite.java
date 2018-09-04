package com.chenshinan.designpattern.C9composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shinan.chen
 * @date 2018/9/4
 */
public class Composite extends Component {
    private String name;
    private List<Component> childs;

    public Composite(String name) {
        this.name = name;
        this.childs = new ArrayList<>();
    }

    @Override
    public void addChild(Component component) {
        childs.add(component);
        component.setParent(this);
    }

    @Override
    public void removeChild(Component component) {
        childs.remove(component);

        List<Component> cchilds = component.getChild();
        for(Component cchild:cchilds){
            cchild.setParent(this);
            getChild().add(cchild);
        }

    }

    @Override
    public List<Component> getChild(){
        return childs;
    }

    @Override
    public void printName(String pre) {
        System.out.println(pre+name);
        for(Component child:getChild()){
            child.printName("————"+pre);
        }
    }
}
