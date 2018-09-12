package com.chenshinan.designpattern.C12Flyweight;

import lombok.Getter;
import lombok.Setter;

/**
 * 缓存配置信息
 * @author shinan.chen
 * @date 2018/9/12
 */
@Getter
@Setter
public class CacheInfo {
    /**
     * 对象被缓存的时间
     */
    private Long beginTime;
    /**
     * 对象最长未使用时间，到这个值就会清除缓存
     */
    private Long durableTime;
    /**
     * 是否永久存储
     */
    private Boolean isPersist;
    /**
     * 使用次数
     */
    private int count;

    public CacheInfo(Long beginTime, Long durableTime, Boolean isPersist, int count) {
        this.beginTime = beginTime;
        this.durableTime = durableTime;
        this.isPersist = isPersist;
        this.count = count;
    }
}
