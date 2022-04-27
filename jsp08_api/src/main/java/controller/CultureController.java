package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CultureService;

@WebServlet("*.culture")
public class CultureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CultureService cultureservice = new CultureService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri= request.getRequestURI();
		System.out.println(uri);
		String path=request.getContextPath();
		
		if(uri.contains("addr")) {
			//파싱 후 view에 맵전달
			String name = request.getParameter("name");
			Map<String, Object> map = cultureservice.cultureParsing(name);
			
			//위도,경도 구하기
			Map<String, Double> gmap= cultureservice.geocoding((String)map.get("ADDR"));
			System.out.println("gmap:"+gmap);
			request.setAttribute("map", map);
			request.setAttribute("gmap", gmap);
			request.getRequestDispatcher("/view/cultureaddr.jsp")
				.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
