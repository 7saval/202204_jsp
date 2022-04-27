package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AirJSONService;

@WebServlet("*.air")
public class AirController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AirJSONService airservice = new AirJSONService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = request.getContextPath();
		if(uri.contains("jspform")) {
			//jsp로 이동하기 위한 목적
			List<Map<String, Object>> airlist= airservice.selectList("year");
			System.out.println(airlist);
			//airlist.jsp이동(포워딩)
			request.getRequestDispatcher("view/airlist.jsp")
					.forward(request, response);
		}
		if(uri.contains("list")) {
			//연도로 조회
//			String year=request.getParameter("year");
//			List<Map<String, Object>> airlist = airservice.selectList("year");
//			
//			//forward
//			request.setAttribute("year", year);
//			request.setAttribute("airlist", airlist);
//			request.getRequestDispatcher("/view/airlist.jsp")
//					.forward(request, response);
			//지역명 조회
			String districtName = request.getParameter("districtName");
			List<Map<String, Object>> airlist = airservice.selectList(districtName);
			
			//forward이동
			request.setAttribute("airlist", airlist);
			request.getRequestDispatcher("/view/airlist.jsp")
								.forward(request, response);
		}
		else if(uri.contains("dbsave")) {
			//파싱 후 db저장하기 위해서
			String year=request.getParameter("year");
			//파싱 후 db저장
			int cnt = airservice.airParsing(year);
			//redirect 이동
			String msg = URLEncoder.encode(cnt+"건 저장", "utf-8");
			response.sendRedirect(path+"/jspform.air?msg="+msg+"&year="+year);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
