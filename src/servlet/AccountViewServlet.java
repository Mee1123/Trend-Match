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

import model.User;
import service.UserService;
import service.ValueService;

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
		if (user.getId()==0) {
			HttpSession session = request.getSession();
			userId =  (int) session.getAttribute("userID");
			request.setAttribute("session", 1);
			user = service.accountView(userId);
		}
		ValueService valueService = new ValueService();
		ArrayList<String> values = new ArrayList<>();
		for(int value_id:user.getValue_id()) {
		values.add(valueService.getValueName(value_id).getValue())	;
		}
		String valueStrings[]= {"","",""};
		if(values.size()<1) {
			valueStrings[0] = values.get(0);
		}if(values.size()<2) {
			valueStrings[1] = values.get(1);
		}if(values.size()<3) {
			valueStrings[2] = values.get(2);
		}

		System.out.println("Serv_userID:"+user.getId());
		request.setAttribute("user", user);
		System.out.println(valueStrings[0]);
		request.setAttribute("Value1", valueStrings[0]);
		request.setAttribute("Value2", valueStrings[1]);
		request.setAttribute("Value3", valueStrings[2]);
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
