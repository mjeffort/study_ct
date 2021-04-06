/**
    https://www.hackerrank.com/challenges/placements/problem
    정렬의 기준을 잘 못 알고 해석하고 있어서 오래걸림
    > sql 문제에서 항상 정렬 기준이 어떤것인지 다시 한번 확인
*/

select A.Name
from Students A
INNER JOIN Friends B
ON A.ID = B.ID
INNER JOIN Packages C
ON A.ID = C.ID
INNER JOIN Packages C2
ON B.Friend_ID = C2.ID
WHERE C.Salary <= C2.Salary
ORDER BY C2.Salary