package s01;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/J20220329_04")
public class J20220329_04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		String pname = request.getParameter("pname");
		int price = Integer.parseInt(request.getParameter("price"));
		int pqty = Integer.parseInt(request.getParameter("pqty"));
		int salesprice = price*pqty;
		
		//주소를 변경, msg전달
		/*
		 * String msg= URLEncoder.encode(cnt + "건 추가", "utf-8");
		 * response.sendRedirect("20220328_16_db.jsp?msg="+msg);
		 */
		//경로가 변경
		String name = URLEncoder.encode(pname, "utf-8");
		response.sendRedirect("/jsp01/view/servlet/20220329_04_redi_sales.jsp?name="+name+"&salesprice="+salesprice);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
