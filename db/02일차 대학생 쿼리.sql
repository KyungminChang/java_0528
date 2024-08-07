use university;
# 컴퓨터 공학 고길동 학생이 수강 신청한 강의의 개수를 조회하는 쿼리
SELECT 
    st_name, st_major, count(*)
FROM
    course
        JOIN
    student ON st_num = co_st_num
WHERE
    st_name = '고길동' AND st_major = '컴퓨터공학';
# 신입생을 조회하는 쿼리
select * from student where st_num LIKE '2024%' and st_grade;
# 각 전공 별 학생수 조회하는 쿼리
select st_major '전공', count(*) from student group by st_major; 
# 컴퓨터공학 고길동 학생이 수강 신청한 학점을 조회하는 쿼리
SELECT 
    st_name, st_major, sum(le_point) '학점'
FROM
    course
        JOIN
    student ON st_num = co_st_num
        JOIN
    lecture ON co_le_num = le_num
WHERE
    st_name = '고길동' and st_major = '컴퓨터공학';

# 강의별 수강 신청한 학생수를 조회하는 쿼리
SELECT 
    le_title, count(co_st_num) 학생수
FROM
    course
        JOIN
    lecture ON co_le_num = le_num
GROUP BY le_title;

# 학생이 있는 학과 이름을 조회하는 쿼리
select distinct st_major from student;
select st_major from student group by st_major;

# 홍길동 학생이 수강하는 강의 목록을 조회하는 쿼리
SELECT DISTINCT
    st_name '학생이름', le_title '과목명'
FROM
    course
        JOIN
    student ON st_num = co_st_num
		JOIN
	lecture ON le_num = co_le_num
WHERE
    st_name = '홍길동';

# 김교수가 강의하는 강의명을 조회하는 쿼리
select 
	pr_name '교수명', le_title '강의명'
from lecture
	join 
    professor on pr_num = le_pr_num
where
	pr_name = '김교수';