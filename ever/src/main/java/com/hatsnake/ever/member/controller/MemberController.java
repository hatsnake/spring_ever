package com.hatsnake.ever.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hatsnake.ever.member.service.MemberService;
import com.hatsnake.ever.member.util.RemoteAddrUtils;
import com.hatsnake.ever.member.vo.MemberVO;

@Controller
public class MemberController {
	
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MemberService memberService;
	
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
		List<MemberVO> login = memberService.login(member);
		
		if(login.size() != 1) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/login";
		} else {
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
		MemberVO member2 = (MemberVO) session.getAttribute("member");
		int mno = member2.getMno();
		member1.setMno(mno);
		
		// member3 : 세션 mno를 통해 조회한 사용자 정보를 저장한 객체
		List<MemberVO> member3 = memberService.memberSelect(member1);
		model.addAttribute("m", member3.get(0));
		
		
		Map<String, String> map = new HashMap<>();
		map.put("01", "남자");
		map.put("02", "여자");
		map.put("03", "선택 안함");
		
		model.addAttribute("map", map);
		
		return "member/memberUpdate";
	}
	
	@ResponseBody
	@PostMapping("/member/update")
	public String memberUpdate(MemberVO member, HttpServletRequest req) throws Exception {
		
		// 업데이트 ip주소 가져오기
		String updateip = RemoteAddrUtils.RemoteAddr(req);
		member.setMupdateip(updateip);
		
		// 업데이트 아이디 가져오기
		HttpSession session = req.getSession();
		MemberVO sessionMember = (MemberVO) session.getAttribute("member");
		member.setMupdateid(sessionMember.getMid());

		int result = memberService.memberUpdate(member);
		
		if(result == 1) 
			return "true";
		
		return "false";
	}
	
}
