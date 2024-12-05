package com.example.model;

public class Account {
    private double balance;
    private int number;

    public Account(double balance, int number) {
        this.balance = balance;
        this.number = number;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Depositing " + amount + " to account " + number);
    }

    public synchronized  void withdraw(double amount) {
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawing " + amount + " from account " + number);
        }
        else {
            System.out.println("Balance lower than " + amount);
        }
    }

    public synchronized double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
