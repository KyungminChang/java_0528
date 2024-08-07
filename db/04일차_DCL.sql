# cgv DB관리를 위한 cgv_admin 계정을 추가(비번 : admin123)
# CREATE USER '아이디'@'호스트명' IDENTIFIED BY '비밀번호';
# 호스트명 
# 	- localhost 내부에서만 사용 가능(다른 PC에서 해당 DB에 접근 불가능)
# 	- % : 외부에서도 사용 가능(다른 PC에서도 아이디와 비번이 맞으면 접근 가능)
# cgv DB 관리를 위한 cgv_admin 계정을 추가(비번 : admin123)
CREATE USER 'cgv_admin'@'%' IDENTIFIED BY 'admin123';

# 계정 조회
SELECT USER, HOST FROM MYSQL.USER;