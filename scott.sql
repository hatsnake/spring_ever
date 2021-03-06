-- ??ȸ
SELECT * FROM E_MEMBER;
SELECT * FROM E_MEMBER_AUTH;
SELECT * FROM E_ARTICLE;
SELECT * FROM E_ARTICLE_LIKE;
SELECT * FROM E_ARTICLE_HASHTAG;
SELECT * FROM E_COMMENT;

-- ???̺? ????
DROP TABLE E_MEMBER;
DROP TABLE E_MEMBER_AUTH;
DROP TABLE E_ARTICLE;
DROP TABLE E_ARTICLE_LIKE;
DROP TABLE E_ARTICLE_HASHTAG;
DROP TABLE E_COMMENT;

-- ?????? ????
DROP SEQUENCE E_MEMBER_SEQ;
DROP SEQUENCE E_MEMBER_AUTH_SEQ;
DROP SEQUENCE E_ARTICLE_SEQ;
DROP SEQUENCE E_ARTICLE_LIKE_SEQ;
DROP SEQUENCE E_ARTICLE_HASHTAG_SEQ;
DROP SEQUENCE E_COMMENT_SEQ;

-- ?ε??? üũ
SELECT INDEX_NAME, TABLE_NAME, COLUMN_NAME
FROM USER_IND_COLUMNS;

SELECT E_MEMBER_SEQ.CURRVAL FROM dual;
SELECT * FROM user_sequences;

-- ???? ???̺?
CREATE TABLE E_MEMBER (
  MNO NUMBER,
  MID VARCHAR2(40) NOT NULL,
  MPASSWORD VARCHAR2(100) NOT NULL,
  MNICKNAME VARCHAR2(60) NOT NULL,
  MNAME VARCHAR2(40) NOT NULL,
  MIMAGE VARCHAR2(500) DEFAULT 'default.png',
  MBIRTH DATE NOT NULL,
  MGENDER VARCHAR2(3) NOT NULL,
  MEMAIL VARCHAR2(60),
  MPHONE VARCHAR2(40) NOT NULL,
  MZIP VARCHAR2(10),
  MADDR1 VARCHAR2(200),
  MADDR2 VARCHAR2(200),
  MVISITEDCOUNT NUMBER DEFAULT 0,
  MCOMMENTCOUNT NUMBER DEFAULT 0,
  MBOARDCOUNT NUMBER DEFAULT 0,
  MAUTHID VARCHAR2(3) DEFAULT '01' NOT NULL,
  MVISITEDDATE DATE DEFAULT SYSDATE,
  MINSERTDATE DATE DEFAULT SYSDATE,
  MINSERTIP VARCHAR2(100) NOT NULL,
  MUPDATEDATE DATE,
  MUPDATEIP VARCHAR2(100),
  MUPDATEID VARCHAR2(40),
  MDELETEYN VARCHAR2(1) DEFAULT 'N',
  MDELETEDATE DATE,
  MDELETEIP VARCHAR2(100),
  MDELETEID VARCHAR2(40),
  PRIMARY KEY(MNO)
);

-- ???? ??????
CREATE SEQUENCE E_MEMBER_SEQ START WITH 1 INCREMENT BY 1;

-- ???????? ???̺?
CREATE TABLE E_MEMBER_AUTH (
	MAUTHNO NUMBER,
    MAUTHID VARCHAR2(3) NOT NULL,
    MAUTHNAME VARCHAR2(20) NOT NULL,
	PRIMARY KEY(MAUTHNO)
);

-- ???????? ??????
CREATE SEQUENCE E_MEMBER_AUTH_SEQ START WITH 1 INCREMENT BY 1;

INSERT INTO E_MEMBER_AUTH VALUES(E_MEMBER_AUTH_SEQ.NEXTVAL, '00', '??????');
INSERT INTO E_MEMBER_AUTH VALUES(E_MEMBER_AUTH_SEQ.NEXTVAL, '01', '?Ϲ?ȸ??');

COMMIT;

