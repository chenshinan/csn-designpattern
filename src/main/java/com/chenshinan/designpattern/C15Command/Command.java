package com.chenshinan.designpattern.C15Command;

/**
 * @author shinan.chen
 * @date 2018/9/17
 */

/**
 * 命令接口，声明执行的操作
 */
interface Command {
    /**
     * 执行命令对应的操作
     */
    void execute();
}

/**
 * 具体的命令实现对象
 */
class ConcreteCommand implements Command{
    /**
     * 持有相应的接收者对象
     */
    private Receiver receiver;
    /**
     * 示意，命令对象可以有自己的状态
     */
    private String status;

    /**
     * 构造方法，传入相应的接收者对象
     * @param receiver
     */
    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //通常会转调接收者对象的相应方法，让接收者来真正执行功能
        this.receiver.action();
    }
}

/**
 * 接收者对象
 */
class Receiver{
    private String name;
    /**
     * 示意方法，真正执行命令相应的操作
     */
    public void action(){
        //真正执行命令操作的功能代码
        System.out.println("do action");
    }
}

/**
 * 调用者
 */
class Invoker{
    /**
     * 持有命令对象
     */
    private Command command = null;

    /**
     * 设置调用者持有的命令对象
     * @param command
     */
    public void setCommand(Command command){
        this.command = command;
    }

    /**
     * 示意方法，要求命令执行请求
     */
    public void runCommand(){
        if(command!=null){
            //调用命令对象的执行方法
            command.execute();
        }
    }
}

/**
 * 客户端，负责组装这些休息，此处并没有执行
 */
class Client {
    /**
     * 示意，负责创建命令对象，并设定它的接收者
     */
    public void assemble(){
        //创建接收者
        Receiver receiver = new Receiver();
        //创建命令对象，设定它的接收者
        Command command = new ConcreteCommand(receiver);
        //创建Invoker，把命令对象设置进去
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
    }
}