package threadtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App {

    private ExecutorService executor;
    public static void main( String[] args )
    {
        App app = new App();
        app.run();
    }

    public App() {
        System.out.println( "Starting" );

        executor = Executors.newCachedThreadPool();
    }

    public void run() {
        Task task1 = new Task(10, 300, "Task1");
        Task task2 = new Task(10, 300, "task2");
        Task task3 = new Task(10, 300, "task3");

        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
    }
}
