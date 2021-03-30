create table occupations(
name varchar(20),
occupation varchar(20)
);

insert into occupations (name, occupation)
VALUES
('Samantha', 'Doctor'),
('Julia', 'Actor'),
('Maria', 'Actor'),
('Meera', 'Singer'),
('Ashely', 'Professor'),
('Ketty', 'Professor'),
('Christeen', 'Professor'),
('Jane', 'Actor'),
('Jenny', 'Doctor'),
('Priya', 'Singer')
;

select * from occupations;


select 
	SUM(DECODE(occupation, 'Doctor', name)) as "Doctor",
	SUM(DECODE(occupation, 'Actor', name)) as "Actor",
    SUM(DECODE(occupation, 'Singer', name)) as "Singer",
    SUM(DECODE(occupation, 'Professor', name)) as "Professor"
from occupations;
select *
FROM OCCUPATIONS a,(SELECT @vOccup:='', @rownum:=0 FROM DUAL) b;


SELECT a.*,
        (CASE @vOccup WHEN a.OCCUPATION THEN @rownum:=@rownum+1 ELSE @rownum:=1 END) rnum,
        (@vOccup:=a.OCCUPATION) vOccup
    FROM OCCUPATIONS a,(SELECT @vOccup:='', @rownum:=0 FROM DUAL) b
    ORDER BY OCCUPATION, NAME ;
    
    
SELECT
    GROUP_CONCAT(if(Occupation = 'Doctor', Name, NULL)) AS 'Doctor', 
    GROUP_CONCAT(if(Occupation = 'Professor', Name, NULL)) AS 'Professor', 
    GROUP_CONCAT(if(Occupation = 'Singer', Name, NULL)) AS 'Singer', 
    GROUP_CONCAT(if(Occupation = 'Actor', Name, NULL)) AS 'Actor'
FROM
(
    SELECT a.*,
        (CASE @vOccup WHEN a.OCCUPATION THEN @rownum:=@rownum+1 ELSE @rownum:=1 END) rnum,
        (@vOccup:=a.OCCUPATION) vOccup
    FROM OCCUPATIONS a,(SELECT @vOccup:='', @rownum:=0 FROM DUAL) b
    ORDER BY OCCUPATION, NAME ) c
GROUP BY c.rnum;
    
