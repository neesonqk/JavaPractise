package concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(new PrintTask(0, 1000));

        forkJoinPool.shutdown();
        while (!forkJoinPool.isTerminated()){
            //System.out.println("Processing...");
        }

        System.out.println("Start SUM");

        ForkJoinPool forkJoinPool2 = new ForkJoinPool();
        Future<Integer> future = forkJoinPool2.submit(new SumTask(0, 1000));

        forkJoinPool2.shutdown();
        while (!forkJoinPool.isTerminated()){
            //System.out.println("Processing...");
        }

        System.out.println("SUM: " + future.get());
    }


}
