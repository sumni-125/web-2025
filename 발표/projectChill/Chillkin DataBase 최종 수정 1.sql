CREATE TABLE Menu (
	Menu_Code VARCHAR2(255)  PRIMARY KEY,
    Menu_Name VARCHAR2(255) NOT NULL,
	Price VARCHAR2(255) NULL,
	ingredient_needs VARCHAR2(255) NULL
);

CREATE TABLE Hub (
	H_I_Code VARCHAR2(255) PRIMARY KEY,
	H_I_Name VARCHAR2(255) NULL,
	H_I_Cnt number(3) NULL,
	H_I_Price VARCHAR2(255) NULL
);

CREATE TABLE Branches (
	Branch_Id VARCHAR2(5) PRIMARY KEY,
	Pw VARCHAR2(255) NULL,
	Address VARCHAR2(255) NULL,
	Tel VARCHAR2(255) NULL
);

CREATE TABLE ingredients (
	I_Code VARCHAR2(255), 
	Branch_Id VARCHAR2(255) NOT NULL,
	I_Name VARCHAR2(255) NULL,
	I_Cnt number(3) NULL,
	FOREIGN KEY (Branch_Id) REFERENCES Branches(Branch_Id),
    FOREIGN KEY (I_CODE) REFERENCES Hub(H_I_Code)
);


CREATE TABLE B_Order (
	O_Code VARCHAR2(255) PRIMARY KEY,
	Menu_Code VARCHAR2(255) NOT NULL,
	Branch_Id VARCHAR2(255) NOT NULL,
    O_cnt NUMBER(2) NOT NULL,
    O_Date DATE DEFAULT SYSDATE,
	FOREIGN KEY (Menu_Code) REFERENCES Menu(Menu_Code),
	FOREIGN KEY (Branch_Id) REFERENCES Branches(Branch_Id)
);

CREATE TABLE B_I_ORDER (
    B_I_Code VARCHAR2 (5) PRIMARY KEY,
    B_I_Date DATE DEFAULT SYSDATE,
    B_Code VARCHAR2(5),
    I_Code VARCHAR2(255),
    I_Cnt NUMBER(3),
    FOREIGN KEY (B_Code) REFERENCES Branches(Branch_ID),
    FOREIGN KEY (I_Code) REFERENCES Hub(H_I_Code)
);

CREATE TABLE Reviews (
  R_CODE VARCHAR2(5) PRIMARY KEY,
  ID VARCHAR2(5),
  TITLE VARCHAR2(500),
  DETAIL VARCHAR2(1000),
  ANSWER VARCHAR2(1000),
  R_DATE DATE DEFAULT SYSDATE,
  CONSTRAINT FK_Reviews_Branches FOREIGN KEY (ID)
    REFERENCES Branches(Branch_Id)
);



-- 가맹점 코드 생성 시퀀스
CREATE OR REPLACE TRIGGER TRG_CREATE_BRANCHE_CODE
BEFORE INSERT ON branches
for each row
DECLARE
    v_branch_code varchar2(4);   
BEGIN
    -- branche_code에 사용할 전화번호 뒷 4자리 가져오기
    if :new.branch_id is null then
    v_branch_code := substr(replace(:new.tel,'-',''),-4,4);
    :NEW.Branch_Id := 'B' || v_branch_code ;
     END if;
end;
/


-- 가맹점 테이블 생성
INSERT INTO Branches (branch_id, pw, address)
values ('admin', 'admin', '본사');

INSERT INTO Branches ( Pw, Address, Tel) 
VALUES ('pass123', '서울 강남구', '02-1111-2222');

INSERT INTO Branches (Pw, Address, Tel) 
VALUES ('chicken77', '부산 해운대구', '010-3333-4444');

INSERT INTO Branches (Pw, Address, Tel) 
VALUES ('bbq321', '대구 수성구', '010-5555-6666');


