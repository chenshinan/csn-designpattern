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

## 过滤器模式：Filter Pattern

这种模式允许开发人员使用不同的标准来过滤一组对象，通过逻辑运算以解耦的方式把它们连接起来。这种类型的设计模式属于结构型模式，它结合多个标准来获得单一标准。

过滤器模式只是一种设计思路，使得代码结构更清晰更好维护，就目前这些功能来说java8提供的stream处理起来更方便

## 组合模式：Composite Pattern

组合模式通过把叶子对象当成特殊的组合对象看待，从而对叶子对象和组合对象一视同仁，统统当成了Component对象，有机的统一了叶子对象和组合对象。

正是因为统一了叶子对象和组合对象，在将对象构建成树形结构的时候，才不需要做区分，反正是组件对象里面包含其它的组件对象，如此递归下去；也才使得对于树形结构的操作变得简单，不管对象类型，统一操作。

`适用于`：含有多层级关系的数据，访问时需要统一进行操作，例如：文件夹/文件、服装/商品

## 装饰器模式：Decorator Pattern

装饰模式能够实现动态的为对象添加功能，是从一个对象外部来给对象增加功能，相当于是改变了对象的外观。当装饰过后，从外部使用系统的角度看，就不再是使用原始的那个对象了，而是使用被一系列的装饰器装饰过后的对象。这样就能够灵活的改变一个对象的功能，只要动态组合的装饰器发生了改变，那么最终所得到的对象的功能也就发生了改变。变相的还得到了另外一个好处，那就是装饰器功能的复用，可以给一个对象多次增加同一个装饰器，也可以用同一个装饰器装饰不同的对象。

装饰器实现了对被装饰对象的某些装饰功能，可以在装饰器里面调用被装饰对象的功能，获取相应的值，这其实是一种递归调用。装饰器是用来装饰组件的，装饰器一定要实现和组件类一致的接口，保证它们是同一个类型，并具有同一个外观，这样组合完成的装饰才能够递归的调用下去。

`装饰模式与适配器模式`（它们有一个共同的别名：Wrapper）：这两个模式功能上是不一样的，适配器模式是用来改变接口的，而装饰模式是用来改变对象功能的。一句话区别：`装饰模式是一个接口两个类，适配器模式是两个接口一个类`

## 外观模式：Facade Pattern

外观模式，封装内部复杂的方法调用，给客户端提供一个简单调用入口，松散了客户端与子系统的耦合关系，让子系统内部的模块能更容易扩展和维护，对于一个子系统而言，外观类不需要很多，通常可以实现成为一个单例，Facade的方法本身并不进行功能的处理，Facade的方法的实现只是实现一个功能的组合调用，外观模式很好的体现了“最少知识原则”

简单例子：电脑整机是 CPU、内存、硬盘的外观。有了外观以后，启动电脑和关闭电脑都简化了

`适用于`：子系统调用复杂，通过外观类提供给客户端简单的调用接口（有点类似controller层）

## 享元模式：Flyweight Pattern

享元模式，真正应该被缓存的数据是那些不变且重复出现的数据，把它们称为对象的`内部状态`，而那些变化的数据就不缓存了，把它们称为对象的`外部状态`。在享元模式中，为了创建和管理共享的享元部分，引入了享元工厂，享元工厂中一般都包含有享元对象的实例池，享元对象就是缓存在这个实例池中的。内部状态和外部状态是独立的，外部状态的变化不应该影响到内部状态，但可以和内部状态封装成一个新的对象。在享元模式中，通常是在第一次向享元工厂请求获取共享对象的时候，进行共享对象的初始化，而且多半都是在享元工厂内部实现，不会从外部传入共享对象。

demo中加入了缓存的引用次数和垃圾回收

`适用于`：如果由于使用大量包含相同元素（内部状态）的对象，造成很大的存储开销，可以使用享元模式来减少对象实例数量，节约内存

## 代理模式⭐️：Proxy Pattern

代理模式是通过创建一个代理对象，用这个代理对象去代表真实的对象，客户端得到这个代理对象过后，对客户端没有什么影响，就跟得到了真实对象一样来使用。当客户端操作这个代理对象的时候，实际上功能最终还是会由真实的对象来完成，只不过是通过代理操作的，也就是客户端操作代理，代理操作真正的对象

代理模式，由于一开始只查询部分属性，之后又要查看每一条详情而导致的1+N次查询，因此适用的场景是详情查的次数少的。Hibernate的Lazy Load就是使用代理来实现的，原理是一样的。

代理模式的本质：控制对象访问。代理模式通过代理目标对象，把代理对象插入到客户和目标对象之间，从而为客户和目标对象引入一定的间接性，正是这个间接性，给了代理对象很多的活动空间

