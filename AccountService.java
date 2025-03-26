package com.bank.service;

import com.bank.entity.Account;
import com.bank.repository.AccountRepository;

public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void createAccount(int accountNumber, String holderName, double balance) {
        if (repository.getAccount(accountNumber) != null) {
            System.out.println("Account already exists!");
            return;
        }
        Account account = new Account(accountNumber, holderName, balance);
        repository.addAccount(account);
        System.out.println("Account successfully created.");
    }

    public boolean deposit(int accountNumber, double amount) {
        Account account = repository.getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful.");
            return true;
        }
        System.out.println("Account not found.");
        return false;
    }

    public boolean withdraw(int accountNumber, double amount) {
        Account account = repository.getAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return false;
        }
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
            return true;
        }
        System.out.println("Insufficient balance.");
        return false;
    }

    public double checkBalance(int accountNumber) {
        Account account = repository.getAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return -1;
        }
        return account.getBalance();
    }
}
