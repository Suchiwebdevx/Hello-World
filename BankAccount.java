package Com.main;

public class BankAccount {

    //encapsulation( private data)
    private String owner;
    private double balance;

    // Constructor
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    // Methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Not enough balance!");
        } else {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    public void showBalance() {
        System.out.println(owner + "'s balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Suchi", 1000);
        acc.showBalance();
        acc.deposit(500);
        acc.withdraw(300);
        acc.withdraw(5000);
        acc.showBalance();
    }
}
