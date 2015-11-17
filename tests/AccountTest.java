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

public class AccountTest
{
	public static void main(String [] args){
		//Username, Password, Password1, Name

		//test for signIn
		System.out.println("Enter Username:");
		Scanner sc = new Scanner(System.in);
    	String username = sc.next();
		System.out.println("Enter Password:");
    	String password = sc.next();
    	
    	Account user = Account.signIn(username, password);

		System.out.println("User Name:"+user.getName());
	}
}