package com.bank.repository;

import com.bank.entity.Account;
import java.util.HashMap;
import java.util.Map;

public class AccountRepository {
    private Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }
}