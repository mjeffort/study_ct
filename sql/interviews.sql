/*
Enter your query here.
*/

select 
C1.contest_id
,C1.hacker_id
,C1.name
, SUM(COALESCE(S.total_submissions,0)) as total_submissions
, Sum(COALESCE(S.total_accepted_submissions,0)) as total_accepted_submissions
, SUM(COALESCE(V.total_views,0)) as total_views
, SUM(COALESCE(V.total_unique_views,0)) as total_unique_views
from Contests C1
INNER JOIN Colleges C2
ON C1.contest_id = C2.contest_id
INNER JOIN Challenges C3
ON C2.college_id = C3.college_id
LEFT JOIN (
    select challenge_id
    , SUM(total_views) as total_views
    , SUM(total_unique_views) as total_unique_views
    from View_Stats
    group by challenge_id
) V
ON C3.challenge_id = V.challenge_id
LEFT JOIN (
    select challenge_id
    , SUM(total_submissions) as total_submissions
    , SUM(total_accepted_submissions) as total_accepted_submissions
    from Submission_Stats 
    group by challenge_id
) S
ON C3.challenge_id = S.challenge_id
group by C1.contest_id, C1.hacker_id, C1.name

