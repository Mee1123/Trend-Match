package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import form.SimilarityUserForm;
import helper.SessionHelper;
import model.User;
import service.UserService;

/**
 * Servlet implementation class Top
 */
@WebServlet("/Top")
public class Top extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Top() {
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
		if (SessionHelper.sessionCheck(request, response)) {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			HttpSession session = request.getSession();
			Object userSession = session.getAttribute("userID");

			int userId = (int) userSession;
			// 管理者か
			if (userId == 1) {
				System.out.println("Top:管理者ユーザー");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/TopForAdmin.jsp");
				dispatcher.forward(request, response);
			}
			// idサーチ
			UserService userService = new UserService();
			User user = userService.accountView(userId);
			// アカウントなし
			if (user.getNickname() == null) {
				System.out.println("Top:アカウントなしユーザー");
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/TopForNoAccount.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/startAccountRegistration.jsp");
				dispatcher.forward(request, response);
			} // アカウントあり
			else {
				ArrayList<SimilarityUserForm> users = userService.matching(userId);
				ArrayList<User> users2 = new ArrayList<>();
				// user並べ替え
				users.sort((a, b) -> a.getSimilarityInt() - b.getSimilarityInt());
				for (SimilarityUserForm similarityuser : users) {
					users2.add(userService.accountView(similarityuser.getId()));
				}
				System.out.println("Top:アカウントありユーザー");
				request.setAttribute("users", users2);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Top.jsp");
				dispatcher.forward(request, response);

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (SessionHelper.sessionCheck(request, response)) {
		doGet(request, response);
	}
	}

}
