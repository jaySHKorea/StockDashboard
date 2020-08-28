package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import db.StockLoad;

public class BoardController {

	// 멤버 변수 필요 ( MemberDao(DB)와 연결되는 클래스 )
	private StockLoad stockLoad;
	
	public void setStockLoad(
			StockLoad stockLoad) {
		this.stockLoad = stockLoad;
	}
	
	// XML을 가져와서 View에 전송
	 @RequestMapping(value = "/main")
	 public void StockToMain(Model model) {
	     String html = getHtml("http://asp1.krx.co.kr/servlet/krx.asp.XMLSise?code=035420");
	     JSONObject json = XML.toJSONObject(html);
	     Map<String, Object> resultMap = parseJsonToMap(json.toString());
	     model.addAttribute("map", resultMap);
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
}
