

-- Write your MySQL query statement below

with unique_email(email, id) as (
    select email, min(id) as id
    from Person
    group by email
)
delete
from Person
where id not in (select id from unique_email);
