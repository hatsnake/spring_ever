package com.hatsnake.ever.member.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.hatsnake.ever.member.service.MemberService;
import com.hatsnake.ever.member.vo.CovidPageVO;
import com.hatsnake.ever.member.vo.CovidVO;
import com.hatsnake.ever.member.vo.MemberVO;
import com.hatsnake.ever.util.MediaUtils;
import com.hatsnake.ever.util.RemoteAddrUtils;
import com.hatsnake.ever.util.UploadFileUtils;

@Controller
public class MemberController {
	
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MemberService memberService;
	
	@Resource(name="memberUploadPath")
	private String uploadPath;

	@GetMapping("/uploadForm")
	public String uploadForm() {
		return "member/uploadForm";
	}
	
	@PostMapping("/upload")
	public String upload(String profile, String id, String name) throws Exception {
		System.out.println("profile : " + profile);
		System.out.println("id : " + id);
		System.out.println("name : " + name);
		
		return "redirect:/";
	}
	
	// 파일명 랜덤생성 메소드
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
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
		System.out.println("파일이름 : " + file.getOriginalFilename());
		System.out.println("파일크기 : " + file.getSize());
		System.out.println("컨텐츠 타입 : " + file.getContentType());
		
		return new ResponseEntity<String>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()), HttpStatus.OK);
	}
	
	@RequestMapping("/upload/displayFile")
	@ResponseBody
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
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
	
	@GetMapping("/test")
	public String test() {
		return "member/test";
	}
	
	@GetMapping("/openapi/test")
	@ResponseBody
	public List<Map<String, Object>> openApiTest(String pageNo, String numOfRows) throws Exception{
		ArrayList<CovidVO> covidList = new ArrayList<CovidVO>();
		ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		CovidVO covidVO = new CovidVO();
		CovidPageVO covidPageVO = new CovidPageVO();
		Map<String, Object> covidMap = new HashMap<String, Object>();
		
        StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=jGCxcDXeNgMyySydOuzHqkiyqUvuQFeR7%2BJ7b00O%2FXL1aTqAgs5YxS0lJgYXr269d6UwXh%2FSXTlBMmRJbkHRJw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode("20200310", "UTF-8")); /*검색할 생성일 범위의 시작*/
        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode("20200415", "UTF-8")); /*검색할 생성일 범위의 종료*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
		Document doc = dBuilder.parse(url.toString());
		
	    doc.getDocumentElement().normalize();
        System.out.println("Root Element : "+doc.getDocumentElement().getNodeName());
        
        NodeList nodeList = doc.getElementsByTagName("item");
        
        // 페이지 정보
        NodeList nodeBody = doc.getElementsByTagName("body");
        
        Node bodyNode = nodeBody.item(0);
        Element bodyElement = (Element) bodyNode;
        String numofrows = getTagValue("numOfRows", bodyElement);
        String pageno = getTagValue("pageNo", bodyElement);
        String totalcount = getTagValue("totalCount", bodyElement);
        
        covidPageVO.setNumofrows(numofrows);
        covidPageVO.setPageno(pageno);
        covidPageVO.setTotalcount(totalcount);
        
        int totalPageCount = Integer.parseInt(totalcount); 
        int totalPageNum = (int) (Math.ceil((Math.ceil(Double.parseDouble(totalcount)/10)*10)/Double.parseDouble(numofrows)));
        int startPage = (Integer.parseInt(pageno) - 1) * Integer.parseInt(numofrows);
        int endPage = (Integer.parseInt(pageno) * Integer.parseInt(numofrows));
        
        covidPageVO.setTotalPageCount(totalPageCount);
        covidPageVO.setStartPage(startPage);
        covidPageVO.setEndPage(endPage);
        
        System.out.println(startPage + " ~ " + endPage + " : " + totalcount + " : " + totalPageNum);
        
        covidMap.put("covidPageVO", covidPageVO);
        
        
        if(totalPageCount > endPage) {
	        // 데이터 정보
	        //for(int temp = 0; temp<nodeList.getLength(); temp++) {
	        for(int temp = startPage; temp < endPage; temp++) {
	        	System.out.println("통과?");
	        	Node nNode = nodeList.item(temp);
	        	if(nNode.getNodeType()==Node.ELEMENT_NODE) {
	        		Element element = (Element) nNode;
	        		
	        		String accdefrate = getTagValue("accDefRate", element);
	        		String accexamcnt = getTagValue("accExamCnt", element);
	        		String deathcnt = getTagValue("deathCnt", element);  
	        		String decidecnt = getTagValue("decideCnt", element); 
	        		String createdt = getTagValue("createDt", element);  
	        		String seq = getTagValue("seq", element);       
	        		String statedt = getTagValue("stateDt", element);   
	        		String statetime = getTagValue("stateTime", element); 
	        		String updatedt = getTagValue("updateDt", element);  
	        		
	        		covidVO.setAccdefrate(accdefrate);
	        		covidVO.setAccexamcnt(accexamcnt);
	        		covidVO.setDeathcnt(deathcnt);
	        		covidVO.setDecidecnt(decidecnt);
	        		covidVO.setCreatedt(createdt);
	        		covidVO.setSeq(seq);
	        		covidVO.setStatedt(statedt);
	        		covidVO.setStatetime(statetime);
	        		covidVO.setUpdatedt(updatedt);
	
	        		covidList.add(new CovidVO(accdefrate, accexamcnt, deathcnt, decidecnt, createdt, seq, statedt, statetime, updatedt));
	        	}        	
	        }
        } else {
	        for(int temp = startPage; temp < totalPageCount; temp++) {
	        	System.out.println("통과?");
	        	Node nNode = nodeList.item(temp);
	        	if(nNode.getNodeType()==Node.ELEMENT_NODE) {
	        		Element element = (Element) nNode;
	        		
	        		String accdefrate = getTagValue("accDefRate", element);
	        		String accexamcnt = getTagValue("accExamCnt", element);
	        		String deathcnt = getTagValue("deathCnt", element);  
	        		String decidecnt = getTagValue("decideCnt", element); 
	        		String createdt = getTagValue("createDt", element);  
	        		String seq = getTagValue("seq", element);       
	        		String statedt = getTagValue("stateDt", element);   
	        		String statetime = getTagValue("stateTime", element); 
	        		String updatedt = getTagValue("updateDt", element);  
	        		
	        		covidVO.setAccdefrate(accdefrate);
	        		covidVO.setAccexamcnt(accexamcnt);
	        		covidVO.setDeathcnt(deathcnt);
	        		covidVO.setDecidecnt(decidecnt);
	        		covidVO.setCreatedt(createdt);
	        		covidVO.setSeq(seq);
	        		covidVO.setStatedt(statedt);
	        		covidVO.setStatetime(statetime);
	        		covidVO.setUpdatedt(updatedt);
	
	        		covidList.add(new CovidVO(accdefrate, accexamcnt, deathcnt, decidecnt, createdt, seq, statedt, statetime, updatedt));
	        	}        	
	        }
        }
        
        covidMap.put("covidList", covidList);
        
        result.add(covidMap);
        
        return result;
	}
	
    private static String getTagValue(String tag, Element ele) {
        NodeList nodeList = ele.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nodeList.item(0);

        if(nValue == null) {
            return null;
        }

        return nValue.getNodeValue();
    }
	
}
