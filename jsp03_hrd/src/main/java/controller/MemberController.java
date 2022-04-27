package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.Member;

//회원관리 컨트롤러
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MemberDAO mdao = new MemberDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		if (uri.contains("join")) {
			String custname = request.getParameter("custname");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String joindate = request.getParameter("joindate");
			String grade = request.getParameter("grade");
			String city = request.getParameter("city");
			//member객체 생성
			Member member = new Member(custname, phone, address, joindate, grade, city);
			System.out.println(member);
			int cnt = mdao.insert(member);
			System.out.println(cnt+"건 추가");
			String contextPath = request.getContextPath();
			System.out.println(contextPath);
			String msg = URLEncoder.encode("등록완료", "utf-8");
			response.sendRedirect(contextPath+"/view/memberAdd.jsp?msg="+msg);
		}else if(uri.contains("list")) {
			//리스트
			//dao호출
			List<Member> mlist= mdao.selectList();
			System.out.println(mlist);
			request.setAttribute("mlist", mlist);
			request.getRequestDispatcher("/view/memberList.jsp")
				.forward(request, response);
		}else if(uri.contains("modiform")) {
			//수정폼으로
			int custno = Integer.parseInt(request.getParameter("custno"));
			//한건조회
			//dao호출
			Member member =mdao.selectOne(custno);
			System.out.println(member);
			request.setAttribute("member", member);
			request.getRequestDispatcher("/view/memberModify.jsp")
				.forward(request, response);
		}else if(uri.contains("modify")) {
			int custno = Integer.parseInt(request.getParameter("custno"));
			String custname = request.getParameter("custname");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String joindate = request.getParameter("joindate");
			String grade = request.getParameter("grade");
			String city = request.getParameter("city");
			Member member = new Member();
			member.setCustno(custno);
			member.setCustname(custname);
			member.setPhone(phone);
			member.setAddress(address);
			member.setJoindate(joindate);
			member.setGrade(grade);
			member.setCity(city);
			
			System.out.println(member);
			int cnt = mdao.update(member);
			System.out.println(cnt+"건 수정");
			String msg = URLEncoder.encode("수정완료","utf-8");
			//수정폼으로 이동시 기존데이터 조회필요=>컨트롤러 재호출
			response.sendRedirect("/jsp03_hrd/member/modiform?custno="+custno+"&msg="+msg);
		}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