通常把自己实现的代理模式，称为`Java的静态代理`,使用Java内建的对代理模式支持的功能来实现的代理称为`Java的动态代理`,Java的动态代理目前只能代理接口，基本的实现是依靠Java的反射机制和动态生成class的技术，来动态生成被代理的接口的实现对象。如果要实现类的代理，可以使用cglib。java反射就是在运行时动态获取类的信息，方法，构造方法等信息。可以加载一个在运行时才确定其名称信息的类，并确定该类的基本信息

`适用于`：

        需要为一个对象在不同的地址空间提供局部代表的时候，可以使用远程代理；
        需要按照需要创建开销很大的对象的时候，可以使用虚代理；
        需要控制对原始对象的访问的时候，可以使用保护代理；
        需要在访问对象的时候执行一些附加操作的时候，可以使用智能指引代理
        
## 责任链模式：Chain Of Responsebility Pattern

责任链模式，使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。

首先职责链模式会定义一个所有处理请求的对象都要继承实现的抽象类，这样就有利于随时切换新的实现；其次每个处理请求对象只实现业务流程中的一步业务处理，这样使其变得简单；最后职责链模式会动态的来组合这些处理请求的对象

`标准链`是当找到合适的接收者处理后就停止了，`功能链`是一个请求在职责链中传递，每个职责对象负责处理请求的某一方面的功能，处理完成后，不是停止，而是继续向下传递请求，当请求通过很多职责对象处理过后，功能也就处理完了

`适用于`：

        如果有多个对象可以处理同一个请求，但是具体由哪个对象来处理该请求，是运行时刻动态确定的。这种情况可以使用职责链模式
        如果你想在不明确指定接收者的情况下，向多个对象中的一个提交一个请求的话，可以使用职责链模式
        如果想要动态指定处理一个请求的对象集合，可以使用职责链模式，职责链模式能动态的构建职责链eeee

`相似`：功能与装饰模式相似，但应用场景不同

## 命令模式：Command Pattern

> Client -> Invoker -> Command -> Receiver

命令模式的关键之处就是把请求封装成为对象，也就是命令对象，并定义了统一的执行操作的接口，这个命令对象可以被存储、转发、记录、处理、撤销等，整个命令模式都是围绕这个对象在进行。`例如参数化配置、可撤销操作、宏命令、队列请求、日志请求等功能处理`

在标准的命令模式里面，命令的实现类是没有真正实现命令要求的功能的，真正执行命令的功能的是接收者。如果命令的实现对象比较智能，它自己就能真实地实现命令要求的功能，而不再需要调用接收者，那么这种情况就称为智能命令

* `参数化配置`：可以用不同的命令对象，去参数化配置客户的请求

* `可撤销操作`：放弃该操作，回到未执行该操作前的状态`（两种思路：一种是补偿式，又称反操作式，另一种是存储恢复式）`

* `宏命令`：简单点说就是包含多个命令的命令，是一个命令的组合。`举个例子，就像是进饭店点菜，点了许多菜之后厨师才开始做菜`

* `队列请求`：就是对命令对象进行排队，组成工作队列，然后依次取出命令对象来执行

### 优点

* 降低耦合，调用者和接收者都不知道彼此

* 把请求封装，更方便控制

`适用于`：

        如果需要抽象出需要执行的动作，并参数化这些对象，可以选用命令模式，把这些需要执行的动作抽象成为命令，然后实现命令的参数化配置
        如果需要在不同的时刻指定、排列和执行请求，可以选用命令模式，把这些请求封装成为命令对象，然后实现把请求队列化
        如果需要支持取消操作，可以选用命令模式
        如果需要支持当系统崩溃时，能把对系统的操作功能重新执行一遍，可以选用命令模式
        在需要事务的系统中，可以选用命令模式
        
## 解释器模式：Interpreter Pattern

解析器：指的是把描述客户端调用要求的表达式，经过解析，形成一个抽象语法树的程序，不是指xml的解析器。

解释器：解析完成后，自动调用解释器来解释抽象语法树，并执行每个节点所对应的功能，从而完成通用的xml解析。`解释中的上下文context对象中有要解释的对象`

对于抽象的语法树这个树状结构，很明显可以使用组合模式来构建。解释器模式把需要解释的对象分成了两大类，一类是节点元素，就是可以包含其它元素的组合元素，比如非终结符元素，对应成为组合模式的Composite；另一类是终结符元素，相当于组合模式的叶子对象。解释整个抽象语法树的过程，也就是执行相应对象的功能的过程。

解释器模式使用解释器对象来表示和处理相应的语法规则，一般一个解释器处理一条语法规则

上下文在解释器模式中起到非常重要的作用，由于上下文会被传递到所有的解释器中，因此可以在上下文中存储和访问解释器的状态，比如前面的解释器可以存储一些数据在上下文中，后面的解释器就可以获取这些值。上下文还有一个功能，就是可以提供所有解释器对象的公共功能

