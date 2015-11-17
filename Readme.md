/**
1.	Have four tables in your database.
Account(Username, Password, Name);
Account(varchar 30, varchar 30, varchar 30);

/ deposit and withdrawl methods 
CheckingAccount(CheckingAccountNumber, CustomerName, Balance, CustomerID); 
CheckingAccount(varchar 10, varchar 30, float, varchar 30); 

SavingsAccount(SavingsAccountNumber, CustomerName, Balance, CustomerID);
CheckingAccount(varchar 10, varchar 30, float, varchar 30); 

/static variable for id

Transaction(TransactionID, TransactionType, TransactionDate, Amount, FromAccount, ToAccount, CustomerID)
Transaction(varchar 40, varchar 10, date, float, varchar 10, varchar 10, varchar 30)
FromAccount, ToAccount - foreign key from checking and savings.

getPayeeList --> should return the list of payees with id

Payee(PayeeID, PayeeName, PayerAccountNumber, PayeeAddress, PayeePhoneNumber, CustomerID)
Payee(varchar 40, varchar 30, varchar 10, varchar 40, varchar 15, varchar 30)

Payment(PaymentID, Amount, PaymentDate, PayeeID, FromAccount, CustomerID)
Payment(varchar 40, float, date, varchar 40, varchar 10, varchar 30)

FromAccount - foreign key of ?

Note that CustomerID is Username of table Account and foreign key in the tables of CheckingAccount, SavingsAccount, Transaction, Payee and Payment. 

2.	Define the five entity classes, 

1.CheckingAccount and SavingsAccount with proper instance variables and methods of opening an account, depositing to an account, withdrawing from an account, 
2.Transaction with proper instance variables and methods of recording a transaction and retrieving a transaction, 
3.Payee with proper instance variables and methods of adding a Payee, updating a Payee and deleting a Payee, and 
4.Payment with proper instance variables with methods of scheduling a Payment, canceling a scheduled Payment, delivering a scheduled Payment.  Have the classes included in your package.
**/


3.
Use Case Name:	
		Transfer
Participating Actor:	
		Initiated by a customer
Flow of Events:	
		1. The customer selects either Checking Account or Savings Account as source, and Savings Account as destination if selected source is Checking Account(or Checking Account as destination if selected source is Savings Account.), and enters amount of money, and then clicks on Transfer contained in TransferBO.
		2. TransferControl is created by TransferBO.
		3. The control object creates CheckingAccount (or the selected source) object and invokes an operation of withdraw, and SavingsAccount (or selected destination) object and invokes an operation of deposit. If the transfer is successful, it creates Transaction object to keep track of the transfer.
		4. TransferControl creates TransactionConfirmationBO to show “Transfer Completed!” if the transfer is successful; otherwise to show “Transfer Failed!”
Entry Conditions:	
		The customer has logged in to the system.
Exit Conditions:	
		Transfer is confirmed of success or failure.
Quality Requirements:	 
		The transfer amount must be less than or equal to the current balance of the selected source; the selected source must be different from the selected destination.
		Above is the use case of Transferring money. Similarly develop your use cases of Account Overview, Inquire Transactions, Add Payee, Edit Payee, Delete Payee, Schedule Payment, Cancel Payment, Edit Payment, and Deliver Payment by using the services from your bank as examples. And develop your Java programs to fully implement the functionalities with access to database. Assume that a customer has two accounts, Savings Account and Checking Account. 
		Organize these functionalities as tabs in a window. The default tab is Account Overview. Please combine Open Account into this application.  Show the window after successful login. Overall these tabs must be in your window, 
		
		Account Overview, 
		Open Account, 
		Transfer, 
		Inquire Transactions, 
		Bill Pay in which 
			Payee and 
			Payment are subtabs. 

		Customers can inquire their transactions by entering a starting date and ending date. 
