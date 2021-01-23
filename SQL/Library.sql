SELECT * FROM AUTHORS
SELECT * FROM MEMBERS
SELECT * FROM PUBLISHER
SELECT * FROM BOOKS
SELECT * FROM BOOK_TRANSACTION


--SOLUTIONS:
===========================================================================================================

--1) How many books are there in each category, in the library?

-------------------------------------------------------------------------------------------------------------

SELECT book_category, COUNT(book_category)
FROM books GROUP BY
book_category

-------------------------------------------------------------------------------------------------------------

--2) Title wise how may copies of books are available in the ‘rdbms’
--category?

-------------------------------------------------------------------------------------------------------------

SELECT  title,sum(copy_no) 
FROM books
WHERE
book_category='RDBMS'
GROUP BY title

-------------------------------------------------------------------------------------------------------------	

--3) Prepare a list of the latest edition of the books in category/title sequence,
--in the following format:
--Category title edition
-------------------------------------------------------------------------------------------------------------

SELECT book_category,title,MAX(edition) 
FROM books 
GROUP BY book_category,title
 
-------------------------------------------------------------------------------------------------------------

--4) Which publisher(s) books are the maximum available in the library?

-------------------------------------------------------------------------------------------------------------

SELECT publisher_id,publisher_name 
FROM publishers
WHERE publisher_id=(SELECT publisher_id FROM
		(SELECT publisher_id,DENSE_RANK()OVER(ORDER BY COUNT(publisher_id) DESC ) "bookc"
		FROM books GROUP BY publisher_id) a
		WHERE a.bookc=1)
			  
-------------------------------------------------------------------------------------------------------------

--5) Prepare a list of books that are due as on date, in delay descending
--sequence , in the following format:

--Title      member name      due date delay
-------------------------------------------------------------------------------------------------------------

SELECT b.title, m.member_name,t.due_date AS delay_due_date
FROM members m,book_transaction t, books b 
WHERE t.return_date > t.due_date AND t.member_id = m.member_id
AND t.book_id = b.book_id
ORDER by t.due_date desc;
			  
-------------------------------------------------------------------------------------------------------------
--6) What are the categories of books published by ‘willey publications’
-------------------------------------------------------------------------------------------------------------

SELECT book_category
FROM books
WHERE publisher_id=(
		SELECT publisher_id FROM publishers
		WHERE publisher_name='ralco')
GROUP BY book_category
				  
-------------------------------------------------------------------------------------------------------------
--7) Which are the categories of books that are least utilised
-------------------------------------------------------------------------------------------------------------

SELECT book_category
FROM books
WHERE book_id NOT IN( 
	SELECT book_id FROM book_transaction)
			 
-------------------------------------------------------------------------------------------------------------
--8) Which are the categories of books that are most utilised
-------------------------------------------------------------------------------------------------------------

SELECT book_category
FROM books
WHERE book_id IN(SELECT book_id FROM book_transaction)
			 
-------------------------------------------------------------------------------------------------------------
--9) Which books were not lent during the last quarter of the year(oct-dec
--2003)
-------------------------------------------------------------------------------------------------------------

SELECT book_id,title 
FROM books
WHERE book_id NOT IN 
(SELECT book_id
FROM book_transaction
WHERE EXTRACT (year FROM issue_date) != 2003 AND EXTRACT ( month FROM issue_date) NOT IN (10,11,12))

-------------------------------------------------------------------------------------------------------------
--10) List the book detail taken by each member.
-------------------------------------------------------------------------------------------------------------

SELECT b.title,m.member_name 
FROM books b,members m,book_transaction t
WHERE b.book_id=t.book_id AND  t.member_id=m.member_id 

-------------------------------------------------------------------------------------------------------------
--11) Which author’s book is more in number in the library?
-------------------------------------------------------------------------------------------------------------
        
SELECT author_name
FROM authors
WHERE author_id=(
		SELECT author_id 
		FROM 
		(SELECT author_id,DENSE_RANK()OVER(ORDER BY count(author_id)desc) "authorc"
		FROM books GROUP BY author_id) a
		WHERE a.authorc=1)
		
-------------------------------------------------------------------------------------------------------------	
--12) Which author’s book is costliest?
-------------------------------------------------------------------------------------------------------------

SELECT author_name
FROM authors
WHERE author_id=(SELECT author_id 
		FROM 
		(SELECT author_id,DENSE_RANK()OVER(ORDER BY MAX(price) desc) "authorc"
		FROM books 
		GROUP BY author_id) a
		WHERE a.authorc=1)
		
-------------------------------------------------------------------------------------------------------------
--13) Along with member details, list the books that crossed the due date.
-------------------------------------------------------------------------------------------------------------    
 
SELECT b.title,t.book_id,m.member_id 
FROM books b,book_transaction t,members m
WHERE return_date>due_date AND b.book_id=t.book_id AND t.member_id=m.member_id

