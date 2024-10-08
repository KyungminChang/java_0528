USE PRODUCT;

DROP TABLE IF EXISTS TEST;
CREATE TABLE TEST(
	NUM INT PRIMARY KEY AUTO_INCREMENT,
    DATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);
DROP EVENT IF EXISTS INSERT_EVENT;
CREATE EVENT INSERT_EVENT
ON SCHEDULE EVERY 30 SECOND
STARTS '2024-07-25 12:35:00'
DO
	INSERT INTO TEST() VALUES();
    
SELECT * FROM TEST;
SELECT * FROM INFORMATION_SCHEMA.EVENTS;

# 이벤트 스케쥴러 상태 확인
SHOW VARIABLES LIKE 'EVENT%';

# 이벤트 스케쥴러 상태 변경
SET GLOBAL EVENT_SCHDULER = ON; # ON RO OFF
    