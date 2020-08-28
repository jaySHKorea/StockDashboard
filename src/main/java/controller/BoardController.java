package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class BoardController {

	 @RequestMapping(value = "/main")
	 public void krx(Model model) {
	     String html = getHtml("http://asp1.krx.co.kr/servlet/krx.asp.XMLSise?code=035420");
	     JSONObject json = XML.toJSONObject(html);
	     Map<String, Object> resultMap = parseJsonToMap(json.toString());
	     model.addAttribute("map", resultMap);
	 }
}
