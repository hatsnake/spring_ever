package com.hatsnake.ever.article.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.hatsnake.ever.article.vo.Criteria;
import com.hatsnake.ever.article.vo.PageMaker;
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

	// 글 리스트
	@GetMapping("/article/list")
	public String list(Model model, Criteria cri) throws Exception {
		logger.info("ArticleController.list() 함수 시작");
		
		List<ArticleVO> articleList = articleService.articleList(cri);
		model.addAttribute("articleList", articleList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(articleService.articleListCount());
		model.addAttribute("pageMaker", pageMaker);
		
		return "article/articleList";
	}

	// 상세글
	@GetMapping("/article/view/{ano}")
	public String view(@PathVariable int ano, Model model, 
					   HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("ArticleController.view() 함수 시작");
		ArticleVO article = new ArticleVO();
		article.setAno(ano);
		
		Cookie oldCookie = null;
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("articleView")) {
					oldCookie = cookie;
				}
			}
		}
		
		if(oldCookie != null) {
			if(!oldCookie.getValue().contains("[" + ano + "]")) {
				articleService.viewCountUp(article);
				oldCookie.setValue(oldCookie.getValue() + "_[" + ano + "]");
				oldCookie.setPath("/");
				oldCookie.setMaxAge(60 * 60 * 24);
				res.addCookie(oldCookie);
			}
		} else {
			articleService.viewCountUp(article);
			Cookie newCookie = new Cookie("articleView", "[" + ano + "]");
			newCookie.setPath("/");
			newCookie.setMaxAge(60 * 60 * 24);
			res.addCookie(newCookie);
		}
		
		List<ArticleVO> articleList = articleService.articleView(article);
		
		if(articleList.size() != 1) 
			return "redirect:/";
		
		model.addAttribute("article", articleList.get(0));
		
		return "article/articleView";
	}
	
	// 좋아요 갯수 조회
	@GetMapping("/article/getLike")
	@ResponseBody
	public int getLike(int ano) throws Exception {
		ArticleLikeVO articleLike = new ArticleLikeVO();
		articleLike.setAno(ano);
		
		int likeCount = articleService.getLike(articleLike);
		
		return likeCount;
	}
	
	// 좋아요 체크 여부
	@GetMapping("/article/checkLike")
	@ResponseBody
	public String checkLike(int ano, String mid) throws Exception {
		ArticleLikeVO articleLike = new ArticleLikeVO();
		articleLike.setAno(ano);
		articleLike.setMid(mid);
		
		int checkLike = articleService.checkLike(articleLike);
		
		if(checkLike >= 1) {
			return "true";
		} else {
			return "false";
		}
	}
	
	// 좋아요 추가
	@PostMapping("/article/addLike")
	@ResponseBody
	public String addLike(int ano, String mid) throws Exception {
		ArticleLikeVO articleLike = new ArticleLikeVO();
		articleLike.setAno(ano);
		articleLike.setMid(mid);
		
		int result = articleService.addLike(articleLike);
		
		if(result == 1) {
			return "true";
		} else {
			return "false";
		}
	}

	// 좋아요 삭제
	@PostMapping("/article/removeLike")
	@ResponseBody
	public String removeLike(int ano, String mid) throws Exception {
		ArticleLikeVO articleLike = new ArticleLikeVO();
		articleLike.setAno(ano);
		articleLike.setMid(mid);
		
		int result = articleService.removeLike(articleLike);
		
		if(result == 1) {
			return "true";
		} else {
			return "false";
		}
	}	
	
}