-- 메뉴 테이블 생성
INSERT INTO MENU (Menu_Code, Menu_Name, Price, ingredient_needs) VALUES ('CH001','Chillcken', '16000', '닭고기');
INSERT INTO Menu (Menu_Code, Menu_Name, Price, ingredient_needs) VALUES ('CH002','간장 치킨', '17000', '닭고기,간장소스');
INSERT INTO Menu (Menu_Code, Menu_Name, Price, ingredient_needs) VALUES ('CH003','양념 치킨', '18000', '닭고기,양념소스');
INSERT INTO Menu (Menu_Code, Menu_Name, Price, ingredient_needs) VALUES ('CH004','뿌링클 치킨', '21000', '닭고기,뿌링클시즈닝');
INSERT INTO Menu (Menu_Code, Menu_Name, Price, ingredient_needs) VALUES ('CH005','슈프림 양념 치킨', '23000', '닭고기,양념소스,슈프림소스');

-- Hub 테이블 생성
INSERT INTO Hub (H_I_Code, H_I_Name, H_I_Cnt, H_I_Price) VALUES ('I001', '닭고기', '100', '3000');
INSERT INTO Hub (H_I_Code, H_I_Name, H_I_Cnt, H_I_Price) VALUES ('I002', '간장소스', '50', '500');
INSERT INTO Hub (H_I_Code, H_I_Name, H_I_Cnt, H_I_Price) VALUES ('I003', '양념소스', '60', '600');
INSERT INTO Hub (H_I_Code, H_I_Name, H_I_Cnt, H_I_Price) VALUES ('I004', '뿌링클시즈닝', '60', '600');
INSERT INTO Hub (H_I_Code, H_I_Name, H_I_Cnt, H_I_Price) VALUES ('I005', '슈프림소스', '60', '700');

-- 가맹점 재고 테이블 생성
INSERT INTO ingredients (I_Code, Branch_Id, I_Name, I_Cnt) 
VALUES ('I001', 'B2222', '닭고기', '30');

INSERT INTO ingredients (I_Code, Branch_Id, I_Name, I_Cnt) 
VALUES ('I001', 'B4444', '닭고기', '30');

INSERT INTO ingredients (I_Code, Branch_Id, I_Name, I_Cnt) 
VALUES ('I001', 'B6666', '닭고기', '30');

INSERT INTO ingredients (I_Code, Branch_Id, I_Name, I_Cnt) 
VALUES ('I002', 'B2222', '간장소스', '15');

INSERT INTO ingredients (I_Code, Branch_Id, I_Name, I_Cnt) 
VALUES ('I002', 'B4444', '간장소스', '15');

INSERT INTO ingredients (I_Code, Branch_Id, I_Name, I_Cnt) 
VALUES ('I002', 'B6666', '간장소스', '15');

INSERT INTO ingredients (I_Code, Branch_Id, I_Name, I_Cnt) 
VALUES ('I003', 'B2222', '양념소스', '20');

INSERT INTO ingredients (I_Code, Branch_Id, I_Name, I_Cnt) 
VALUES ('I003', 'B4444', '양념소스', '20');

INSERT INTO ingredients (I_Code, Branch_Id, I_Name, I_Cnt) 
VALUES ('I003', 'B6666', '양념소스', '20');

INSERT INTO ingredients (I_Code, Branch_Id, I_Name, I_Cnt) 
VALUES ('I004', 'B2222', '뿌링클시즈닝', '20');

INSERT INTO ingredients (I_Code, Branch_Id, I_Name, I_Cnt) 
VALUES ('I004', 'B4444', '뿌링클시즈닝', '20');

INSERT INTO ingredients (I_Code, Branch_Id, I_Name, I_Cnt) 
VALUES ('I004', 'B6666', '뿌링클시즈닝', '20');

INSERT INTO ingredients (I_Code, Branch_Id, I_Name, I_Cnt) 
VALUES ('I005', 'B2222', '슈프림소스', '20');

