package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Covid;
import service.CovidXMLService;

@WebServlet("*.covid")
public class CovidController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CovidXMLService covidservice = new CovidXMLService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = request.getContextPath();
		
		if(uri.contains("list")) {
			//코로나 현황 조회
			String startDt = request.getParameter("startDt");
			String endDt = request.getParameter("endDt");
			System.out.println(startDt);
			System.out.println(endDt);
			
			//covidservice.covidParsing(startDt, endDt);
//			System.out.println(covidList);
			
			List<Covid> clist = covidservice.selectList(startDt, endDt);
			System.out.println("controller clist: " + clist);
			//forward 이동
			request.setAttribute("clist", clist);
			//url바꾸는 게 아니라 내 프로젝트 안에 정보 가져오므로 path가져올 필요x
			request.getRequestDispatcher("/view/covidlist.jsp")
					.forward(request, response);
		}else if(uri.contains("dbsave")) {
			String startDt = request.getParameter("startDt");
			String endDt = request.getParameter("endDt");
			//파싱후db저장
			int cnt = covidservice.covidParsing(startDt, endDt);
			//System.out.println(cnt+"건 db저장 완료");
			
			//redirect 리스트로 이동
			//메시지 전송 : cnt건 db저장 완료
			String msg = URLEncoder.encode(cnt+"건 db저장 완료", "utf-8");
			response.sendRedirect(path+"/view/covidlist.jsp?msg="+msg +"&startDt="+startDt+"&endDt="+endDt);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
