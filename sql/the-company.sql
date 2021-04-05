/*-- 
    the-company
    https://www.hackerrank.com/challenges/the-company/problem
*/

select C1.company_code, C1.founder
, COUNT(distinct C2.lead_manager_code) as lead_manager_cnt
, COUNT(distinct C3.senior_manager_code) as senior_manager_cnt
, COUNT(distinct C4.manager_code) as manager_cnt
, COUNT(distinct C5.employee_code) as employee_cnt
from Company C1
INNER JOIN Lead_Manager C2
ON C1.company_code = C2.company_code
INNER JOIN Senior_Manager C3
ON C2.company_code = C3.company_code
AND C2.lead_manager_code = C3.lead_manager_code
INNER JOIN Manager C4
ON C3.company_code = C4.company_code
AND C3.senior_manager_code = C4.senior_manager_code
INNER JOIN Employee C5 
ON C4.company_code = C5.company_code
AND C4.manager_code = C5.manager_code
group by C1.company_code, C1.founder;