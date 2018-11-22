package threadtest;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private Integer nonAtomicCounter = 0;
    private AtomicInteger counter = new AtomicInteger(0);

    public int increment(int inc) {
        synchronized (nonAtomicCounter) {
            int temp = nonAtomicCounter;
            nonAtomicCounter = temp + inc;
        }
        return counter.addAndGet(inc);

    }

    public int getAtomicValue() {
        return counter.get();
    }

    public int getNonAtomicValue() {
        return nonAtomicCounter;
    }
}
