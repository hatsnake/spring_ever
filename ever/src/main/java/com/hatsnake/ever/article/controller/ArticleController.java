package com.hatsnake.ever.article.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hatsnake.ever.article.service.ArticleService;
import com.hatsnake.ever.article.vo.ArticleLikeVO;
import com.hatsnake.ever.article.vo.ArticleVO;
import com.hatsnake.ever.article.vo.CommentVO;
import com.hatsnake.ever.article.vo.PageMaker;
import com.hatsnake.ever.article.vo.SearchCriteria;
import com.hatsnake.ever.util.RemoteAddrUtils;

@Controller
public class ArticleController {

	private final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Inject
	private ArticleService articleService;
	
	@Resource(name="articleUploadPath")
	private String uploadPath;
	
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
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
		System.out.println("article : " + article);
		
		String insertip = RemoteAddrUtils.RemoteAddr(req);
		article.setAinsertip(insertip);
		
		int result = articleService.articleWrite(article);
		
		return "redirect:/article/view?ano=" + result; 
	}
	
	// 글 리스트
	@GetMapping("/article/list")
	public String list(Model model, SearchCriteria scri) throws Exception {
		logger.info("ArticleController.list() 함수 시작");
		
		List<HashMap<String, Object>> articleList = articleService.articleList(scri);
		model.addAttribute("articleList", articleList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(articleService.articleListCount(scri));
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("scri", scri);
		
		return "article/articleList";
	}

	// 상세글
	@GetMapping("/article/view")
	public String view(ArticleVO article, Model model, SearchCriteria scri,
					   HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("ArticleController.view() 함수 시작");
		int ano = article.getAno();
		System.out.println("ano : " + ano);
		
		// 쿠키 생성
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
		
		List<HashMap<String, Object>> articleList = articleService.articleView(article);
		
		if(articleList.size() != 1) 
			return "redirect:/";
		
		model.addAttribute("article", articleList.get(0));
		model.addAttribute("scri", scri);
		
		return "article/articleView";
	}
	
	// 좋아요 갯수 조회
	@GetMapping("/article/getLike")
	@ResponseBody
	public int getLike(int ano) throws Exception {
		logger.info("ArticleController.getLike() 함수 시작");
		
		ArticleLikeVO articleLike = new ArticleLikeVO();
		articleLike.setAno(ano);
		
		int likeCount = articleService.getLike(articleLike);
		
		return likeCount;
	}
	
	// 좋아요 체크 여부
	@GetMapping("/article/checkLike")
	@ResponseBody
	public String checkLike(int ano, int mno) throws Exception {
		logger.info("ArticleController.checkLike() 함수 시작");
		
		ArticleLikeVO articleLike = new ArticleLikeVO();
		articleLike.setAno(ano);
		articleLike.setMno(mno);
		
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
	public String addLike(int ano, int mno) throws Exception {
		logger.info("ArticleController.addLike() 함수 시작");
		
		ArticleLikeVO articleLike = new ArticleLikeVO();
		articleLike.setAno(ano);
		articleLike.setMno(mno);
		
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
	public String removeLike(int ano, int mno) throws Exception {
		logger.info("ArticleController.removeLike() 함수 시작");
		
		ArticleLikeVO articleLike = new ArticleLikeVO();
		articleLike.setAno(ano);
		articleLike.setMno(mno);
		
		int result = articleService.removeLike(articleLike);
		
		if(result == 1) {
			return "true";
		} else {
			return "false";
		}
	}	
	
	// 댓글 작성
	@PostMapping("/comment/write")
	@ResponseBody
	public String commentWrite(CommentVO comment, HttpServletRequest req) throws Exception {
		logger.info("ArticleController.commentWrite() 함수 시작");
		int result = 0;
		String insertip = RemoteAddrUtils.RemoteAddr(req);
		comment.setCinsertip(insertip);
		
		if(comment.getPcno() == 0) {
			result = articleService.writeComment(comment);
		} else {
			result = articleService.writeCommentReply(comment);
		}
		
		if(result >= 1) {
			return "true";
		} else {
			return "false";
		}
	}
	
	// 댓글리스트
	@GetMapping("/comment/list")
	@ResponseBody
	public HashMap<String, Object> commentList(CommentVO comment, SearchCriteria scri) throws Exception {
		logger.info("ArticleController.commentList() 함수 시작");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("comment", comment);
		map.put("scri", scri);
		
		List<HashMap<String, Object>> commentList = articleService.commentList(map);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(articleService.commentListCount(map));
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("commentList", commentList);
		result.put("pageMaker", pageMaker);
		
		return result;
	}
	
	// 파일 전송
	@PostMapping("/article/uploadImage")
	@ResponseBody
	public HashMap<String, Object> summernoteUploadImage(@RequestParam("file") MultipartFile file) {
		HashMap<String, Object> jsonResult = summernoteUploadImageFile(file);
		System.out.println(jsonResult);
		
		return jsonResult;
	}
	
	public HashMap<String, Object> summernoteUploadImageFile(MultipartFile file) {
		HashMap<String, Object> hashMap = new HashMap<>();
		
		// String fileRoot = "C:\\summernoteImg\\";
		String originalFileName = file.getOriginalFilename();
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
		
		String saveFileName = UUID.randomUUID()+extension;
			
		File targetFile = new File(uploadPath+ "\\" + saveFileName);
		
		try {
			InputStream fileStream = file.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);
			hashMap.put("url", "/articleImage/" + saveFileName);
			hashMap.put("responseCode", "succcess");
		} catch(IOException e) {
			FileUtils.deleteQuietly(targetFile);
			hashMap.put("responseCode", "error");
			e.printStackTrace();
		}	
		return hashMap;
	}

}