-- ?Խñ? ???̺?
CREATE TABLE E_ARTICLE (
	ANO NUMBER,
    ATITLE VARCHAR2(200) NOT NULL,
	ACONTENT VARCHAR2(3000) NOT NULL,
	AWRITER NUMBER NOT NULL,
	AVIEWCNT NUMBER DEFAULT 0,
	ACATEGORYNO NUMBER NOT NULL,
	ACATEGORYNOREF NUMBER,
	AINSERTDATE DATE DEFAULT SYSDATE,
	AINSERTIP VARCHAR2(100) NOT NULL,
	AINSERTID NUMBER NOT NULL,
	AUPDATEDATE DATE,
	AUPDATEIP VARCHAR2(100),
	AUPDATEID VARCHAR2(40),
	ADELETEYN VARCHAR2(1) DEFAULT 'N',
	ADELETEDATE DATE,
	ADELETEIP VARCHAR2(100),
	ADELETEID VARCHAR2(40),
    PRIMARY KEY(ANO)
);

-- ?????? ???? Ȯ??
SELECT LENGTHB(ACONTENT) FROM E_ARTICLE;

-- ?Խñ? ??????
CREATE SEQUENCE E_ARTICLE_SEQ START WITH 1 INCREMENT BY 1;

-- ????¡
SELECT 
    ANO,
    ACATEGORYNO,
    ACATEGORYNOREF,
    ATITLE,
    ACONTENT,
    AWRITER,
    AINSERTDATE,
    AVIEWCNT
FROM (
    SELECT 
        ANO,
        ACATEGORYNO,
        ACATEGORYNOREF,
        ATITLE,
        ACONTENT,
        AWRITER,
        AINSERTDATE,
        AVIEWCNT,
        ROW_NUMBER() OVER(ORDER BY ANO DESC) AS RNUM
    FROM E_ARTICLE
) E
WHERE RNUM BETWEEN 1 AND 10
ORDER BY ANO DESC;

-- ?Խñ? ???ƿ? ???̺?
CREATE TABLE E_ARTICLE_LIKE (
	LNO NUMBER,
    ANO NUMBER NOT NULL,
	MNO NUMBER NOT NULL,
    PRIMARY KEY(LNO)
);

-- ?Խñ? ???ƿ? ??????
CREATE SEQUENCE E_ARTICLE_LIKE_SEQ START WITH 1 INCREMENT BY 1;

-- ?Խñ? ?ؽ??±? ???̺?
CREATE TABLE E_ARTICLE_HASHTAG (
	HNO NUMBER,
	ANO NUMBER NOT NULL,
	HASHTAG_NAME VARCHAR2(60) NOT NULL,
	PRIMARY KEY(HNO)
);

-- ?Խñ? ?ؽ??±? ??????
CREATE SEQUENCE E_ARTICLE_HASHTAG_SEQ START WITH 1 INCREMENT BY 1;


SELECT * FROM E_ARTICLE;
-- ????
SELECT * FROM E_ARTICLE 
WHERE AINSERTDATE BETWEEN TO_DATE(TO_CHAR(SYSDATE -1, 'YYYYMMDD'), 'YYYYMMDD') 
AND TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD') + 1, 'YYYYMMDD');

-- 1????
SELECT * FROM E_ARTICLE 
WHERE AINSERTDATE BETWEEN TO_DATE(TO_CHAR(SYSDATE -7, 'YYYYMMDD'), 'YYYYMMDD') 
AND TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD') + 1, 'YYYYMMDD');

-- ?Ѵ???
SELECT * FROM E_ARTICLE 
WHERE AINSERTDATE BETWEEN TO_DATE(TO_CHAR(ADD_MONTHS(SYSDATE, -1), 'YYYYMMDD'), 'YYYYMMDD') 
AND TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD') + 1, 'YYYYMMDD');

-- 6??????
SELECT * FROM E_ARTICLE 
WHERE AINSERTDATE BETWEEN TO_DATE(TO_CHAR(ADD_MONTHS(SYSDATE, -6), 'YYYYMMDD'), 'YYYYMMDD') 
AND TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD') + 1, 'YYYYMMDD');

-- 1????
SELECT * FROM E_ARTICLE 
WHERE AINSERTDATE BETWEEN TO_DATE(TO_CHAR(ADD_MONTHS(SYSDATE, -12), 'YYYYMMDD'), 'YYYYMMDD') 
AND TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD') + 1, 'YYYYMMDD');

