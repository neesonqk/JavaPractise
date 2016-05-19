package concurrent;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer>{

    private final int max = 100;
    private int start;
    private int end;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if((end - start) <= max){
            int sum = 0;
            for(int i = start; i < end; i++){
                sum += i;
            }
            return sum;
        }else {
            int mid = (start + end) / 2;
            SumTask left = new SumTask(start, mid);
            SumTask right = new SumTask(mid, end);
            left.fork();
            right.fork();

            return left.join() + right.join();
        }
    }
}
