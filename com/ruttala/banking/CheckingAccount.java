/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: October, 2013													      *
*******************************************************************************/

//CheckingAccountNumber, CustomerName, Balance, CustomerID

package com.ruttala.banking;

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import com.ruttala.banking.*;

public class CheckingAccount
{   //Instance Variables
	private String CheckingAccountNumber, CustomerName, CustomerID;
	private float Balance = -1;

	public CheckingAccount(String CA_Num, String Cust_Name, String Cust_ID, String Bal) { //Constructor One with three parameters
		CheckingAccountNumber = CA_Num;
		CustomerName = Cust_Name;
		CustomerID = Cust_ID;
		Balance = Float.parseFloat(Bal);
	}

	public CheckingAccount(String CA_Num) { //Constructor Two with one parameter
		CheckingAccountNumber = CA_Num;
	}

    public boolean openAcct() {
	     boolean done = false;
				try {
				    if (!done) {
				        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				        Connection DBConn = ToDB.openConn();
				        Statement Stmt = DBConn.createStatement();
				        String SQL_Command = "SELECT CheckingAccountNumber FROM CheckingAccount WHERE CheckingAccountNumber ='"+CheckingAccountNumber+"'"; //SQL query command
				        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				        done = !Rslt.next();
				        if (done) {
						    SQL_Command = "INSERT INTO CheckingAccount(CheckingAccountNumber, CustomerName, Balance, CustomerID)"+
						                  " VALUES ('"+CheckingAccountNumber+"','"+CustomerName+"',"+Balance+", '"+CustomerID+"')"; //Save the username, password and Name
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
    public double getBalance() {  //Method to return a CheckingAccount balance
		try {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Balance FROM CheckingAccount WHERE CheckingAccountNumber ='"+CheckingAccountNumber+"'"; //SQL query command for Balance
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command);

		        while (Rslt.next()) {
					Balance = Rslt.getFloat(1);
			    }
			    Stmt.close();
			    ToDB.closeConn();
		}
	    catch(java.sql.SQLException e)
	    {
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
	    {
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return Balance;
	}

    public double getBalance(String ChkAcctNumber) {  //Method to return a CheckingAccount balance
		try {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Balance FROM CheckingAccount WHERE CheckingAccountNumber ='"+CheckingAccountNumber+"'"; //SQL query command for Balance
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command);

		        while (Rslt.next()) {
					Balance = Rslt.getFloat(1);
			    }
			    Stmt.close();
			    ToDB.closeConn();
		}
	    catch(java.sql.SQLException e)
	    {
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
	    {
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return Balance;
	}
}