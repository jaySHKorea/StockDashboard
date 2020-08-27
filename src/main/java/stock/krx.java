package stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class krx {
	
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
}
