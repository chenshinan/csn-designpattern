## 工厂模式：Factory Pattern

用工厂模式来替代new的主要原因是：

* 1、创建对象统一用工厂创建，方便修改

* 2、子类易于拓展

* 3、当构建一个对象需要附带一系列的动作、逻辑代码等，而这些大量代码尽量不放到构造函数中，把要做的事情解藕出来，因此在此处执行额外要做的事情

## 抽象工厂模式：Abstract Factory Pattern

抽象工厂模式，应用于模板一样的一系列产品的构建

        抽象工厂：品牌：Hp、Db
        产品：Hp鼠标、Hp键盘、Db鼠标、Db键盘

易于拓展：

* 当增加一个品牌QQ时，只需要增加一个QQ工厂实现类、QQ鼠标、QQ键盘

* 当增加一个产品耳机Head时，只需要增加Head接口及不同厂家的实现类DbHead、DbHead，及在抽象工厂中增加创建新产品的方法createHead

## 单例模式：Singleton Pattern

* 简单模式，加载类时就加载出实例，多线程安全，没有加锁

* 静态内部类模式：静态内部类会被延迟加载，只有通过显式调用getInstance方法时，才会显式装载SingletonHolder类，从而实例化instance，同样多线程安全，没有加锁

* 双重锁模式：实例延迟加载，通过使用volatile修饰实例，保证多线程安全，在getInstance中使用synchronized的对象锁，保证创建实例时的同步锁

在使用单例模式创建实例时，推荐使用1，若明确需求要延迟加载再考虑2、3

## 建造者模式⭐️：Builder Pattern

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

`NewMusic newMusic = new NewMusic.Builder().composer("chenshinan").writer("jaychou").build()`

## 原型模式：ProtoType Pattern

针对于构建过程复杂、繁琐的对象，又有频繁创建实例的场景，可以考虑使用原型模式克隆出新实例，根据需求选择浅拷贝【通过构造函数】与深拷贝【通过序列化】

### 浅拷贝实现：复制对象，对象属性是同一个引用

* 实现Cloneable接口，重写clone方法

* 通过传入对象的构造函数【推荐】

### 深拷贝实现：复制对象，包括对象属性也是全新对象

* 序列号，实现Serializable接口，添加deepCopy方法，用流复制对象【推荐】

* 通过传入对象的构造函数，若有对象属性需要new，子对象需要实现同样的构造函数

## 适配器模式：Adapter Pattern

        类适配器：通过继承来实现适配器功能
        对象适配器：通过组合来实现适配器功能
        接口适配器：通过抽象类来实现适配，只需用到接口中的部分方法

类适配器与对象适配器的使用场景一致，仅仅是实现手段稍有区别，二者主要用于如下场景：

* 想要使用一个已经存在的类，但是它却不符合现有的接口规范，导致无法直接去访问，这时创建一个适配器就能间接去访问这个类中的方法。

* 我们有一个类，想将其设计为可重用的类（可被多处访问），我们可以创建适配器来将这个类来适配其他没有提供合适接口的类。

> 以上两个场景其实就是从两个角度来描述一类问题，那就是要访问的方法不在合适的接口里，一个从接口出发（被访问），一个从访问出发（主动访问）。

接口适配器使用场景：

* 想要使用接口中的某个或某些方法，但是接口中有太多方法，我们要使用时必须实现接口并实现其中的所有方法，可以使用抽象类来实现接口，并不对方法进行实现（仅置空），然后我们再继承这个抽象类来通过重写想用的方法的方式来实现。这个抽象类就是适配器

## 桥接模式：Bridge Pattern

桥接（Bridge）是用于把抽象化与实现化解耦，使得二者可以独立变化。这种模式涉及到一个作为桥接的接口，使得实体类的功能独立于接口实现类。这两种类型的类可被结构化改变而互不影响。`桥接模式将继承关系转化成关联关系，它降低了类与类之间的耦合度，减少了系统中类的数量，也减少了代码量`

> 桥接模式中的所谓脱耦，就是指在一个软件系统的抽象化和实现化之间使用关联关系（组合或者聚合关系）而不是继承关系，从而使两者可以相对独立地变化，这就是桥接模式的用意

例子中：可以使用相同的抽象类方法但是不同的桥接实现类，来画出不同颜色的图形