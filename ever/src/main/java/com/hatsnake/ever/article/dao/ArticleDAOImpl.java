package com.hatsnake.ever.article.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hatsnake.ever.article.vo.ArticleVO;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

	private final Logger logger = LoggerFactory.getLogger(ArticleDAOImpl.class);
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public int articleWrite(ArticleVO article) throws Exception {
		return sqlSession.insert("articleMapper.articleWrite", article);
	}

}
