/**
   https://www.hackerrank.com/challenges/symmetric-pairs/problem 
    쌍으로 이루어지는 값이 있는 값을 출력하는 조건
    x = y 일때, x <> y 일 때 조건이 달라짐에 유의
*/

select P.x, P.y
FROM Functions P
INNER JOIN Functions P2
ON P.x = P2.y and P.y = P2.x
group by P.x , P.y
having (P.x = P.y and count(*) > 1) or P.x < P.y
order by P.x
