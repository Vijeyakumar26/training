SALES DOMAIN
-----------------------------------------------------------------------------------------
SELECT * FROM country
SELECT * FROM branch
SELECT * FROM salesrep
SELECT * FROM order_master
SELECT * FROM order_detail
SELECT * FROM customer
SELECT * FROM product
SELECT * FROM category

-----------------------------------------------------------------------------------------

--1.Which category has maximum products?
------------------------------------------------------------------------------------------

SELECT category_code,COUNT (product_code)
FROM product
GROUP BY category_code
HAVING COUNT(product_code)>=ALL
(SELECT COUNT(product_code)
FROM product 
GROUP BY category_code)

------------------------------------------------------------------------------------------

--2.Which category has minimum products?

------------------------------------------------------------------------------------------
SELECT category_code,COUNT (product_code)
FROM product
GROUP BY category_code
HAVING COUNT(product_code)<=ALL
(SELECT COUNT(product_code)
FROM product 
GROUP BY category_code)
------------------------------------------------------------------------------------------

--3.Which category has no products?

------------------------------------------------------------------------------------------

SELECT category_code
FROM category 
where category_code NOT IN(SELECT DISTINCT category_code from product )

------------------------------------------------------------------------------------------

--4.Which is the costliest product?

------------------------------------------------------------------------------------------

SELECT product code,price
FROM product 
WHERE price=(SELECT MAX(price)FROM product)

------------------------------------------------------------------------------------------

--5.Which category has costliest product?

------------------------------------------------------------------------------------------

SELECT category_code
FROM product
WHERE price=(SELECT MAX(price)FROM product)

------------------------------------------------------------------------------------------

--6.Which category has lot of products (with respect to quantity ON hand)?

------------------------------------------------------------------------------------------

SELECT category_code,SUM(qty_ON_hand)
FROM product
GROUP BY category_code
HAVING SUM(qty_ON_hand) >= ALL
	(SELECT SUM(qty_ON_hand)
	FROM product
	GROUP BY category_code)
------------------------------------------------------------------------------------------

--7. Category wise display the costliest products?

------------------------------------------------------------------------------------------

SELECT category_code,product_code,price
FROM(SELECT category_code,product_code,price,
	 DENSE_RANK() OVER(PARTITION BY category_code ORDER BY price DESC)AS rank
	FROM product)tmp
	WHERE rank=1

------------------------------------------------------------------------------------------

--8.Category wise display the product whose quantity ON hand is minimum?

------------------------------------------------------------------------------------------

SELECT category_code,SUM(qty_ON_hand)
FROM product
GROUP BY category_code
HAVING SUM(qty_ON_hand) <= ALL
	(SELECT SUM(qty_ON_hand)
	FROM product
	GROUP BY category_code)

------------------------------------------------------------------------------------------

--9.Which order has maximum products?

------------------------------------------------------------------------------------------
SELECT order_code,COUNT(product_code)
FROM order_detail
GROUP BY order_code
HAVING COUNT(product_code)>=ALL(
	SELECT COUNT(product_code)
	FROM order_detail
	GROUP BY order_code)
------------------------------------------------------------------------------------------

--10.Which is the frequently ordered product?

------------------------------------------------------------------------------------------
SELECT PROD_DESC
FROM PRODUCT
WHERE PRODUCT_CODE = ANY
	(SELECT product_code
	FROM order_detail
	GROUP BY product_code	
	HAVING COUNT(order_code)>=ALL(
		SELECT COUNT(order_code)
		FROM order_detail
		GROUP BY product_code))
------------------------------------------------------------------------------------------

--11.Which product is least ordered product?

------------------------------------------------------------------------------------------

SELECT PROD_DESC
FROM PRODUCT
WHERE PRODUCT_CODE = ANY
	(SELECT PRODUCT_CODE
	FROM ORDER_DETAIL
	GROUP BY PRODUCT_CODE
	HAVING COUNT(ORDER_CODE)<=
		ALL(SELECT COUNT(ORDER_CODE)
  		FROM ORDER_DETAIL
  		GROUP BY PRODUCT_CODE
		ORDER BY PRODUCT_CODE DESC))


------------------------------------------------------------------------------------------

