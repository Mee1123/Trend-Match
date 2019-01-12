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
import service.ValueService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/DeleteUserCheck")
public class DeleteUserCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserCheckServlet() {
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
		System.out.println("Serv_userID:"+user.getId());
		request.setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/checkUserDelete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println("Serv_userID");



			String userIdString = request.getParameter("id");
			System.out.println(userIdString);
			//User user = new User();
			//user.setId(Integer.parseInt(userIdString));

			int userId = Integer.valueOf(userIdString);
			//DBから授業の削除
			UserService Service = new UserService();
			User user = Service.accountView(userId);

			ValueService valueService = new ValueService();
			String valuesStrings[]= {"","",""};
			int i=0;
			for(int valueId:user.getValue_id()){
				valuesStrings[i]= valueService.getValueName(valueId).getValue();
				i++;
			}

			request.setAttribute("user", user);
			System.out.println(valuesStrings[0]);
			request.setAttribute("value1", valuesStrings[0]);
			request.setAttribute("value2", valuesStrings[1]);
			request.setAttribute("value3", valuesStrings[2]);

			Service.DeleteUser(user);


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/finishUserDelete.jsp");
			dispatcher.forward(request, response);
	/*		if(request.getParameter("submit").equals("はい")){
		}else if(request.getParameter("submit").equals("いいえ")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/AccountView.jsp");
			dispatcher.forward(request, response);
		}

*/


		}

}
