package com.hatsnake.ever.article.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hatsnake.ever.article.service.ArticleService;
import com.hatsnake.ever.article.vo.ArticleVO;
import com.hatsnake.ever.member.util.RemoteAddrUtils;

@Controller
public class ArticleController {

	private final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Inject
	private ArticleService articleService;
	
	// 글작성
	@GetMapping("/article/write")
	public String writeForm() throws Exception {
		logger.info("ArticleController.writeForm() 함수 시작");
		
		return "article/articleWrite";
	}
	
	@PostMapping("/article/write")
	public void write(ArticleVO article, HttpServletRequest req, String btag) throws Exception {
		logger.info("ArticleController.write() 함수 시작");
		logger.info("btag : " + btag);
		
		String insertip = RemoteAddrUtils.RemoteAddr(req);
		article.setBinsertip(insertip);
		
		int result = articleService.articleWrite(article);
		
		if(result == 1) {
			logger.info("글 작성 성공");
		} else {
			logger.info("글 작성 실패");
		}
	}

	// 글리스트
	@GetMapping("/article/list")
	public String list() throws Exception {
		logger.info("ArticleController.list() 함수 시작");
		
		return "article/articleList";
	}

	// 상세글
	@GetMapping("/article/view")
	public String view() throws Exception {
		logger.info("ArticleController.view() 함수 시작");
		
		
		return "article/articleView";
	}
}
