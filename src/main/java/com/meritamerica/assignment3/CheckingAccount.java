package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;

public class CheckingAccount extends BankAccount {
	public double openingBalance, interestRate, futureBalance;
	CheckingAccount(double openingBalance) {
		super();
		this.openingBalance = openingBalance;
		this.interestRate = 0.0001;
	}
	static CheckingAccount readFromString(String accountData) throws ParseException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(""));
			//format.parse();
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException("String was not parsed correctly.");
		}
		return new CheckingAccount( BankAccount.readFromString(accountData));
	}

	public double getBalance() {
		return this.openingBalance;
	}
	public double getInterestRate() {
		return this.interestRate;
	}
	public boolean withdraw(double amount) {
		if (amount < openingBalance && amount > 0) {
			openingBalance -= amount;
			return true;
		} else {
			System.out.println("Not enough money!!!");
			return false;
		}
	}
	public boolean deposit(double amount) {
		if (amount > 0) {
			openingBalance += amount;
			return true;
		} else {
			System.out.println("Cannot deposit a negative amount");
			return false;
		}
	}
	public double futureValue(int years) {
		futureBalance = (openingBalance * Math.pow(1.0 + interestRate, years));
		return futureBalance;
	}
	@Override
	public String toString() {
		return "Checking Account Balance: " + openingBalance + "\r\n" + "Checking Account Interest Rate: "
				+ interestRate + "\r\n" + "Checking Account Balance in 3 years " + futureBalance;
	}
}