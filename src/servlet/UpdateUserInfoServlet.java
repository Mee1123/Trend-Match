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
import service.UserService;;

/**
 * Servlet implementation class UpdateUserInfoServlet
 */
@WebServlet("/user/update")
public class UpdateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int userId = user.getUserId();
		UserService userService = new UserService();
		//User user = new User();
		user = userService.getMyInfo(userId);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user/update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		request.setCharacterEncoding("UTF-8");
		String mailaddress = request.getParameter("mailaddress");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		//User user = new User();
		//user.setMailAddress(mailaddress);
		//user.setPassword(password);
		//user.setName(name);

		UpdateUserInfoForm form = new UpdateUserInfoForm(mailaddress, password, name);

		//Formにエラー個所がなければ、不正な値はなかったものとして処理.
		if (form.getError().isEmpty()) {
			UserService userService = new UserService();
			try {
				userService.updateUserInfo(request,form);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (form.getError().isEmpty()) {
				System.out.println("Servlet,2,success");
				//response.sendRedirect("/SE18G2/Top");
				response.sendRedirect("/WEB-INF/jsp/user/updateFinished.jsp");//登録完了画面へ移行させる
			} else {
				request.setAttribute("form", form);
				doGet(request, response);
			}
		}
	}

}
