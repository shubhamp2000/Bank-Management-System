package com.bank.runner;

import java.util.Scanner;

import com.bank.repository.AccountRepository;
import com.bank.service.AccountService;

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountRepository repository = new AccountRepository();
        AccountService service = new AccountService(repository);

        while (true) {
            System.out.println("\nBank Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Holder Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    service.createAccount(accNo, name, balance);
                    System.out.println("Account created successfully!");
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    accNo = scanner.nextInt();
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();
                    if (service.deposit(accNo, amount)) {
                        System.out.println("Amount Deposited Successfully!");
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accNo = scanner.nextInt();
                    System.out.print("Enter Amount: ");
                    amount = scanner.nextDouble();
                    if (service.withdraw(accNo, amount)) {
                        System.out.println("Amount Withdrawn Successfully!");
                    } else {
                        System.out.println("Insufficient Balance or Account Not Found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    accNo = scanner.nextInt();
                    double accBalance = service.checkBalance(accNo);
                    if (accBalance != -1) {
                        System.out.println("Account Balance: " + accBalance);
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid Choice! Please try again.");
            }
        }
    }
}

