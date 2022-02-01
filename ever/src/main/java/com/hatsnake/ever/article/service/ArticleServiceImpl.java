package com.hatsnake.ever.article.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hatsnake.ever.article.dao.ArticleDAO;
import com.hatsnake.ever.article.vo.ArticleVO;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	private final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
	
	@Inject
	private ArticleDAO articleDao;
	
	@Override
	public int articleWrite(ArticleVO article) throws Exception {
		return articleDao.articleWrite(article);
	}

}
