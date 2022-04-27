package service;

	import java.io.InputStreamReader;
	import java.net.HttpURLConnection;
	import java.net.URL;
	import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import dao.AirDAO;

import java.io.BufferedReader;
	import java.io.IOException;

	public class AirJSONService {
		private AirDAO airdao = new AirDAO();
//		private String issueDate;
//		private String year = issueDate.substring(0, 4);
	    public int airParsing(String year) throws IOException {
	    	
	    	//반환값
	    	List<Map<String, Object>> airlist = new ArrayList<>();
	    	
	    	String servicekey ="HI2ANjDRXk0VPLrbcMbc14NQR2ixM7CxWHNfcM5%2BigJZb5vlfpXQN3M92S1pNPAL0af3Kl7wiQF1n0HC6GaW0A%3D%3D";
	        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+servicekey); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*xml 또는 json*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("500", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("year","UTF-8") + "=" + URLEncoder.encode(year, "UTF-8")); /*측정 연도*/
	        urlBuilder.append("&" + URLEncoder.encode("itemCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*미세먼지 항목 구분(PM10, PM25), PM10/PM25 모두 조회할 경우 파라미터 생략*/
	        System.out.println(urlBuilder.toString()); //url출력
	        URL url = new URL(urlBuilder.toString());
	        
	        //url접속
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
	        
	        //json파싱
	        //파싱 라이브러리 : json-simple-1.1.1.jar
	        JSONParser parser = new JSONParser();
	        try {
				JSONObject object = (JSONObject) parser.parse(sb.toString());
				object = (JSONObject) object.get("response");
				object = (JSONObject) object.get("body");
				JSONArray array= (JSONArray) object.get("items");
				System.out.println(array);
				System.out.println("---------------------------");
				for(int i=0;i<array.size();i++) {
					System.out.println("-----------------------");
					Map<String, Object> map = new HashMap<>();
					object= (JSONObject) array.get(i);
					Set<String> kset = object.keySet();
					for(String key:kset) {
						//키와 값
						System.out.println(key + ":" + object.get(key));
						map.put(key, object.get(key));
					}
					airlist.add(map); //리스트에 맵 넣기
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        int cnt = airdao.insert(airlist);
	        //System.out.println(airlist);
			return cnt;
	    }
	    
	    public List<Map<String, Object>> selectList(String districtName){
	    	return airdao.selectList(districtName);
	    }
	}

