package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CultureService {
	//주소 요청하고 파싱하기
	 public Map<String, Object> cultureParsing(String name) {
		 Map<String, Object> map= new HashMap<>();
		 try {
			 //서울시 문화위치정보 명칭 검색
			 //https://www.data.go.kr/data/15056764/openapi.do
			 String servicekey="46637968524a746837324241436853";
			 StringBuilder sb = new StringBuilder();
			 sb.append("http://openAPI.seoul.go.kr:8088/");
			 sb.append(servicekey);
			 sb.append("/json/");
			 sb.append("SearchCulturalFacilitiesNameService/1/5/");
			 sb.append(name);
			 System.out.println(sb.toString());
			 
			 //conn요청+데이터받기
			 URL url = new URL(sb.toString());
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
	         sb = new StringBuilder();
	         String line;
	         while ((line = rd.readLine()) != null) {
	             sb.append(line);
	         }
	         rd.close();
	         conn.disconnect();
	         System.out.println(sb.toString()); //문자열 데이터
	         //-----------------------------------------------
	         //JSON파싱
	         JSONParser parser = new JSONParser();
	         JSONObject object = (JSONObject)parser.parse(sb.toString());
	         object = (JSONObject) object.get("SearchCulturalFacilitiesNameService");
	         System.out.println(object);
	         JSONArray array= (JSONArray) object.get("row");
	         System.out.println(array.get(0));
	         object = (JSONObject) array.get(0); //index가 한개만 있다
	         //System.out.println(object);
	         //object를 map에 넣기
	         
	         map.put("FAC_CODE", object.get("FAC_CODE"));
	         map.put("SUBJCODE", object.get("SUBJCODE"));
	         map.put("FAC_NAME", object.get("FAC_NAME"));
	         map.put("CODENAME", object.get("CODENAME"));
	         map.put("ADDR", object.get("ADDR"));
	         
	         System.out.println("map:"+ map);      
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	 }
	 //주소를 이용하여 위도, 경도 알아내기
	 public Map<String, Double> geocoding(String addr) {
		 Map<String, Double> map= new HashMap<>();
		 try {
			 //서울시 문화위치정보 명칭 검색
			 StringBuilder sb = new StringBuilder();
			 sb.append("https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode");
			 sb.append("?query="+URLEncoder.encode(addr, "utf-8"));
			 System.out.println(sb.toString());
			 
			 //conn요청+데이터받기
			 URL url = new URL(sb.toString());
			 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	         conn.setRequestMethod("GET");
	         conn.setRequestProperty("Content-type", "application/json");
	         conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "ukqfsgw1gc");//앱 등록 시 발급받은 Client ID
	         conn.setRequestProperty("X-NCP-APIGW-API-KEY", "hYTVWpPH5Jjg3QYXjin1BDFMsqoy30qSU6E2q0yu");//앱 등록 시 발급 받은 Client Secret
	         System.out.println("Response code: " + conn.getResponseCode());
	         BufferedReader rd;
	         if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	             rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	         } else {
	             rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	         }
	         sb = new StringBuilder();
	         String line;
	         while ((line = rd.readLine()) != null) {
	             sb.append(line);
	         }
	         rd.close();
	         conn.disconnect();
	         System.out.println(sb.toString()); //응답받은 문자열 데이터
	         //-----------------------------------------------
	         //JSON파싱 : 
	         JSONParser parsor = new JSONParser();
	         JSONObject object = (JSONObject) parsor.parse(sb.toString()); //문자열을 json객체로 변경
	        //object = (JSONObject) object.get("addresses");
	        // System.out.println(object.get("addresses"));
	         
	        //만약 totalcnt가 0이라면 null을 리턴 / objects따로 선언
	         JSONObject objects = (JSONObject) object.get("meta");
	        //System.out.println(objects);
	        long totCnt = (long)objects.get("totalCount");
	        System.out.println(totCnt);
	        if(totCnt==0) {
	        	return null; //데이터가 미존재 시 메소드 종료
	        }
	        
        	JSONArray array = (JSONArray) object.get("addresses");
	        object = (JSONObject) array.get(0);
	         //x값을 다운캐스팅 후 실수형으로 형변환
	         double x = Double.parseDouble((String) object.get("x"));
	         double y = Double.parseDouble((String) object.get("y"));
	         map.put("x", x);
	         map.put("y",y);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	 }
	 
	 
	 
	 
	 
	 
}
