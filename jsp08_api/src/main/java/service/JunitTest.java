package service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import dao.AirDAO;

class JunitTest {
	CovidXMLService covidService = new CovidXMLService();
	CountryJSONService countryService = new CountryJSONService();
	CultureService cultureservice = new CultureService();
	AirJSONService airService = new AirJSONService();
	AirDAO airdao = new AirDAO();
	@Test
	void testCovid() throws IOException, SAXException, ParserConfigurationException {
		//코로나 확진자
		covidService.covidParsing("20220328","20220331");
	}
	
	//컨트리 테스트
	@Test
	void testCountry() {
		countryService.countryParsing("GB");
	}
	
	//문화위치정보
	@Test
	void testCulture() {
		Map<String, Object> map= cultureservice.cultureParsing("서울연극센터");
		System.out.println(map);
	}
	
	//지오코딩테스트
		@Test
		void testCultureGeocoding() {
			Map<String, Double> map = cultureservice.geocoding("서울 광진구 능동 18-11");
			System.out.println("map:"+map);
		}
	//미세먼지테스트
		@Test
		void testAir() throws IOException {
//			airdao.selectList("2022-03-04");
			int cnt = airService.airParsing("2020");
			System.out.println(cnt+"건 저장");
		}
	//미세먼지조회
		@Test
		void testAirList() {
			airService.selectList("2022");
		}
}
