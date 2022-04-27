package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/file/*")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = request.getContextPath();
		if(uri.contains("download")) {
			//파일 다운로드
			String filename = request.getParameter("filename");
			System.out.println("다운로드할 파일이름:"+filename);
			String savedir= getServletContext().getInitParameter("savedir");
			String fileurl = savedir + "/"+filename;
			System.out.println(fileurl);
			//마임타입:파일의 종류
			String mimeType = getServletContext().getMimeType(filename);
			System.out.println(mimeType);
			if(mimeType == null)
				mimeType = "application/octet-stream;charset=utf-8";
			response.setContentType(mimeType);
			
			//첨부파일로 보내기
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
			
			//서버의 파일을 읽어서 전송
			//파일입력스트림 생성
			FileInputStream fis= new FileInputStream(fileurl);
			//응답 출력스트림 얻기
			ServletOutputStream out = response.getOutputStream();
			
			//반복문을 이용해서 파일 읽어서 전송
			byte[] b = new byte[4096]; //파일읽어서 저장할 배열
			int numRead=0;
			while((numRead = fis.read(b, 0, b.length)) != -1) { //읽어들일 바이트가 -1이면 종료
				out.write(b, 0, numRead);
			}
			out.flush(); //내보내기(버퍼비우기)
			out.close();
			fis.close();
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
