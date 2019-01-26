package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import form.AccountSearchInfoForm;
import model.User;
import service.UserService;

/**
 * Servlet implementation class AccountSearchInfo
 */
@WebServlet("/AccountSearchInfo")
public class AccountSearchInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountSearchInfoServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/AccountSearchInfo.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		// jspからformの内容を取り出して,LoginFormを作成.
		String nickname = request.getParameter("nickname");
		String graduate = request.getParameter("graduate");
		System.out.println("AccountSearchInfoServlet.doPost:graduate="+graduate);
		String department = request.getParameter("department");
		String occupation_id_String = request.getParameter("occupation");
		String sex_id_String = request.getParameter("sex");
		String freespace = request.getParameter("freespace");
		String display_id_String = request.getParameter("display");
		if(sex_id_String != null){
		switch (sex_id_String) {
		case "human":
			sex_id_String = "";
			break;
		case "man":
			sex_id_String = "1";
			break;
		case "woman":
			sex_id_String = "2";
			break;
		default:
			break;
		}
		}
		AccountSearchInfoForm form = new AccountSearchInfoForm(nickname, department, freespace, graduate,
				occupation_id_String, sex_id_String, display_id_String);

		// Formにエラー個所がなければ、不正な値はなかったものとして処理.
		if (form.getError().isEmpty()) {
			UserService service = new UserService();
			ArrayList<User> users = new ArrayList<>();
			try {
				users = service.accountSearchInfo(request, form);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (form.getError().isEmpty()) {
				request.setAttribute("users", users);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/WEB-INF/AccountSearchResult.jsp");
				dispatcher.forward(request, response);

			} else {
				for (String error : form.getError()) {
					System.out.println("e2"+error);
				}
				request.setAttribute("form", form.getError());
				doGet(request, response);
			}
		} else {
			System.out.println(form.getError().size());
			for (String error : form.getError()) {
				System.out.println("e1"+error);
			}
			request.setAttribute("form", form.getError());
			doGet(request, response);
		}
	}

}
