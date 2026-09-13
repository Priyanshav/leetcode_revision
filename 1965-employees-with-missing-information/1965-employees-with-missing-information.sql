# Write your MySQL query statement below
SELECT employee_id
FROM (
    SELECT employee_id
    FROM Employees
    UNION ALL
    SELECT employee_id
    FROM Salaries
    ORDER BY employee_id
) AS employee_id
GROUP BY employee_id
HAVING COUNT(*) = 1