package com.hatsnake.ever.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hatsnake.ever.member.dao.MemberDAO;
import com.hatsnake.ever.member.vo.MemberVO;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	private final MemberDAO memberDao;
	
	public MemberServiceImpl(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	// 회원가입
	@Override
	public void register(MemberVO member) throws Exception {
		logger.info("MemberServiceImpl.register() 함수 시작");
		
		memberDao.register(member);
	}

	// 로그인
	@Override
	public List<HashMap<String, Object>> login(MemberVO member) throws Exception {
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
	public List<HashMap<String, Object>> memberSelect(MemberVO member) throws Exception {
		logger.info("MemberServiceImpl.memberSelect() 함수 시작");
		
		return memberDao.memberSelect(member);
	}

	@Override
	public int memberIdCheck(MemberVO member) throws Exception {
		logger.info("MemberServiceImpl.memberIdCheck() 함수 시작");
		
		return memberDao.memberIdCheck(member);
	}

	@Override
	public int memberNicknameCheck(MemberVO member) throws Exception {
		logger.info("MemberServiceImpl.memberNicknameCheck() 함수 시작");
		
		return memberDao.memberNicknameCheck(member);
	}

	@Override
	public int publicProfileVisitedCount(MemberVO member) throws Exception {
		logger.info("MemberServiceImpl.publicProfileVisitedCount() 함수 시작");
		
		return memberDao.publicProfileVisitedCount(member);
	}

	@Override
	public int publicProfileArticleCount(MemberVO member) throws Exception {
		logger.info("MemberServiceImpl.publicProfileArticleCount() 함수 시작");
		
		return memberDao.publicProfileArticleCount(member);
	}

	@Override
	public int publicProfileCommentCount(MemberVO member) throws Exception {
		logger.info("MemberServiceImpl.publicProfileCommentCount() 함수 시작");
		
		return memberDao.publicProfileCommentCount(member);
	}

	@Override
	public List<Map<String, Object>> publicProfileArticleList(Map<String, Object> map) {
		logger.info("MemberServiceImpl.publicProfileArticleList() 함수 시작");
		
		return memberDao.publicProfileArticleList(map);
	}

	@Override
	public int publicProfileArticleListCount(Map<String, Object> map) {
		logger.info("MemberServiceImpl.publicProfileArticleListCount() 함수 시작");
		
		return memberDao.publicProfileArticleListCount(map);
	}

	@Override
	public List<Map<String, Object>> publicProfileCommentList(Map<String, Object> map) {
		logger.info("MemberServiceImpl.publicProfileCommentList() 함수 시작");
		
		return memberDao.publicProfileCommentList(map);
	}

	@Override
	public int publicProfileCommentListCount(Map<String, Object> map) {
		logger.info("MemberServiceImpl.publicProfileCommentListCount() 함수 시작");
		
		return memberDao.publicProfileCommentListCount(map);
	}

	@Override
	public int memberUpdateVistedCount(MemberVO member) {
		logger.info("MemberServiceImpl.publicProfileCommentListCount() 함수 시작");
		
		return memberDao.memberUpdateVistedCount(member);
	}

	@Override
	public void certifiedPhoneNumber(String userPhoneNumber, int randomNumber) {
		logger.info("MemberServiceImpl.certifiedPhoneNumber() 함수 시작");
		
		String api_key = "NCSGIE1PPDKNBH3B";
		String api_secret = "GJNN1HZ9X52X1XQNFW4I05BHIQLROUXM";
		Message coolsms = new Message(api_key, api_secret);
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", userPhoneNumber);
		params.put("from", "01045146106");
		params.put("type", "SMS");
		params.put("text", "[EVER] 인증번호는 " + "[" + randomNumber + "]" + "입니다.");
		params.put("app_version", "test app 1.2");
		
		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch(CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}

}
