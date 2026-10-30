package com.main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    @Test
    void depositIncreasesBalance() {
        BankAccount acc = new BankAccount("Suchi", 1000);
        assertTrue(acc.deposit(500));
        assertEquals(1500, acc.getBalance(), 0.001);
    }

    @Test
    void depositZeroIsRejected() {
        BankAccount acc = new BankAccount("Suchi", 1000);
        assertFalse(acc.deposit(0));
        assertEquals(1000, acc.getBalance(), 0.001);
    }

    @Test
    void depositNegativeIsRejected() {
        BankAccount acc = new BankAccount("Suchi", 1000);
        assertFalse(acc.deposit(-100));
        assertEquals(1000, acc.getBalance(), 0.001);
    }

    @Test
    void withdrawReducesBalance() {
        BankAccount acc = new BankAccount("Suchi", 1000);
        assertTrue(acc.withdraw(300));
        assertEquals(700, acc.getBalance(), 0.001);
    }

    @Test
    void withdrawMoreThanBalanceIsRejected() {
        BankAccount acc = new BankAccount("Suchi", 1000);
        assertFalse(acc.withdraw(5000));
        assertEquals(1000, acc.getBalance(), 0.001);
    }

    @Test
    void withdrawExactBalanceWorks() {
        BankAccount acc = new BankAccount("Suchi", 1000);
        assertTrue(acc.withdraw(1000));
        assertEquals(0, acc.getBalance(), 0.001);
    }

    @Test
    void withdrawNegativeIsRejected() {
        BankAccount acc = new BankAccount("Suchi", 1000);
        assertFalse(acc.withdraw(-50));
        assertEquals(1000, acc.getBalance(), 0.001);
    }

    @Test
    void negativeOpeningBalanceThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount("Suchi", -1));
    }
}