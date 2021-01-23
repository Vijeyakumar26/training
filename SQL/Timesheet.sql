--TIME SHEET DOMAIN

SELECT * FROM  SKILL
SELECT * FROM  DEPARTMENT
SELECT * FROM  EMPLOYEE
SELECT * FROM  MOBILERECHARGE
SELECT * FROM  EMPLOYEESKILL
SELECT * FROM  ROLE
SELECT * FROM  T_PROJECT 
SELECT * FROM  ALLOCATION

-------------------------------------------------------------------------------------

--1.Which PROJECT hAS maximum number of EMPLOYEES?

--------------------------------------------------------------------------------------
SELECT project_name,project_id
FROM t_project 
WHERE project_id=(SELECT project_id FROM allocation
				GROUP BY project_id
				HAVING COUNT(emp_id)>= ALL(SELECT COUNT(emp_id) 
						   FROM allocation 
						   GROUP BY project_id))

--------------------------------------------------------------------------------------

--2.Which EMPLOYEE hAS not yet been allocated to any PROJECT?

--------------------------------------------------------------------------------------

SELECT emp_id,emp_name 
FROM employee 
WHERE emp_id  NOT IN 
(SELECT emp_id FROM allocation)

---------------------------------------------------------------------------------------

--3.Which role played BY the employee 'E03' frequently?

---------------------------------------------------------------------------------------
SELECT role_title 
FROM role 
WHERE role_id=
(SELECT role_id 
FROM allocation 
WHERE emp_id='E03' 
GROUP BY role_id 
ORDER BY COUNT(role_id) DESC
LIMIT 1)
---------------------------------------------------------------------------------------

--4.Which is the costliest Project?

---------------------------------------------------------------------------------------
SELECT project_name
FROM t_project
WHERE project_id =
	(SELECT project_id
	FROM allocation
	GROUP BY project_id
	HAVING SUM((to_date-FROM_date)*amount_per_day) >= 
				ALL(SELECT SUM((to_date-FROM_date)*amount_per_day)
				FROM allocation
				GROUP BY project_id))
---------------------------------------------------------------------------------------

--5.How many employees were there in costliest Project?

---------------------------------------------------------------------------------------

SELECT COUNT(emp_id)AS NOOFEMP,project_id,SUM((to_date-FROM_date)*amount_per_day)
FROM allocation
GROUP BY project_id
HAVING SUM((to_date-FROM_date)*amount_per_day) >= ALL
	(SELECT SUM((to_date-FROM_date)*amount_per_day)
	FROM allocation
	GROUP BY project_id)

---------------------------------------------------------------------------------------

--6.Which is the cheapest Project in the year 2012?

---------------------------------------------------------------------------------------
SELECT project_id,SUM((to_date-FROM_date)*amount_per_day)
FROM allocation
WHERE to_date::text LIKE '2012%' OR FROM_date::text LIKE '2012%'
GROUP BY project_id
HAVING SUM((to_date-FROM_date)*amount_per_day) <= ALL(SELECT SUM((to_date-FROM_date)*amount_per_day)
FROM allocation
WHERE to_date::text LIKE '2012%' OR FROM_date::text LIKE '2012%'
GROUP BY project_id)

---------------------------------------------------------------------------------------

--7.What is the salary of employee, who played maximum roles in Project 'P02'?

---------------------------------------------------------------------------------------

SELECT emp_id,emp_name,salary
FROM employee
WHERE emp_id = 
	(SELECT emp_id
	FROM allocation
	WHERE project_id='P02'
	GROUP BY emp_id
	ORDER BY COUNT(role_id) DESC LIMIT 1)

---------------------------------------------------------------------------------------

--8.How many projects are handled BY senior most employee?

---------------------------------------------------------------------------------------
SELECT COUNT(project_id)
FROM allocation
WHERE emp_id=(SELECT emp_id
	FROM employee
	ORDER BY hire_date ASC
	LIMIT 1)
---------------------------------------------------------------------------------------

--9.What is the total amount spent for unASsigned employees?

