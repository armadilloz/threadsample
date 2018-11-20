package threadtest;

import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {
    private int repetitions;
    private long delay;
    private String message;

    public Task(int repetitions, long delay, String message) {
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
