package com.main;

import java.util.Scanner;

import com.service.BankService;

public class BankingSystem {

	public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);
		        BankService bank = new BankService();

		        while (true) {
		            System.out.println("\n===== BANK SYSTEM =====");
		            System.out.println("1. Create Account");
		            System.out.println("2. Deposit");
		            System.out.println("3. Withdraw");
		            System.out.println("4. Check Balance");
		            System.out.println("5. Exit");
		            System.out.print("Enter choice: ");

		            int choice = sc.nextInt();

		            switch (choice) {
		                case 1:
		                    System.out.print("Enter Account No: ");
		                    int accNo = sc.nextInt();
		                    sc.nextLine();
		                    System.out.print("Enter Name: ");
		                    String name = sc.nextLine();
		                    System.out.print("Enter Initial Balance: ");
		                    double bal = sc.nextDouble();
		                    bank.createAccount(accNo, name, bal);
		                    break;

		                case 2:
		                    System.out.print("Enter Account No: ");
		                    accNo = sc.nextInt();
		                    System.out.print("Enter Amount: ");
		                    double dep = sc.nextDouble();
		                    bank.deposit(accNo, dep);
		                    break;

		                case 3:
		                    System.out.print("Enter Account No: ");
		                    accNo = sc.nextInt();
		                    System.out.print("Enter Amount: ");
		                    double wit = sc.nextDouble();
		                    bank.withdraw(accNo, wit);
		                    break;

		                case 4:
		                    System.out.print("Enter Account No: ");
		                    accNo = sc.nextInt();
		                    bank.checkBalance(accNo);
		                    break;

		                case 5:
		                    System.out.println("Thank you!");
		                    System.exit(0);

		                default:
		                    System.out.println("Invalid choice!");
		            }
		        }
		}

}
