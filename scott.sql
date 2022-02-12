-- 조회
SELECT * FROM E_MEMBER;
SELECT * FROM E_MEMBER_AUTH;
SELECT * FROM E_ARTICLE;
SELECT * FROM E_ARTICLE_LIKE;
SELECT * FROM E_ARTICLE_HASHTAG;
SELECT * FROM E_COMMENT;

-- 테이블 삭제
DROP TABLE E_MEMBER;
DROP TABLE E_MEMBER_AUTH;
DROP TABLE E_ARTICLE;
DROP TABLE E_ARTICLE_LIKE;
DROP TABLE E_ARTICLE_HASHTAG;
DROP TABLE E_COMMENT;

-- 시퀀스 삭제
DROP SEQUENCE E_MEMBER_SEQ;
DROP SEQUENCE E_MEMBER_AUTH_SEQ;
DROP SEQUENCE E_ARTICLE_SEQ;
DROP SEQUENCE E_ARTICLE_LIKE_SEQ;
DROP SEQUENCE E_ARTICLE_HASHTAG_SEQ;
DROP SEQUENCE E_COMMENT_SEQ;

SELECT E_MEMBER_SEQ.CURRVAL FROM dual;
SELECT * FROM user_sequences;

-- 멤버 테이블
CREATE TABLE E_MEMBER (
  MNO NUMBER,
  MID VARCHAR2(40) NOT NULL,
  MPASSWORD VARCHAR2(100) NOT NULL,
  MNICKNAME VARCHAR2(60) NOT NULL,
  MNAME VARCHAR2(40) NOT NULL,
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

-- 멤버 시퀀스
CREATE SEQUENCE E_MEMBER_SEQ START WITH 1 INCREMENT BY 1;

-- 멤버권한 테이블
CREATE TABLE E_MEMBER_AUTH (
	MAUTHNO NUMBER,
    MAUTHID VARCHAR2(3) NOT NULL,
    MAUTHNAME VARCHAR2(20) NOT NULL,
	PRIMARY KEY(MAUTHNO)
);

-- 멤버권한 시퀀스
CREATE SEQUENCE E_MEMBER_AUTH_SEQ START WITH 1 INCREMENT BY 1;

-- 게시글 테이블
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

-- 콘텐츠 길이 확인
SELECT LENGTHB(ACONTENT) FROM E_ARTICLE;

-- 게시글 시퀀스
CREATE SEQUENCE E_ARTICLE_SEQ START WITH 1 INCREMENT BY 1;

-- 페이징
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

-- 게시글 좋아요 테이블
CREATE TABLE E_ARTICLE_LIKE (
	LNO NUMBER,
    ANO NUMBER NOT NULL,
	MNO NUMBER NOT NULL,
    PRIMARY KEY(LNO)
);

-- 게시글 좋아요 시퀀스
CREATE SEQUENCE E_ARTICLE_LIKE_SEQ START WITH 1 INCREMENT BY 1;

-- 게시글 해쉬태그 테이블
CREATE TABLE E_ARTICLE_HASHTAG (
	HNO NUMBER,
	ANO NUMBER NOT NULL,
	HASHTAG_NAME VARCHAR2(60) NOT NULL,
	PRIMARY KEY(HNO)
);

-- 게시글 해쉬태그 시퀀스
CREATE SEQUENCE E_ARTICLE_HASHTAG_SEQ START WITH 1 INCREMENT BY 1;


SELECT * FROM E_ARTICLE;
-- 어제
SELECT * FROM E_ARTICLE 
WHERE AINSERTDATE BETWEEN TO_DATE(TO_CHAR(SYSDATE -1, 'YYYYMMDD'), 'YYYYMMDD') 
AND TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD') + 1, 'YYYYMMDD');

-- 1주전
SELECT * FROM E_ARTICLE 
WHERE AINSERTDATE BETWEEN TO_DATE(TO_CHAR(SYSDATE -7, 'YYYYMMDD'), 'YYYYMMDD') 
AND TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD') + 1, 'YYYYMMDD');

-- 한달전
SELECT * FROM E_ARTICLE 
WHERE AINSERTDATE BETWEEN TO_DATE(TO_CHAR(ADD_MONTHS(SYSDATE, -1), 'YYYYMMDD'), 'YYYYMMDD') 
AND TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD') + 1, 'YYYYMMDD');

-- 6개월전
SELECT * FROM E_ARTICLE 
WHERE AINSERTDATE BETWEEN TO_DATE(TO_CHAR(ADD_MONTHS(SYSDATE, -6), 'YYYYMMDD'), 'YYYYMMDD') 
AND TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD') + 1, 'YYYYMMDD');

-- 1년전
SELECT * FROM E_ARTICLE 
WHERE AINSERTDATE BETWEEN TO_DATE(TO_CHAR(ADD_MONTHS(SYSDATE, -12), 'YYYYMMDD'), 'YYYYMMDD') 
AND TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD') + 1, 'YYYYMMDD');

-- =============================================================
-- 댓글
/*
COMMENT_NO //댓글 번호
COMMENT_NO_REF //대댓글 번호
BOARD_NO //게시글 번호
COMMENT_CONTENT //댓글 내용
COMMENT_INSERTDATE //댓글 생성일
COMMENT_INSERTIP //댓글 생성 IP
COMMENT_INSERTID //댓글 생성 아이디
COMMENT_UPDATEDATE //댓글 수정일
COMMENT_UPDATEIP //댓글 수정 IP
COMMENT_UPDATEID //댓글 수정 아이디
COMMENT_DELETEYN //댓글 삭제여부
COMMENT_DELETEDATE //댓글 삭제날짜
COMMENT_DELETEIP //댓글 삭제 IP
COMMENT_DELETEID //댓글 삭제 아이디
*/

-- 댓글 테이블
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

-- 댓글 시퀀스
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
    '첫번째 대댓글',
    'hatsnake',
    '127.0.0.1',
    'hatsnake'
);

-- 계층형 댓글
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
        START WITH PCNO = 0 -- 시작형
        CONNECT BY PRIOR CNO = PCNO -- 연결
        ORDER SIBLINGS BY CNO DESC -- 정렬순서
    ) B
) C
WHERE NUM BETWEEN 1 AND 10;

SELECT * FROM E_ARTICLE;