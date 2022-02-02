package com.hatsnake.ever.article.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hatsnake.ever.article.dao.ArticleDAO;
import com.hatsnake.ever.article.vo.ArticleLikeVO;
import com.hatsnake.ever.article.vo.ArticleVO;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	private final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
	
	@Inject
	private ArticleDAO articleDao;
	
	@Override
	public int articleWrite(ArticleVO article) throws Exception {
		logger.info("ArticleServiceImpl.articleWrite() 함수 시작");
		
		return articleDao.articleWrite(article);
	}

	@Override
	public List<ArticleVO> articleView(ArticleVO article) throws Exception {
		logger.info("ArticleServiceImpl.articleView() 함수 시작");
		
		return articleDao.articleView(article);
	}

	@Override
	public int getArticleLike(ArticleLikeVO articleLike) throws Exception {
		logger.info("ArticleServiceImpl.getArticleLike() 함수 시작");
		
		return articleDao.getArticleLike(articleLike);
	}

}
