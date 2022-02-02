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
import com.hatsnake.ever.article.vo.Criteria;

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
	public List<ArticleVO> articleList(Criteria cri) throws Exception {
		logger.info("ArticleDAOImpl.articleList() 함수 시작");
		
		return sqlSession.selectList("articleMapper.articleList", cri);
	}
	
	@Override
	public int articleListCount() throws Exception {
		logger.info("ArticleDAOImpl.articleListCount() 함수 시작");
		
		return sqlSession.selectOne("articleMapper.articleListCount");
	}
	
	@Override
	public List<ArticleVO> articleView(ArticleVO article) throws Exception {
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

}
