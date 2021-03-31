# Write your MySQL query statement below

# select Salary as SecondHighestSalary
# from (
#     select Salary,
#     ROW_NUMBER() OVER(ORDER BY Salary desc) as rnum
#     from Employee
#     group by Salary
# ) T
# where rnum = 2
# union all
# select null
# limit 1;

SELECT 
    IFNULL(
        (SELECT DISTINCT
            Salary
        FROM
            Employee
        ORDER BY Salary DESC
        LIMIT 1, 1), 
    NULL) AS SecondHighestSalary;
