package com.main;

public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.owner = owner;
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance = balance + amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance = balance - amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }
}