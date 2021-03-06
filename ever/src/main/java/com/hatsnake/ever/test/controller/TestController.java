package com.hatsnake.ever.test.controller;

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
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.hatsnake.ever.member.vo.CovidPageVO;
import com.hatsnake.ever.member.vo.CovidVO;
import com.hatsnake.ever.util.MediaUtils;
import com.hatsnake.ever.util.UploadFileUtils;

@Controller
public class TestController {

	private final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	/*====================== OPEN API ================================*/
	
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
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /*???????????????*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*??? ????????? ?????? ???*/
        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode("20200310", "UTF-8")); /*????????? ????????? ????????? ??????*/
        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode("20200415", "UTF-8")); /*????????? ????????? ????????? ??????*/
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
        
        // ????????? ??????
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
	        // ????????? ??????
	        //for(int temp = 0; temp<nodeList.getLength(); temp++) {
	        for(int temp = startPage; temp < endPage; temp++) {
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
	
    private String getTagValue(String tag, Element ele) {
        NodeList nodeList = ele.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nodeList.item(0);

        if(nValue == null) {
            return null;
        }

        return nValue.getNodeValue();
    }
    
    /* ====================== /OPEN API ================================*/
}
