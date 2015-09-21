/******************************************************************************
*	Program Author: Himaja Suman Ruttala for CSCI 6810 Java and the Internet  *
*	Date: September, 2015													  *
*******************************************************************************/

/*
Payee test
*/

import java.util.*; //including Java packages used by this program
import java.lang.*; //including Java packages used by this program
import com.ruttala.banking.*;

public class PayeeTest
{
	public static void main(String [] args){
		//String P_Name, String PA_Num, String P_Address, String PPh_Num, String Cust_ID
		//PayeeID, PayeeName, PayerAccountNumber, PayeeAddress, PayeePhoneNumber, CustomerID
		
		// test for addPayee()
		// Payee payee = new Payee("Radhika", "23456789", "add0 add9 add13", "8143230969", "Himaja");
		// Payee payee1 = new Payee("Krishna", "11111111", "add1 add9 add13", "9999999999", "Himaja");
		// Payee payee2 = new Payee("John", "22222222", "add1 add9 add13", "000000000", "Suman");
		// Payee payee3 = new Payee("Green", "66666666", "add1 add9 add13", "7878787878", "Suman");
		// payee.addPayee();
		// payee1.addPayee();
		// payee2.addPayee();
		// payee3.addPayee();

		//test for getPAyeeList
		List <Payee> payeeList = new ArrayList<Payee>();
		payeeList = Payee.getPayeeList("Suman"); 

		for (int i=0; i < payeeList.size() ; i++ ) {
			System.out.println("Name:"+payeeList.get(i).getPayeeName());
			System.out.println("Acc Num:"+payeeList.get(i).getPayerAcNum());
			System.out.println("Ph. Num:" +payeeList.get(i).getPayeePhoneNum());
			System.out.println("Address:"+payeeList.get(i).getPayeeAddress());
			System.out.println("=====================================\n");
		}

		//test for updatePayee
		Scanner sc = new Scanner(System.in);
    	String name = sc.next();
    	payeeList.get(0).setPayeeName(name);
    	payeeList.get(0).updatePayee();


    	payeeList = Payee.getPayeeList("Suman"); 
    	for (int i=0; i < payeeList.size() ; i++ ) {
			System.out.println("Name:"+payeeList.get(i).getPayeeName());
			System.out.println("Acc Num:"+payeeList.get(i).getPayerAcNum());
			System.out.println("Ph. Num:" +payeeList.get(i).getPayeePhoneNum());
			System.out.println("Address:"+payeeList.get(i).getPayeeAddress());
			System.out.println("=====================================\n");
		}

		//test for deletePayee
		System.out.println("Select Payee you want to delete?");
		for (int i=0; i < payeeList.size() ; i++ ) {
			System.out.println((i+1) + ". "+payeeList.get(i).getPayeeName());
		}
		int n = sc.nextInt();
		payeeList.get(n-1).deletePayee();

		payeeList = Payee.getPayeeList("Suman"); 
    	for (int i=0; i < payeeList.size() ; i++ ) {
			System.out.println("Name:"+payeeList.get(i).getPayeeName());
			System.out.println("Acc Num:"+payeeList.get(i).getPayerAcNum());
			System.out.println("Ph. Num:" +payeeList.get(i).getPayeePhoneNum());
			System.out.println("Address:"+payeeList.get(i).getPayeeAddress());
			System.out.println("=====================================\n");
		}

	}
}