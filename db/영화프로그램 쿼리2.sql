use cgv;
select * from screen;
# 데드풀과 울버린 영화의 CGV 강남에서 7/27에 상영하는 상영시간표를 조회하는 쿼리
SELECT 
    mo_title 영화, th_name 영화관, sc_name 상영관, sd_date 상영일, sd_time 상영시간
FROM
    schedule
        JOIN
    screen ON sc_num = sd_sc_num
		JOIN
	THEATER ON sc_th_num = th_num
		JOIN
	movie ON sd_mo_num = mo_num
WHERE
    sd_date = '2024-07-27' AND th_name = 'CGV강남' AND mo_title = '데드풀과 울버린';
# 서브 쿼리를 이용
SELECT  mo_title 영화, th_name 영화관, sc_name 상영관, sd_date 상영일, sd_time 상영시간 FROM SCHEDULE
 JOIN SCREEN ON SD_SC_NUM = SC_NUM
 JOIN (SELECT * FROM THEATER WHERE TH_NAME = 'CGV강남') TH
	ON SC_TH_NUM = TH_NUM
    JOIN (SELECT * FROM MOVIE WHERE MO_TITLE = '데드풀과 울버린') MO
    ON MO_NUM = SD_MO_NUM
    WHERE SD_DATE = '2024-07-27';
# CGV강남 1관에 등록된 좌석을 조회하는 쿼리
SELECT 
    se_name 좌석명
FROM
    seat
        JOIN
    screen ON se_sc_num = sc_num
        JOIN
    theater ON sc_th_num = th_num
		JOIN
	schedule ON sd_num = ti_sd_num
WHERE
    th_num = 1 AND sc_name = '1관';
# abc 123회원이 예약한 예매 내역을 조회하는 쿼리(영화 제목, 극장 이름, 상영관 이름, 시간, 좌석번호)
SELECT 
    MO_TITLE 영화, sd_date 일시, sd_time 시간, th_name 극장, sc_name 상영관, se_name 좌석, ticketing.*, movie.*
FROM
    ticketing
    JOIN ticketing_list ON ti_num = tl_ti_num
    JOIN seat ON se_num = tl_se_num
    JOIN schedule ON sd_num = ti_sd_num
    JOIN screen ON sd_sc_num = sc_num
    JOIN THEATER ON TH_NUM = SC_TH_NUM
    JOIN MOVIE ON SD_MO_NUM = MO_NUM
WHERE
    ti_me_id = 'abc123';

# 1번 스케쥴에 예약된 좌석을 조회하는 쿼리
SELECT 
    SE_NAME '예약된 좌석 번호'
FROM
  (SELECT * FROM ticketing WHERE TI_SD_NUM = 6) TT
  JOIN TICKETING_LIST ON TI_NUM = TL_TI_NUM
  JOIN SEAT ON TL_SE_NUM = SE_NUM;
# CGV강남점 1관의 좌석을 조회하는 쿼리
# 1번 상영관의 좌석들을 조회하는 쿼리
SELECT * FROM SEAT  WHERE SE_SC_NUM = 1;

# 데드풀과 울버린 CGV강남점 1관 7/27 10:00에 예약된 좌석을 조회
# 데드풀과 울버린 CGV강남점 1관 7/27 10:00에 예약 가능한 좌석을 조회
# 1번 스케줄에 예약 가능한 1번 상영관 좌석을 조회하는 쿼리
SELECT 
    SE_NAME
FROM
    SEAT
WHERE
    SE_SC_NUM = 1
        AND SE_NAME NOT IN (SELECT 
            SE_NAME
        FROM
            (SELECT 
                *
            FROM
                ticketing
            WHERE
                TI_SD_NUM = 6) TT
                JOIN
            TICKETING_LIST ON TI_NUM = TL_TI_NUM
                JOIN
            SEAT ON TL_SE_NUM = SE_NUM);
# 1번 스케줄에서 예약 가능한 좌석들의 수를 조회
SELECT COUNT(SE_NAME) 예약가능한좌석수
FROM
    SEAT
WHERE
    SE_SC_NUM = 1
        AND SE_NAME NOT IN (SELECT 
            SE_NAME
        FROM
            (SELECT 
                *
            FROM
                ticketing
            WHERE
                TI_SD_NUM = 6) TT
                JOIN
            TICKETING_LIST ON TI_NUM = TL_TI_NUM
                JOIN
            SEAT ON TL_SE_NUM = SE_NUM);
# 장르별 등록된 영화 개수를 조회하는 쿼리
SELECT MG_GE_NAME, COUNT(MG_MO_NUM) FROM MOVIE_GENRE JOIN GENRE ON GE_NAME = MG_GE_NAME GROUP BY MG_GE_NAME; 
SELECT GE_NAME, COUNT(MG_NUM) FROM MOVIE_GENRE RIGHT JOIN GENRE ON GE_NAME = MG_GE_NAME GROUP BY GE_NAME;

# 개봉한 영화를 조회하는 쿼리
SELECT * FROM MOVIE WHERE MO_DATE <= NOW();

# 오늘부터 한 달 사이에 개봉한 영화를 조회하는 쿼리
SELECT * FROM MOVIE WHERE MO_DATE BETWEEN DATE_SUB(NOW(), INTERVAL 1 MONTH) AND NOW();