---------------------------------------------------------------------------------------
SELECT SUM(salary)
FROM employee
WHERE emp_id NOT IN
 (SELECT emp_id FROM allocation)
------------------------------------------------------------------------------------------

--10.How many projects are completed till date (ASSUMe to_date is completion date in Allocation table)?

---------------------------------------------------------------------------------------

SELECT COUNT( DISTINCT project_id) 
FROM allocation
WHERE TO_DATE < CURRENT_DATE

---------------------------------------------------------------------------------------

--11.How many employees have worked for less than 10 Projects?

---------------------------------------------------------------------------------------

SELECT  COUNT(DISTINCT emp_id)
FROM allocation
WHERE emp_id  IN(SELECT emp_id
FROM  allocation
GROUP BY emp_id
HAVING COUNT(DISTINCT project_id)<=10)

---------------------------------------------------------------------------------

--12.How many employees are working with role 'R02' in project 'P04'

---------------------------------------------------------------------------------

SELECT COUNT(emp_id) 
FROM allocation 
WHERE role_id='R02' AND project_id='P04'

---------------------------------------------------------------------------------

--13.Which client hAS given maximum number of Projects?

---------------------------------------------------------------------------------

SELECT client_name
FROM t_project
WHERE project_id =
(SELECT project_id
FROM allocation
GROUP BY project_id
HAVING COUNT(project_id)>= ALL
	(SELECT COUNT(project_id)
	FROM allocation
	GROUP BY project_id))
	
---------------------------------------------------------------------------------

--14.Which employee hAS not been allocated to any project in the year 2010?

---------------------------------------------------------------------------------

SELECT emp_id, emp_name
FROM employee
WHERE emp_id = ANY
(SELECT emp_id
FROM allocation
WHERE emp_id != ALL
	(SELECT emp_id
	FROM allocation
	WHERE FROM_date::text LIKE '2010%'
	GROUP BY emp_id)
GROUP BY emp_id)

---------------------------------------------------------------------------------

--15.Find the total number of days worked BY the employee 'E04' in project 'P02'?
---------------------------------------------------------------------------------

SELECT SUM(to_date-FROM_date) 
FROM allocation 
WHERE emp_id='E04' and Project_id='P02'

---------------------------------------------------------------------------------

--16.Which Project hAS been completed exactly ON deadline date?

---------------------------------------------------------------------------------

SELECT t.project_id,t.project_name,a.to_date,t.deadline
FROM allocation a INNER JOIN t_project t
ON a.project_id=t.project_id
GROUP BY t.project_id,a.to_date
HAVING a.to_date=t.deadline;

---------------------------------------------------------------------------------

--17.How many employees were working for the Project, which hAS crossed the deadline?

---------------------------------------------------------------------------------

SELECT a.project_id,COUNT(a.emp_id)
FROM allocation a
JOIN t_project t
ON( a.project_id=t.project_id)
WHERE a.to_date > t.deadline
GROUP BY a.project_id

---------------------------------------------------------------------------------

--18.Which Project hAS been completed so earlier?
---------------------------------------------------------------------------------

SELECT DISTINCT (tp.project_id) ,tp.project_name 
FROM t_project tp 
JOIN allocation a  
ON tp.project_id = a.project_id 
WHERE a.to_date < tp.deadline

---------------------------------------------------------------------------------

--19.Which Project hAS taken maximum duration?

---------------------------------------------------------------------------------

SELECT t.project_name, t.project_id, (a.to_date - a.FROM_date) AS days_in_project 
FROM allocation a
JOIN t_project t
ON a.project_id = t.project_id
WHERE (a.to_date - a.FROM_date) =
(SELECT MAX((to_date - FROM_date))FROM allocation)


---------------------------------------------------------------------------------

--20.Prepare a report in following format

--Emp Id	Total Number of Days in bench
---------------------------------------------------------------------------------	
	
