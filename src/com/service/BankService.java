package com.service;

import com.model.Account;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class BankService {
    private Map<Integer, Account> accounts = new HashMap<>();
    private final String FILE_NAME = "bank.txt";

    public BankService() {
        loadData();
    }

    public void createAccount(int accNo, String name, double balance) {
        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists!");
            return;
        }
        accounts.put(accNo, new Account(accNo, name, balance));
        saveData();
        System.out.println("Account created successfully!");
    }

    public void deposit(int accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }
        acc.deposit(amount);
        saveData();
        System.out.println("Amount deposited!");
    }
    

    public void withdraw(int accNo, double amount) {
        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }
        if (acc.withdraw(amount)) {
            saveData();
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void checkBalance(int accNo) {
        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }
        acc.display();
    }
    
    private void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int accNo = Integer.parseInt(data[0]);
                String name = data[1];
                double balance = Double.parseDouble(data[2]);

                accounts.put(accNo, new Account(accNo, name, balance));
            }

        } catch (Exception e) {
            System.out.println("No previous data found.");
        }
    }
 
   
    
    //File Handling
    private void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Account acc : accounts.values()) {
                writer.write(acc.getAccountNumber() + "," + acc.getName() + "," + acc.getBalance());
                writer.newLine();
            }

        } catch (Exception e) {
            System.out.println("Error saving data");
        }
    }
    
    

//    private void saveData() {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
//            oos.writeObject(accounts);
//        } catch (Exception e) {
//            System.out.println("Error saving data");
//        }
//    }
//
//    private void loadData() {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
//            accounts = (HashMap<Integer, Account>) ois.readObject();
//        } catch (Exception e) {
//            accounts = new HashMap<>();
//        }
//    }
}


  
