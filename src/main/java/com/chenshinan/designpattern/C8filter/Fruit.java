package com.chenshinan.designpattern.C8filter;

import java.util.ArrayList;
import java.util.List;

class Fruit{
    private String name;
    private String taste;
    private String shape;
    Fruit(String name,String taste,String shape){
        this.name=name;
        this.taste=taste;
        this.shape=shape;
    }
    public String getName() {
        return name;
    }

    public String getTaste() {
        return taste;
    }

    public String getShape() {
        return shape;
    }


}

interface Criteria{
    public List<Fruit> meetCriteria(List<Fruit> allfruit);
}

class CriteriaName implements Criteria{

    @Override
    public List<Fruit> meetCriteria(List<Fruit> allfruit) {
        List<Fruit> oranges=new ArrayList<>();
        for(Fruit fruit:allfruit){
            if(fruit.getName()=="橘子"){
                oranges.add(fruit);
            }
        }
        return oranges;
    }

}

class CriteriaTaste implements Criteria{

    @Override
    public List<Fruit> meetCriteria(List<Fruit> allfruit) {
        List<Fruit> sweetfruit=new ArrayList<Fruit>();
        for(Fruit fruit:allfruit){
            if(fruit.getTaste()=="甜的"){
                sweetfruit.add(fruit);
            }
        }
        return sweetfruit;
    }

}

class CriteriaShape implements Criteria{

    @Override
    public List<Fruit> meetCriteria(List<Fruit> allfruit) {
        List<Fruit> circlefruit=new ArrayList<Fruit>();
        for(Fruit fruit:allfruit){
            if(fruit.getShape()=="圆形"){
                circlefruit.add(fruit);
            }
        }
        return circlefruit;
    }

}

class AndCriteria implements Criteria{      //多重过滤器类
    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria,Criteria otherCriteria){
        this.criteria=criteria;
        this.otherCriteria=otherCriteria;
    }


    @Override
    public List<Fruit> meetCriteria(List<Fruit> allfruit) {
        List<Fruit>  firstCriteriafruit=criteria.meetCriteria(allfruit);    //生成新的容器放置第一重过滤
        return otherCriteria.meetCriteria(firstCriteriafruit);              //第二重过滤
    }

}

class OrCriteria implements Criteria{
    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria,Criteria otherCriteria){
        this.criteria=criteria;
        this.otherCriteria=otherCriteria;
    }


    @Override
    public List<Fruit> meetCriteria(List<Fruit> allfruit) {
        List<Fruit>  firstCriteriaItems=criteria.meetCriteria(allfruit);        //第一重过滤放置一个新容器内
        List<Fruit>  otherCriteriaItems=otherCriteria.meetCriteria(allfruit);   //仍是第一重过滤放置一个新容器内
        for(Fruit fruit:otherCriteriaItems){                                    //对第二个新容器遍历
            if(!firstCriteriaItems.contains(fruit)){                            //对比第一个容器内的对象
                firstCriteriaItems.add(fruit);
            }
        }
        return firstCriteriaItems;
    }

}