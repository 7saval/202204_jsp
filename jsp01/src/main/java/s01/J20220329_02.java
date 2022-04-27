package s01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//확장자 패턴(확장자가 cal인 모든 매핑을 처리
@WebServlet("*.cal")
public class J20220329_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public J20220329_02() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String url = request.getRequestURI();
		System.out.println(uri);
		System.out.println(url);
		
		//삼각형의 넓이를 구하기
		double width = Integer.parseInt(request.getParameter("width"));
		double height = Integer.parseInt(request.getParameter("height"));
		double area = width*height/2;
		
		//forward방식 이동(20220329_02_mapping.jsp)
		request.setAttribute("area", area);
		
		request.getRequestDispatcher("/view/servlet/20220329_02_mapping.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
