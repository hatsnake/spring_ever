package com.hatsnake.ever;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hatsnake.ever.member.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("/header")
	public String header(HttpServletRequest req, Model model) throws Exception {
		logger.info("HomeController.header() 함수 시작");
		
		HttpSession session = req.getSession();
		
		MemberVO sessionMember = (MemberVO) session.getAttribute("member");
		model.addAttribute("member", sessionMember);
		
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