SELECT emp_id ,days_in_bench  
FROM (SELECT e.emp_id,(a.from_date - e.hire_date  ) AS days_in_bench,
		dense_rank() over (PARTITION BY e.emp_id ORDER BY (a.from_date - e.hire_date) DESC ) AS rank 
		FROM employee e
		INNER JOIN allocation a on e.emp_id=a.emp_id
		GROUP BY e.emp_id,days_in_bench) temp 
WHERE rank = 1;
	
	
---------------------------------------------------------------------------------	
--21.	Prepare a report in followingformat

--Project Name	Number of Employees
	
---------------------------------------------------------------------------------	
	
	
SELECT t_project.project_name,COUNT(emp_id) AS number_of_employees 
FROM t_project
INNER JOIN allocation ON t_project.project_id = allocation.project_id
GROUP BY project_name
ORDER BY project_name;


---------------------------------------------------------------------------------

--22.	Prepare a report in followingformat

--Role Name	Number of Employees
	
-----------------------------------------------------------------------------------

SELECT role.role_title AS role_name,COUNT(emp_id) AS number_of_employees FROM role
INNER JOIN allocation ON role.role_id = allocation.role_id
GROUP BY role_name
ORDER BY role_name;

---------------------------------------------------------------------------------

--23.	Prepare a report in followingformat

--Emp Name	Number of Projects
---------------------------------------------------------------------------------	
	
SELECT employee.emp_name,COUNT(project_id) AS number_of_project FROM employee
INNER JOIN allocation ON employee.emp_id=allocation.emp_id
GROUP BY emp_name
ORDER BY emp_name;

---------------------------------------------------------------------------------

--24.	Prepare a report in followingformat

--Emp Name	Number of Roles

---------------------------------------------------------------------------------	
 
SELECT employee.emp_name,COUNT(role_id) AS number_of_role 
FROM employee
INNER JOIN allocation
ON employee.emp_id=allocation.emp_id
GROUP BY emp_name
ORDER BY number_of_role desc;

---------------------------------------------------------------------------------

--25.	Prepare a report in thisformat

--Role Name	Number of Employees

---------------------------------------------------------------------------------	

SELECT allocation.role_id AS ROLE_NAME,COUNT(emp_id) AS number_of_employees
 FROM allocation
INNER JOIN t_project ON allocation.project_id = t_project.project_id
GROUP BY role_id
ORDER BY role_id;

---------------------------------------------------------------------------------

--26.	Prepare a report in thisformat

--Role Name	Number of Projects
---------------------------------------------------------------------------------	
	
	
SELECT role.role_title AS role_name,COUNT(project_id) AS number_of_project
FROM role
INNER JOIN allocation ON role.role_id=allocation.role_id
GROUP BY role_name
ORDER BY role_name;
---------------------------------------------------------------------------------

--27.	Prepare a report in this format

--Emp Name	Role Name	Number of Projects
---------------------------------------------------------------------------------		
		
SELECT employee.emp_name,role.role_title AS role_name, COUNT(project_id) AS number_of_project
FROM ((allocation
INNER JOIN employee ON allocation.emp_id = employee.emp_id)
INNER JOIN role ON allocation.role_id = role.role_id)
GROUP BY emp_name,role_title
ORDER BY emp_name;

---------------------------------------------------------------------------------

--28.	Prepare a report in thisformat

--Project Name	Role Name	Number of Employees
---------------------------------------------------------------------------------		

SELECT t_project.project_name,role.role_title AS role_name,COUNT(emp_id)AS number_of_employee
FROM((allocation
INNER JOIN t_project ON allocation.project_id=t_project.project_id)
INNER JOIN role ON allocation.role_id = role.role_id)
GROUP BY role_title,project_name
ORDER BY project_name;

---------------------------------------------------------------------------------

--29.	Prepare a report in thisformat

--Role Name	Emp Name	Number of Projects
---------------------------------------------------------------------------------		
		
		
SELECT role.role_title AS role_name,employee.emp_name, COUNT(project_id) AS number_of_project
FROM ((allocation
INNER JOIN employee ON allocation.emp_id = employee.emp_id)
INNER JOIN role ON allocation.role_id = role.role_id)
GROUP BY role_title,emp_name
ORDER BY emp_name;

