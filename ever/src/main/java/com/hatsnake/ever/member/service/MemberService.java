package com.hatsnake.ever.member.service;

import java.util.List;

import com.hatsnake.ever.member.vo.MemberVO;

public interface MemberService {
	// 회원가입
	public void register(MemberVO member) throws Exception;
	
	// 로그인
	public List<MemberVO> login(MemberVO member) throws Exception;
	
	// 회원정보 수정
	public int memberUpdate(MemberVO member) throws Exception;
	
	// 회원정보 조회
	public List<MemberVO> memberSelect(MemberVO member) throws Exception;
}
