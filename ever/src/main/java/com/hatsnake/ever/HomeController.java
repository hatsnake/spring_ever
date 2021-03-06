package com.hatsnake.ever;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hatsnake.ever.member.service.MemberService;
import com.hatsnake.ever.member.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private MemberService memberService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
	}
	
	@GetMapping("/header")
	public String header(HttpServletRequest req, Model model) throws Exception {
		logger.info("HomeController.header() 함수 시작");
		
		HttpSession session = req.getSession();
		
		// member1 : 세션의 mno값을 담는 객체
		MemberVO member1 = null;
	    member1 = new MemberVO();
		
	    // member2 : 세션정보를 저장한 객체
		HashMap<String, Object> member2 = (HashMap<String, Object>) session.getAttribute("member");
		
		if(member2 != null) {
			int mno = Integer.parseInt(String.valueOf(member2.get("mno")));
			member1.setMno(mno);
			
			// member3 : 세션 mno를 통해 조회한 사용자 정보를 저장한 객체
			List<HashMap<String, Object>> member3 = memberService.memberSelect(member1);
			
			if(member3.size() >= 1) {
				HashMap<String, Object> sessionMember = member3.get(0);
				model.addAttribute("member", sessionMember);
			} else {
				model.addAttribute("member", null);
			}
		} else {
			model.addAttribute("member", null);
		}

		return "fragment/header";
	}

	@GetMapping("/sidebar")
	public String sidebar() throws Exception {
		
		return "fragment/sidebar";
	}
	
	@GetMapping("/footer")
	public String footer() throws Exception {
		
		return "fragment/footer";
	}	
	
}
