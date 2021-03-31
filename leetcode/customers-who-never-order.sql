# Write your MySQL query statement below
# https://leetcode.com/problems/customers-who-never-order/solution/

select Name as Customers
from Customers 
left join Orders
on Customers.Id = Orders.CustomerId
where Orders.Id is null;