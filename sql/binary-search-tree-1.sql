/**
    https://www.hackerrank.com/challenges/binary-search-tree-1/problem    

*/
select T.N,
CASE WHEN T.P IS NULL THEN 'Root'
    WHEN T2.N IS NOT NULL THEN 'Inner'
    WHEN T2.N IS NULL THEN 'Leaf'
    END
from BST T
LEFT JOIN BST T2
ON T.N = T2.P
GROUP BY T.N,
CASE WHEN T.P IS NULL THEN 'Root'
    WHEN T2.N IS NOT NULL THEN 'Inner'
    WHEN T2.N IS NULL THEN 'Leaf'
    END
ORDER BY T.N