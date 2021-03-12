package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;

public class MeritBank {
	public static int size = 5, numberOfAccountHolders = 0, numberOfCDOfferings = 0;
	public static int size = 100, numberOfAccountHolders = 0, numberOfCDOfferings = 0;
	public static long[] accountNumbers = new long[size];
	public static AccountHolder[] accountHolders = new AccountHolder[size];
	public static CDOffering[] CDOfferings = new CDOffering[size];
	
	/*
	MeritBank(){
		
	}*/
	
	public static void addAccountHolder(AccountHolder accountHolder) {
		if(numberOfAccountHolders == size) {
			size *= 2;
			AccountHolder[] temp = new AccountHolder[size];
			for(int i = 0; i < numberOfAccountHolders; i++) {
				temp[i] = accountHolders[i];
			}
			accountHolders = temp;
			accountHolders[numberOfAccountHolders] = accountHolder;
			numberOfAccountHolders++;
		}else {
			accountHolders[numberOfAccountHolders] = accountHolder;
			numberOfAccountHolders++;
		}
	}
	
	public static AccountHolder[] getAccountHolders() {
		return accountHolders;
	}
	
	public static CDOffering[] getCDOfferings() {
		return CDOfferings;
	}
	
	public static CDOffering getBestCDOffering(double depositAmount) {
		CDAccount temp = new CDAccount(CDOfferings[0], depositAmount);
		CDOffering best = CDOfferings[0];
		for(int i = 1; i < numberOfCDOfferings; i++) {
			if(temp.futureValue(CDOfferings[i].getTerm()) > temp.futureValue(CDOfferings[i - 1].getTerm())) {
				best = CDOfferings[i];
			}
		}
		return best;
	}
	
	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		CDAccount temp = new CDAccount(CDOfferings[0], depositAmount);
		CDOffering secondBest = CDOfferings[0];
		CDOffering best = CDOfferings[0];
		for(int i = 1; i < numberOfCDOfferings; i++) {
			if(temp.futureValue(CDOfferings[i].getTerm()) > temp.futureValue(CDOfferings[i - 1].getTerm())) {
				secondBest = best;
				best = CDOfferings[i];	
			}
		}
		return secondBest;
	}
	
	public static void clearCDOfferings() {
		CDOfferings = null;
	}
	
	public static void setCDOfferings(CDOffering[] offerings) { 
		CDOfferings = offerings;
	}
	
	public static long getNextAccountNumber() {
		return accountNumbers[numberOfAccountHolders];
	}
	
	
	// List account holders displayed in ascending order of their total balances (End of Assignment 3)
	// https://docs.google.com/document/d/13BmjQpgCn4dliDZCj_Qts7Qr6vv1NJyMwtssQ38jSQA/edit#
	public static double totalBalances() {
		double total = 0.0;
		for(int i = 0; i < numberOfAccountHolders; i++) {
			total += (accountHolders[i].getTotalAccountBalances());
		}
		return total;
	}
	
	public String toString() {
		return "AccountHolders: " + accountHolders + 
				"CDOfferings: " + CDOfferings;
	}


/****************************************BufferedReader***************************************************************/

	static boolean readFromFile(String fileName) {

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){

			String line = "";
			int allAccountHolders;
			int allCheckingsAcc;
			int allSavingsAcc;
			int allCDAcc;
			int allCDOfferings;


			while((line = br.readLine()) != null) {
				for(int i = 0; i < allAccountHolders; i++ ) {
					AccountHolder account = AccountHolder.readFromString(line);
					addAccountHolder(account);

				for(int j =0; j < allCheckingsAcc; j++) {
					CheckingAccount ChAccount = CheckingAccount.readFromString(line);
					account.addCheckingAccount(ChAccount);
				}
				for(int k =0; k < allSavingsAcc; k++) {
					SavingsAccount SvAccount = SavingsAccount.readFromString(line);
					account.addSavingsAccount(SvAccount);
				}
				for(int h =0; h < allCDAcc; h++) {
					CDAccount CDAcc = CDAccount.readFromString(line);
					account.addCDAccount(CDAcc);
				}
				}

				CDOfferings = new CDOffering[allCDOfferings];
				for (int i = 0; i < allCDOfferings; i++) {
					CDOfferings[i] = CDOffering.readFromString(line);

				}
			}
			br.close();
			return true;

		} catch (Exception e) {
			System.out.print("Something went wrong.");
			return false;
		}

	}

	static boolean writeToFile(String fileName) {
		return false;

	}
	static AccountHolder[] sortAccountHolders() {
		Arrays.sort(accountHolders);
			return accountHolders;
	}
	static void setNextAccountNumber(long nextAccountNumber) {
		nextAccountNumber = accountNumbers;
	}
}	