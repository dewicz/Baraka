package com.example.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class BankTest {
    Bank bank;

    @Before
    public void setUp() {
        bank = new Bank(new HashMap<>());

    }

    @Test
    public void createAccount() {
        bank.createAccount(1);
        bank.createAccount(2);
        Assert.assertEquals(2, bank.getAccounts().size());
    }

    @Test
    public void transfer() {
        bank.createAccount(1);
        bank.createAccount(2);
        Account account = bank.findAccount(1);
        account.deposit(5.0);
        Account accountTwo = bank.findAccount(2);
        bank.transfer(1,2,2.0);
        Assert.assertEquals(3.0, account.getBalance(), 0);
        Assert.assertEquals(2.0, accountTwo.getBalance(), 0);
    }

}