-------------------------------------------------------------------------------------------------------------
--14) Who is the most delaying member in the library?
-------------------------------------------------------------------------------------------------------------

SELECT member_name FROM members
WHERE member_id=(SELECT member_id 
			FROM book_transaction 
			WHERE return_date>due_date)   
			
-------------------------------------------------------------------------------------------------------------
--15) Which publication is being used by most of the members?
-------------------------------------------------------------------------------------------------------------

SELECT publisher_name 
FROM publishers
WHERE publisher_id IN (
			SELECT publisher_id 
			FROM books
			WHERE book_id IN(
					SELECT book_id 
					FROM book_transaction
					WHERE member_id IN(
						SELECT member_id 
						FROM members)))
						
-------------------------------------------------------------------------------------------------------------			   
       
--16) How many copies of book available in each publication?

-------------------------------------------------------------------------------------------------------------

SELECT sum(copy_no),publisher_id
FROM books
GROUP BY publisher_id

-------------------------------------------------------------------------------------------------------------

--17) Find the books that is lent after fewer days of its acquisition? MIN(return_date-issue_date)

-------------------------------------------------------------------------------------------------------------

SELECT b.book_id ,b.title
FROM book_transaction bt
JOIN books b
ON (b.book_id=bt.book_id)
GROUP by b.book_id
HAVING MIN(return_date-issue_date) <= ALL
	(SELECT MIN(return_date-issue_date)
	FROM  book_transaction bt
	GROUP by b.book_id)

-------------------------------------------------------------------------------------------------------------

--18) Along with book details, list the members who returns the book
--Before the due date.

-------------------------------------------------------------------------------------------------------------

SELECT b.title,m.member_name 
FROM books b,members m,book_transaction t
WHERE t.return_date<=t.due_date AND t.book_id=b.book_id AND t.member_id=m.member_id

-------------------------------------------------------------------------------------------------------------
		   
--19) Which is the costliest book in each publication?

-------------------------------------------------------------------------------------------------------------

SELECT  DISTINCT p.publisher_name,b.title,b.price
FROM  books b,publishers p,
			  (SELECT  publisher_id,MAX(price) pr 
			  FROM books
			  GROUP BY publisher_id) a
WHERE a.publisher_id=b.publisher_id AND a.pr=b.price AND b.publisher_id=p.publisher_id
			  
-------------------------------------------------------------------------------------------------------------

--20) List the authors belonging to each publication.

-------------------------------------------------------------------------------------------------------------

SELECT DISTINCT a.author_name,p.publisher_name 
FROM authors a,publishers p,books b
WHERE a.author_id=b.author_id AND  b.publisher_id=p.publisher_id
ORDER BY p.publisher_name;
		
-------------------------------------------------------------------------------------------------------------

--21) Which publication’s book is most delayed in returning?

-------------------------------------------------------------------------------------------------------------

SELECT publisher_name 
FROM publishers
WHERE publisher_id=(
		SELECT publisher_id 
		FROM books
		WHERE book_id=(SELECT book_id 
					FROM book_transaction
					WHERE return_date>due_date))
					
-------------------------------------------------------------------------------------------------------------
		 
---22) Which department is frequent in accessing the library?

-------------------------------------------------------------------------------------------------------------

SELECT member_id, member_dept 
FROM members
WHERE member_id IN(
		  SELECT member_id FROM book_transaction)
		  
-------------------------------------------------------------------------------------------------------------	
	  
--23) Which book the training dept. Is using frequently?

-------------------------------------------------------------------------------------------------------------

SELECT b.title 
FROM books b,book_transaction t,members m
WHERE t.member_id=m.member_id 
AND   t.book_id=b.book_id
AND  m.member_dept='TRNG'
		  
-------------------------------------------------------------------------------------------------------------

--24) List the members in each department who accessed the library
--During the month of june’2003.

-------------------------------------------------------------------------------------------------------------

SELECT member_name,member_dept 
FROM members
WHERE member_id=
	   (SELECT member_id FROM book_transaction
	   WHERE issue_date= )
	   
-------------------------------------------------------------------------------------------------------------

--25) Find the latest edition of each book along with their authors name?

-------------------------------------------------------------------------------------------------------------

SELECT DISTINCT b.title,b.author_id,a.author_name 
FROM books b,authors a,
     (SELECT  title ,MAX(edition) edi FROM books
		 GROUP BY  title) h
WHERE b.title=h.title AND b.edition=h.edi AND b.author_id=a.author_id

-------------------------------------------------------------------------------------------------------------

--26) Who is the frequent accesser in each department?

-------------------------------------------------------------------------------------------------------------

SELECT member_name
FROM members
WHERE member_id IN
		(SELECT member_id FROM book_transaction)
		
-------------------------------------------------------------------------------------------------------------

--27) Which is the cheapest book in each publication?

-------------------------------------------------------------------------------------------------------------

SELECT  DISTINCT b.title,b.publisher_id,b.price
 FROM books b,
	(SELECT publisher_id ,MIN(price) pr 
		FROM books
		group by publisher_id) a
		WHERE b.publisher_id = a.publisher_id AND b.price = a.pr;
		
