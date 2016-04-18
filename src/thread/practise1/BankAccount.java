package thread.practise1;

public class BankAccount {
    private double balance;

    public synchronized void deposit(double amount){
        balance += amount;
    }

//    without synchronized
//    public void deposit(double amount){
//        balance += amount;
//    }

    public double getBalance(){
        return this.balance;
    }
}
