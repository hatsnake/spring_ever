package com.hatsnake.ever.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hatsnake.ever.article.vo.PageMaker;
import com.hatsnake.ever.article.vo.SearchCriteria;
import com.hatsnake.ever.member.service.MemberService;
import com.hatsnake.ever.member.vo.MemberVO;
import com.hatsnake.ever.util.MediaUtils;
import com.hatsnake.ever.util.RemoteAddrUtils;
import com.hatsnake.ever.util.UploadFileUtils;

@Controller
public class MemberController {
	
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private final MemberService memberService;
	
	@Resource(name="memberUploadPath")
	private String uploadPath;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	// 로그인
	@GetMapping("/member/login")
	public String loginForm() throws Exception {
		logger.info("MemberController.loginForm() 함수 시작");
		
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String login(MemberVO member, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("MemberController.login() 함수 시작");
		
		HttpSession session = req.getSession();
		List<HashMap<String, Object>> login = memberService.login(member);
		
		if(login.size() != 1) {		
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/login";
		} else {
			Date now = new Date();
			// Date tomorrow = new Date(now.getTime() + (1000 * 60 * 60 * 24)); 
			
			Date lastDate = (Date) login.get(0).get("mvisiteddate");
			Date lastDateTomorrow = new Date(lastDate.getTime() + (1000 * 60 * 60 * 24));
			
			if(now.after(lastDateTomorrow)) {
				member.setMvisiteddate(now);
				member.setMno(Integer.parseInt(String.valueOf(login.get(0).get("mno"))));
				// 방문수 하나 증가
				System.out.println(member.getMvisiteddate() + ", " + member.getMno());
				int result = memberService.memberUpdateVistedCount(member);
			}
			
			session.setAttribute("member", login.get(0));
			return "redirect:/";
		}
		
	}
	
	// 로그아웃
	@GetMapping("/member/logout")
	public String logout(HttpServletRequest req) throws Exception {
		logger.info("MemberController.logout() 함수 시작");
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		return "redirect:/";
	}

	// 회원가입
	@GetMapping("/member/register")
	public String registerForm() throws Exception {
		logger.info("MemberController.registerForm() 함수 시작");
		
		return "member/register";
	}

	@PostMapping("/member/register")
	public String register(MemberVO member, HttpServletRequest req) throws Exception {
		logger.info("MemberController.register() 함수 시작");
		
		String insertip = RemoteAddrUtils.RemoteAddr(req);
		member.setMinsertip(insertip);
		
		memberService.register(member);
		
		return "redirect:/member/login";
	}
	
	// 회원정보 수정
	@GetMapping("/member/update")
	public String memberUpdateForm(HttpServletRequest req, Model model) throws Exception {
		logger.info("MemberController.memberUpdateForm() 함수 시작");
		
		HttpSession session = req.getSession();
		
		// member1 : 세션의 mno값을 담는 객체
		MemberVO member1 = null;
	    member1 = new MemberVO();
		
	    // member2 : 세션정보를 저장한 객체
		HashMap<String, Object> member2 = (HashMap<String, Object>) session.getAttribute("member");
		int mno = Integer.parseInt(String.valueOf(member2.get("mno")));
		member1.setMno(mno);
		
		// member3 : 세션 mno를 통해 조회한 사용자 정보를 저장한 객체
		List<HashMap<String, Object>> member3 = memberService.memberSelect(member1);
		
		if(member3.size() >= 1) {
			model.addAttribute("m", member3.get(0));
		}
		
		Map<String, String> map = new HashMap<>();
		map.put("01", "남자");
		map.put("02", "여자");
		map.put("03", "선택 안함");
		
		model.addAttribute("map", map);
		
		return "member/memberUpdate";
	}
	
	@PostMapping("/member/update")
	@ResponseBody
	public String memberUpdate(MemberVO member, HttpServletRequest req) throws Exception {
		
		// 업데이트 ip주소 가져오기
		String updateip = RemoteAddrUtils.RemoteAddr(req);
		member.setMupdateip(updateip);
		
		// 업데이트를 한 아이디 저장하기 위해 가져오기
		HttpSession session = req.getSession();
		HashMap<String, Object> sessionMember = (HashMap<String, Object>) session.getAttribute("member");
		member.setMupdateid(String.valueOf(sessionMember.get("mid")));

		int result = memberService.memberUpdate(member);
		
		if(result == 1) 
			return "true";
		
		return "false";
	}
	
	// 회원 프로필
	@GetMapping("/member/profile")
	public String memberProfile(HttpServletRequest req, Model model) throws Exception {
		logger.info("MemberController.memberProfile() 함수 시작");
		
		HttpSession session = req.getSession();
		
		// member1 : 세션의 mno값을 담는 객체
		MemberVO member1 = null;
	    member1 = new MemberVO();
		
	    // member2 : 세션정보를 저장한 객체
		HashMap<String, Object> member2 = (HashMap<String, Object>) session.getAttribute("member");
		int mno = Integer.parseInt(String.valueOf(member2.get("mno")));
		member1.setMno(mno);
		
		// member3 : 세션 mno를 통해 조회한 사용자 정보를 저장한 객체
		List<HashMap<String, Object>> member3 = memberService.memberSelect(member1);
		
		if(member3.size() >= 1) {
			model.addAttribute("m", member3.get(0));
		}
		
		
		Map<String, String> map = new HashMap<>();
		map.put("01", "남자");
		map.put("02", "여자");
		map.put("03", "선택 안함");
		
		model.addAttribute("map", map);
		
		return "member/memberProfile";
	}

	// 회원 프로필
	@GetMapping("/member/setting")
	public String memberSetting(HttpServletRequest req, Model model) throws Exception {
		logger.info("MemberController.memberSetting() 함수 시작");
		
		HttpSession session = req.getSession();
		
		// member1 : 세션의 mno값을 담는 객체
		MemberVO member1 = null;
	    member1 = new MemberVO();
		
	    // member2 : 세션정보를 저장한 객체
		HashMap<String, Object> member2 = (HashMap<String, Object>) session.getAttribute("member");
		int mno = Integer.parseInt(String.valueOf(member2.get("mno")));
		member1.setMno(mno);
		
		// member3 : 세션 mno를 통해 조회한 사용자 정보를 저장한 객체
		List<HashMap<String, Object>> member3 = memberService.memberSelect(member1);
		
		if(member3.size() >= 1) {
			model.addAttribute("m", member3.get(0));
		}
		
		
		Map<String, String> map = new HashMap<>();
		map.put("01", "남자");
		map.put("02", "여자");
		map.put("03", "선택 안함");
		
		model.addAttribute("map", map);
		
		return "member/memberSetting";
	}
	
	// 회원 프로필
	@GetMapping("/member/changePassword")
	public String memberChangePassword(HttpServletRequest req, Model model) throws Exception {
		logger.info("MemberController.memberChangePassword() 함수 시작");
		
		HttpSession session = req.getSession();
		
		// member1 : 세션의 mno값을 담는 객체
		MemberVO member1 = null;
	    member1 = new MemberVO();
		
	    // member2 : 세션정보를 저장한 객체
		HashMap<String, Object> member2 = (HashMap<String, Object>) session.getAttribute("member");
		int mno = Integer.parseInt(String.valueOf(member2.get("mno")));
		member1.setMno(mno);
		
		// member3 : 세션 mno를 통해 조회한 사용자 정보를 저장한 객체
		List<HashMap<String, Object>> member3 = memberService.memberSelect(member1);
		
		if(member3.size() >= 1) {
			model.addAttribute("m", member3.get(0));
		}
		
		
		Map<String, String> map = new HashMap<>();
		map.put("01", "남자");
		map.put("02", "여자");
		map.put("03", "선택 안함");
		
		model.addAttribute("map", map);
		
		return "member/memberChangePassword";
	}	
	
	// 아이디 체크
	@GetMapping("/member/idCheck")
	@ResponseBody
	public boolean idCheck(MemberVO member) throws Exception {
		logger.info("MemberController.idCheck() 함수 시작");
		
		int result = memberService.memberIdCheck(member);
		
		if(result == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// 닉네임 체크
	@GetMapping("/member/nicknameCheck")
	@ResponseBody
	public boolean nicknameCheck(MemberVO member) throws Exception {
		logger.info("MemberController.nicknameCheck() 함수 시작");
		
		int result = memberService.memberNicknameCheck(member);
		
		if(result == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// 공개 프로필
	@GetMapping("/member/memberPublicProfile")
	public String memberPublicProfile(int mno, Model model) throws Exception {
		logger.info("MemberController.memberPublicProfile() 함수 시작");		
		
		MemberVO member = new MemberVO();
		member.setMno(mno);
		model.addAttribute("mno", mno);
		
		int visitedCount = memberService.publicProfileVisitedCount(member);
		int articleCount = memberService.publicProfileArticleCount(member);
		int commentCount = memberService.publicProfileCommentCount(member);
				
		model.addAttribute("visitedCount", visitedCount);
		model.addAttribute("articleCount", articleCount);
		model.addAttribute("commentCount", commentCount);
		
		return "member/memberPublicProfile";
	}
	
	// 게시글 리스트 Ajax
	@GetMapping("/member/memberArticleList")
	@ResponseBody
	public Map<String, Object> memberArticleList(MemberVO member, SearchCriteria scri) throws Exception {
		logger.info("MemberController.memberArticleList() 함수 시작");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member", member);
		map.put("scri", scri);
		
		List<Map<String, Object>> articleList = memberService.publicProfileArticleList(map);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(memberService.publicProfileArticleListCount(map));
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("articleList", articleList);
		result.put("pageMaker", pageMaker);
		
		return result;
	}
	
	// 댓글 리스트 Ajax
	@GetMapping("/member/memberCommentList")
	@ResponseBody
	public Map<String, Object> memberCommentList(MemberVO member, SearchCriteria scri) throws Exception {
		logger.info("MemberController.memberArticleList() 함수 시작");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member", member);
		map.put("scri", scri);
		
		List<Map<String, Object>> commentList = memberService.publicProfileCommentList(map);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(memberService.publicProfileCommentListCount(map));
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("articleList", commentList);
		result.put("pageMaker", pageMaker);
		
		return result;
	}
	
	// 문자 인증
	@GetMapping("/phoneCheck")
	@ResponseBody
	public String sendSMS(@RequestParam("phone") String userPhoneNumber) {
		int randomNumber = (int)((Math.random() * (9999 - 1000 + 1)) + 1000);
		
		System.out.println(userPhoneNumber + ", " + randomNumber);
		
		memberService.certifiedPhoneNumber(userPhoneNumber, randomNumber);
		
		return Integer.toString(randomNumber);
	}
	
	//=========================== 프로필 사진 업로드 =====================================

	@GetMapping("/uploadForm")
	public String uploadForm() {
		return "member/uploadForm";
	}
	
	@PostMapping("/upload")
	public String upload(String profile, String id, String name) throws Exception {
		logger.info("MemberController.upload() 함수 시작");
		
		System.out.println("profile : " + profile);
		System.out.println("id : " + id);
		System.out.println("name : " + name);
		
		return "redirect:/";
	}
	
	// 파일명 랜덤생성 메소드
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		logger.info("MemberController.uploadFile() 함수 시작");
		
		UUID uuid = UUID.randomUUID();
		String savedName = uuid.toString() + "_" + originalName;
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	
	// Ajax 업로드
	@PostMapping(value = "/uploadAjax", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		logger.info("MemberController.uploadAjax() 함수 시작");
		
		System.out.println("파일이름 : " + file.getOriginalFilename());
		System.out.println("파일크기 : " + file.getSize());
		System.out.println("컨텐츠 타입 : " + file.getContentType());
		
		return new ResponseEntity<String>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()), HttpStatus.OK);
	}
	
	@RequestMapping("/upload/displayFile")
	@ResponseBody
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		logger.info("MemberController.displayFile() 함수 시작");
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath + fileName);
			if(mType != null) {
				headers.setContentType(mType);
			} else {
				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("utf-8"), "iso-8859-1") + "\"");
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		
		return entity;
	}    	
	//=========================== /프로필 사진 업로드 =====================================	
	
}
