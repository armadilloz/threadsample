package threadtest;

import java.util.concurrent.Callable;

/**
 * Increment and print integer value from a thread
 */
public class Task2 implements Callable<Integer> {
    private int repetitions;
    private long delay;
    private AtomicCounter counter;
    private int inc;

    public Task2(int repetitions, long delay, AtomicCounter counter, int inc) {
        this.repetitions = repetitions;
        this.delay = delay;
        this.counter = counter;
        this.inc = inc;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0 ; i < repetitions ; i++) {
            System.out.println(counter.increment(inc));
            Thread.sleep(delay);
        }

        return repetitions;
    }
}
