# Write your MySQL query statement below
SELECT id,
    CASE
        WHEN P.p_id IS NULL THEN 'Root'
        WHEN EXISTS(
            SELECT 1
            FROM Tree C
            WHERE C.p_id = P.id
        ) THEN 'Inner'
        ELSE 'Leaf'
    END AS type
FROM Tree P