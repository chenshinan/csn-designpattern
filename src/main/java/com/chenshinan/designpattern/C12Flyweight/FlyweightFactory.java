package com.chenshinan.designpattern.C12Flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shinan.chen
 * @date 2018/9/12
 */

/**
 * 享元工厂，通常实现成为单例
 */
public class FlyweightFactory {
    private static FlyweightFactory factory = new FlyweightFactory();

    public static FlyweightFactory getFactory(){
        return factory;
    }

    /**
     * 缓存多个flyweight对象
     */
    private Map<String, Flyweight> map = new HashMap<>();

    /**
     * 获取key对应的享元对象
     */
    public Flyweight getFlyweight(String key){
        Flyweight flyweight = map.get(key);
        if(flyweight==null){
            flyweight = new AuthorizationFlyweight(key);
            map.put(key,flyweight);
        }
        return  flyweight;
    }
}
