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
		/**/

		String eg1 = request.getParameter("enneagram1");
		String eg2 = request.getParameter("enneagram2");
		String eg3 = request.getParameter("enneagram3");
		String eg4 = request.getParameter("enneagram4");
		String eg5 = request.getParameter("enneagram5");
		String eg6 = request.getParameter("enneagram6");
		String eg7 = request.getParameter("enneagram7");
		String eg8 = request.getParameter("enneagram8");
		String eg9 = request.getParameter("enneagram9");

		if(eg1==""){
			System.out.println("未入力");
			eg1="0";
		}else if(eg2==""){
			eg2="0";
		}else if(eg3==""){
			eg3="0";
		}else if(eg4==""){
			eg4="0";
		}else if(eg5==""){
			eg5="0";
		}else if(eg6==""){
			eg6="0";
		}else if(eg7==""){
			eg7="0";
		}else if(eg8==""){
			eg8="0";
		}else if(eg9==""){
			eg9="0";
		}


		/*int enneagram1 = Integer.parseInt(eg1);
		int enneagram2 = Integer.parseInt(eg2);
		int enneagram3 = Integer.parseInt(eg3);
		int enneagram4 = Integer.parseInt(eg4);
		int enneagram5 = Integer.parseInt(eg5);
		int enneagram6 = Integer.parseInt(eg6);
		int enneagram7 = Integer.parseInt(eg7);
		int enneagram8 = Integer.parseInt(eg8);
		int enneagram9 = Integer.parseInt(eg9);*/

		enneagramRegistrationForm form = new enneagramRegistrationForm(eg1,eg2,eg3,eg4,eg5,eg6,eg7,eg8,eg9);
		//enneagramRegistrationForm form = new enneagramRegistrationForm(enneagram1,enneagram2,enneagram3,enneagram4,enneagram5,enneagram6,enneagram7,enneagram8,enneagram9);
		System.out.println("formから戻りました");

		System.out.println("enneagramRegistrationServlet.doPost:"+form.getError());

		//Formにエラー個所がなければ、不正な値はなかったものとして処理.
		if(form.getError().isEmpty()){
			HttpSession session = request.getSession();

			int userId = (int) session.getAttribute("userID");
			System.out.println("エニアグラム登録:userId="+userId);

			System.out.println("セッションからID引っ張る");
			System.out.println(userId);

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
				System.out.println("enneagramRegistrationServlet.doPost:"+form.getError());
				request.setAttribute("form", form.getError());
				doGet(request, response);
				}
		}else {
			System.out.println("enneagramRegistrationServlet.doPost:"+form.getError());
			request.setAttribute("form", form.getError());
			doGet(request, response);
		}

	}
	}

}