---------------------------------------------------------------------------------

--30.	Prepare a report in thisformat

--Dept Id	Number of Employees
---------------------------------------------------------------------------------	

SELECT DEPT_ID,COUNT(EMP_ID) AS NO_OF_EMPLOYEES
FROM EMPLOYEE
GROUP BY DEPT_ID
ORDER BY NO_OF_EMPLOYEES;
---------------------------------------------------------------------------------

--31.	Prepare a report in thisformat

--Mgr_id	Number of Employees
---------------------------------------------------------------------------------	
	
SELECT mgr_id , COUNT (emp_id) AS no_of_employees
FROM EMPLOYEE
GROUP BY
mgr_id

--------------------------------------------------------------------------------
--32.	Prepare a report in thisformat

--Emp Name	Role Name	Project Name

---------------------------------------------------------------------------------	
		
SELECT employee.emp_name, role.role_title,t_project.project_name
FROM employee INNER JOIN allocation ON employee.emp_id =allocation.emp_id
INNER JOIN role ON allocation.role_id =role.role_id
INNER JOIN t_project ON allocation.project_id =t_project.project_id

---------------------------------------------------------------------------------
/*
33.	Prepare a report in thisformat

Project id	Emp id	Total Amount collected
		
Sort the report with respect to the Total Amount collected in Descending ORDER.
*/
---------------------------------------------------------------------------------

SELECT emp_id,project_id, SUM((to_date - FROM_date)* amount_per_day) AS TOTALAMT
FROM allocation
GROUP BY emp_id,project_id
ORDER BY TOTALAMT DESC


----------------------------------------------------------------------------------
--34.	Prepare a report in thisformat

--Emp id	Role id	Total Amount collected
---------------------------------------------------------------------------------		

SELECT emp_id,role_id, SUM((to_date - FROM_date)* amount_per_day) AS TOTALAMT
FROM allocation
GROUP BY emp_id,role_id
ORDER BY TOTALAMT DESC

---------------------------------------------------------------------------------		
/*
35.	Prepare a report in thisformat

Emp id	Role id	Project id	Total Amount collected
Sort the report with respect to the Total Amount collected in Descending ORDER.
*/
---------------------------------------------------------------------------------

SELECT emp_id,project_id,role_id, SUM((to_date - FROM_date)* amount_per_day) AS TOTALAMT
FROM allocation
GROUP BY emp_id,project_id,role_id
ORDER BY TOTALAMT DESC


---------------------------------------------------------------------------------
/*
36.	Prepare a report in this format?

Emp id		Mgr Id	Comments
123			432		HAS Manager
			456		No Manger
125			456		HAS Manger
If Manager id is NULL for an employee then the comment must be “No Manager “
*/
---------------------------------------------------------------------------------

SELECT emp_id,mgr_id,
CASE
WHEN mgr_id is null then 'No manager' else 'HAS Manager'
END
AS COMMENTS
FROM employee

---------------------------------------------------------------------------------
/*
37.	Prepare a report in this format Ram Works for AShok,
									Adam works for Akbar
WHERE Ram is employee name and AShok is his corresponding manager
*/
---------------------------------------------------------------------------------

SELECT empl.emp_name||' works for '||emp.emp_name
FROM EMPLOYEE emp
INNER JOIN EMPLOYEE empl 
ON emp.emp_id=empl.mgr_id;

---------------------------------------------------------------------------------

--38.Which employees earns more than his/her manager?
---------------------------------------------------------------------------------

SELECT E.emp_name ,E.SALARY
FROM employee E
INNER JOIN employee M
ON E.Mgr_id = M.emp_id AND 
E.SALARY > M.SALARY

---------------------------------------------------------------------------------
--39.	Which manager JOINed after his/her subordinates?
---------------------------------------------------------------------------------

SELECT e.emp_name 
FROM employee e
INNER JOIN employee m 
ON e.Mgr_id = m.emp_id AND 
e.hire_date < m.hire_date

