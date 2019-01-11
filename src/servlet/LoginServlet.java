package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import form.LoginForm;
import service.UserService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		// jspからformの内容を取り出して,LoginFormを作成.

		if (request.getParameter("goto").equals("こちら")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userRegistration.jsp");
			dispatcher.forward(request, response);
		} else {
			String mailAddress = request.getParameter("mailAddress");
			String password = request.getParameter("password");
			LoginForm form = new LoginForm(mailAddress, password);

			// Formにエラー個所がなければ、不正な値はなかったものとして処理.
			if (form.getError().isEmpty()) {
				UserService service = new UserService();
				try {
					service.LoginUser(request, form);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				if (form.getError().isEmpty()) {
					response.sendRedirect("/SE18G2/Top");
				} else {
					request.setAttribute("form", form);
					doGet(request, response);
				}
			} else {
				request.setAttribute("form", form);
				doGet(request, response);
			}

		}
	}

}