--12.What product is not at all ordered?

------------------------------------------------------------------------------------------

SELECT product_code
FROM product
WHERE product_code
NOT IN(SELECT DISTINCT(product_code)FROM order_detail)

------------------------------------------------------------------------------------------

--13.Which is the costliest order? ( Calculate the bill )

------------------------------------------------------------------------------------------

SELECT order_code,SUM(qty_ordered*price)AS bill
FROM product PR JOIN order_detail OD
ON OD.product_code=PR.product_code
GROUP BY order_code
HAVING SUM(qty_ordered*price)>=
ALL(SELECT SUM(qty_ordered*price)AS bill
   FROM product PR JOIN order_detail OD
   ON OD.product_code=PR.product_code
   GROUP BY order_code)

------------------------------------------------------------------------------------------

--14.In which date the costliest order made?

------------------------------------------------------------------------------------------

SELECT OD.order_code,ODM.order_date
FROM product PR 
JOIN order_detail OD ON PR.product_code=OD.product_code
JOIN order_master ODM
ON OD. order_code=ODM.order_code
GROUP BY OD.order_code,ODM.order_date
HAVING SUM(qty_ordered*price)>=ALL
	(SELECT SUM(qty_ordered*price)AS bill
	FROM product PR JOIN order_detail OD
	ON PR.product_code=OD.product_code
	GROUP BY order_code)

------------------------------------------------------------------------------------------

--15.Which customer made the costliest order?

------------------------------------------------------------------------------------------

SELECT C.CUSTOMER_CODE,C.CUSTOMER_NAME,SUM(A.QTY_ORDERED * P.PRICE) AS PRICE FROM CUSTOMER C
JOIN ORDER_MASTER M 
ON C.CUSTOMER_CODE=M.CUSTOMER_CODE
JOIN ORDER_DETAIL A 
ON M.ORDER_CODE=A.ORDER_CODE
JOIN PRODUCT P 
ON A.PRODUCT_CODE=P.PRODUCT_CODE
GROUP BY C.CUSTOMER_CODE
ORDER BY PRICE DESC LIMIT 1


------------------------------------------------------------------------------------------

--16.Which customer made the costliest order today? 

------------------------------------------------------------------------------------------

SELECT C.CUSTOMER_CODE,C.CUSTOMER_NAME,SUM(A.QTY_ORDERED * P.PRICE) AS PRICE FROM CUSTOMER C
JOIN ORDER_MASTER M 
ON C.CUSTOMER_CODE=M.CUSTOMER_CODE
JOIN ORDER_DETAIL A
ON M.ORDER_CODE=A.ORDER_CODE
JOIN PRODUCT P 
ON A.PRODUCT_CODE=P.PRODUCT_CODE
WHERE M.ORDER_DATE= M.ORDER_DATE
GROUP BY C.CUSTOMER_CODE
ORDER BY PRICE DESC LIMIT 1


------------------------------------------------------------------------------------------
--17.Generate the report like
--Customer name -- Ordercode-- Orderdate-- No_of_products_ordered--  Total Bill--
------------------------------------------------------------------------------------------

SELECT C.CUSTOMER_NAME, M.ORDER_CODE ,M.ORDER_DATE,COUNT(DISTINCT A.PRODUCT_CODE) 
AS "NO_OF_PRODUCTS_ORDERED",SUM(A.QTY_ORDERED * P.PRICE)
AS "TOTAL_BILL" FROM CUSTOMER C
JOIN ORDER_MASTER M 
ON C.CUSTOMER_CODE= M.CUSTOMER_CODE
JOIN ORDER_DETAIL A
ON M.ORDER_CODE=A.ORDER_CODE
JOIN PRODUCT P
ON A.PRODUCT_CODE=P.PRODUCT_CODE
GROUP BY C.CUSTOMER_NAME,M.ORDER_CODE
ORDER BY "TOTAL_BILL" DESC


------------------------------------------------------------------------------------------

--18.Write query the customers who are eligible for home delivery (if
--tot_bill>=5000)?XX

-----------------------------------------------------------------------------------------

