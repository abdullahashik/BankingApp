/******************************************************************************
*	Program Author: Himaja Suman Ruttala for CSCI 6810 Java and the Internet	  *
*	Date: September, 2015													  *
*******************************************************************************/

/*
Payee(PayeeID, PayeeName, PayerAccountNumber, PayeeAddress, PayeePhoneNumber, CustomerID)
Payee with proper instance variables and methods of adding a Payee, updating a Payee and deleting a Payee
*/
package com.ruttala.banking;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import com.ruttala.banking.*;

public class SavingsAccount
{   //Instance Variables
	String SavingsAccountNumber, CustomerName, CustomerID;
	float Balance;

	public SavingsAccountNumber(SaAcNu, CuNa, CuID, Bal){
		SavingsAccountNumber = SaAcNu;
		CustomerName = CuNa;
		CustomerID = CuID;
		Balance = Bal;
	}

	public boolean openAcct() {
	     boolean done = false;
				try {
				    if (!done) {
				        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				        Connection DBConn = ToDB.openConn();
				        Statement Stmt = DBConn.createStatement();
				        String SQL_Command = "SELECT SavingsAccountNumber FROM CheckingAccount WHERE SavingsAccountNumber ='"+SavingsAccountNumber+"'"; //SQL query command
				        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				        done = !Rslt.next();
				        if (done) {
						    SQL_Command = "INSERT INTO CheckingAccount(SavingsAccountNumber, CustomerName, Balance, CustomerID)"+
						                  " VALUES ('"+SavingsAccountNumber+"','"+CustomerName+"',"+Balance+", '"+CustomerID+"')"; //Save the username, password and Name
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

	public float withdraw(){
		return amount;
	}
}