---------------------------------------------------------------------------------
--40.	Using Correlated Subquery and WITH clause
--Find all employees who earns more than the average salary of his/her department?
---------------------------------------------------------------------------------

SELECT emp_id, dept_id, salary
FROM employee AS e1
WHERE salary >
		(SELECT AVG(salary) 
    	FROM employee AS e2
    	WHERE e1.dept_id=e2.dept_id)

---------------------------------------------------------------------------------
--41.	Using Correlated Subquery:
--Display the details of employees who have changed their roles at leASt twice?
---------------------------------------------------------------------------------

SELECT emp_id,emp_name,mobile_no
FROM employee
WHERE emp_id IN (
SELECT emp_id
FROM allocation
GROUP BY emp_id
HAVING COUNT(role_id) >=  2)

---------------------------------------------------------------------------------

--42.Display the departments that does not have employees(ALL POSSIBILITIES)?

---------------------------------------------------------------------------------
SELECT dept_id 
FROM department
EXCEPT
SELECT DISTINCT dept_id 
FROM employee


SELECT dept_id 
FROM department
WHERE dept_id NOT IN (SELECT DISTINCT dept_id FROM employee)


SELECT dept_id 
FROM department d
WHERE NOT EXISTS
(
SELECT DISTINCT dept_id 
FROM employee e 
WHERE d.dept_id=e.dept_id
)
---------------------------------------------------------------------------------

--43.Find the department which hAS employees(ALL POSSIBILITIES)?

---------------------------------------------------------------------------------
SELECT dept_id 
FROM department
INTERSECT
SELECT DISTINCT dept_id 
FROM employee


SELECT dept_id 
FROM department
WHERE dept_id IN (SELECT DISTINCT dept_id FROM employee)


SELECT dept_id
FROM department d
WHERE  EXISTS
(SELECT DISTINCT dept_id
 FROM employee e 
 WHERE d.dept_id=e.dept_id)
---------------------------------------------------------------------------------
--44.	Using ROLL UP and CUBE
--Generate a report:

--ProjectID		Role ID		NoofEmployees
--------------------------------------------------------------------------------


SELECT project_id,role_id,COUNT(emp_id)
FROM allocation
GROUP BY rollup(project_id,role_id)
ORDER BY (project_id,role_id)

Cube:
SELECT project_id,role_id,COUNT(emp_id)
FROM allocation
GROUP BY rollup(project_id,role_id)
ORDER BY (project_id,role_id)

---------------------------------------------------------------------------------

--45.	Using ROLL UP and CUBE
--Generate a report:

--EmployeeID	ProjectID	Totalsalary

---------------------------------------------------------------------------------

SELECT emp_id,project_id, SUM((to_date - FROM_date)  * amount_per_day)
FROM allocation
GROUP BY ROLLUP(emp_id,project_id)
ORDER BY (emp_id,project_id)

SELECT emp_id,project_id, SUM((to_date - FROM_date)  * amount_per_day)
FROM allocation
GROUP BY CUBE(emp_id,project_id)
ORDER BY (emp_id,project_id)

---------------------------------------------------------------------------------
/* 46.	Prepare a hierarchicalreport:

LEVEL	EMPLOYEE

1	raja
2	anil
3	anjali
( hint: start with emp_name='raja' )
*/

WITH RECURSIVE subordinates AS (
SELECT
1 AS n,
emp_id,
mgr_id,
emp_name

FROM employee
WHERE  emp_name LIKE 'raja%'

UNION

SELECT
s.n+1,
e.emp_id,
e.mgr_id,
e.emp_name
FROM
employee e
INNER JOIN subordinates s ON s.emp_id = e.mgr_id) 

SELECT * FROM subordinates;

---------------------------------------------------------------------------------
/* 
47.	Using CASE/DECODE

EmpID	NumberofSkills	Description

If Employee have,
i)	more than 5 no of skills: Description is “MajorResource”
ii)	more than 3 no of skills : Description is “UsefulResource”
iii)	more than 1 no of skills : Description is “Resource”
*/
---------------------------------------------------------------------------------
CASE:

