package com.chenshinan.designpattern.C1Factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shinan.chen
 * @date 2018/8/27
 */
public class Doctor implements Person {

    private static final Logger LOGGER = LoggerFactory.getLogger(Doctor.class);

    @Override
    public void work() {
        LOGGER.info("doctor doing diagnose");
    }
}
