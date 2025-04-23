-- 유저 테이블
CREATE TABLE user_tbl (
    user_id      VARCHAR2(50) PRIMARY KEY,
    user_pw      VARCHAR2(50) NOT NULL,
    user_mail    VARCHAR2(50) NOT NULL,
    user_tell    VARCHAR2(50),
    user_score   NUMBER(3) DEFAULT 1 NOT NULL,
    user_point   NUMBER(3) DEFAULT 10 NOT NULL,
    user_day     DATE DEFAULT SYSDATE NOT NULL
    
);

CREATE TABLE quiz_tbl (
    quiz_id  VARCHAR2(50) PRIMARY KEY,
    quiz_title VARCHAR2(50) NOT NULL,
    quiz_answer VARCHAR2(50) NOT NULL,
    quiz_solved  NUMBER(10) NOT NULL
);

insert into quiz_tbl values ('Lv.1', '기본 출력', 'Hello, Java!', 0);
insert into quiz_tbl values ('Lv.2', '변수와 연산', '11', 0);
insert into quiz_tbl values ('Lv.3', '조건문', 'B', 0);
insert into quiz_tbl values ('Lv.4', '반복문', '1 2 3', 0);
insert into quiz_tbl values ('Lv.5', '배열', '12', 0);
insert into quiz_tbl values ('Lv.6', '메서드 호출', '12', 0);
insert into quiz_tbl values ('Lv.7', '객체 생성과 필드', '민수', 0);
insert into quiz_tbl values ('Lv.8', '상속과 오버라이딩', '멍멍', 0);
insert into quiz_tbl values ('Lv.9', 'static과 인스턴스', '3', 0);
insert into quiz_tbl values ('Lv.10', '예외 처리와 흐름', '에러 발생끝', 0);
insert into quiz_tbl values ('Lv.11', '증감 연산자', '12', 0);
insert into quiz_tbl values ('Lv.12', '배열과 반복문', '2 3 4 2 ', 0);
insert into quiz_tbl values ('Lv.13', '재귀 알고리즘', '8', 0);
insert into quiz_tbl values ('Lv.14', '클래스와 객체 초기화', '25', 0);


-- 게시글 테이블
create table post_tbl (
    post_id NUMBER PRIMARY KEY,
    user_id VARCHAR2(50) NOT NULL,
    title VARCHAR2(200) NOT NULL,
    content CLOB NOT NULL,
    likes NUMBER DEFAULT 0,
    views NUMBER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_post_user FOREIGN KEY (user_id) REFERENCES user_tbl(user_id)
);
-- 댓글 테이블
CREATE TABLE comment_tbl (
    comment_id      NUMBER(10) PRIMARY KEY,
    post_id         NUMBER(10) NOT NULL,
    user_id         VARCHAR2(50) NOT NULL,  
    comment_content VARCHAR2(500) NOT NULL,
    comment_good    NUMBER(3) DEFAULT 1 NOT NULL,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_comment_post FOREIGN KEY (post_id) REFERENCES post_tbl(post_id),
    CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES user_tbl(user_id)
);

--글 , 댓글 시퀸스
CREATE SEQUENCE post_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE comment_seq START WITH 1 INCREMENT BY 1;