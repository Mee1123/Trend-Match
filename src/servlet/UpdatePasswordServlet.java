package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import form.UpdateUserInfoForm;
import model.User;
import service.UserService;

/**
 * Servlet implementation class UpdateUserInfoServlet
 */
@WebServlet("/user/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePasswordServlet() {
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
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userID");

		UserService userService = new UserService();
		User user = new User();
		user = userService.getMyInfo(userId);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user/updatePassword.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String mailaddress = request.getParameter("mailaddress");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userID");

		UpdateUserInfoForm form = new UpdateUserInfoForm(name, mailaddress, password, password2);

		//Formにエラー個所がなければ、不正な値はなかったものとして処理.
		if (form.getError().isEmpty()) {
			System.out.println("エラーなし");
			UserService userService = new UserService();
			try {
				//userService.updateUserInfo(request,form);
				userService.updateUserInfo(form,userId);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (form.getError().isEmpty()) {
				System.out.println("Servlet,2,success");
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append("Served at: ").append(request.getContextPath());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user/updateFinished.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setCharacterEncoding("UTF-8");
				request.setAttribute("form", form);
				doGet(request, response);
			}
		}else {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			request.setAttribute("form", form);
			doGet(request, response);
		}
	}

}
