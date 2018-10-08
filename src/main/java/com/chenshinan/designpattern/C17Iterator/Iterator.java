package com.chenshinan.designpattern.C17Iterator;

/**
 * 迭代器接口，定义访问和遍历元素的操作
 *
 * @author shinan.chen
 * @date 2018/10/8
 */
public interface Iterator {
    /**
     * 移动到聚合对象的第一个位置
     */
    void first();

    /**
     * 移动到聚合对象的下一个位置
     */
    void next();

    /**
     * 判断是否已经移动到聚合对象的最后一个位置
     *
     * @return true表示已经移动到聚合对象的最后一个位置，
     * false表示还没有移动到聚合对象的最后一个位置
     */
    boolean isDone();

    /**
     * 获取迭代的当前元素
     *
     * @return 迭代的当前元素
     */
    Object currentItem();
}

/**
 * 具体迭代器实现对象，示意的是聚合对象为数组的迭代器
 * 不同的聚合对象相应的迭代器实现是不一样的
 */
class ConcreteIterator implements Iterator {
    /**
     * 持有被迭代的具体的聚合对象
     */
    private ConcreteAggregate aggregate;
    /**
     * 内部索引，记录当前迭代到的索引位置。
     * -1表示刚开始的时候，迭代器指向聚合对象第一个对象之前
     */
    private int index = -1;

    /**
     * 构造方法，传入被迭代的具体的聚合对象
     *
     * @param aggregate 被迭代的具体的聚合对象
     */
    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        if (index < this.aggregate.size()) {
            index = index + 1;
        }
    }

    @Override
    public boolean isDone() {
        if (index == this.aggregate.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Object currentItem() {
        return this.aggregate.get(index);
    }
}
