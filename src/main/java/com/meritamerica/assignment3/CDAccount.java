package com.meritamerica.assignment3;

import java.text.ParseException;
import java.util.Date;

import com.meritamerica.assignment3.BankAccount;
import com.meritamerica.assignment3.CDOffering;
public class CDAccount extends BankAccount {
	public CDOffering offering = new CDOffering();
	public int term;
	public double interestRate;
	public Date startDate = new Date();
	
	
	CDAccount(CDOffering offering, double balance){
		super();
		this.offering = offering;
		this.balance = balance;
		this.term = offering.getTerm();
		this.interestRate = offering.getInterestRate();
	}

	public CDAccount(double balance, double interestRate, Date date, long accountNumber, int newTerm) {
		super(balance, interestRate, date, accountNumber);
		this.term = term;
	}

	// Create appropriate constructors

	CDAccount() {
	//CDAccount() {

	//}


	static CDAccount readFromString(String accountData) throws ParseException {

	}

	
	public double getBalance() {
		return this.balance;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public int getTerm() {
		return this.term;
	}
	
	public java.util.Date getStartDate(){
		return this.startDate;
	}
	
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	public double futureValue(int years) {
		futureBalance = (balance * Math.pow(1.0 + interestRate, years));
		return futureBalance;
	}
}