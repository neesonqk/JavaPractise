package thread.practise1;

public class DepositThread implements Runnable{
    private final BankAccount bankAccount;
    private double amount;

    public DepositThread(BankAccount bankAccount, double amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        bankAccount.deposit(amount);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //##### if BankAccount depositWithSynchronize is not a synchronize method, then here :
        //synchronized(bankAccount){
        //    bankAccount.deposit(amount);
        //}
    }
}
