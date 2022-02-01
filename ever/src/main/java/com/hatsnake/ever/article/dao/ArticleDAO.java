package com.hatsnake.ever.article.dao;

import com.hatsnake.ever.article.vo.ArticleVO;

public interface ArticleDAO {
	// 글 작성
	public int articleWrite(ArticleVO article) throws Exception;
}
