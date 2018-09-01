package com.chenshinan.designpattern.C5ProtoType;

import com.chenshinan.designpattern.C4Builder.Music;
import com.chenshinan.designpattern.C4Builder.MusicBuilder;
import com.chenshinan.designpattern.C4Builder.NewMusic;

/**
 * @author shinan.chen
 * @date 2018/9/1
 */
public class ProtoTypeMain {
    public static void main(String[] args) {

        /**
         * 两种浅拷贝实现：复制对象，对象属性是同一个引用
         */
        LowCopy lowCopy = new LowCopy();
        lowCopy.setName("name");
        lowCopy.setDescription("xx");
        lowCopy.setLowCopySon(new LowCopySon());

        //第一种：实现Cloneable接口，重写clone方法
        LowCopy newLowCopy1 = (LowCopy) lowCopy.clone();
        //第二种，通过传入对象的构造函数【推荐】
        LowCopy newLowCopy2 = new LowCopy(lowCopy);

        /**
         * 两种深拷贝实现：复制对象，包括对象属性也是全新对象
         */
        DeepCopy deepCopy = new DeepCopy();
        deepCopy.setName("name");
        deepCopy.setDescription("xx");
        deepCopy.setDeepCopySon(new DeepCopySon());

        //第一种：序列号，实现Serializable接口，添加deepCopy方法，用流复制对象【推荐】
        DeepCopy newDeepCopy1 = null;
        try {
            newDeepCopy1 = deepCopy.deepClone();
        }catch (Exception e){
            System.out.println("深拷贝失败");
        }
        //第二种，通过传入对象的构造函数，若有对象属性需要new，子对象需要实现同样的构造函数
        DeepCopy newDeepCopy2 = new DeepCopy(deepCopy);

        /**
         * 原型模式：针对于构建过程复杂、繁琐的对象，又有频繁创建实例的场景，
         * 可以考虑使用原型模式克隆出新实例，根据需求选择浅拷贝【通过构造函数】
         * 与深拷贝【通过序列化】
         */
        System.out.println("debug test");
    }
}
