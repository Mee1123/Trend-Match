package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import form.checkUserRegistrationForm;
import service.UserService;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/checkUserRegistration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/checkUserRegistration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//jspからformの内容を取り出して,LoginFormを作成.
		String userName = request.getParameter("Name");
		String mailAddress = request.getParameter("MailAddress");
		String password =request.getParameter("Password");
		System.out.println(userName);
		checkUserRegistrationForm form = new checkUserRegistrationForm(userName,mailAddress,password);

		//Formにエラー個所がなければ、不正な値はなかったものとして処理.
		if(form.getError().isEmpty()){
			System.out.println("エラーなし");
			UserService service = new UserService();
			//System.out.println("新しいサービスを生成しました");
			try {
				service.RegistrationUser(request,form);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("エラーあり");
			}
			if (form.getError().isEmpty()) {
				System.out.println("完了画面に遷移します");

				//ここの書き方が分からない
				//response.sendRedirect("/WEB-INF/finishUserRegistration.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/finishUserRegistration.jsp");
				dispatcher.forward(request, response);

			}
			else {
				request.setAttribute("form", form);
				doGet(request, response);
				}
		}else {
			request.setAttribute("form", form);
			doGet(request, response);
		}

		}

}