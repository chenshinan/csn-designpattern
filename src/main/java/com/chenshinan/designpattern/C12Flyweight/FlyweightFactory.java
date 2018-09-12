package com.chenshinan.designpattern.C12Flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shinan.chen
 * @date 2018/9/12
 */

/**
 * 享元工厂，通常实现成为单例
 */
public class FlyweightFactory {

    private static final Logger logger = LoggerFactory.getLogger(FlyweightFactory.class);

    private static FlyweightFactory factory = new FlyweightFactory();

    public FlyweightFactory() {
        //创建工厂时开启跑清理缓存的线程
        Thread cleanCache = new Thread(new ClearCacheTask());
        cleanCache.start();
    }

    public static FlyweightFactory getFactory() {
        return factory;
    }

    /**
     * 缓存多个flyweight对象
     */
    private Map<String, Flyweight> map = new HashMap<>();

    /**
     * 缓存信息
     */
    private Map<String, CacheInfo> cacheInfoMap = new HashMap<>();

    /**
     * 默认最长未使用时间
     */
    private final Long DURABLE_TIME = 5 * 1000L;

    /**
     * 获取key对应的享元对象
     */
    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = map.get(key);
        if (flyweight == null) {
            flyweight = new AuthorizationFlyweight(key);
            map.put(key, flyweight);
            //存储缓存信息
            CacheInfo cacheInfo = new CacheInfo(System.currentTimeMillis(), DURABLE_TIME, false, 0);
            cacheInfoMap.put(key, cacheInfo);
        } else {
            //获取到缓存对象，计数+1，beginTime重制
            CacheInfo cacheInfo = cacheInfoMap.get(key);
            cacheInfo.setCount(cacheInfo.getCount() + 1);
            cacheInfo.setBeginTime(System.currentTimeMillis());
            cacheInfoMap.put(key, cacheInfo);
        }
        return flyweight;
    }

    /**
     * 清除缓存对象和配置信息
     */
    public void removeFlyweight(String key) {
        map.remove(key);
        cacheInfoMap.remove(key);
    }

    /**
     * 独立线程，循环检查缓存配置
     */
    public class ClearCacheTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                List<String> cleanKeys = new ArrayList<>();
                for (Map.Entry<String, CacheInfo> entry : cacheInfoMap.entrySet()) {
                    CacheInfo cacheInfo = entry.getValue();
                    if (System.currentTimeMillis() - cacheInfo.getBeginTime() > cacheInfo.getDurableTime()) {
                        //先记录起来
                        cleanKeys.add(entry.getKey());
                    }
                }
                //清理缓存
                for (String key : cleanKeys) {
                    removeFlyweight(key);
                }

                logger.info("ClearCacheTask has {} cache,info:{}", cacheInfoMap.size(), cacheInfoMap.entrySet());

                try {
                    //休息1s
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
