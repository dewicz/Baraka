package com.example.model;

import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts;

    public Bank(Map<Integer, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized Account createAccount(int number) {
        Account account = null;
        if(!accounts.containsKey(number)) {
            account = new Account(0.0, number);
            accounts.put(number, account);
            System.out.println("Created account " + number);
        }
        else {
            System.out.println("Account already exists");
        }
        return account;
    }

    public Account findAccount(int number) {
        return accounts.get(number);
    }

    public void transfer(int accountNumberOne, int accountNumberTwo, double amount) {
        Account accountOne, accountTwo;

        synchronized (this) {
            accountOne = findAccount(accountNumberOne);
            accountTwo = findAccount(accountNumberTwo);
            if(accountOne == null || accountTwo == null) {
                throw new IllegalArgumentException("Transfer not possible between non existent accounts");
            }


                    if (accountOne.getBalance() >= amount) {
                        accountOne.withdraw(amount);
                        accountTwo.deposit(amount);
                        System.out.printf("Transferred %f from account %d to %d%n", amount, accountNumberOne, accountNumberTwo);
                    } else {
                        throw new IllegalArgumentException("Insufficient balance");
                    }

        }

    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }
}
