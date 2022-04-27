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

import dto.Country;
import service.CountryJSONService;


@WebServlet("*.country")
public class CountryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CountryJSONService countryservice = new CountryJSONService(); 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = request.getContextPath();
		if(uri.contains("jspform")) {	
			//jsp로 이동하기 위한 목적
			//iso조회
			List<Map<String, String>> isolist= countryservice.selectList_iso();
			System.out.println(isolist);
			
			//countrylist.jsp이동(포워딩)
			request.setAttribute("isolist", isolist);
			request.getRequestDispatcher("/view/countrylist.jsp")
					.forward(request, response);
			
		}else if(uri.contains("list")) {
			//db에서 조회
			String iso =request.getParameter("iso");
			//System.out.println(iso);
			//iso조회(이거로 조회하니까)
			List<Map<String, String>> isolist= countryservice.selectList_iso();
			
			List<Country> clist= countryservice.selectList(iso);
			//System.out.println(clist);
			//forward이동
			request.setAttribute("clist", clist);
			request.setAttribute("isolist", isolist);
			request.getRequestDispatcher("/view/countrylist.jsp")
					.forward(request, response);
		}else if(uri.contains("dbsave")) {
			//파싱 후 db저장하기 위해서
			String iso = request.getParameter("iso");
			System.out.println(iso);
			//파싱 후 db저장
			int cnt = countryservice.countryParsing(iso);
			
			//redirect 방식:url변경
			String msg = URLEncoder.encode(cnt+"건 저장", "utf-8");
			response.sendRedirect(path+"/jspform.country?msg="+msg+"&iso="+iso);
		}else if(uri.contains("detail")) {
			//상세조회로 이동
			String sfty_notice_id= request.getParameter("sfty_notice_id");
			//한건조회
			Country country = countryservice.selectOne(sfty_notice_id);
			//System.out.println(country);
			//forward방식 이동(대량정보)
			request.setAttribute("country", country);
			request.getRequestDispatcher("/view/countrydetail.jsp")
					.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
