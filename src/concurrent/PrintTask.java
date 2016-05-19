package concurrent;

import java.util.concurrent.RecursiveAction;

public class PrintTask extends RecursiveAction{

    private final int maximum = 20;

    private int start;
    private int end;

    public PrintTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if((end - start) <= maximum){
            for (int i = start; i < end; i++){
                System.out.println(i);
            }
        }else {
            int mid = (start + end) / 2;
            PrintTask left = new PrintTask(start, mid);
            PrintTask right = new PrintTask(mid, end);
            left.fork();
            right.fork();
        }
    }
}
