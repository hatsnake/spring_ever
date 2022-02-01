package com.hatsnake.ever.article.dao;

import java.util.List;

import com.hatsnake.ever.article.vo.ArticleLikeVO;
import com.hatsnake.ever.article.vo.ArticleVO;

public interface ArticleDAO {
	// 글 작성
	public int articleWrite(ArticleVO article) throws Exception;
	
	// 글 상세정보
	public List<ArticleVO> articleView(ArticleVO article) throws Exception;
	
	// 좋아요 갯수 가져오기
	public int getArticleLike(ArticleLikeVO articleLike) throws Exception;
}
