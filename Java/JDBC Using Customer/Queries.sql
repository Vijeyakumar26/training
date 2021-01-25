CREATE TABLE CUSTOMERS 
(customerId INT PRIMARY KEY,customerName VARCHAR(20), accountno INT, accountType VARCHAR(10), 
 balance Numeric(7,2), mailId VARCHAR(20),contactNo INT);
 
 
INSERT INTO CUSTOMERS (customerId,customerName,accountno,accountType,balance,mailId,contactNo)
VALUES(1,'anu',45645,'Savings',5000.00,'fdjh@htcindia',987456321);

SELECT * FROM CUSTOMERS;

SELECT customerId,customerName,accountno,accountType,balance,mailId,contactNo FROM CUSTOMERS;

TRUNCATE CUSTOMERS;