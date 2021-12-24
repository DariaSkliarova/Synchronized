import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.exe();
    }

    private void exe() {

        Point point = new Point(0, 0);
        Collection<Future<?>> results = new ArrayList<>();

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 2000; i++) {
            Future<?> result = executor.submit(new PointMovingTask(point));
            results.add(result);
        }

        try {
            for (Future<?> result : results) {
                result.get(3, TimeUnit.SECONDS);
                executor.shutdown();
            }
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println(point.x);
        System.out.println(point.y);

        FibonacciTaskThread fibonacci = new FibonacciTaskThread();
        fibonacci.start();
        try {
            fibonacci.join(3000);
            System.out.println("Fibonacci: " + fibonacci.f);
            fibonacci.interrupt();
        } catch (InterruptedException e) {
            fibonacci.interrupt();
            System.out.println("Task was interrupted");
            e.printStackTrace();
        }

        FibonacciRunnable fibonacci1 = new FibonacciRunnable();
        Thread thread = new Thread(fibonacci1);
        thread.start();
        try {
            thread.join(3000);
            System.out.println("Fibonacci: " + fibonacci1.f);
            thread.interrupt();
        } catch (InterruptedException e) {
            thread.interrupt();
            e.printStackTrace();
        }
    }
}
