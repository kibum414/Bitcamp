package unit05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 보낼 땐 response를 사용하여 UTF-8로 보냄
		response.setContentType("text/html; charset=UTF-8");
		
		// 받을 땐 request를 사용함
		// 값이 없거나 age가 숫자가 아닐 때 예외 처리 발생 -> 유효성 검사 필요(javascript 이용)
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.println("당신이 입력한 정보입니다.<br>");
		out.println("아이디 : ");
		out.println(id);
		out.println("<br> 나이 : ");
		out.println(age);
		
		// 자바 스크립트로 이전 페이지로 이동하는 링크를 만들어 줌
		// -1 : 바로 전 페이지로 돌아감
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		out.print("</body></html>");
		
		out.close();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
