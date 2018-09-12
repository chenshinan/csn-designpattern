package com.chenshinan.designpattern.C12Flyweight;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shinan.chen
 * @date 2018/9/12
 */
@Setter
@Getter
public class AuthorizationFlyweight implements Flyweight {
    /**
     * 内部状态，安全实体
     */
    private String securityEntity;
    /**
     * 内部状态，权限
     */
    private String permit;

    public AuthorizationFlyweight(String key) {
        String[] keys = key.split(",");
        this.securityEntity = keys[0];
        this.permit = keys[1];
    }

    @Override
    public String show() {
        return "【"+securityEntity+","+permit+"】";
    }
}
