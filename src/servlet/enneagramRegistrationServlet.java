package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import form.enneagramRegistrationForm;
import helper.SessionHelper;
import service.UserService;;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/enneagramRegistration")
public class enneagramRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public enneagramRegistrationServlet() {
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



		//遷移元
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/enneagramRegistration.jsp");
		dispatcher.forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (SessionHelper.sessionCheck(request, response)) {
		request.setCharacterEncoding("UTF-8");
		//jspからformの内容を取り出し
		int eg1 = Integer.parseInt(request.getParameter("enneagram1"));
		int eg2 = Integer.parseInt(request.getParameter("enneagram2"));
		int eg3 = Integer.parseInt(request.getParameter("enneagram3"));
		int eg4 = Integer.parseInt(request.getParameter("enneagram4"));
		int eg5 = Integer.parseInt(request.getParameter("enneagram5"));
		int eg6 = Integer.parseInt(request.getParameter("enneagram6"));
		int eg7 = Integer.parseInt(request.getParameter("enneagram7"));
		int eg8 = Integer.parseInt(request.getParameter("enneagram8"));
		int eg9 = Integer.parseInt(request.getParameter("enneagram9"));

		enneagramRegistrationForm form = new enneagramRegistrationForm(eg1,eg2,eg3,eg4,eg5,eg6,eg7,eg8,eg9);
		System.out.println("formから戻りました");

		HttpSession session = request.getSession();

		int userId = (int) session.getAttribute("userID");
		System.out.println("エニアグラム登録:userId="+userId);

		System.out.println("セッションからID引っ張る");
		System.out.println(userId);

		//Formにエラー個所がなければ、不正な値はなかったものとして処理.
		if(form.getError().isEmpty()){
			UserService service = new UserService();
			try {
				service.RegistrationEnneagram(request,form, userId);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (form.getError().isEmpty()) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/unfinishedAccountRegistration.jsp");
				dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("form", form.getError());
				doGet(request, response);
				}
		}else {
			request.setAttribute("form", form.getError());
			doGet(request, response);
		}

	}
	}

}