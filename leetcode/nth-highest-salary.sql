CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select Salary
      from (
            select Salary,
            ROW_NUMBER() OVER(ORDER BY Salary desc) as rnum
            from Employee
            group by Salary
        ) T
        where rnum = N
        union all
        select null
        limit 1
  );
END