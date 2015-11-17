/******************************************************************************
*	Program Author: Himaja Suman Ruttala for CSCI 6810 Java and the Internet  *
*	Date: September, 2015													  *
*******************************************************************************/

/*
Account test
*/

import java.util.*;
import java.lang.*;
import com.ruttala.banking.*;

public class CheckingAccountTest
{
	public static void main(String [] args){
		//CheckingAccountNumber, CustomerName, CustomerID, Balance

    	CheckingAccount ChkAcct = new CheckingAccount("22226666", "skd", "Himaja", 1000);
    	CheckingAccount ChkAcct1 = new CheckingAccount();
    	ChkAcct1 = ChkAcct1.getAccountInfo("tang");

		//test for updateBalance
		// Scanner sc = new Scanner(System.in);
		boolean x = ChkAcct1.Withdraw("2222233333", 100);
		// System.out.println("Updated Balance is :" + ChkAcct1.getCANum());
		// System.out.println("Enter Withdrawl Amount:");
  //   	float amt = sc.nextInt();
  //   	amt = ChkAcct.getBal() - amt;
  //   	ChkAcct.setBalance(amt);
  //   	ChkAcct.updateBalance();

		// System.out.println("Enter Deposit Amount:");
		// amt = sc.nextInt();
  //   	amt = ChkAcct.getBal() + amt;
  //   	ChkAcct.setBalance(amt);
  //   	ChkAcct.updateBalance();
		// System.out.println("Updated Balance is :" + ChkAcct.getBalance());
	}
}