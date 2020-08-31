package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import db.AuthInfo;
import db.Stock;
import db.StockService;

@Controller
@RequestMapping("/dashboard")
public class BoardController {

	/* DB 사용시 개발
	// 멤버 변수 필요 ( MemberDao(DB)와 연결되는 클래스 )
	private StockService stockService;
	
	public void setStockService(
			StockService stockService) {
		this.stockService = stockService;
	}*/
	
	// 바로 접근 시
	@GetMapping
	public String goDashboard(HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		if ( authInfo == null) {
			return "redirect:/login";
		}
		return "dashboard/dashboard";
	}
	
	@RequestMapping("/dashboard")
	public String list(
			@ModelAttribute("cmd") ListCommand listCommand,
			Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "dashboard/dashboard";
		}
		
		if ( listCommand.getID() != null) {
			try {
				String html = getHtml("http://asp1.krx.co.kr/servlet/krx.asp.XMLSise?code="+listCommand.getID());
			    JSONObject json = XML.toJSONObject(html);
			    Map<String, Object> resultMap = parseJsonToMap(json.toString());
			    //System.out.println(resultMap);
			    model.addAttribute("identify","XML 파싱 완료!");
			    //model.addAttribute("map", resultMap);
			} catch( Exception e) {
				return "dashboard/noStock";
			}
		}
		
		/* 나중에 기간 입력 개발 후에
		if (listCommand.getID() != null && 
				listCommand.getFrom() != null && listCommand.getTo() != null) {
			String html = getHtml("http://asp1.krx.co.kr/servlet/krx.asp.XMLSise?code="+listCommand.getID());
		    JSONObject json = XML.toJSONObject(html);
		    Map<String, Object> resultMap = parseJsonToMap(json.toString());
		    model.addAttribute("map", resultMap);
		}*/
		return "dashboard/dashboard";
	}
	
	// XML을 가져오기
	public String getHtml(String url) {
		try {
			URL targetUrl = new URL(url);
			BufferedReader reader = new BufferedReader(new InputStreamReader(targetUrl.openStream()));
			StringBuilder html = new StringBuilder();
			String current = "";
			while ((current = reader.readLine()) != null) {
				html.append(current);
			}
			reader.close();
		     	 return html.toString();
		     } catch (MalformedURLException e) {
		         e.printStackTrace();
		     } catch (IOException e) {
		         e.printStackTrace();
		     }
		     return null;
	}
	
	// JSON -> MAP 으로 변환
	public Map<String, Object> parseJsonToMap(String json) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, new TypeReference<Map<String, Object>>() {
			});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new HashMap<String, Object>();
	}
	// Map-> Stock 클래스로 변환
	public List<Stock> changeMapToStock(Map<String,Object> map){
		List<Stock> stockinfo = null;
		return stockinfo;
	}
}
