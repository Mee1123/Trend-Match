package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import form.userRegistrationForm;
import service.UserService;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/userRegistration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userRegistration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//jspからformの内容を取り出して,LoginFormを作成.
		String userName = request.getParameter("userName");
		String mailAddress = request.getParameter("mailAddress");
		String password =request.getParameter("password");
		String password2 =request.getParameter("password2");
		userRegistrationForm form = new userRegistrationForm(userName,mailAddress,password,password2);

		//Formにエラー個所がなければ、不正な値はなかったものとして処理.
		if(form.getError().isEmpty()){
			UserService service = new UserService();
			try {
				service.RegistrationUser(request,form);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (form.getError().isEmpty()) {
				response.sendRedirect("/WEB-INF/checkUserRegistration");
			}
			else {
				request.setAttribute("form", form);
				doGet(request, response);
				}
		}else {
			request.setAttribute("form", form);
			doGet(request, response);
		}

		}

}