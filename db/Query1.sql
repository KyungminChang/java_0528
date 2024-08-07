/*
DDL : DB나 테이블을 정의, 수정, 삭제할 때 사용하는 쿼리
	- create 
    - drop
    - alter
DML : 데이터를 추가/수정/삭제/조회할 때 사용하는 쿼리
	- insert 
    - updaate
    - delete
    - select
    
*/
# 1학년 1반 2번 둘리 학생 추가
Insert into student(grade, class, num, name) value(1, 1, 2, '둘리'); 
# 1학년 1학기 영어 과목 추가
# 1학년 1학기 수학 과목 추가
Insert into subject(grade, semester, name) values(1, 1, '영어'), (1,1, '수학'); 

# 1학년 1반 1번 학생의 영어 성적 추가 (중간: 80, 기말: 100, 수행 100)
# 1학년 1반 1번 학생의 수학 성적 추가 (중간: 100, 기말: 100, 수행 80)
# 1학년 1반 2번 학생의 국어 성적 추가 (중간: 50, 기말: 100, 수행 80)
# 1학년 1반 2번 학생의 영어 성적 추가 (중간: 100, 기말: 100, 수행 100)
# 1학년 1반 2번 학생의 수학 성적 추가 (중간: 50, 기말: 50, 수행 50)
Insert into score(midTerm, finalTerm, performance, studentNum, subjectNum);
values(80, 100, 100, 1, 2),(100,100,80,1,3),(50,100,80,2,1),(100,100,100,2,2),(50,50,50,2,3);
