package com.hatsnake.ever.article.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hatsnake.ever.article.service.ArticleService;
import com.hatsnake.ever.article.vo.ArticleLikeVO;
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
	public String write(ArticleVO article, HttpServletRequest req, String atag) throws Exception {
		logger.info("ArticleController.write() 함수 시작");
		logger.info("atag : " + atag);
		
		String insertip = RemoteAddrUtils.RemoteAddr(req);
		article.setAinsertip(insertip);
		
		int result = articleService.articleWrite(article);
		
		return "redirect:/article/view/" + result; 
	}

	// 글리스트
	@GetMapping("/article/list")
	public String list() throws Exception {
		logger.info("ArticleController.list() 함수 시작");
		
		return "article/articleList";
	}

	// 상세글
	@GetMapping("/article/view/{ano}")
	public String view(@PathVariable int ano, Model model) throws Exception {
		logger.info("ArticleController.view() 함수 시작");
		logger.info("ano : " + ano);
		ArticleVO article = new ArticleVO();
		article.setAno(ano);
		
		List<ArticleVO> articleList = articleService.articleView(article);
		
		if(articleList.size() != 1) 
			return "redirect:/";
		
		model.addAttribute("article", articleList.get(0));
		
		return "article/articleView";
	}
	
	// 좋아요 갯수 조회
	@GetMapping("/article/like")
	@ResponseBody
	public int getLike(int ano) throws Exception {
		ArticleLikeVO articleLike = new ArticleLikeVO();
		articleLike.setAno(ano);
		
		int heartCount = articleService.getArticleLike(articleLike);
		
		return heartCount;
	}
	
}
