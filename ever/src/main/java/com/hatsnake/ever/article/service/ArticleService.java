package com.hatsnake.ever.article.service;

import java.util.HashMap;
import java.util.List;

import com.hatsnake.ever.article.vo.ArticleLikeVO;
import com.hatsnake.ever.article.vo.ArticleVO;
import com.hatsnake.ever.article.vo.CommentVO;
import com.hatsnake.ever.article.vo.SearchCriteria;

public interface ArticleService {
	// 글 작성
	public int articleWrite(ArticleVO article) throws Exception;
	
	// 글 리스트
	public List<HashMap<String, Object>> articleList(SearchCriteria scri) throws Exception;
	
	// 글 총 갯수
	public int articleListCount(SearchCriteria scri) throws Exception;
	
	// 글 상세정보
	public List<HashMap<String, Object>> articleView(ArticleVO article) throws Exception;
	
	// 좋아요 갯수 가져오기
	public int getLike(ArticleLikeVO articleLike) throws Exception;
	
	// 좋아요 체크 여부
	public int checkLike(ArticleLikeVO articleLike) throws Exception;

	// 좋아요 추가
	public int addLike(ArticleLikeVO articleLike) throws Exception;
	
	// 종아요 삭제
	public int removeLike(ArticleLikeVO articleLike) throws Exception;
	
	// 조회수 증가
	public void viewCountUp(ArticleVO article) throws Exception;
	
	// 댓글 작성
	public int writeComment(CommentVO comment) throws Exception;
	
	// 댓글 리스트
	public List<HashMap<String, Object>> commentList(HashMap<String, Object> map) throws Exception;
	
	// 댓글 총 갯수
	public int commentListCount(HashMap<String, Object> map) throws Exception;
	
	// 대댓글 작성
	public int writeCommentReply(CommentVO comment) throws Exception;	
}
