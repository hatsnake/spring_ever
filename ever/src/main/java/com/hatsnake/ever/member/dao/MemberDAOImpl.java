package com.hatsnake.ever.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hatsnake.ever.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	private static Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private final SqlSession sqlSession;
	
	@Autowired
	public MemberDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 회원가입
	@Override
	public void register(MemberVO member) throws Exception {
		logger.info("MemberDAOImpl.register() 함수 시작");
		
		sqlSession.insert("memberMapper.register", member);
	}

	// 로그인
	@Override
	public List<HashMap<String, Object>> login(MemberVO member) throws Exception {
		logger.info("MemberDAOImpl.login() 함수 시작");
		
		return sqlSession.selectList("memberMapper.login", member);
	}

	// 회원정보 수정
	@Override
	public int memberUpdate(MemberVO member) throws Exception {
		logger.info("MemberDAOImpl.memberUpdate() 함수 시작");
		
		return sqlSession.update("memberMapper.memberUpdate", member);
	}

	@Override
	public List<HashMap<String, Object>> memberSelect(MemberVO member) throws Exception {
		logger.info("MemberDAOImpl.memberSelect() 함수 시작");
		
		return sqlSession.selectList("memberMapper.memberSelect", member);
	}

	@Override
	public int memberIdCheck(MemberVO member) throws Exception {
		logger.info("MemberDAOImpl.memberIdCheck() 함수 시작");
		
		return sqlSession.selectOne("memberMapper.memberIdCheck", member);
	}

	@Override
	public int memberNicknameCheck(MemberVO member) throws Exception {
		logger.info("MemberDAOImpl.memberNicknameCheck() 함수 시작");
		
		return sqlSession.selectOne("memberMapper.memberNicknameCheck", member);
	}

	@Override
	public int publicProfileVisitedCount(MemberVO member) throws Exception {
		logger.info("MemberDAOImpl.publicProfileVisitedCount() 함수 시작");
		
		return sqlSession.selectOne("memberMapper.publicProfileVisitedCount", member);
	}

	@Override
	public int publicProfileArticleCount(MemberVO member) throws Exception {
		logger.info("MemberDAOImpl.publicProfileArticleCount() 함수 시작");
		
		return sqlSession.selectOne("memberMapper.publicProfileArticleCount", member);
	}

	@Override
	public int publicProfileCommentCount(MemberVO member) throws Exception {
		logger.info("MemberDAOImpl.publicProfileCommentCount() 함수 시작");
		
		return sqlSession.selectOne("memberMapper.publicProfileCommentCount", member);
	}

	@Override
	public List<Map<String, Object>> publicProfileArticleList(Map<String, Object> map) {
		logger.info("MemberDAOImpl.publicProfileArticleList() 함수 시작");
		
		return sqlSession.selectList("memberMapper.publicProfileArticleList", map);
	}

	@Override
	public int publicProfileArticleListCount(Map<String, Object> map) {
		logger.info("MemberDAOImpl.publicProfileArticleListCount() 함수 시작");
		
		return sqlSession.selectOne("memberMapper.publicProfileArticleListCount", map);
	}

	@Override
	public List<Map<String, Object>> publicProfileCommentList(Map<String, Object> map) {
		logger.info("MemberDAOImpl.publicProfileCommentList() 함수 시작");
		
		return sqlSession.selectList("memberMapper.publicProfileCommentList", map);
	}

	@Override
	public int publicProfileCommentListCount(Map<String, Object> map) {
		logger.info("MemberDAOImpl.publicProfileCommentListCount() 함수 시작");
		
		return sqlSession.selectOne("memberMapper.publicProfileCommentListCount", map);
	}

	@Override
	public int memberUpdateVistedCount(MemberVO member) {
		logger.info("MemberDAOImpl.memberUpdateVistedCount() 함수 시작");
		
		return sqlSession.update("memberMapper.memberUpdateVistedCount", member);
	}
	
}
