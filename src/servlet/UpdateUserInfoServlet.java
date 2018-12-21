package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("UTF-8");
		String userId = session.getAttribute("userId");
		UserService userService = new UserService();
		User user = new User();
		user = userService.getMyInfo(Integer.parseInt(userId));
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user/update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String mailaddress = request.getParameter("mailaddress");
		String password = request.getParameter("password");
		User user = new User();
		user.setUserName(userName);
		user.setMailaddress(mailaddress);
		user.setPassword(password);
		UserService userService = new UserService();
		userService.updateUserInfo(user);
		response.sendRedirect("");//登録完了画面へ移行させる
	}

}