INSERT INTO ingredients (I_Code, Branch_Id, I_Name, I_Cnt) 
VALUES ('I005', 'B4444', '슈프림소스', '20');

INSERT INTO ingredients (I_Code, Branch_Id, I_Name, I_Cnt) 
VALUES ('I005', 'B6666', '슈프림소스', '20');


--======================================================================--
-- 트리거 & 시퀀스
-- 발주 코드 생성 시퀀스 & 트리거
CREATE SEQUENCE B_I_ORDER_CODE_SEQ
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 999
NOCYCLE
NOCACHE;

CREATE OR REPLACE TRIGGER TRG_CREATE_B_I_ORDER_CODE
BEFORE INSERT ON B_I_ORDER
FOR EACH ROW
DECLARE
BEGIN
    :NEW.B_I_Code := 'BI' || LPAD(B_I_ORDER_CODE_SEQ.NEXTVAL,3, '0');
END;
/

select * from branches;

-- 회원가입시 ingredients insert 추가
CREATE OR REPLACE TRIGGER TRG_CREATE_Branches_insert_ingredients
AFTER INSERT ON Branches
FOR EACH ROW
BEGIN
    INSERT INTO ingredients (
    I_code, branch_id, i_name, i_cnt)
    values('I001',:new.branch_id,'닭고기','0');
    INSERT INTO ingredients (
    I_code, branch_id, i_name, i_cnt)
    values('I002',:new.branch_id,'간장소스','0');
    INSERT INTO ingredients (
    I_code, branch_id, i_name, i_cnt)
    values('I003',:new.branch_id,'양념소스','0');
    INSERT INTO ingredients (
    I_code, branch_id, i_name, i_cnt)
    values('I004',:new.branch_id,'뿌링클시즈닝','0');
    INSERT INTO ingredients (
    I_code, branch_id, i_name, i_cnt)
    values('I005',:new.branch_id,'슈프림소스','0');
END;
/

-- 주문번호 생성 시퀀스 & 트리거   
CREATE SEQUENCE order_code_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9999
NOCYCLE
NOCACHE;

CREATE OR REPLACE TRIGGER TRG_CREATE_ORDER_CODE
BEFORE INSERT ON B_ORDER
for each row
DECLARE
BEGIN
    :NEW.O_Code := 'O' || LPAD(order_code_seq.nextval, 4, '0');
end;
/

-- 발주시 허브 재고 감소 가맹점 재고 증가 트리거
CREATE OR REPLACE TRIGGER trg_bi_order_insert
AFTER INSERT ON B_I_ORDER
FOR EACH ROW
BEGIN
    -- 1. 중앙창고(Hub)에서 재료 차감
    UPDATE Hub
    SET H_I_Cnt = H_I_Cnt - :NEW.I_Cnt
    WHERE H_I_Code = :NEW.I_Code;

    -- 2. 지점 재고(ingredients) 증가
    UPDATE Ingredients
    SET I_Cnt = I_Cnt + :NEW.I_Cnt
    WHERE I_Code = :NEW.I_Code
      AND Branch_Id = :NEW.B_Code;
END;
/


-- 음식 주문 시 해당 가맹점 재고 감소 트리거
CREATE OR REPLACE TRIGGER trg_decrease_stock_after_order
AFTER INSERT ON B_Order
FOR EACH ROW
DECLARE
    v_ingredients VARCHAR2(1000);
    v_start       NUMBER := 1;
    v_comma_pos   NUMBER;
    v_ingredient_name VARCHAR2(255);
    v_i_code      VARCHAR2(255);
    v_b_order     VARCHAR2(1000);
    v_o_cnt       number(2);