解释器模式根据需求给定一个`表达式`（例如：root/a/b/c.name），将表达式解析成一个由解释器组成的`抽象语法树`，一个解释器对象处理一个语法规则的方式，把复杂的功能分离开；然后再按照抽象语法树传入`上下文`（上下文包含要解释的对象）来解释执行，实现相应的功能

`适用于`：

        当有一个语言需要解释执行，并且可以将该语言中的句子表示为一个抽象语法树的时候，可以考虑使用解释器模式。
        在使用解释器模式的时候，还有两个特点需要考虑，一个是语法相对应该比较简单，太复杂的语法不合适使用解释器模式；另一个是效率要求不是很高，对效率要求很高的情况下，不适合使用解释器模式

## 迭代器模式：Iterator Pattern

迭代器模式：提供一种方法顺序访问一个聚合对象中各个元素，而又不需要爆了该对象的内部表示

迭代器模式在实际开发中是很有用的，比如在实际开发中很常用的翻页功能的实现，可以采用`纯数据库实现 + 纯内存实现`，思路是这样的：如果每页显示10条记录，根据判断，用户很少翻到10页过后，那好了，第一次访问的时候，就一次性从数据库中获取前10页的数据，也就是100条记录，把这100条记录放在内存里面

`迭代器模式把聚合对象和访问聚合的机制实现了分离`，所以可以在迭代器上实现不同的`迭代策略`，最为典型的就是实现过滤功能的迭代器

`适用于`：

        如果你希望提供访问一个聚合对象的内容，但是又不想暴露它的内部表示的时候，可以使用迭代器模式来提供迭代器接口，从而让客户端只是通过迭代器的接口来访问聚合对象，而无需关心聚合对象内部实现。
        如果你希望有多种遍历方式可以访问聚合对象，可以使用迭代器模式。
        如果你希望为遍历不同的聚合对象提供一个统一的接口，可以使用迭代器模式
        如果你希望有多种迭代策略
        
## 中介者模式：Mediator Pattern

中介者模式：用一个中介对象来封装一系列的对象交互。中介者使得各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互

同事类：对于中介对象而言，所有相互交互的对象，被视为同事类，中介对象就是来维护各个同事之间的关系，而所有的同事类都只是和中介对象交互

定义：如果一个对象的操作会引起其它相关对象的变化，或者是某个操作需要引起其它对象的后续或连带操作，而这个对象又不希望自己来处理这些关系，那么就可以找中介者，把所有的麻烦扔给它，只在需要的时候通知中介者，其它的就让中介者去处理就可以了。反过来，其它的对象在操作的时候，可能会引起这个对象的变化，也可以这么做。最后对象之间就完全分离了，谁都不直接跟其它对象交互，那么相互的关系，全部被集中到中介者对象里面了，所有的对象就只是跟中介者对象进行通信，相互之间不再有联系。

优缺点：把所有对象之间的交互都封装在中介者当中，无形中还得到另外一个好处，就是能够集中的控制这些对象的交互关系，这样有什么变化的时候，修改起来就很方便.中介者模式的一个潜在缺点是，如果同事对象的交互非常多，而且比较复杂，当这些复杂性全部集中到中介者的时候，会导致中介者对象变得十分的复杂，而且难于管理和维护

> 如何实现同事和中介者的通信?

* 一种实现方式是在Mediator接口中定义一个特殊的通知接口，作为一个通用的方法，让各个同事类来调用这个方法

* 另外一种实现方式是可以采用观察者模式，把Mediator实现成为观察者，而各个同事类实现成为Subject，这样同事类发生了改变，会通知Mediator

在`标准的中介者模式`中，把使用中介者对象来交互的那些对象称为同事类，这不是乱叫的，`在中介者模式中，要求这些类都要继承相同的类`，也就是说，这些对象从某个角度讲是同一个类型，算是兄弟对象

`广义中介者`：只要是实现封装对象之间的交互功能，就可以应用上中介者模式，而`不必过于拘泥于中介者模式本身的结构`，标准的中介者模式限制很多，导致能完全按照标准使用中介者模式的地方并不是很多，而且多集中在界面实现上。只要本质不变，稍稍变形一下，简化一下，或许能更好的使用中介者模式

`适用于`：

        如果一组对象之间的通信方式比较复杂，导致相互依赖、结构混乱，可以采用中介者模式，把这些对象相互的交互管理起来，各个对象都只需要和中介者交互，从而使得各个对象松散耦合，结构也更清晰易懂。
        如果一个对象引用很多的对象，并直接跟这些对象交互，导致难以复用该对象。可以采用中介者模式，把这个对象跟其它对象的交互封装到中介者对象里面，这个对象就只需要和中介者对象交互就可以了
        