-------------------------------------------------------------------------------------------------------------

--28) How many no. Of books available for “java” in each publication?

-------------------------------------------------------------------------------------------------------------      

SELECT publisher_id ,COUNT(publisher_id)
FROM books 
WHERE title='UNIX'
GROUP BY publisher_id
		
		SELECT *FROM books 
		WHERE title='UNIX' AND publisher_id=50003
		
-------------------------------------------------------------------------------------------------------------

--29) Count the inactive members in each department.

-------------------------------------------------------------------------------------------------------------

SELECT member_dept,count(member_dept)
FROM members
WHERE  status='I'
GROUP BY member_dept

-------------------------------------------------------------------------------------------------------------

--30) Which book is being returned very late frequently?

-------------------------------------------------------------------------------------------------------------

SELECT title , book_id 
FROM books
WHERE book_id in (SELECT book_id FROM BOOK_TRANSACTION 
					WHERE return_date>due_date);
					
-------------------------------------------------------------------------------------------------------------

--31) Which book is being favourite of each department? 

-------------------------------------------------------------------------------------------------------------

SELECT b.title as fav_book,M.MEMBER_DEPT,COUNT(bt.BOOK_ID) 
FROM MEMBERS M 
JOIN book_transaction  bt
ON M.MEMBER_ID=bt.MEMBER_ID
JOIN books b
ON (b.book_id=bt.book_id)
GROUP BY b.title, M.MEMBER_DEPT

-------------------------------------------------------------------------------------------------------------

--32) Which books were rent during the first quarter of the year?

-------------------------------------------------------------------------------------------------------------

SELECT book_id 
FROM book_transaction
WHERE issue_date >= justify_interval(interval '120 days');
		
SELECT justify_interval(interval '120 days'),
EXTRACT(QUARTER FROM justify_interval('120 days')); 

-------------------------------------------------------------------------------------------------------------

--33) Who are the inactive members in each department?

-------------------------------------------------------------------------------------------------------------

SELECT member_dept,member_name 
FROM members
WHERE status='I'
GROUP BY member_dept,member_name
		
-------------------------------------------------------------------------------------------------------------

--34) Who is frequent visitor of the library?

-------------------------------------------------------------------------------------------------------------

SELECT member_name
FROM members 
WHERE member_id IN (SELECT member_id FROM book_transaction)

-------------------------------------------------------------------------------------------------------------    

--35) List the bookname, author_name, publisher_name for the books
--Available in rack no. 5
-------------------------------------------------------------------------------------------------------------

SELECT b.rack_number,b.title, a.author_name, p.publisher_name
FROM  books b,authors a,publishers p
WHERE  b.publisher_id=p.publisher_id AND b.author_id=a.author_id AND rack_number=5

-------------------------------------------------------------------------------------------------------------

--36) Which rack of books is being accessed frequently?

-------------------------------------------------------------------------------------------------------------

SELECT  book_id, rack_number 
FROM books 
WHERE book_id  IN 
	  (SELECT book_id FROM book_transaction)
	  
-------------------------------------------------------------------------------------------------------------

--37) Which rack of books is being accessed least?

-------------------------------------------------------------------------------------------------------------

SELECT DISTINCT(rack_number)
FROM books 
GROUP BY book_id
HAVING COUNT(book_id) <= ALL
	  (SELECT COUNT(book_id) FROM book_transaction
	  GROUP BY book_id)
	  
-------------------------------------------------------------------------------------------------------------

--38) Count the book rack wise.

-------------------------------------------------------------------------------------------------------------

SELECT rack_number,count(rack_number)
FROM books 
GROUP BY rack_number

-------------------------------------------------------------------------------------------------------------

--39) Who is the oldest member of the library?

-------------------------------------------------------------------------------------------------------------

SELECT member_name
FROM members 
WHERE member_st_da = (SELECT MIN(member_st_da) 
					FROM members);
ORDER BY member_st_da ASC;
  
-------------------------------------------------------------------------------------------------------------

--40) Which is being the favourite book (frequently accessed) of the oldest member of the library?

-------------------------------------------------------------------------------------------------------------

SELECT title 
FROM books 
WHERE book_id=(
	SELECT book_id FROM book_transaction WHERE member_id = 
	(SELECT member_id
	FROM members 
	WHERE member_st_da =(SELECT MIN(member_st_da) AS d 
						FROM members)));

-------------------------------------------------------------------------------------------------------------	

--41) Which is being the favourite book (frequently accessed) of the
--frequent accesser of the library?

-------------------------------------------------------------------------------------------------------------
SELECT title ,book_id 
FROM books 
WHERE book_id=(SELECT book_id 
				FROM book_transaction 
				WHERE issue_date= 
					(SELECT MAX(issue_date) 
					FROM book_transaction));
	 
-------------------------------------------------------------------------------------------------------------	 