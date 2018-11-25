package threadtest;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private Integer nonAtomicCounter = 0;
    private MyAtomicCounter myAtomicCounter = new MyAtomicCounter(0);
    private AtomicInteger counter = new AtomicInteger(0);

    public int increment(int inc) {
        // synchronized (nonAtomicCounter) {
            int temp = nonAtomicCounter;
            nonAtomicCounter = temp + inc;
        // }
        myAtomicCounter.add(inc);
        return counter.addAndGet(inc);

    }

    public int getMyAtomicValue() {
        return this.myAtomicCounter.getNum();
    }

    public int getAtomicValue() {
        return counter.get();
    }

    public int getNonAtomicValue() {
        return nonAtomicCounter;
    }
}

class MyAtomicCounter {
    private int num;

    MyAtomicCounter(int num) {
        this.num = num;
    }

    int getNum() {
        return this.num;
    }

    synchronized int add(int inc) {
        this.num += inc;
        return this.num;
    }

}