package com.hatsnake.ever.article.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hatsnake.ever.article.vo.ArticleLikeVO;
import com.hatsnake.ever.article.vo.ArticleVO;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

	private final Logger logger = LoggerFactory.getLogger(ArticleDAOImpl.class);
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public int articleWrite(ArticleVO article) throws Exception {
		logger.info("ArticleDAOImpl.articleWrite() 함수 시작");
		sqlSession.insert("articleMapper.articleWrite", article);		
		return article.getAno();
	}

	@Override
	public List<ArticleVO> articleView(ArticleVO article) throws Exception {
		logger.info("ArticleDAOImpl.articleView() 함수 시작");
		
		return sqlSession.selectList("articleMapper.articleView", article);
	}

	@Override
	public int getArticleLike(ArticleLikeVO articleLike) throws Exception {
		logger.info("ArticleDAOImpl.getArticleLike() 함수 시작");
		
		return sqlSession.selectOne("articleMapper.getArticleLike", articleLike);
	}

}
