## 工厂模式

用工厂模式来替代new的主要原因是：

* 1、创建对象统一用工厂创建，方便修改

* 2、子类易于拓展

* 3、当构建一个对象需要附带一系列的动作、逻辑代码等，而这些大量代码尽量不放到构造函数中，把要做的事情解藕出来，因此在此处执行额外要做的事情

## 抽象工厂模式

抽象工厂模式，应用于模板一样的一系列产品的构建

        抽象工厂：品牌：Hp、Db
        产品：Hp鼠标、Hp键盘、Db鼠标、Db键盘

易于拓展：

* 当增加一个品牌QQ时，只需要增加一个QQ工厂实现类、QQ鼠标、QQ键盘

* 当增加一个产品耳机Head时，只需要增加Head接口及不同厂家的实现类DbHead、DbHead，及在抽象工厂中增加创建新产品的方法createHead

## 单例模式

* 简单模式，加载类时就加载出实例，多线程安全，没有加锁

* 静态内部类模式：静态内部类会被延迟加载，只有通过显式调用getInstance方法时，才会显式装载SingletonHolder类，从而实例化instance，同样多线程安全，没有加锁

* 双重锁模式：实例延迟加载，通过使用volatile修饰实例，保证多线程安全，在getInstance中使用synchronized的对象锁，保证创建实例时的同步锁

在使用单例模式创建实例时，推荐使用1，若明确需求要延迟加载再考虑2、3

## 建造者模式⭐️

建造者模式比较独立，将对象本身与构建过程解耦。使用多个简单的对象一步一步构建成一个复杂的对象。这种类型的设计模式属于创建型模式，提供了创建对象的最佳方式。一个Builder类会一步一步构造最终的对象。该Builder类是独立于其他对象的。

```java
public class NewMusic {
    private String writeWord;
    private String writeMusic;

    public NewMusic(Builder builder) {
        this.writeMusic = builder.writeMusic;
        this.writeWord = builder.writeWord;
    }

    protected static class Builder{
        private String writeWord;
        private String writeMusic;

        protected Builder composer(String composer){
            this.writeMusic = composer;
            return this;
        }

        protected Builder writer(String writer){
            this.writeWord = writer;
            return this;
        }

        protected NewMusic build(){
            return new NewMusic(this);
        }
    }
}
```

`NewMusic newMusic = new NewMusic.Builder().composer("chenshinan").writer("jaychou").build();`