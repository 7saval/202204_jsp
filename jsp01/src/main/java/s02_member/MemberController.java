package s02_member;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//디렉토리 패턴
// /member/ 로 시작하는 모든 매핑 처리
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO mdao = new MemberDAO(); //dao 객체 필드로 생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩(utf-8)
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		//join처리
		if(uri.contains("insert")) {
			//view 데이터 읽기
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			//멤버객체 생성
			Member member = new Member(userid, passwd, name, email);
			System.out.println(member);
			//입력받을 거라 세터 필요없음
			//dao객체 생성
			//MemberDAO mdao = new MemberDAO();
			int cnt = mdao.insert(member);
			System.out.println(cnt+"건 추가");
			//회원가입 완료 메세지 view에 보내기
			//20220329_01_insert.jsp
			String msg = URLEncoder.encode(cnt+"건 추가","utf-8");
			response.sendRedirect("/jsp01/view/db/20220329_01_insert.jsp?msg="+msg);
		}else if(uri.contains("selectList")) {
			//조회리스트
			//MemberDAO mdao = new MemberDAO();
			List<Member> mlist = mdao.selectList();
			//System.out.println(mlist);
			//20220330_02_selectList.jsp 로 이동
			//forward이동(대량의 데이터 전송)
			//contextpath 제외
			request.setAttribute("mlist", mlist);
			request.getRequestDispatcher("/view/db/20220330_02_selectList.jsp")
				.forward(request, response);
		}else if(uri.contains("modify")) {
			//수정폼으로 이동
			//한건조회
			String userid = request.getParameter("userid");
			System.out.println(userid);
			
			Member member= mdao.selectOne(userid);
			System.out.println(member);
			
			//forward 이동
			request.setAttribute("member", member);
			request.getRequestDispatcher("/view/db/20220330_03_update.jsp")
				.forward(request, response);
		}else if(uri.contains("update")) {
			//수정
			//view 데이터 읽기
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			//객체 생성(DAO에 넘겨주려고)
			Member member = new Member();
			//MemberDAO mdao = new MemberDAO();
			member.setUserid(userid);
			member.setPasswd(passwd);
			member.setName(name);
			member.setEmail(email);
			System.out.println(member);
			int cnt = mdao.update(member);
			
			System.out.println(cnt+"건 수정");
			//redirect이동(조회)
			//String msg = URLEncoder.encode(cnt+"건 수정", "utf-8");
			response.sendRedirect("/jsp01/member/selectList");
		}else if(uri.contains("remove")) {
			//삭제
			String userid = request.getParameter("userid");
			int cnt = mdao.delete(userid);
			System.out.println(cnt+"건 삭제");
			//redirect이동(조회)
			//String msg = URLEncoder.encode(cnt+"건 삭제","utf-8");
			response.sendRedirect("/jsp01/member/selectList");
		}
		
		

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
