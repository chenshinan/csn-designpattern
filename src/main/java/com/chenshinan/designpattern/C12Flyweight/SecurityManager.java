package com.chenshinan.designpattern.C12Flyweight;

import java.util.*;

/**
 * @author shinan.chen
 * @date 2018/9/12
 */
public class SecurityManager {
    private static SecurityManager manager = new SecurityManager();

    public static SecurityManager getManager() {
        return manager;
    }

    /**
     * 在运行期间，用来存放登录人员对应的权限，
     * 在Web应用中，这些数据通常会存放到session中
     */
    private List<User> memoryUsers = new ArrayList<>();

    /**
     * 从数据库中获取某人所拥有的权限
     */
    private Collection<Flyweight> queryByUser(String user) {
        Collection<Flyweight> col = new ArrayList<>();
        for (String s : TestDB.colDB) {
            String ss[] = s.split(",");
            if (ss[0].equals(user)) {
                Flyweight fm = FlyweightFactory.getFactory().getFlyweight(ss[1] + "," + ss[2]);
                col.add(fm);
            }
        }
        return col;
    }

    public void login(String user){
        Collection<Flyweight> flyweights = queryByUser(user);
        memoryUsers.add(new User(user,flyweights));
    }

    public void showMemory(){
        for(User userData:memoryUsers){
            userData.showMemory();
        }
    }
}
