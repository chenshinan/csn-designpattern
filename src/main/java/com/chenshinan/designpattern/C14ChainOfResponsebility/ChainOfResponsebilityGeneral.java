package com.chenshinan.designpattern.C14ChainOfResponsebility;

/**
 * @author shinan.chen
 * @date 2018/9/15
 */
public class ChainOfResponsebilityGeneral {
}

abstract class AbstractLoggerGeneral {
    static int INFO = 1;
    static int INFO_ADD = 11;
    static int DEBUG = 2;
    static int ERROR = 3;
    protected int level;
    private AbstractLoggerGeneral nextProcesser;

    public void setNextProcesser(AbstractLoggerGeneral nextProcesser) {
        this.nextProcesser = nextProcesser;
    }

    protected abstract void showMessage(String message);

    public void logMessage(int level, String message) {
        if (level >= this.level) {
            showMessage(message);
        }
        if (nextProcesser != null) {
            nextProcesser.logMessage(level, message);
        }

    }
}

class InfoLoggerGeneral extends AbstractLoggerGeneral {
    public InfoLoggerGeneral(int level) {
        this.level = level;
    }

    @Override
    protected void showMessage(String message) {
        System.out.println("Info level: " + message);
    }
}

class InfoLoggerGeneralAdditional extends InfoLoggerGeneral {

    public InfoLoggerGeneralAdditional(int level) {
        super(level);
    }

    public void logMessage(int level, String message) {
        if (level == AbstractLoggerGeneral.INFO_ADD) {
            showAddMessage(message);
        } else {
            super.logMessage(level, message);
        }
    }

    protected void showAddMessage(String message) {
        System.out.println("Info level add: " + message);
    }
}