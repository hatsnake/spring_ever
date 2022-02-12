package com.hatsnake.ever.article.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hatsnake.ever.article.dao.ArticleDAO;
import com.hatsnake.ever.article.vo.ArticleLikeVO;
import com.hatsnake.ever.article.vo.ArticleVO;
import com.hatsnake.ever.article.vo.CommentVO;
import com.hatsnake.ever.article.vo.SearchCriteria;

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
	public List<HashMap<String, Object>> articleList(SearchCriteria scri) throws Exception {
		logger.info("ArticleServiceImpl.articleList() 함수 시작");
		
		return articleDao.articleList(scri);
	}
	
	@Override
	public int articleListCount(SearchCriteria scri) throws Exception {
		logger.info("ArticleServiceImpl.articleListCount() 함수 시작");
		
		return articleDao.articleListCount(scri);
	}

	@Override
	public List<HashMap<String, Object>> articleView(ArticleVO article) throws Exception {
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

	@Override
	public int writeComment(CommentVO comment) throws Exception {
		logger.info("ArticleServiceImpl.writeComment() 함수 시작");
		
		return articleDao.writeComment(comment);
	}

	@Override
	public List<HashMap<String, Object>> commentList(HashMap<String, Object> map) throws Exception {
		logger.info("ArticleServiceImpl.commentList() 함수 시작");
		
		return articleDao.commentList(map);
	}

	@Override
	public int commentListCount(HashMap<String, Object> map) throws Exception {
		logger.info("ArticleServiceImpl.commentListCount() 함수 시작");
		
		return articleDao.commentListCount(map);
	}

	@Override
	public int writeCommentReply(CommentVO comment) throws Exception {
		logger.info("ArticleServiceImpl.writeCommentReply() 함수 시작");
		
		return articleDao.writeCommentReply(comment);
	}

}
