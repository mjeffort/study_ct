# https://leetcode.com/problems/exchange-seats/


# Write your MySQL query statement below

# SELECT ROW_NUMBER() OVER(ORDER BY id) as id, student
# FROM (
#     SELECT id+1 as id, student
#     FROM seat
#     WHERE MOD(id, 2) = 1
#     UNION ALL
#     SELECT id-1 as id, student
#     FROM seat
#     WHERE MOD(id, 2) = 0
# ) T



SELECT id+1 as id, student
FROM seat
WHERE MOD(id, 2) = 1 and id not in (select MAX(id) from seat)
UNION ALL
SELECT id-1 as id, student
FROM seat
WHERE MOD(id, 2) = 0
UNION ALL
SELECT id as id, student
FROM seat
WHERE MOD(id, 2) = 1 and id in (select MAX(id) from seat)
order by id;