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

        System.out.println("level info————————————————");
        infoLogger.logMessage(AbstractLogger.INFO, "时间");
        System.out.println("level debug————————————————");
        infoLogger.logMessage(AbstractLogger.DEBUG, "誓言");
        System.out.println("level error————————————————");
        infoLogger.logMessage(AbstractLogger.ERROR, "祈祷");
    }
}
