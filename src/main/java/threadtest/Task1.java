package threadtest;

import java.util.concurrent.Callable;

/**
 * Something that does something that takes a while
 */
public class Task1 implements Callable<Integer> {
    private int repetitions;
    private long delay;
    private String message;

    public Task1(int repetitions, long delay, String message) {
        this.repetitions = repetitions;
        this.delay = delay;
        this.message = message;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0 ; i < repetitions ; i++) {
            System.out.println(message);
            Thread.sleep(delay);
        }

        return repetitions;
    }
}
