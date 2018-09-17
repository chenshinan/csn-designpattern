package com.chenshinan.designpattern.C15Command;

/**
 * @author shinan.chen
 * @date 2018/9/17
 */
public class CommandMain {
    public static void main(String[] args){
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);

        invoker.runCommand();
        /**
         * 命令模式的关键之处就是把请求封装成为对象，也就是命令对象，并定义了统一的执行操作的接口，
         * 这个命令对象可以被存储、转发、记录、处理、撤销等，整个命令模式都是围绕这个对象在进行。
         * 例如参数化配置、可撤销操作、宏命令、队列请求、日志请求等功能处理
         */
    }
}
