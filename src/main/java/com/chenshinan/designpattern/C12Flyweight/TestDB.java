package com.chenshinan.designpattern.C12Flyweight;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author shinan.chen
 * @date 2018/9/12
 */
/**
 * 供测试用，在内存中模拟数据库中的值
 */
public class TestDB {
    /**
     * 用来存放授权数据的值
     */
    public static Collection<String> colDB = new ArrayList<>();

    static {
        //通过静态块来填充模拟的数据
        colDB.add("陈一,人员列表,查看");
        colDB.add("陈二,人员列表,查看");
        colDB.add("陈二,薪资数据,查看");
        colDB.add("陈三,薪资数据,修改");
        colDB.add("陈四,人员列表,查看");
        colDB.add("陈五,人员列表,查看");
        colDB.add("陈六,人员列表,查看");
    }
}