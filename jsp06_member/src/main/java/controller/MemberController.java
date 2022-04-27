package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.Member;
import service.MemberService;


@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService memberservice = new MemberService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String path = request.getContextPath();
		
		if(uri.contains("join")) {
			//회원가입
			//saveDirectory : 파일저장경로(서버의 경로)
			//String saveDirectory = "c:/javaprogramming/savedir";
			//프로젝트의 web.xml의 context-param의 값을 읽기
			String saveDirectory = getServletContext().getInitParameter("savedir");
			
			
			//size: 업로드파일 사이즈 제한
			//1024byte -> 1kbyte
			//1024kbyte -> 1mbite
			int size = 1024*1024*10; //10mbyte
			//DefaultFileRenamePolicy(): 같은 이름의 파일이 있을 때 파일이름 변경
			//cos라이브러리에 있음
			MultipartRequest multi = new MultipartRequest(request, saveDirectory, size, "utf-8",
					new DefaultFileRenamePolicy());
			
			//MultipartRequest객체의 메소드를 이용해서 데이터 얻기
			String userid = multi.getParameter("userid");
			String passwd = multi.getParameter("passwd");
			String zipcode = multi.getParameter("zipcode");
			String addrload = multi.getParameter("addrload");
			String addrdetail = multi.getParameter("addrdetail");
			//실제 저장된 파일이름
			String filename = multi.getFilesystemName("photo");
			//Member객체생성
			Member member = new Member();
			member.setUserid(userid);
			member.setPasswd(passwd);
			member.setZipcode(zipcode);
			member.setAddrload(addrload);
			member.setAddrdetail(addrdetail);
			member.setFilename(filename);
			System.out.println(member);
			
			//서비스 호출
			int cnt = memberservice.insert(member);
			System.out.println(cnt+"건 추가");
			
			//redirect이동
			response.sendRedirect(path + "/member/join.jsp?msg="+ URLEncoder.encode(cnt+"건 추가", "utf-8"));
		}else if(uri.contains("login")) {
			//로그인
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			System.out.println(userid);
			System.out.println(passwd);
			//service호출
			Map<String, Object> rmap = memberservice.loginCheck(userid, passwd);
			//msg: 로그인 성공, 회원미존재, 비밀번호 불일치
			
			//로그인 성공시 세션을 생성
			int code = (int)rmap.get("code");
			if(code == 0) { //성공
				//세션객체생성
				HttpSession session= request.getSession(); //sessionid별로 session생성
				//세션에 값 담기
				session.setAttribute("userid", userid);
				session.setAttribute("passwd", passwd);
				//세션의 유효시간(초단위)
				session.setMaxInactiveInterval(60*60*3); //3시간
				
				
				//쿠키에 userid 저장
				//idsave값 읽기
				String idsave = request.getParameter("idsave");
				System.out.println("idsave"+idsave);
				Cookie useridCookie = new Cookie("userid", userid);
				//useridCookie.setMaxAge(10); //10초 (0이면 삭제)
				if (idsave==null) { //기억하지 않기
					useridCookie.setMaxAge(0); //cookie삭제
				}
				response.addCookie(useridCookie); //response객체에 담기(클라이언트에 저장)
				
				//메인으로 이동
				response.sendRedirect(path+"/main.jsp");
			}else {
				//로그인 실패 시 로그인 이동(Controller=>view이동/post방식과 상관없음)
				String msg = (String)rmap.get("msg");
				response.sendRedirect(path+"/login.jsp?msg="+URLEncoder.encode(msg, "utf-8"));
			}
			
		}else if(uri.contains("logout")) {
			//로그아웃
			HttpSession session = request.getSession();
			session.invalidate(); //모든 색션변수 삭제
			response.sendRedirect(path+"/login.jsp?msg="+URLEncoder.encode("로그아웃 완료", "utf-8"));
		}else if(uri.contains("info")) {
			//회원정보 조회(한건 조회)
			//세션에서 userid정보 얻기
			HttpSession session = request.getSession();
			String userid = (String)session.getAttribute("userid");
			System.out.println(userid);
			Member member = memberservice.selectOne(userid);
			//System.out.println(member);
			//forward 이동
			request.setAttribute("member", member); //requestScope에 넣겠다(일회성)
			request.getRequestDispatcher("/member/info.jsp").forward(request, response);
		}else if(uri.contains("list")) {
			//조회정보
			String findkey = request.getParameter("findkey");
			String findvalue = request.getParameter("findvalue");
			//검색조건이 없을 때(null일 경우) 처리
			if (findkey==null) findkey="userid";
			if (findvalue==null) findvalue="";
			
//			String findkey = "addrload";
//			String findvalue = "";
			Map<String,String> findmap = new HashMap<>();
			findmap.put("findkey", findkey);
			findmap.put("findvalue", findvalue);
			
//			HttpSession session = request.getSession(); //계속 가져가야 하는 userid가져올 필요 없음
//			List<Member> mlist = (List<Member>)session.getAttribute("mlist");		
			List<Member> mlist = memberservice.selectList(findmap);
			//System.out.println(mlist);
			//forward 이동
			request.setAttribute("mlist", mlist); //requestScope에 넣겠다
			request.getRequestDispatcher("/member/list.jsp").forward(request, response);
		}else if(uri.contains("modiform")) {
			//수정폼으로 이동
			String userid= request.getParameter("userid");
			System.out.println(userid);
			//한건 조회 가져오기
			Member member = memberservice.selectOne(userid);
			//forward이동
			request.setAttribute("member", member);
			request.getRequestDispatcher("/member/modify.jsp").forward(request, response);
		}else if(uri.contains("modify")) {
			//수정
			String saveDirectory = getServletContext().getInitParameter("savedir");
			
			
			//size: 업로드파일 사이즈 제한
			//1024byte -> 1kbyte
			//1024kbyte -> 1mbite
			int size = 1024*1024*10; //10mbyte
			//DefaultFileRenamePolicy(): 같은 이름의 파일이 있을 때 파일이름 변경
			//cos라이브러리에 있음
			MultipartRequest multi = new MultipartRequest(request, saveDirectory, size, "utf-8",
					new DefaultFileRenamePolicy());
			
			//MultipartRequest객체의 메소드를 이용해서 데이터 얻기
			String userid = multi.getParameter("userid");
			String passwd = multi.getParameter("passwd");
			String zipcode = multi.getParameter("zipcode");
			String addrload = multi.getParameter("addrload");
			String addrdetail = multi.getParameter("addrdetail");
			//실제 저장된 파일이름
			String sysfilename = multi.getFilesystemName("photo");
			System.out.println("실제 올라간 파일 이름:"+ sysfilename);
			String filename=null;
			if(sysfilename==null) //파일을 변경하지 않았을 경우
					filename = multi.getFilesystemName("filename");
			else
				filename = sysfilename;
			//Member객체생성
			Member member = new Member();
			member.setUserid(userid);
			member.setPasswd(passwd);
			member.setZipcode(zipcode);
			member.setAddrload(addrload);
			member.setAddrdetail(addrdetail);
			member.setFilename(filename);
			System.out.println(member);
			String msg = memberservice.update(member);
			System.out.println(msg);
			//redirect 개인정보 이동 //url바뀌는 거니까 contextpath부터 작성
			response.sendRedirect(path + "/info.member?userid="+userid);
			
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
