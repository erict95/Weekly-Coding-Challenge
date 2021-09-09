CREATE TABLE worker(
worker_id SERIAL UNIQUE PRIMARY KEY, 
first_name VARCHAR(255),
last_name VARCHAR(255),
salary INTEGER,
joining_date TIMESTAMP,
department VARCHAR(255)
);

CREATE TABLE bonus(
worker_ref_id SERIAL,
bonus_date TIMESTAMP,
bonus_amount VARCHAR(255),
CONSTRAINT workers_id PRIMARY KEY (worker_ref_id),
FOREIGN KEY (worker_ref_id) REFERENCES worker(worker_id)
);

CREATE TABLE title(
worker_ref_id SERIAL,
worker_title VARCHAR(255),
affected_from TIMESTAMP,
CONSTRAINT workers_id PRIMARY KEY (worker_ref_id),
FOREIGN KEY (worker_ref_id) REFERENCES worker(worker_id)
);

INSERT INTO worker VALUES
(1, 'Rick', 'Smith', 100000, '2021-02-20 09:00:00', 'HR'),
(2, 'Sam', 'Williams', 80000, '2021-06-11 09:00:00', 'Admin'),
(3, 'John', 'Brown', 300000, '2021-02-20 09:00:00', 'HR'),
(4, 'Amy', 'Jones', 500000, '2021-02-20 09:00:00', 'Admin'),
(5, 'Sean', 'Garcia', 500000, '2021-06-11 09:00:00', 'Admin'),
(6, 'Ryan', 'Miller', 200000, '2021-06-11 09:00:00', 'Account'),
(7, 'Patty', 'Davis', 75000, '2021-01-20 09:00:00', 'Account'),
(8, 'Monica', 'Rodriguez', 90000, '2021-04-11 09:00:00', 'Admin');

INSERT INTO bonus VALUES
(1, '2021-02-20 00:00:00', 5000),
(2, '2021-06-11 00:00:00', 3000),
(3, '2021-02-20 00:00:00', 4000),
(1, '2021-02-20 00:00:00', 4500),
(2, '2021-06-11 00:00:00', 3500);

INSERT INTO title VALUES
(1, 'Manager', '2021-02-20 00:00:00'),
(2, 'Executive', '2021-06-11 00:00:00'),
(8, 'Executive', '2021-06-11 00:00:00'),
(5, 'Manager', '2021-06-11 00:00:00'),
(4, 'Asst. Manager', '2021-06-11 00:00:00'),
(7, 'Executive', '2021-06-11 00:00:00'),
(6, 'Lead', '2021-06-11 00:00:00'),
(3, 'Lead', '2021-06-11 00:00:00');

--A) Write an SQL query to fetch worker names with salaries >= 50000 and <= 100000
SELECT first_name, last_name, salary 
FROM worker 
WHERE salary >= 50000 AND salary <= 100000;

--B) Write an SQL query to fetch the no. of workers for each department in the descending order.
SELECT COUNT(worker_id), department 
FROM worker 
GROUP BY department 
ORDER BY department DESC;

--C) Write an SQL query to fetch intersecting records of two tables.
SELECT A.worker_id, A.first_name, A.last_name, B.worker_title, A.salary, C.bonus_amount 
FROM ((worker A 
INNER JOIN title B
ON A.worker_id = B.worker_ref_id)
INNER JOIN bonus C
ON A.worker_id = A.worker_ref_id);

--D) Write an SQL query to determine the 5th highest salary without using TOP or limit method.
SELECT * FROM worker A
WHERE 4 = (
SELECT COUNT(DISTINCT salary) FROM worker B
WHERE B.salary > A.salary
);