SELECT C.CUSTOMER_NAME,COUNT(DISTINCT A.PRODUCT_CODE) AS "NO_OF_PRODUCTS_ORDERED",
SUM(A.QTY_ORDERED * PRICE) AS "TOT_VALUE"
FROM CUSTOMER C
JOIN ORDER_MASTER M ON C.CUSTOMER_CODE =M.CUSTOMER_CODE
JOIN ORDER_DETAIL A ON M.ORDER_CODE=A.ORDER_CODE
JOIN PRODUCT P ON P.PRODUCT_CODE=P.PRODUCT_CODE
GROUP BY C.CUSTOMER_NAME,M.ORDER_CODE
HAVING SUM(A.QTY_ORDERED * PRICE)>=5000

-----------------------------------------------------------------------

--19.Which country has maximum branches?

---------------------------------------------------------------------

SELECT COUNTRY_NAME
FROM COUNTRY
WHERE COUNTRY_CODE = ANY
		(SELECT COUNTRY_CODE
		FROM BRANCH
		GROUP BY COUNTRY_CODE
		HAVING COUNT(COUNTRY_CODE) >= ALL(SELECT COUNT(COUNTRY_CODE)
						FROM BRANCH
						GROUP BY COUNTRY_CODE))
GROUP BY COUNTRY_NAME

---------------------------------------------------------------------

--20.Which country has minimum branches?

---------------------------------------------------------------------

SELECT COUNTRY_NAME
FROM COUNTRY
WHERE COUNTRY_CODE = ANY
		(SELECT COUNTRY_CODE
		FROM BRANCH
		GROUP BY COUNTRY_CODE
		HAVING COUNT(COUNTRY_CODE) <= ALL(SELECT COUNT(COUNTRY_CODE)
						FROM BRANCH
						GROUP BY COUNTRY_CODE))
GROUP BY COUNTRY_NAME
---------------------------------------------------------------------

--21.Which country has no branches?

---------------------------------------------------------------------

SELECT COUNTRY_NAME
FROM COUNTRY
WHERE COUNTRY_CODE =
	(SELECT COUNTRY_CODE
	FROM COUNTRY
	EXCEPT
	SELECT DISTINCT(COUNTRY_CODE)
	FROM BRANCH)

---------------------------------------------------------------------

--22.Which branch has more sales representatives?

---------------------------------------------------------------------

SELECT BRANCH_NAME
FROM BRANCH
WHERE BRANCH_CODE = ANY
		(SELECT BRANCH_CODE
		FROM SALESREP
		GROUP BY BRANCH_CODE
		HAVING COUNT(BRANCH_CODE) >= ALL(SELECT COUNT(BRANCH_CODE)
						FROM SALESREP
						GROUP BY BRANCH_CODE))
GROUP BY BRANCH_NAME

---------------------------------------------------------------------

--23.Which branch has less sales representatives?

---------------------------------------------------------------------

SELECT BRANCH_NAME
FROM BRANCH
WHERE BRANCH_CODE = ANY
		(SELECT BRANCH_CODE
		FROM SALESREP
		GROUP BY BRANCH_CODE
		HAVING COUNT(BRANCH_CODE) <= ALL(SELECT COUNT(BRANCH_CODE)
						FROM SALESREP
						GROUP BY BRANCH_CODE))
GROUP BY BRANCH_NAME

---------------------------------------------------------------------

--24.Which branch has no sales representatives?

---------------------------------------------------------------------

SELECT BRANCH_NAME
FROM BRANCH
WHERE BRANCH_CODE =
		(SELECT BRANCH_CODE
		FROM BRANCH
		EXCEPT
		SELECT DISTINCT(BRANCH_CODE)
		FROM SALESREP)

---------------------------------------------------------------------

--25.Who is the active sales rep?

---------------------------------------------------------------------

SELECT SALESREP_NAME
FROM SALESREP
WHERE SALESREP_ID =
		(SELECT SALESREP_ID
		FROM ORDER_MASTER
		WHERE ORDER_DATE = (SELECT MAX(ORDER_DATE)
					FROM ORDER_MASTER))

---------------------------------------------------------------------

--26.Display all the manager’s names?

---------------------------------------------------------------------

SELECT SALESREP_NAME
FROM SALESREP
WHERE SALESREP_ID = ANY
	(SELECT DISTINCT(MGR)
	FROM SALESREP
	WHERE MGR IS NOT NULL)

