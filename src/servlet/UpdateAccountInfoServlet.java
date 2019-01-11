package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import form.UpdateAccountInfoForm;
import model.User;
import model.Value;
import service.UserService;
import service.ValueService;

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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userID");
		System.out.println(userId);

		UserService userService = new UserService();
		User user = new User();
		//アカウント情報を取りに行く
		user = userService.getMyAccountInfo(userId);

		ValueService valueService = new ValueService();
		String valuesStrings[] = { "", "", "" };
		int i = 0;
		for (int valueId : user.getValue_id()) {
			valuesStrings[i] = valueService.getValueName(valueId).getValue();
			i++;
		}

		System.out.println("AccountViewServlet:user_id=" + user.getId());
		request.setAttribute("user", user);
		System.out.println(valuesStrings[0]);
		request.setAttribute("value1", valuesStrings[0]);
		request.setAttribute("value2", valuesStrings[1]);
		request.setAttribute("value3", valuesStrings[2]);
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
		Date graduate = new java.sql.Date(utilGraduate.getTime());
		System.out.println(utilGraduate.toString());
		//int graduate = Integer.parseInt(request.getParameter("graduate"));

		String department = request.getParameter("department");
		System.out.println(request.getParameter("department"));
		int occupationId = Integer.parseInt(request.getParameter("occupationId"));
		System.out.println(request.getParameter("occupationId"));
		int sexId = Integer.parseInt(request.getParameter("sexId"));
		System.out.println(request.getParameter("sexId"));
		String contact = request.getParameter("contact");
		System.out.println(request.getParameter("contact"));
		String freeSpace = request.getParameter("freeSpace");

		int jobOffer_id = 0;
		String jobOffer = request.getParameter("jobOffer");
		if (jobOffer.equals("内定あり")) {
			jobOffer_id = 1;
		} else {
			jobOffer_id = 0;
		}

		ValueService valueService = new ValueService();
		Value value1_result = valueService.getValueID(request.getParameter("value1"));
		Value value2_result = valueService.getValueID(request.getParameter("value2"));
		Value value3_result = valueService.getValueID(request.getParameter("value3"));
		int value1_id = value1_result.getId();
		int value2_id = value2_result.getId();
		int value3_id = value3_result.getId();

		UpdateAccountInfoForm form = new UpdateAccountInfoForm(nickName, picturePath, graduate, department,
				occupationId, sexId,
				contact, freeSpace,
				jobOffer_id, value1_id, value2_id, value3_id);

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userID");

		System.out.println(form.getJoboffer_id());
		//Formにエラー個所がなければ、不正な値はなかったものとして処理.
		if (form.getError().isEmpty()) {
			UserService userService = new UserService();
			try {

				userService.updateAccountInfo(form, userId, value1_id, value2_id, value3_id);

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
		} else {
			request.setAttribute("form", form);
			doGet(request, response);
		}
	}

}