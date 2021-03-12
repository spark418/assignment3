package com.meritamerica.assignment3;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		MeritBank.readFromFile("src/test/testMeritBank_good.txt");
	}
CDOffering[] CDOfferings = new CDOffering[5]; {

CDOfferings[0] = new CDOffering(1,1.8/100);
CDOfferings[1] = new CDOffering(2,1.9/100);
CDOfferings[2] = new CDOffering(3,2.0/100);
CDOfferings[3] = new CDOffering(5,2.5/100);
CDOfferings[4] = new CDOffering(10,2.2/100);
}
AccountHolder ah1 = new AccountHolder();

CheckingAccount ca1 = new CheckingAccount(1000);
SavingsAccount sa1 = new SavingsAccount(10000);

CheckingAccount ca2 = new CheckingAccount(5000);
SavingsAccount sa2 = new SavingsAccount(50000);

CheckingAccount ca3 = new CheckingAccount(50000);
SavingsAccount sa3 = new SavingsAccount(500000);//Will not add. Constraint met.

CheckingAccount ca4 = new CheckingAccount(5000);
SavingsAccount sa4 = new SavingsAccount(50000);

ah1.addCheckingAccount(ca1);
ah1.addSavingsAccount(sa1);

ah1.addCheckingAccount(ca2);
ah1.addSavingsAccount(sa2);

ah1.addCheckingAccount(ca3);
ah1.addSavingsAccount(sa3);

ah1.addCheckingAccount(ca4);
ah1.addSavingsAccount(sa4);


ah1.printAccountBalances();

MeritBank.getCDOfferings();
ah1.addCDAccount(MeritBank.getBestCDOffering(ah1.getCombinedBalance()), ah1.getCombinedBalance());

MeritBank.addAccountHolder(ah1);

AccountHolder ah2 = new AccountHolder();

ah2.addCheckingAccount(1000);
ah2.addSavingsAccount(10000);

MeritBank.getCDOfferings();
ah2.addCDAccount(MeritBank.getSecondBestCDOffering(ah2.getCombinedBalance()), ah2.getCombinedBalance());

MeritBank.addAccountHolder(ah2);

MeritBank.clearCDOfferings();

AccountHolder ah3 = new AccountHolder();

try {
	ah3.addCDAccount(MeritBank.getSecondBestCDOffering(ah3.getCombinedBalance()), ah3.getCombinedBalance());
}catch(Exception e) {
	System.out.println("Cannot add CDAccount");
}

ah3.addCheckingAccount(1000);
ah3.addSavingsAccount(10000);

MeritBank.addAccountHolder(ah3);

System.out.println(MeritBank.totalBalances());
}
}