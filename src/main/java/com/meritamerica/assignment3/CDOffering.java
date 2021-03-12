package com.meritamerica.assignment3;

import java.io.FileWriter;

public class CDOffering {
	int term;
	double interestRate;
	
	CDOffering(){
	}
	
	CDOffering(int term, double interestRate){
		this.term = term;
		this.interestRate = interestRate;
	}
	
	public int getTerm() {
		return term;
	}
	
	public double getInterestRate() {
		return interestRate;
	}


	 static CDOffering readFromString(String CDOfferingDataString) throws NumberFormatException{
	       String [] CDOff = CDOfferingDataString.split(",");
	       int term = Integer.parseInt(CDOff[0]);
	       double interestRate = Double.parseDouble(CDOff[1]);
	       CDOffering offering = new CDOffering(term, interestRate);
	       return offering;
	 }
	 public String writeToString() {
		//FileWriter writer = new FileWriter();
		 String string = "";
		 string += this.term + "," + this.interestRate;
		 return string;
	 }
}