/**
1.	Have four tables in your database.
Account(Username, Password, Name);
Account(varchar 30, varchar 30, varchar 30);

/ deposit and withdrawl methods 
CheckingAccount(CheckingAccountNumber, CustomerName, Balance, CustomerID); 
CheckingAccount(varchar 8, varchar 30, float, varchar 30); 

SavingsAccount(SavingsAccountNumber, CustomerName, Balance, CustomerID);
CheckingAccount(varchar 8, varchar 30, float, varchar 30); 

/ static variable for id

Transaction(TransactionID, TransactionType, TransactionDate, Amount, FromAccount, ToAccount, CustomerID)
Transaction(varchar 40, varchar 10, date, float, varchar 8, varchar 8, varchar 30)
FromAccount, ToAccount - foreign key from checking and savings.

getPayeeList --> should return the list of payees with id

Payee(PayeeID, PayeeName, PayerAccountNumber, PayeeAddress, PayeePhoneNumber, CustomerID)
Payee(varchar 40, varchar 30, varchar 8, varchar 40, varchar 15, varchar 30)

Payment(PaymentID, Amount, PaymentDate, PayeeID, FromAccount, CustomerID)
Payment(varchar 40, float, date, varchar 40, varchar 8, varchar 30)

FromAccount - foreign key of ?

Note that CustomerID is Username of table Account and foreign key in the tables of CheckingAccount, SavingsAccount, Transaction, Payee and Payment. 

2.	Define the five entity classes, 

1.CheckingAccount and SavingsAccount with proper instance variables and methods of opening an account, depositing to an account, withdrawing from an account, 
2.Transaction with proper instance variables and methods of recording a transaction and retrieving a transaction, 
3.Payee with proper instance variables and methods of adding a Payee, updating a Payee and deleting a Payee, and 
4.Payment with proper instance variables with methods of scheduling a Payment, canceling a scheduled Payment, delivering a scheduled Payment.  Have the classes included in your package.
**/