package thread.practise1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        ExecutorService service = Executors.newFixedThreadPool(100);

        for(int i = 0; i < 100; i++){
            service.execute(new DepositThread(bankAccount, 1));
        }

        service.shutdown();

        while (!service.isTerminated()){}

        System.out.println(bankAccount.getBalance());
    }
}
