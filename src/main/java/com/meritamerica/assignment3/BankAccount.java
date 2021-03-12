package com.meritamerica.assignment3;

import java.util.Date;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class BankAccount {
	public long accountNumber;
	public double balance, interestRate, futureBalance;

	public Date accountOpenedOn;
	BankAccount(){
	}

	BankAccount(double balance, double interestRate){
		this.balance = balance;
		this.interestRate = interestRate;
	}
	BankAccount(long accountNumber, double balance, double interestRate){
		this.accountNumber = new Random().nextLong();
}	BankAccount(double balance, double interestRate, Date accountOpenedOn) {
		this.balance = balance;
		this.interestRate = interestRate;
	}

	BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
	}
	static BankAccount readFromString(String accountData) throws ParseException {
		String AccountNumber = ""; 
		String Balance = ""; 
		String InterestRate = ""; 
		String Date = "";
		int i = 1;

		try {
			BufferedReader br = new BufferedReader(new FileReader(""));
			//format.parse();
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException("String was not parsed correctly.");
			for (char acct: accountData.toCharArray()) { 
				if(acct == ',' ) 
					{i++; continue;}
				if(i == 1) 
					{AccountNumber += acct;}
				if(i == 2) 
					{Balance += acct;}
				if(i == 3) 
					{InterestRate += acct;}
				if(i == 4) 
					{Date += acct;}
			} 
			long parsedAccountNumber = Long.parseLong(AccountNumber);
			double parsedBalance = Double.parseDouble(Balance);
			double parsedRate = Double.parseDouble(InterestRate);
			Date parsedDate = new SimpleDateFormat("dd/MM/yyyy").parse(Date);

			BankAccount parsedAccount = new BankAccount(parsedAccountNumber, parsedBalance, parsedRate, parsedDate);

			return parsedAccount;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public String writeToString() {
		StringBuilder write = new StringBuilder(); 
		return write.append(accountNumber).append(",").append(balance).append(",").append(interestRate).append(",").append(accountOpenedOn).toString();

	}

	public Date getOpenedOn() {
		return accountOpenedOn;
	}

	public double getInterestRate() {
		return interestRate;
	}
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public boolean withdraw(double amount) {
		if(amount < balance && amount > 0) {
			this.balance -= amount;
			return true;
		}else {
			System.out.println("Not enough money!!!");
			return false;
		}
	}
	
	public boolean deposit(double amount) {
		if(amount > 0) {
			this.balance += amount;
			return true;
		}else {
			System.out.println("Cannot deposit a negative amount");
			return false;
		}
	}
	
	public double futureValue(int years) {
		futureBalance = (balance * Math.pow(1.0 + interestRate, years));
		return futureBalance;
	}
}