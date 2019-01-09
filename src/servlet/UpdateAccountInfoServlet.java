package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import form.UpdateAccountInfoForm;
import model.User;
import service.UserService;

/**
 * Servlet implementation class UpdateAccountInfoServlet
 */
@WebServlet("/account/update")
public class UpdateAccountInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateAccountInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("UTF-8");
		/*HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int userId = user.getUserId();*/

		UserService userService = new UserService();
		User user = new User();
		//アカウント情報を取りに行く
		user = userService.getMyAccountInfo(1);
		System.out.println(user.getName());
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account/update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		request.setCharacterEncoding("UTF-8");
		String nickName = request.getParameter("nickName");
		String picturePath = request.getParameter("picturePath");
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilGraduate = null;
		try {
			utilGraduate = (java.util.Date) sdFormat.parse(request.getParameter("graduate"));
		} catch (ParseException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		// java.util.Dateからjava.sql.Dateに変換する。
        java.sql.Date graduate = new java.sql.Date(utilGraduate.getTime());
        System.out.println(utilGraduate.toString());

		String department = request.getParameter("department");
		System.out.println(request.getParameter("department"));
		int occupationId = Integer.parseInt(request.getParameter("occupationId"));
		System.out.println(request.getParameter("occupationId"));
		int sexId = Integer.parseInt(request.getParameter("sexId"));
		System.out.println(request.getParameter("sexId"));
		String contact = request.getParameter("contact");
		System.out.println(request.getParameter("contact"));
		String freeSpace = request.getParameter("freeSpace");
		int jobOfferId = Integer.parseInt(request.getParameter("jobOfferId"));
		int valueId1 = Integer.parseInt(request.getParameter("valueId1"));
		int valueId2 = Integer.parseInt(request.getParameter("valueId2"));
		int valueId3 = Integer.parseInt(request.getParameter("valueId3"));
		//HttpSession session = request.getSession();
		//User user = (User) session.getAttribute("user");
		//int userId = user.getUserId();
		//今sessionないから

		UpdateAccountInfoForm form = new UpdateAccountInfoForm(nickName, picturePath, graduate, department, occupationId, sexId,
				contact, freeSpace,
				jobOfferId, valueId1, valueId2, valueId3);

		System.out.println(form.getJobOfferId());
		//Formにエラー個所がなければ、不正な値はなかったものとして処理.
		if (form.getError().isEmpty()) {
			UserService userService = new UserService();
			try {

				userService.updateAccountInfo(form, 1);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (form.getError().isEmpty()) {
				System.out.println("Servlet,2,success");
				//response.sendRedirect("/SE18G2/Top");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account/updateFinished.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("form", form);
				doGet(request, response);
			}
		}else {
			request.setAttribute("form", form);
			doGet(request, response);
		}
	}

}