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
		HttpSession session = request.getSession();
		int sessionId=1;
		int userId ;
		if(userIdString != null){
			userId = Integer.valueOf(userIdString);
			sessionId =2;
		}
		else {
			userId =  (int) session.getAttribute("userID");
		}
		UserService service = new UserService();
		User user = service.accountView(userId);
		//このif文なんだ？推定:存在しないユーザーの時？
		if (user.getId()==0) {
			userId =  (int) session.getAttribute("userID");
			sessionId = 1;
			user = service.accountView(userId);
		}
		if (1 == (int)session.getAttribute("userID")) {
			sessionId =0;
		}
		//価値観はない場合、NUllの代わりに空白を入れたい
		ValueService valueService = new ValueService();
		String valuesStrings[]= {"","",""};
		int i=0;
		for(int valueId:user.getValue_id()){
			valuesStrings[i]= valueService.getValueName(valueId).getValue();
			i++;
		}

		System.out.println("AccountViewServlet:user_id="+user.getId());
		request.setAttribute("user", user);
		System.out.println(valuesStrings[0]);
		request.setAttribute("session",sessionId );
		request.setAttribute("value1", valuesStrings[0]);
		request.setAttribute("value2", valuesStrings[1]);
		request.setAttribute("value3", valuesStrings[2]);
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
