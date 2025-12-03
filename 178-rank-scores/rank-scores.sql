# Write your MySQL query statement below
select score, Dense_rank() over(order by score DESC) as "Rank"
FROM Scores;