package com.chenshinan.designpattern.C14ChainOfResponsebility;

/**
 * @author shinan.chen
 * @date 2018/9/15
 */
public class ChainOfResonsebilityMain {
    public static void main(String[] args) {
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);

        infoLogger.setNextProcesser(debugLogger);
        debugLogger.setNextProcesser(errorLogger);

        System.out.println("————————————————level info————————————————");
        infoLogger.logMessage(AbstractLogger.INFO, "时间");
        System.out.println("————————————————level debug————————————————");
        infoLogger.logMessage(AbstractLogger.DEBUG, "誓言");
        System.out.println("————————————————level error————————————————");
        infoLogger.logMessage(AbstractLogger.ERROR, "祈祷");

        System.out.println("===========================================");
        /**
         * 拓展继承方式，通过继承InfoLoggerGeneral的方式拓展新功能
         */
        AbstractLoggerGeneral infoLoggerGeneral = new InfoLoggerGeneralAdditional(AbstractLoggerGeneral.INFO);
        infoLoggerGeneral.logMessage(AbstractLoggerGeneral.INFO,"时间");

        System.out.println("————————————————level info add—————————————");
        AbstractLoggerGeneral infoLoggerGeneralAdd = new InfoLoggerGeneralAdditional(AbstractLoggerGeneral.INFO_ADD);
        infoLoggerGeneralAdd.logMessage(AbstractLoggerGeneral.INFO_ADD,"时间");
    }
}
