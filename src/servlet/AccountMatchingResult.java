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
import model.User;
import service.UserService;

/**
 * Servlet implementation class AccountMatchingResult
 */
@WebServlet("/AccountMatchingResult")
public class AccountMatchingResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountMatchingResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		int userId =  (int) session.getAttribute("userID");
		UserService userService =new UserService();
		ArrayList<SimilarityUserForm> users = userService.matching(userId);
		ArrayList<User> users2 = new ArrayList<>();
		//user並べ替え
		users.sort((a,b)-> a.getSimilarityInt() - b.getSimilarityInt());
		for(SimilarityUserForm user:users){
			users2.add(userService.accountView(user.getId()));
		}
		System.out.println("サーブレット:"+users2.size());
		request.setAttribute("users", users2);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/AccountMatchingResult.jsp");
		dispatcher.forward(request, response);
	}

}
