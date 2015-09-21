/******************************************************************************
*	Program Author: Himaja Suman Ruttala for CSCI 6810 Java and the Internet  *
*	Date: September, 2015													  *
*******************************************************************************/

/*
Payment test
*/

import java.util.*; //including Java packages used by this program
import java.lang.*; //including Java packages used by this program
import com.ruttala.banking.*;
// import java.sql.*;

public class PaymentTest
{
	public static void main(String [] args){
		//float Amount, Date PaymentDate, UUID PayeeID, String FromAccount, String Status, String CustomerID
		//PaymentID, Amount, PaymentDate, PayeeID, FromAccount, Status, CustomerID

		// test for addPayment()
		
		// Payment Payment1 = new Payment("Krishna", "11111111", "add1 add9 add13", "9999999999", "Himaja");
		// Payment Payment2 = new Payment("John", "22222222", "add1 add9 add13", "000000000", "Suman");
		// Payment Payment3 = new Payment("Green", "66666666", "add1 add9 add13", "7878787878", "Suman");
		// Payment.addPayment();
		// Payment1.addPayment();
		// Payment2.addPayment();
		// Payment3.addPayment();

		// List <Payee> payeeList = new ArrayList<Payee>();
		// payeeList = Payee.getPayeeList("Suman"); 

		// System.out.println("Select the payee to whom you want to schedule the payment");

		// for (int i=0; i < payeeList.size() ; i++ ) {
		// 	System.out.println(i+": "+payeeList.get(i).getPayeeName());
		// }

		// System.out.println("=====================================\n");
		
		Scanner sc = new Scanner(System.in);
  //   	int selected = sc.nextInt();

    	// UUID payeeId = payeeList.get(selected).getPayeeId();
    	// java.util.Date utilDate = new java.util.Date();
    	// java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    	// Payment payment = new Payment(220, utilDate, payeeId, "22233344", "Initiated", "Suman");


    	// payment.schedulePayment();

		//test for getPaymentList
		List <Payment> PaymentList = new ArrayList<Payment>();
		PaymentList = Payment.getPaymentList("Suman"); 

		for (int i=0; i < PaymentList.size() ; i++ ) {
			System.out.println("Amount:"+PaymentList.get(i).getPaymentAmount());
			System.out.println("Payment Date:"+PaymentList.get(i).getPaymentDate());
			System.out.println("Payee ID:" +PaymentList.get(i).getPayeeID());
			System.out.println("From Account:"+PaymentList.get(i).getFromAccount());
			System.out.println("Status:"+PaymentList.get(i).getStatus());
			System.out.println("CustomerID:"+PaymentList.get(i).getCustomerID());
			System.out.println("=====================================\n");
		}

		//test for updatePayment
		System.out.println("Select Payment you want to update?");
		for (int i=0; i < PaymentList.size() ; i++ ) {
			System.out.println((i+1) + ". "+PaymentList.get(i).getPaymentAmount());
			System.out.println(PaymentList.get(i).getPaymentDate());
		}
    	int j = sc.nextInt();
    	PaymentList.get(j-1).setPaymentAmount(1200);
    	PaymentList.get(j-1).updatePayment();


    	PaymentList = Payment.getPaymentList("Suman"); 
    	for (int i=0; i < PaymentList.size() ; i++ ) {
			System.out.println("Amount:"+PaymentList.get(i).getPaymentAmount());
			System.out.println("Payment Date:"+PaymentList.get(i).getPaymentDate());
			System.out.println("Payee ID:" +PaymentList.get(i).getPayeeID());
			System.out.println("From Account:"+PaymentList.get(i).getFromAccount());
			System.out.println("Status:"+PaymentList.get(i).getStatus());
			System.out.println("=====================================\n");
		}

		//test for deletePayment
		System.out.println("Select Payment you want to delete?");
		for (int i=0; i < PaymentList.size() ; i++ ) {
			System.out.println((i+1) + ". "+PaymentList.get(i).getPaymentAmount());
			System.out.println(PaymentList.get(i).getPaymentDate());
		}
		int n = sc.nextInt();
		PaymentList.get(n-1).cancelPayment();

		PaymentList = Payment.getPaymentList("Suman"); 
    	for (int i=0; i < PaymentList.size() ; i++ ) {
			System.out.println("Amount:"+PaymentList.get(i).getPaymentAmount());
			System.out.println("Payment Date:"+PaymentList.get(i).getPaymentDate());
			System.out.println("Payee ID:" +PaymentList.get(i).getPayeeID());
			System.out.println("From Account:"+PaymentList.get(i).getFromAccount());
			System.out.println("Status:"+PaymentList.get(i).getStatus());
			System.out.println("=====================================\n");
		}

	}
}