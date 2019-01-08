package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserService;

/**
 * Servlet implementation class AccountView
 */
@WebServlet("/AccountView")
public class AccountViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String userIdString = request.getParameter("userId");
		System.out.println(userIdString);
		int userId ;
		if(userIdString != null){
			userId = Integer.valueOf(userIdString);
			request.setAttribute("session",2 );
		}
		else {
			HttpSession session = request.getSession();
			userId =  (int) session.getAttribute("userID");
			request.setAttribute("session", 1);
		}
		UserService service = new UserService();
		User user = service.accountView(userId);
		if (user.getID()==0) {
			HttpSession session = request.getSession();
			userId =  (int) session.getAttribute("userID");
			request.setAttribute("session", 1);
			user = service.accountView(userId);
		}
		System.out.println("Serv_userID:"+user.getID());
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/AccountView.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
