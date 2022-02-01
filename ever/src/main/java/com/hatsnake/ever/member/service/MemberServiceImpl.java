package com.hatsnake.ever.member.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hatsnake.ever.member.dao.MemberDAO;
import com.hatsnake.ever.member.vo.MemberVO;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Inject
	private MemberDAO memberDao;
	
	// 회원가입
	@Override
	public void register(MemberVO member) throws Exception {
		logger.info("MemberServiceImpl.register() 함수 시작");
		
		memberDao.register(member);
	}

	// 로그인
	@Override
	public List<MemberVO> login(MemberVO member) throws Exception {
		logger.info("MemberServiceImpl.login() 함수 시작");
		
		return memberDao.login(member);
	}

	// 회원정보 수정
	@Override
	public int memberUpdate(MemberVO member) throws Exception {
		logger.info("MemberServiceImpl.memberUpdate() 함수 시작");
		
		return memberDao.memberUpdate(member);
	}

	// 회원정보 조회
	@Override
	public List<MemberVO> memberSelect(MemberVO member) throws Exception {
		logger.info("MemberServiceImpl.memberSelect() 함수 시작");
		
		return memberDao.memberSelect(member);
	}

}