-- =============================================================
-- ????
/*
COMMENT_NO //???? ??ȣ
COMMENT_NO_REF //?????? ??ȣ
BOARD_NO //?Խñ? ??ȣ
COMMENT_CONTENT //???? ????
COMMENT_INSERTDATE //???? ??????
COMMENT_INSERTIP //???? ???? IP
COMMENT_INSERTID //???? ???? ???̵?
COMMENT_UPDATEDATE //???? ??????
COMMENT_UPDATEIP //???? ???? IP
COMMENT_UPDATEID //???? ???? ???̵?
COMMENT_DELETEYN //???? ????????
COMMENT_DELETEDATE //???? ??????¥
COMMENT_DELETEIP //???? ???? IP
COMMENT_DELETEID //???? ???? ???̵?
*/

-- ???? ???̺?
CREATE TABLE E_COMMENT (
    CNO NUMBER,
    ANO NUMBER,
    PCNO NUMBER DEFAULT 0 NOT NULL,
    CCONTENT VARCHAR2(3000),
    CWRITER NUMBER NOT NULL,
    CINSERTDATE DATE DEFAULT SYSDATE NOT NULL,
    CINSERTIP VARCHAR2(100) NOT NULL,
    CINSERTID NUMBER NOT NULL,
    CUPDATEDATE DATE,
    CUPDATEIP VARCHAR2(100),
    CUPDATEID VARCHAR2(40),
    CDELETEYN VARCHAR2(1) DEFAULT 'N' NOT NULL,
    CDELETEDATE DATE,
    CDELETEIP VARCHAR2(100),
    CDELETEID VARCHAR2(40),
    PRIMARY KEY(CNO)
);

-- ???? ??????
CREATE SEQUENCE E_COMMENT_SEQ START WITH 1 INCREMENT BY 1;

SELECT * FROM E_COMMENT;

INSERT INTO E_COMMENT (
    CNO,
    ANO,
    CCONTENT,
    CWRITER,
    CINSERTIP,
    CINSERTID
) VALUES (
    21,
    1,
    'ù??° ??????',
    'hatsnake',
    '127.0.0.1',
    'hatsnake'
);

-- ?????? ????
SELECT 
    CNO,
    PCNO,
    ANO,
    LEVEL COMMENTLEVEL,
    CCONTENT,
    CWRITER,
    CINSERTDATE,
    RNUM
FROM (
    SELECT 
        CNO,
        PCNO,
        ANO,
        CCONTENT,
        CWRITER,
        CINSERTDATE,
        ROW_NUMBER() OVER(ORDER BY CNO DESC) AS RNUM
    FROM E_COMMENT
    WHERE ANO = 1
    AND CDELETEYN = 'N'
) 
-- WHERE RNUM BETWEEN 1 AND 10
START WITH PCNO = 0
CONNECT BY PRIOR CNO = PCNO
ORDER SIBLINGS BY CNO DESC, CINSERTDATE DESC;
-- WHERE RNUM BETWEEN #{rowStart} AND #{rowEnd}

SELECT COUNT(CNO) FROM E_COMMENT WHERE CNO > 0;
COMMIT;

SELECT 
  *
FROM (
    SELECT 
      *
    FROM (
        SELECT 
            A.CNO "cno",
            A.PCNO "pcno", 
            A.ANO "ano",
            LEVEL "commentlevel",
            A.CCONTENT "ccontent",
            A.CWRITER "cwriter",
            TO_CHAR(A.CINSERTDATE, 'yyyy.MM.dd. HH:mm') "cinsertdate",
            M.MNICKNAME "mnickname",
            ROWNUM "NUM"
        FROM E_COMMENT A, E_MEMBER M
        WHERE  A.CWRITER = M.MNO
        AND ANO = 2
        AND CDELETEYN = 'N'
        START WITH PCNO = 0 -- ??????
        CONNECT BY PRIOR CNO = PCNO -- ????
        ORDER SIBLINGS BY CNO DESC -- ???ļ???
    ) B
) C
WHERE NUM BETWEEN 1 AND 10;

-- ?湮 ?? ????
UPDATE E_MEMBER SET 
    MVISITEDCOUNT = MVISITEDCOUNT + 1,
    MVISITEDDATE = SYSDATE
WHERE MNO = 6;

ROLLBACK;