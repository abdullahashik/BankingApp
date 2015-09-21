/******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: February, 2014													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
import com.ruttala.banking.*;

public class LoginControl
{
    private Account Acct;

    public LoginControl(String UName, String PWord) {
		Acct = new Account(UName, PWord);
		String CustomerName = Acct.signIn();
        if (!CustomerName.equals("")) {
            //System.out.println("successful!");
            //JOptionPane.showMessageDialog(null, "Login is successful!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            OpenBankAccountBO OpenAcctBO = new OpenBankAccountBO(UName, CustomerName);
        } else
            //System.out.println("fail!");
            JOptionPane.showMessageDialog(null, "Login failed because of invalid username or password.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	}
}