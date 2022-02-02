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
import com.hatsnake.ever.article.vo.Criteria;

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
	public List<ArticleVO> articleList(Criteria cri) throws Exception {
		logger.info("ArticleServiceImpl.articleList() 함수 시작");
		
		return articleDao.articleList(cri);
	}
	
	@Override
	public int articleListCount() throws Exception {
		logger.info("ArticleServiceImpl.articleListCount() 함수 시작");
		
		return articleDao.articleListCount();
	}

	@Override
	public List<ArticleVO> articleView(ArticleVO article) throws Exception {
		logger.info("ArticleServiceImpl.articleView() 함수 시작");
		
		return articleDao.articleView(article);
	}

	@Override
	public int getLike(ArticleLikeVO articleLike) throws Exception {
		logger.info("ArticleServiceImpl.getLike() 함수 시작");
		
		return articleDao.getLike(articleLike);
	}

	@Override
	public int checkLike(ArticleLikeVO articleLike) throws Exception {
		logger.info("ArticleServiceImpl.checkLike() 함수 시작");
		
		return articleDao.checkLike(articleLike);
	}

	@Override
	public int addLike(ArticleLikeVO articleLike) throws Exception {
		logger.info("ArticleServiceImpl.addLike() 함수 시작");
		
		return articleDao.addLike(articleLike);
	}

	@Override
	public int removeLike(ArticleLikeVO articleLike) throws Exception {
		logger.info("ArticleServiceImpl.removeLike() 함수 시작");
		
		return articleDao.removeLike(articleLike);
	}

	@Override
	public void viewCountUp(ArticleVO article) throws Exception {
		logger.info("ArticleServiceImpl.viewCountUp() 함수 시작");
		
		articleDao.viewCountUp(article);
	}

}
