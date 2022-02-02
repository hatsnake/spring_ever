package com.hatsnake.ever.article.dao;

import java.util.List;

import com.hatsnake.ever.article.vo.ArticleLikeVO;
import com.hatsnake.ever.article.vo.ArticleVO;
import com.hatsnake.ever.article.vo.Criteria;

public interface ArticleDAO {
	// 글 작성
	public int articleWrite(ArticleVO article) throws Exception;
	
	// 글 리스트
	public List<ArticleVO> articleList(Criteria cri) throws Exception;
	
	// 글 총 갯수
	public int articleListCount() throws Exception;
	
	// 글 상세정보
	public List<ArticleVO> articleView(ArticleVO article) throws Exception;
	
	// 좋아요 갯수 가져오기
	public int getLike(ArticleLikeVO articleLike) throws Exception;
	
	// 좋아요 체크 여부
	public int checkLike(ArticleLikeVO articleLike) throws Exception;
	
	// 좋아요 추가
	public int addLike(ArticleLikeVO articleLike) throws Exception;
	
	// 좋아요 삭제
	public int removeLike(ArticleLikeVO articleLike) throws Exception;
	
	// 조회수 증가
	public void viewCountUp(ArticleVO article) throws Exception;
}
