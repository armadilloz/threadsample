package threadtest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Hello world!
 *
 */
public class App {

    private ExecutorService executor;

    public static void main(String[] args) {
        App app = new App();
        // app.run2();
        app.run2();
    }

    public App() {
        System.out.println("Starting");

        executor = Executors.newCachedThreadPool();
    }

    public void run1() {
        Task1 task1 = new Task1(10, 300, "Task1");
        Task1 task2 = new Task1(10, 300, "task2");
        Task1 task3 = new Task1(10, 300, "task3");

        Future<Integer> f1 = executor.submit(task1);
        Future<Integer> f2 = executor.submit(task2);
        Future<Integer> f3 = executor.submit(task3);

        try {
            while (!f1.isDone()) {
                System.out.println("waiting");
                Thread.sleep(100);
            }

            System.out.println("Finished f1 " + f1.get());
            System.out.println("Finished f2 " + f2.get());
            System.out.println("Finished f3 " + f3.get());
        } catch (Exception ex) {
            // nothing!
        }
    }

    public void run2() {
        try {
            AtomicCounter counter = new AtomicCounter();

            Task2 task1 = new Task2(10, 300, counter, 1);
            Task2 task2 = new Task2(10, 300, counter, 2);
            Task2 task3 = new Task2(10, 300, counter, 3);

            Future<Integer> f1 = executor.submit(task1);
            Future<Integer> f2 = executor.submit(task2);
            Future<Integer> f3 = executor.submit(task3);

            f1.get();
            f2.get();
            f3.get();

            System.out.println("Atomic counter is " + counter.getAtomicValue());
            System.out.println("Non Atomic counter is " + counter.getNonAtomicValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