SELECT emp_id, COUNT(skill_id) AS NumberofSkills,
CASE
WHEN COUNT(skill_id) > 5 THEN 'Major Resource'
WHEN COUNT(skill_id) < 3 THEN 'Useful  Resource'
WHEN COUNT(skill_id) > 1 THEN ' Resource'
END Description
FROM employeeskill
GROUP BY emp_id
ORDER BY emp_id


---------------------------------------------------------------------------------
/*
48.	Generate a report :

	EmpID	Noofleaves	Description

If no of leaves is greater than 6, Description is “Loss of Pay”
If no of leaves is less than or equal to 6, Description is “No loss of pay” If no of leaves is equal to zero, Description is “Bonus”

conditon is wrong/ input not given
*/
---------------------------------------------------------------------------------

SELECT emp_id,(cASual_leave + sick_leave + privilege_leave) AS leave,
CASE
WHEN (cASual_leave + sick_leave + privilege_leave) >= 6 THEN 'NO Loss of pay '
WHEN (cASual_leave + sick_leave + privilege_leave) < 6 THEN 'Loss of pay '
WHEN (cASual_leave + sick_leave + privilege_leave) = 0 THEN 'bnus'
END as desch
FROM employee
GROUP BY emp_id

---------------------------------------------------------------------------------
--49.	List TOP 5 salariedEmployees?
---------------------------------------------------------------------------------

SELECT emp_id,emp_name,salary FROM employee	 WHERE emp_id IN
(SELECT emp_id FROM
	(SELECT emp_id,emp_name ,dense_rank() over (ORDER BY salary DESC) AS rank FROM employee ) temp
	WHERE temp.rank <=5
) ORDER BY salary DESC

---------------------------------------------------------------------------------

--50.	List TOP 3 Departments (with respect to maximum no ofemployees)?
---------------------------------------------------------------------------------

SELECT dept_id,rank FROM
(  SELECT dept_id ,COUNT(dept_id),dense_rank() over (ORDER BY COUNT(dept_id) DESC) AS rank
FROM employee
GROUP BY dept_id ORDER BY rank  )  temp
WHERE temp.rank <=3

---------------------------------------------------------------------------------

--51.	.For each Department display the 2nd maximum salary earner?
---------------------------------------------------------------------------------
WITH Department AS
(
SELECT
dept_id,
dept_name
FROM
department
GROUP BY
dept_id
ORDER BY dept_id
),
EmployeeRanked AS
(
SELECT
DENSE_RANK() OVER (PARTITION BY dept_id ORDER BY salary DESC) AS Rank,
dept_id,
emp_id, emp_name,
salary
FROM
employee
ORDER BY dept_id
)
SELECT
er.Rank,
d.dept_id,
er.emp_id,
er.emp_name,
er.salary
FROM
department AS d
LEFT OUTER JOIN EmployeeRanked AS er    ON er.dept_id = d.dept_id
AND er.Rank = 2

---------------------------------------------------------------------------------

--52.	Generate areport:
--EmpName	Number ofskills

---------------------------------------------------------------------------------

SELECT e.emp_name AS Employee_Name ,COUNT(s.skill_id) AS Number_Of_skills
FROM employeeskill s INNER JOIN employee e ON s.emp_id=e.emp_id
GROUP BY e.emp_name

---------------------------------------------------------------------------------
--53.	Generate a report :

--EmpName	Numberofrechargesdonesofar
---------------------------------------------------------------------------------

SELECT e.emp_name AS Employee_Name ,COUNT(t.mobile_no) AS Number_of_recharges_done_so_far
FROM mobilerecharge t 
INNER JOIN employee e 
ON t.mobile_no=e.mobile_no
GROUP BY e.emp_name

---------------------------------------------------------------------------------
--54.	Delete duplicate rows FROM Employee table(UsingROWID)?
--------------------------------------------------------------------------------- 
DELETE FROM employee
WHERE rowid not in
(SELECT MIN(rowid)
FROM employee
GROUP BY emp_id, dept_id, mobile_no);
