-- 조회
SELECT * FROM E_MEMBER;
SELECT * FROM E_MEMBER_AUTH;
SELECT * FROM E_BOARD;
SELECT * FROM E_BOARD_LIKE;
SELECT * FROM E_BOARD_HASHTAG;

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
CREATE TABLE E_BOARD (
	BNO NUMBER,
    BTITLE VARCHAR2(200) NOT NULL,
	BCONTENT VARCHAR2(3000) NOT NULL,
	BWRITER VARCHAR2(40) NOT NULL,
	BVIEWCNT NUMBER DEFAULT 0,
	BCATEGORYNO NUMBER NOT NULL,
	BCATEGORYNOREF NUMBER,
	BINSERTDATE DATE DEFAULT SYSDATE,
	BINSERTIP VARCHAR2(100) NOT NULL,
	BINSERTID VARCHAR2(40) NOT NULL,
	BUPDATEDATE DATE,
	BUPDATEIP VARCHAR2(100),
	BUPDATEID VARCHAR2(40),
	BDELETEYN VARCHAR2(1) DEFAULT 'N',
	BDELETEDATE DATE,
	BDELETEIP VARCHAR2(100),
	BDELETEID VARCHAR2(40),
    PRIMARY KEY(BNO)
);

-- 게시글 시퀀스
CREATE SEQUENCE E_BOARD_SEQ START WITH 1 INCREMENT BY 1;

-- 게시글 좋아요 테이블
CREATE TABLE E_BOARD_LIKE (
	LNO NUMBER,
    BNO NUMBER NOT NULL,
	MID VARCHAR2(40) NOT NULL,
    PRIMARY KEY(LNO)
);

-- 게시글 좋아요 시퀀스
CREATE SEQUENCE E_BOARD_LIKE_SEQ START WITH 1 INCREMENT BY 1;

-- 게시글 해쉬태그 테이블
CREATE TABLE E_BOARD_HASHTAG (
	HNO NUMBER,
	BNO NUMBER NOT NULL,
	HASHTAG_NAME VARCHAR2(60) NOT NULL,
	PRIMARY KEY(HNO)
);

-- 게시글 해쉬태그 시퀀스
CREATE SEQUENCE E_BOARD_HASHTAG_SEQ START WITH 1 INCREMENT BY 1;