---------------------------------------------------------------------

--27.Display the sales rep that who has JOINed before their manager?

---------------------------------------------------------------------

SELECT e.SALESREP_NAME 
FROM SALESREP e
INNER JOIN SALESREP m 
ON e.Mgr = m.salesrep_id AND 
e.SALESREP_DOJ < m.SALESREP_DOJ

------------------------------------------------------------------------------------

--28.Display the sales rep that who earns more than their manager?

------------------------------------------------------------------------------------

SELECT E.SALESREP_NAME ,E.SALARY
FROM SALESREP E
INNER JOIN SALESREP M
ON E.Mgr = M.salesrep_id AND 
E.SALARY > M.SALARY

------------------------------------------------------------------------------------------------

--29.Display the manager who earns more than average salary of the sales rep
--working under them.

------------------------------------------------------------------------------------------------

SELECT M.MGR, E.SALESREP_ID,E.SALESREP_NAME ,AVG(E.SALARY)
FROM SALESREP E
INNER JOIN SALESREP M
ON E.Mgr = M.salesrep_id 
WHERE M.SALARY > E.SALARY
GROUP BY M.MGR, E.SALESREP_ID,E.SALESREP_NAME

------------------------------------------------------------------------------------------------

--30.Display the sales rep details that who started their work immediately?

------------------------------------------------------------------------------------------------

SELECT S.SALESREP_ID ,S.SALESREP_NAME,S.SALESREP_DOJ
FROM SALESREP S
INNER JOIN ORDER_MASTER M
ON S.SALESREP_ID=M.SALESREP_ID
WHERE S.SALESREP_DOJ >= M.ORDER_DATE
GROUP BY S.SALESREP_ID ,S.SALESREP_NAME,S.SALESREP_DOJ
----------------------------------------------------------------------------

--31.Display the sales rep that who is in bench for a lONg time?

---------------------------------------------------------------------------
SELECT S.SALESREP_NAME 
FROM SALESREP S JOIN ORDER_MASTER O
ON S.SALESREP_ID = O.SALESREP_ID
WHERE S.SALESREP_DOJ-O.ORDER_DATE >=
	(SELECT MAX(S.SALESREP_DOJ-O.ORDER_DATE) 
	FROM SALESREP S JOIN ORDER_MASTER O
	ON S.SALESREP_ID = O.SALESREP_ID)

---------------------------------------------------------------------------

--32.Display the details of in-active sales representatives.

---------------------------------------------------------------------------

SELECT SALESREP_NAME
FROM SALESREP
WHERE SALESREP_ID NOT IN
		(SELECT SALESREP_ID
		FROM ORDER_MASTER
		)

-----------------------------------------------------------------------------------------------

--33. Generate the report like
--SALESREP_ID | SALES_REP_NAME | SALARY | TOTAL_ORDER_VALUE | COMM 5% OF BILL

--------------------------------------------------------------------------------------------

SELECT s.SALESREP_ID, s.SALESREP_NAME, s.SALARY,sum(p.price*d.qty_ordered)as total_order_value, SUM(0.05*(P.PRICE*D.QTY_ORDERED)) AS COMM 
FROM SALESREP s
JOIN order_master m ON
	s.SALESREP_ID=m.SALESREP_ID
JOIN order_detail d ON 
	m.order_code=d.order_code
JOIN product p ON 
	p.product_code=d.product_code
	group by s.salesrep_id 
	order by salesrep_id asc
---------------------------------------------------------------------------------------------------------------

--34. Generate the report like
  -- SALESREP_NAME | ORDER_CODE | BILL_VALUE
   
---------------------------------------------------------------------------------------------------------------


SELECT s.SALESREP_NAME,M.ORDER_CODE ,sum(p.price*d.qty_ordered)as total_order_value
FROM SALESREP s
JOIN order_master m ON
	s.SALESREP_ID=m.SALESREP_ID
JOIN order_detail d ON 
	m.order_code=d.order_code

JOIN product p ON 
	p.product_code=d.product_code
	group by s.SALESREP_NAME, M.ORDER_CODE, S.salesrep_id
	order by S.salesrep_id asc
