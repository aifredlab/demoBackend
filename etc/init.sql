
-- DDL은 JPA에 의해 자동생성
-- DROP TABLE INS_COMPANY;
-- DROP TABLE INSURANCE;

/*
CREATE TABLE INS_COMPANY (
	ID CHAR(2) PRIMARY KEY PRIMARY KEY
	,NAME VARCHAR(255) NOT NULL
);


CREATE TABLE INSURANCE (
	ID CHAR(4) PRIMARY KEY PRIMARY KEY
	,NAME VARCHAR(255) NOT NULL
	,INS_ID CHAR(2) NOT NULL
);*/


INSERT INTO INS_COMPANY(ID, NAME) VALUES('00', '삼성화재');
INSERT INTO INS_COMPANY(ID, NAME) VALUES('01', '현대해상');
INSERT INTO INS_COMPANY(ID, NAME) VALUES('02', '메리츠화재');
INSERT INTO INS_COMPANY(ID, NAME) VALUES('03', 'KB');
INSERT INTO INS_COMPANY(ID, NAME) VALUES('04', 'DB');
INSERT INTO INS_COMPANY(ID, NAME) VALUES('05', '한화손해보험');
INSERT INTO INS_COMPANY(ID, NAME) VALUES('06', '흥국화재');
INSERT INTO INS_COMPANY(ID, NAME) VALUES('07', '롯데손해보험');
INSERT INTO INS_COMPANY(ID, NAME) VALUES('08', '하나손해보험');


INSERT INTO INSURANCE(ID, NAME, INS_ID) VALUES('0000', '삼성화재 다이렉트운전자보험', '00');
INSERT INTO INSURANCE(ID, NAME, INS_ID) VALUES('0001', '삼성화재 애니카 다이렉트', '00');
INSERT INTO INSURANCE(ID, NAME, INS_ID) VALUES('0002', '삼성화재 다이렉트 어린이보험', '00');