## 备忘录模式：Memento Pattern

在不破坏封装性的前提下，捕获一个对象的内部状态，并在改对象之外保存这个状态，这样以后就可将该对象恢复到原先保存的状态

`备忘录对象`：通常就是用来记录原发器需要保存的状态的对象，为了与外部交互，通常备忘录对象都会实现一个`窄接口`，来标识对象的类型

`原发器对象`：就是需要被保存状态的对象，也是有可能需要恢复状态的对象

`备忘录对象`：主要是负责保存备忘录对象，管理者虽然能存取备忘录对象，但是不能访问备忘录对象内部的数据

`窄接口`：管理者只能看到备忘录的窄接口，窄接口的实现里面通常没有任何的方法，只是一个类型标识，窄接口使得管理者只能将备忘录传递给其它对象。

`宽接口`：原发器能够看到一个宽接口，允许它访问所需的所有数据，来返回到先前的状态。理想状况是：只允许生成备忘录的原发器来访问该备忘录的内部状态，通常实现成为原发器内的一个私有内部类

备忘录模式的标准实现方式：那就是窄接口没有任何的方法，把备忘录对象实现成为原发器对象的私有内部类

`适用于`：

        如果必须保存一个对象在某一个时刻的全部或者部分状态，这样在以后需要的时候，可以把该对象恢复到先前的状态
        如果需要保存一个对象的内部状态，但是如果用接口来让其它对象直接得到这些需要保存的状态，将会暴露对象的实现细节并破坏对象的封装性

`备忘录模式与命令模式`：命令模式实现中，在实现命令的撤销和重做的时候，可以使用备忘录模式，在命令操作的时候记录下操作前后的状态，然后在命令撤销和重做的时候，直接使用相应的备忘录对象来恢复状态就可以了

## 观察者模式⭐️：Observer Pattern

观察者模式：定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新

观察者模式的本质：`触发联动`

观察者模式把这多个订阅者称为观察者：`Observer`，多个观察者观察的对象被称为目标：`Subject`

`特点`：

* 观察者模式实现了观察者和目标之间的抽象耦合：

原本目标对象在状态发生改变的时候，需要直接调用所有的观察者对象，但是抽象出观察者接口过后，目标和观察者就只是在抽象层面上耦合了，也就是说目标只是知道观察者接口，并不知道具体的观察者的类，从而实现目标类和具体的观察者类之间解耦

* 观察者模式实现了动态联动：

当修改目标对象的状态的时候，就会触发相应的通知，然后会循环调用所有注册的观察者对象的相应方法，其实就相当于联动调用这些观察者的方法

* 观察者模式支持广播通信：

由于目标发送通知给观察者是面向所有注册的观察者，所以每次目标通知的信息就要对所有注册的观察者进行广播。当然，也可以通过在目标上添加新的功能来限制广播的范围

`推模型与推模型`：

* 推模型：目标对象主动向观察者推送目标的详细信息，不管观察者是否需要，推送的信息通常是目标对象的全部或部分数据，相当于是在广播通信。

* 拉模型：目标对象在通知观察者的时候，只传递少量信息，如果观察者需要更具体的信息，由观察者主动到目标对象中获取，相当于是观察者从目标对象中拉数据

`使用java自带的接口实现观察者模式`：

* 被观察者：extends Observable

```java
//注意在用Java中的Observer模式的时候，下面这句话不可少
this.setChanged();
//然后主动通知，这里用的是推的方式
this.notifyObservers(this.content);
```

* 观察者：impliments Observer

```java
@Override
public void update(Observable o, Object obj) {
        ...
}
```

`使用RxJava实现的观察者模式`：

```java
Observable.just("本期内容是观察者模式")//创建上游 observable
                .subscribe(new Observer<String>() {//创建下游 observer

                    private String name = "小明";

                    @Override
                    public void onSubscribe(Disposable disposable) {
                    }

                    @Override
                    public void onNext(String value) {
                        System.out.println(name + "收到报纸了，阅读内容是：" + value);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("完成");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("error");
                    }
                });
```

`适用于`：

        当一个抽象模型有两个方面，其中一个方面的操作依赖于另一个方面的状态变化，那么就可以选用观察者模式
        如果在更改一个对象的时候，需要同时连带改变其它的对象，而且不知道究竟应该有多少对象需要被连带改变，这种情况可以选用观察者模式
        当一个对象必须通知其它的对象，但是你又希望这个对象和其它被它通知的对象是松散耦合的，也就是说这个对象其实不想知道具体被通知的对象，这种情况可以选用观察者模式

`观察者模式与状态模式`：观察者模式是当目标状态发生改变时，触发并通知观察者，让观察者去执行相应的操作。而状态模式是根据不同的状态，选择不同的实现，这个实现类的主要功能就是针对状态的相应的操作