BEGIN
    -- 메뉴에서 재료 목록을 가져옴 (예: '닭고기,간장소스')
    SELECT ingredient_needs INTO v_ingredients
    FROM Menu
    WHERE Menu_Code = :NEW.Menu_Code;
    
    -- 주문수량 저장
    v_o_cnt := :NEW.O_cnt;

    -- 반복 처리: 콤마로 구분된 재료명 하나씩 추출
    LOOP
        v_comma_pos := INSTR(v_ingredients, ',', v_start);
        EXIT WHEN v_start > LENGTH(v_ingredients);

        IF v_comma_pos > 0 THEN
            v_ingredient_name := SUBSTR(v_ingredients, v_start, v_comma_pos - v_start);
            v_start := v_comma_pos + 1;
        ELSE
            v_ingredient_name := SUBSTR(v_ingredients, v_start);
            v_start := LENGTH(v_ingredients) + 1;
        END IF;

        -- 재료 이름으로부터 재료 코드 조회
        SELECT H_I_Code INTO v_i_code
        FROM Hub
        WHERE H_I_Name = TRIM(v_ingredient_name);

        -- 주문수량만큼 해당 매장의 재고에서 차감
        UPDATE ingredients
        SET I_Cnt = I_Cnt - v_o_cnt  -- 필요 시 수량 조정
        WHERE I_Code = v_i_code
          AND Branch_Id = :NEW.Branch_Id;
    END LOOP;
END;
/

-- 리뷰(문의) 코드 생성 시퀀스 & 트리거
CREATE SEQUENCE review_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER trg_review_insert
BEFORE INSERT ON Reviews
FOR EACH ROW
BEGIN
  SELECT 'R' || LPAD(review_seq.NEXTVAL, 4, '0')
  INTO :NEW.R_CODE
  FROM dual;
END;
/



-- 가맹점 음식주문 INSERT
INSERT INTO B_Order (Menu_Code, Branch_Id, O_CNT) VALUES ('CH001', 'B4444', 2);
INSERT INTO B_Order (Menu_Code, Branch_Id, O_CNT) VALUES ('CH002', 'B2222', 2);
INSERT INTO B_Order (Menu_Code, Branch_Id, O_CNT) VALUES ('CH003', 'B2222', 4);

-- 리뷰 INSERT
INSERT INTO reviews (id,detail, title) VALUES ('B2222','사장님 요새 장사가 잘 안되는 것 같습니다. 사람들이 치킨을 별로 안좋아하나봐요', '돈좀 벌고싶습니다.');



SELECT * FROM Menu;
SELECT * FROM Hub;
SELECT * FROM Branches;
SELECT * FROM ingredients;
SELECT * FROM B_Order;
SELECT * FROM B_I_ORDER;
SELECT * FROM reviews;


-- 발주 넣을 경우 창고재고에서 깎이기
INSERT INTO B_I_ORDER (B_CODE, I_CODE, I_CNT) VALUES ('B4444', 'I003', 2);
INSERT INTO B_ORDER (MENU_CODE, BRANCH_ID, O_CNT) VALUES('CH002', 'B2222', 2);


COMMIT;




-- 트리거 삭제
DROP TRIGGER TRG_CREATE_BRANCHE_CODE;
DROP TRIGGER TRG_CREATE_ORDER_CODE;
DROP TRIGGER trg_bi_order_insert;
DROP TRIGGER trg_decrease_stock_after_order;
DROP TRIGGER trg_review_insert;
DROP TRIGGER TRG_CREATE_B_I_ORDER_CODE;

-- 시퀀스 삭제
DROP SEQUENCE B_I_ORDER_CODE_SEQ;
DROP SEQUENCE order_code_seq;
DROP SEQUENCE review_seq;

-- 테이블 삭제 (외래키 순서 맞춰서)
DROP TABLE B_I_ORDER;
DROP TABLE B_Order;
DROP TABLE ingredients;
DROP TABLE Hub;
DROP TABLE Menu;
DROP TABLE Reviews;
DROP TABLE Branches;




TRUNCATE table Reviews;
truncate table ingredients;