-----------------------------------------------------------------------------------------------------------------------------------------------
--35. Generate the report like
  -- SALESREP_NAME | ORDER_CODE | NO.OF.PRODUCTS  IN ORDER
-----------------------------------------------------------------------------------------------------------------------------------------------

SELECT s.SALESREP_NAME,M.ORDER_CODE ,COUNT(P.PRODUCT_CODE)as NOPRODUCTS
FROM SALESREP s
JOIN order_master m ON
	s.SALESREP_ID=m.SALESREP_ID
JOIN order_detail d ON 
	m.order_code=d.order_code
JOIN product p ON 
	p.product_code=d.product_code
	group by s.SALESREP_NAME, M.ORDER_CODE,S.salesrep_id
	order by S.salesrep_id asc
-----------------------------------------------------------------------------------------------------------------------------------------------
--36. Generate the report like
--	SALESREP_NAME | ORDER_CODE | BILL_VALUE | NO.OF.PRODUCTS  IN ORDER

	A. For the orders placed ON the year 2010
	B. For the sales rep who has placed not more than 10 orders
	C. For the sales rep whose salary >45000
---------------------------------------------------------------------------------------------

--	36 A. For the orders placed ON the year 2010
	
---------------------------------------------------------------------------------------------

SELECT s.SALESREP_NAME,M.ORDER_CODE ,
		sum(p.price*d.qty_ordered)as total_order_value, COUNT(P.PRODUCT_CODE)as NOPRODUCTS
FROM SALESREP s
JOIN order_master m ON
	s.SALESREP_ID=m.SALESREP_ID
JOIN order_detail d ON 
	m.order_code=d.order_code
JOIN product p ON 
	p.product_code=d.product_code
	WHERE EXTRACT(YEAR FROM M.ORDER_DATE) = '2010'
	group by s.SALESREP_NAME, M.ORDER_CODE, S.salesrep_id
	order by S.salesrep_id asc
	
-------------------------------------------------------------------------------------------

--	36 B. For the sales rep who has placed not more than 10 orders
	
--------------------------------------------------------------------------------------------

SELECT s.SALESREP_NAME,M.ORDER_CODE ,
		sum(p.price*d.qty_ordered)as total_order_value, COUNT(P.PRODUCT_CODE)as NOPRODUCTS
FROM SALESREP s
JOIN order_master m ON
	s.SALESREP_ID=m.SALESREP_ID
JOIN order_detail d ON 
	m.order_code=d.order_code
JOIN product p ON 
	p.product_code=d.product_code
	group by s.SALESREP_NAME, M.ORDER_CODE, S.salesrep_id
	HAVING COUNT(M.SALESREP_ID) < 10
	order by S.salesrep_id asc
--------------------------------------------------------------------------------------------------------

--36C.For the sales rep whose salary >45000

--------------------------------------------------------------------------------------------------------

SELECT s.SALESREP_NAME,M.ORDER_CODE ,
		sum(p.price*d.qty_ordered)as total_order_value, COUNT(P.PRODUCT_CODE)as NOPRODUCTS
FROM SALESREP s
JOIN order_master m ON
	s.SALESREP_ID=m.SALESREP_ID
JOIN order_detail d ON 
	m.order_code=d.order_code
JOIN product p ON 
	p.product_code=d.product_code
	WHERE S.SALARY > 45000
	group by s.SALESREP_NAME, M.ORDER_CODE, S.salesrep_id
	order by S.salesrep_id asc

-----------------------------------------------------------------------------------------------------------------

--37. Who is the senior most sales rep?

-----------------------------------------------------------------------------------------------------------------

SELECT salesrep_name
FROM salesrep
WHERE salesrep_id IN (SELECT salesrep_id FROM (
        SELECT salesrep_id , DENSE_RANK()OVER(ORDER BY (now()-salesrep_doj)desc)as rank 
		FROM salesrep)temp
		WHERE temp.rank<=1)
				
-----------------------------------------------------------------------------------------------------------------

--38. Find the no of orders processed by junior most sales rep

-----------------------------------------------------------------------------------------------------------------
             
