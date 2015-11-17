/******************************************************************************
*	Program Author: Himaja Suman Ruttala for CSCI 6810 Java and the Internet  *
*	Date: September, 2015													  *
*******************************************************************************/

/*
Transaction test
*/

import java.util.*; //including Java packages used by this program
import java.lang.*; //including Java packages used by this program
import com.ruttala.banking.*;

public class TransactionTest
{
	public static void main(String [] args){
		//TransactionID, TransactionType, TransactionDate, Amount, FromAccount, ToAccount, CustomerID
		
		// test for recordTransaction()
		Date date = new Date();
		//Transaction Transaction = new Transaction(date , 239,"Withdrwal", "00001111", "11114444", "Himaja");
		// Transaction Transaction1 = new Transaction("Krishna", "11111111", "add1 add9 add13", "9999999999", "Himaja");
		// Transaction Transaction2 = new Transaction("John", "22222222", "add1 add9 add13", "000000000", "Suman");
		// Transaction Transaction3 = new Transaction("Green", "66666666", "add1 add9 add13", "7878787878", "Suman");
		//Transaction.recordTransaction();
		// Transaction1.recordTransaction();
		// Transaction2.recordTransaction();
		// Transaction3.recordTransaction();

		//test for getTransactionList
		List <Transaction> TransactionList = new ArrayList<Transaction>();
		TransactionList = Transaction.getTransactionList("Himaja"); 

		for (int i=0; i < TransactionList.size() ; i++ ) {
			System.out.println("TransactionID:"+TransactionList.get(i).getTransactionID());
			System.out.println("TransactionType:"+TransactionList.get(i).getTransactionType());
			System.out.println("TransactionDate:"+TransactionList.get(i).getTransactionDate());
			System.out.println("FromAccount:" +TransactionList.get(i).getFromAccount());
			System.out.println("ToAccount:"+TransactionList.get(i).getToAccount());
			System.out.println("CustomerID:"+TransactionList.get(i).getCustomerID());
			System.out.println("=====================================\n");
		}

		//test for retrieveTransactionList

		// Transaction RTransaction = Transaction.retrieveTransaction("Himaja"); 
		
		// System.out.println("TransactionID:"+RTransaction.getTransactionID());
		// System.out.println("TransactionType:"+RTransaction.getTransactionType());
		// System.out.println("TransactionDate:"+RTransaction.getTransactionDate());
		// System.out.println("FromAccount:" +RTransaction.getFromAccount());
		// System.out.println("ToAccount:"+RTransaction.getToAccount());
		// System.out.println("CustomerID:"+RTransaction.getCustomerID());
		// System.out.println("=====================================\n");
	}
}