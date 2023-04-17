insert into customer
	(customer_code, customer_name, customer_pass, customer_birth, customer_job, customer_mail,
	    customer_tel, customer_post, customer_add, role)
values (customer_seq.nextval, '심재학','$2y$10$ubWOBrX/6BNDf1yO12EiGOyOJNTdMef0COfZy0p8iTmPyKAHCHCAq','2016-08-15','회사원','sim@naver.com',
    '010-','12345','경기도 고양시','ROLE_USER');
   
insert into customer
	(customer_code, customer_name, customer_pass, customer_birth, customer_job, customer_mail,
	    customer_tel, customer_post, customer_add, role)
values (customer_seq.nextval, '오소고날','$2y$10$ubWOBrX/6BNDf1yO12EiGOyOJNTdMef0COfZy0p8iTmPyKAHCHCAq','2020-04-15','과학자','ohsogonal@naver.com',
    '010-','180-50','경기도 광주시','ROLE_USER');
    
  
insert into customer
	(customer_code, customer_name, customer_pass, customer_birth, customer_job, customer_mail,
	    customer_tel, customer_post, customer_add, role)
values (customer_seq.nextval, 'admin','$2y$10$ubWOBrX/6BNDf1yO12EiGOyOJNTdMef0COfZy0p8iTmPyKAHCHCAq','2016-08-15','회사원','admin@naver.com',
    '010-','12345','경기도 고양시','ROLE_ADMIN');

  
INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '아바타: 물의 길', 10000);

INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '어벤져스 : 엔드게임', 5000);

INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '토르 : 라그나로크', 1000);

INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '닥터 스트레인지: 대혼돈의 멀티버스', 7000);

INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '어벤져스', 7000);

INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '토르: 러브 앤 썬더', 5000);

INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '맨 오브 스틸', 500);

INSERT INTO MOVIE(MOVIE_ID, TITLE, PRICE) VALUES (MOVIE_SEQ.NEXTVAL, '앤트맨과 와스프', 9000);