SELECT o.salesrep_id,s.salesrep_name,COUNT(o.order_code)
FROM order_master o inner JOIN salesrep s ON o.salesrep_id = s.salesrep_id
WHERE o.salesrep_id = (
		SELECT salesrep_id
		FROM salesrep
		WHERE salesrep_id IN (SELECT salesrep_id FROM (
	        SELECT salesrep_id , DENSE_RANK()OVER(ORDER BY (now()-salesrep_doj)) as rank 
                FROM salesrep)temp
			    WHERE temp.rank<=1)
	)
	GROUP BY o.salesrep_id,s.salesrep_name
---------------------------------------------------------------------------------------------------------

--39. Find the no of orders processed by each mONth in the year 2010?

-----------------------------------------------------------------------------------------------------------------

SELECT COUNT(M.ORDER_CODE)AS NOORDERS,M.ORDER_CODE, TO_CHAR((M.ORDER_DATE),'MONth')
FROM SALESREP s
JOIN ORDER_MASTER m ON
	s.SALESREP_ID=m.SALESREP_ID
JOIN ORDER_DETAIL d ON 
	M.ORDER_CODE=D.ORDER_CODE
	WHERE EXTRACT(YEAR FROM M.ORDER_DATE) = '2010'
	group by M.ORDER_CODE
	order by M.ORDER_DATE ASC


------------------------------------------------------------------------------------------------------------------

--40. Which regiON is having in-active sales rep (using JOINs) ?

-----------------------------------------------------------------------------------------------------------------

SELECT c.regiON
FROM salesrep s inner JOIN branch b
ON s.branch_code = b.branch_code
inner JOIN country c
ON b.country_code = c.country_code
WHERE s.salesrep_id = 			
(SELECT salesrep_id
FROM salesrep
EXCEPT                             
SELECT salesrep_id 
FROM order_master)
    
-----------------------------------------------------------------------------------------------------------------

--41. Which regiON is having junior most sales rep?

-----------------------------------------------------------------------------------------------------------------
     
SELECT regiON 
FROM salesrep s inner JOIN branch b
ON s.branch_code = b.branch_code
inner JOIN country c
ON b.country_code = c.country_code
WHERE b.branch_code = (
SELECT branch_code FROM salesrep
WHERE salesrep_id = (SELECT salesrep_id 
FROM salesrep 
WHERE salesrep_doj = (SELECT MAX(salesrep_doj)
                      FROM salesrep)))
   
--------------------------------------------------------------------------------------------------------------------------------

--42. Find the no of orders whose bill is less than 500?

--------------------------------------------------------------------------------------------------------------------------------

SELECT COUNT(M.ORDER_CODE),sum(p.price*d.qty_ordered)as total_order_value 
FROM SALESREP s
JOIN order_master m ON
	s.SALESREP_ID=m.SALESREP_ID
JOIN order_detail d ON 
	m.order_code=d.order_code
JOIN product p ON 
	p.product_code=d.product_code
	group by M.ORDER_CODE
	HAVING sum(p.price*d.qty_ordered) <500
	order by  M.ORDER_CODE asc

---------------------------------------------------------------------------------------------------------------------------------

--43. What is the frequently ordered product by the most active customer?

---------------------------------------------------------------------------------------------------------------------------------

SELECT product_code 
FROM (
SELECT p.product_code , DENSE_RANK() OVER (ORDER BY COUNT(p.product_code)DESC) AS ranks
FROM product p JOIN order_detail o
ON P.product_code = o.product_code
INNER JOIN order_master om
ON om.order_code = o.order_code
WHERE om.order_code IN (	

SELECT order_code FROM order_master 
WHERE customer_code IN 
	(SELECT customer_code FROM (
SELECT customer_code , DENSE_RANk() OVER( ORDER BY COUNT(customer_code)desc ) as ran
FROM order_master
GROUP BY customer_code 
	)temp
	 WHERE temp.ran = 1))
	GROUP BY p.product_code) s
	WHERE ranks =1
------------------------------------------------------------------------------------------------------------------------------------

--44. What are all the products are not ordered by active customer? 

------------------------------------------------------------------------------------------------------------------------------------

