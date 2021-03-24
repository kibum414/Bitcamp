package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdditionServlet
 */

// URL 맵핑
// Servlet은 상속받는 게 정해져 있음
// HttpServlet 안에는 Request, Response 두 객체가 들어 있음

@WebServlet("/AdditionServlet01")
public class AdditionServlet01 extends HttpServlet {
	// 클래스를 구별하기 위한 ID 번호 (Servlet ID)
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	// 생성자
    public AdditionServlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    // Get 방식 : 주소 창을 통해서 값을 넘겨줄 때 사용
    // Post 방식 : 변수를 정해서 값을 넘겨줄 때 사용
    
    // HttpServlet 클래스 내에
    // HttpServletRequest, HttpServletResponse 가 정의되어 있음
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = 20;
		int num2 = 10;
		int add = num1 + num2;
		
		PrintWriter out = response.getWriter();
		
		// HTML Language
		out.println("<html><head><title>Addition</title></head>");
		out.println("<body>");
		out.println(num1 + " + " + num2 + " = " + add);
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
