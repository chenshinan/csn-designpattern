package com.chenshinan.designpattern.C14ChainOfResponsebility;

/**
 * @author shinan.chen
 * @date 2018/9/15
 */
public class ChainOfResponsebility {
}

abstract class AbstractLogger {
    static int INFO = 1;
    static int DEBUG = 2;
    static int ERROR = 3;
    protected int level;
    private AbstractLogger nextProcesser;

    public void setNextProcesser(AbstractLogger nextProcesser) {
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

class InfoLogger extends AbstractLogger {
    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void showMessage(String message) {
        System.out.println("Info level: " + message);
    }
}

class DebugLogger extends AbstractLogger {
    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void showMessage(String message) {
        System.out.println("Debug level: " + message);
    }
}

class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void showMessage(String message) {
        System.out.println("Error level: " + message);
    }
}