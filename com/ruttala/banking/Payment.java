/******************************************************************************
*	Program Author: Himaja Suman Ruttala for CSCI 6810 Java and the Internet	  *
*	Date: September, 2015													  *
*******************************************************************************/

/*
Payment(PaymentID, Amount, PaymentDate, PayeeID, FromAccount, Status, CustomerID)
FromAccount - foreign key of
Payment with proper instance variables with methods of scheduling a Payment, canceling a scheduled Payment, delivering a scheduled Payment
*/

package com.ruttala.banking;

import java.lang.*; //including Java packages used by this program
import java.util.*;
import java.sql.*;
import com.ruttala.banking.*;
import java.util.UUID;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Payment
{
	/*members*/
	private UUID PaymentID;
	private float Amount;
	private java.util.Date PaymentDate;
	private UUID PayeeID;
	private String FromAccount, Status, CustomerID;

	/*constructors*/
	public Payment(float Amt, java.util.Date P_Date, UUID Pa_ID, String Frm_Acc, String Stat, String Cust_ID) {
		Amount = Amt;
		PaymentDate = P_Date;
		PayeeID = Pa_ID;
		FromAccount = Frm_Acc;
		Status = Stat;
		CustomerID = Cust_ID;
	}

	public Payment(UUID Paymnt_Id, float Amt, java.util.Date P_Date, UUID Pa_ID, String Frm_Acc, String Stat, String Cust_ID) {
		PaymentID = Paymnt_Id;
		Amount = Amt;
		PaymentDate = P_Date;
		PayeeID = Pa_ID;
		FromAccount = Frm_Acc;
		Status = Stat;
		CustomerID = Cust_ID;
	}

	public Payment(){}

	/*getters*/
	public float getPaymentAmount(){
		return Amount;
	}
	public java.util.Date getPaymentDate(){
		return PaymentDate;
	}
	public UUID getPayeeID(){
		return PayeeID;
	}
	public String getFromAccount(){
		return FromAccount;
	}
	public String getStatus(){
		return Status;
	}
	public String getCustomerID(){
		return CustomerID;
	}
	/*setters*/
	public void setPaymentAmount(float Amt){
		Amount = Amt;
	}
	public void setPaymentDate(java.util.Date P_Date){
		PaymentDate = P_Date;
	}
	public void setPayeeID(UUID Pa_ID){
		PayeeID = Pa_ID;
	}
	public void setFromAccount(String Frm_Acc){
		FromAccount = Frm_Acc;
	}
	public void setStatus(String Stat){
		Status = Stat;
	}


	/*methods*/
	public boolean schedulePayment(){
		boolean done = !PaymentDate.equals("") && !PayeeID.equals("") && !FromAccount.equals("") && !CustomerID.equals("")&& Status.equals("Initiated");
		System.out.println(done);
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        if (done) {
		        	// Unique ID generation
		        	PaymentID =  UUID.randomUUID();
		        	//converting java date to sql date
		        	java.sql.Date SQ_PaymentDate = new java.sql.Date(PaymentDate.getTime());
				    String SQL_Command = "INSERT INTO Payment(PaymentID, Amount, PaymentDate, PayeeID, FromAccount, Status, CustomerID) VALUES ('"+PaymentID+ "','"+Amount+ "','"+SQ_PaymentDate+"','"+PayeeID+"','"+FromAccount+"','"+Status+"','"+CustomerID+"')"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
			    }
			    Stmt.close();
			    ToDB.closeConn();
			}
		}
	    catch(java.sql.SQLException e)
	    {         done = false;
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("0011SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {         done = false;
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return done;
	}
	public static List<Payment> getPaymentList(String CustomerID){
		List <Payment> PaymentList = new ArrayList<Payment>();
		DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
		boolean done = false;
		try {		//20
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT * FROM Payment WHERE CustomerID ='"+CustomerID+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        while (Rslt.next()) {
                	
                	UUID Paymt_Id = UUID.fromString(Rslt.getString("PaymentID"));
                	float Amt = Float.parseFloat(Rslt.getString("Amount"));
                	//formating string to date
					java.sql.Date SQ_Pa_Date = Rslt.getDate("PaymentDate");
					java.util.Date Pa_Date = new java.util.Date(SQ_Pa_Date.getTime());
                	UUID Pa_ID = UUID.fromString(Rslt.getString("PayeeID"));
                	String Frm_Acc = Rslt.getString("FromAccount");
                	String Stat = Rslt.getString("Status");
                	String Cust_ID = Rslt.getString("CustomerID");
                	
                	Payment payment = new Payment(Paymt_Id, Amt, Pa_Date, Pa_ID, Frm_Acc, Stat, Cust_ID); // Creating a new object
					PaymentList.add(payment);
                }
			        Stmt.close();
			        ToDB.closeConn();
                    done=true;
		}
	    catch(java.sql.SQLException e)		//5
	    {         done = false;
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {         done = false;
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return PaymentList;
	}
	public boolean updatePayment(){
		System.out.println("PaymentDate: " + PaymentDate);
		System.out.println("PayeeID: " + PayeeID);
		System.out.println("FromAccount: " + FromAccount);
		System.out.println("CustomerID: " + CustomerID);
		System.out.println("Status: " + Status);
		boolean done = !PaymentDate.equals("") && !PayeeID.equals("") && !FromAccount.equals("") && !CustomerID.equals("")&& !Status.equals("");
		try {		//20
		        if(done){
			        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			        Connection DBConn = ToDB.openConn();
			        Statement Stmt = DBConn.createStatement();
			        String SQL_Command = "SELECT * FROM Payment WHERE PaymentID ='"+PaymentID + "';"; //SQL query command
			        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
			        if (Rslt.next()) {
			        	java.sql.Date SQ_PaymentDate = new java.sql.Date(PaymentDate.getTime());
					    SQL_Command = "UPDATE Payment SET Amount='"+Amount+"', PaymentDate='"+SQ_PaymentDate+"', PayeeID='"+PayeeID+"', FromAccount='"+FromAccount+"', Status='"+Status+"' WHERE PaymentID ='"+PaymentID+"';";
					    Stmt.executeUpdate(SQL_Command);
				        Stmt.close();
				        ToDB.closeConn();
					}
		        }
		}
	    catch(java.sql.SQLException e)		//5
	    {         done = false;
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {         done = false;
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return done;
	}
	public boolean cancelPayment(){
		boolean done = false;
		try {		//20
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT * FROM Payment WHERE PaymentID ='"+PaymentID+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        if (Rslt.next()) {
				    SQL_Command = "DELETE FROM Payment WHERE PaymentID='"+PaymentID+"'"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
			        Stmt.close();
			        ToDB.closeConn();
                    done=true;
				}
		}
	    catch(java.sql.SQLException e)		//5
	    {         done = false;
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {         done = false;
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return done;
	}
	// public deliverPayment(){}
}