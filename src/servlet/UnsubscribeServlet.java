package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.SessionHelper;
import model.User;
import service.UserService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Unsubscribe")
public class UnsubscribeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnsubscribeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (SessionHelper.sessionCheck(request, response)) {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/checkUnsubscribe.jsp");
		dispatcher.forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		int userID = (int)session.getAttribute("userID");

		User user = new User();
		user.setId(userID);

		//DBから授業の削除
		UserService userService = new UserService();
		userService.Unsubscribe(user);
		//セッションの削除
		SessionHelper.destroyUserSession(request);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/finishUnsubscribe.jsp");
		dispatcher.forward(request, response);


		}

}
