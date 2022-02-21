package com.hatsnake.ever.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hatsnake.ever.member.vo.MemberVO;

public interface MemberService {
	// 회원가입
	public void register(MemberVO member) throws Exception;
	
	// 로그인
	public List<HashMap<String, Object>> login(MemberVO member) throws Exception;
	
	// 회원정보 수정
	public int memberUpdate(MemberVO member) throws Exception;
	
	// 회원정보 조회
	public List<HashMap<String, Object>> memberSelect(MemberVO member) throws Exception;
	
	// 아이디 체크
	public int memberIdCheck(MemberVO member) throws Exception;
	
	// 닉네임 체크
	public int memberNicknameCheck(MemberVO member) throws Exception;
	
	// 방문자 수
	public int publicProfileVisitedCount(MemberVO member) throws Exception;

	// 게시글 수
	public int publicProfileArticleCount(MemberVO member) throws Exception;

	// 댓글 수
	public int publicProfileCommentCount(MemberVO member) throws Exception;

	// 공개 게시글 리스트
	public List<Map<String, Object>> publicProfileArticleList(Map<String, Object> map);

	// 공개 게시글 갯수
	public int publicProfileArticleListCount(Map<String, Object> map);

	// 공개 댓글 리스트
	public List<Map<String, Object>> publicProfileCommentList(Map<String, Object> map);
	
	// 공개 댓글 수
	public int publicProfileCommentListCount(Map<String, Object> map);

	// 방문자 수 증가
	public int memberUpdateVistedCount(MemberVO member);

	public void certifiedPhoneNumber(String userPhoneNumber, int randomNumber);
}