SELECT p.product_code , p.prod_desc
FROM product p JOIN order_detail od
ON p.product_code = od.product_code
JOIN order_master om 
ON od.order_code = om.order_code
WHERE om.order_code NOT IN (
SELECT order_code FROM order_master 
WHERE customer_code IN (SELECT customer_code FROM (
SELECT customer_code , DENSE_RANk() OVER( ORDER BY COUNT(customer_code)desc ) as ran
FROM order_master
GROUP BY customer_code )temp
	WHERE temp.ran = 1))

--------------------------------------------------------------------------------------------------------------------------------------

--45. Display the orders which can’t be processed immediately?
--(Hint: where order quantity>qoh)

-------------------------------------------------------------------------------------------------------------------------------------------   

SELECT ORDER_CODE
FROM ORDER_DETAIL O
JOIN PRODUCT P
ON O.PRODUCT_CODE = P.PRODUCT_CODE
WHERE O.QTY_ORDERED > P.QTY_ON_HAND

-------------------------------------------------------------------------------------------------------------------------------------------------------
--46. Complete order report
--Cust_name | Cust_address | Order_code | Product_id | Product_name | Order_date
-------------------------------------------------------------------------------------------------------------------------------------------------------

SELECT c.customer_name , om.order_code , p.product_code , p.prod_desc , om.order_date
FROM customer c JOIN order_master om 
ON c.customer_code = om.customer_code 
JOIN order_detail od
ON om.order_code = od.order_code 
JOIN product p
ON od.product_code = p.product_code

 ------------------------------------------------------------------------------------------------------------------------------------------------------------
--47.What is the order of executiON of clauses????
 ------------------------------------------------------------------------------------------------------------------------------------------------------------
FROM 		1
WHERE		2
GROUP BY	3
HAVING		4
SELECT		5
ORDER BY	6
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
--48. Department(branch) wise who is the maximum salary earner?
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

SELECT salesrep_id,salesrep_name,Max_Salary,branch_code 
FROM (
	SELECT s.salesrep_id,s.salesrep_name,MAX(salary) as Max_Salary,b.branch_code,
	DENSE_RANK() OVER(PARTITION by b.branch_code order by MAX(salary)DESC) as rank
	FROM salesrep s
JOIN branch b
ON s.branch_code=b.branch_code
GROUP BY s.salesrep_id,s.salesrep_name,b.branch_code
ORDER BY branch_code DESC)temp
WHERE temp.rank=1

 ------------------------------------------------------------------------------------------------------------------------------------------------------------
--49. Find the Top-10 active customers based ON no. of orders?
 ------------------------------------------------------------------------------------------------------------------------------------------------------------

SELECT customer_code FROM (
SELECT customer_code , DENSE_RANk() OVER( ORDER BY COUNT(customer_code)desc ) as ran
FROM order_master
GROUP BY customer_code )temp
	WHERE temp.ran  <= 10

 ------------------------------------------------------------------------------------------------------------------------------------------------------------
--50. Find the Top-5 orders based ON bill value.
 ------------------------------------------------------------------------------------------------------------------------------------------------------------

SELECT d.order_code ,sum(p.price*d.qty_ordered)as bill_value
FROM product p
JOIN order_detail d 
ON p.product_code=d.product_code
group by d.order_code
order by bill_value desc
limit 5

 ------------------------------------------------------------------------------------------------------------------------------------------------------------
--51. Display the sales rep that who processed the orders OR11 and OR15.
 ------------------------------------------------------------------------------------------------------------------------------------------------------------

SELECT s.salesrep_id , s.salesrep_name 
 FROM salesrep s INNER JOIN order_master o 
 ON s.salesrep_id = o.salesrep_id 
 WHERE o.order_code IN ('OR11' , 'OR15')

 ------------------------------------------------------------------------------------------------------------------------------------------------------------
--52. Generate a report like ‘worker works for manager’
--Ex:
--	Ramesh works for Suresh
--	Suresh works for naresh
 ------------------------------------------------------------------------------------------------------------------------------------------------------------

SELECT empl.salesrep_name||' works for '||emp.salesrep_name
FROM salesrep emp
INNER JOIN salesrep empl 
ON emp.salesrep_id=empl.mgr;

------------------------------------------------------------------------------------------------------------------------------------------------------------