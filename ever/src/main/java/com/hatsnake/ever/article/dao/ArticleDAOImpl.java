package com.hatsnake.ever.article.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hatsnake.ever.article.vo.ArticleLikeVO;
import com.hatsnake.ever.article.vo.ArticleVO;
import com.hatsnake.ever.article.vo.CommentVO;
import com.hatsnake.ever.article.vo.SearchCriteria;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

	private final Logger logger = LoggerFactory.getLogger(ArticleDAOImpl.class);
	
	private final SqlSession sqlSession;
	
	@Autowired
	public ArticleDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public int articleWrite(ArticleVO article) throws Exception {
		logger.info("ArticleDAOImpl.articleWrite() 함수 시작");
		sqlSession.insert("articleMapper.articleWrite", article);		
		return article.getAno();
	}

	@Override
	public List<HashMap<String, Object>> articleList(SearchCriteria scri) throws Exception {
		logger.info("ArticleDAOImpl.articleList() 함수 시작");
		
		return sqlSession.selectList("articleMapper.articleList", scri);
	}
	
	@Override
	public int articleListCount(SearchCriteria scri) throws Exception {
		logger.info("ArticleDAOImpl.articleListCount() 함수 시작");
		
		return sqlSession.selectOne("articleMapper.articleListCount", scri);
	}
	
	@Override
	public List<HashMap<String, Object>> articleView(ArticleVO article) throws Exception {
		logger.info("ArticleDAOImpl.articleView() 함수 시작");
		
		return sqlSession.selectList("articleMapper.articleView", article);
	}

	@Override
	public int getLike(ArticleLikeVO articleLike) throws Exception {
		logger.info("ArticleDAOImpl.getArticleLike() 함수 시작");
		
		return sqlSession.selectOne("articleMapper.getLike", articleLike);
	}

	@Override
	public int checkLike(ArticleLikeVO articleLike) throws Exception {
		logger.info("ArticleDAOImpl.checkLike() 함수 시작");
		
		return sqlSession.selectOne("articleMapper.checkLike", articleLike);
	}
	
	@Override
	public int addLike(ArticleLikeVO articleLike) throws Exception {
		logger.info("ArticleDAOImpl.addLike() 함수 시작");
		
		return sqlSession.insert("articleMapper.addLike", articleLike);
	}

	@Override
	public int removeLike(ArticleLikeVO articleLike) throws Exception {
		logger.info("ArticleDAOImpl.removeLike() 함수 시작");
		
		return sqlSession.delete("articleMapper.removeLike", articleLike);
	}

	@Override
	public void viewCountUp(ArticleVO article) throws Exception {
		logger.info("ArticleDAOImpl.viewCountUp() 함수 시작");
		
		sqlSession.update("articleMapper.viewCountUp", article);
	}

	@Override
	public int writeComment(CommentVO comment) throws Exception {
		logger.info("ArticleDAOImpl.writeComment() 함수 시작");
		
		return sqlSession.insert("articleMapper.writeComment", comment);
	}

	@Override
	public List<HashMap<String, Object>> commentList(HashMap<String, Object> map) throws Exception {
		logger.info("ArticleDAOImpl.commentList() 함수 시작");
		
		return sqlSession.selectList("articleMapper.commentList", map);
	}

	@Override
	public int commentListCount(HashMap<String, Object> map) throws Exception {
		logger.info("ArticleDAOImpl.commentListCount() 함수 시작");
		
		return sqlSession.selectOne("articleMapper.commentListCount", map);
	}

	@Override
	public int writeCommentReply(CommentVO comment) throws Exception {
		logger.info("ArticleDAOImpl.writeCommentReply() 함수 시작");
		
		return sqlSession.insert("articleMapper.writeCommentReply", comment);
	}

}
