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
import helper.SessionHelper;
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
		if (SessionHelper.sessionCheck(request, response)) {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userID");
		System.out.println("UpdateAccountInfoServlet[get]:userId="+userId);

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

		request.setAttribute("user", user);
		System.out.println("UpdateAccountInfoServlet[get]:valuesString="+valuesStrings[0]);
		request.setAttribute("value1", valuesStrings[0]);
		request.setAttribute("value2", valuesStrings[1]);
		request.setAttribute("value3", valuesStrings[2]);
		request.setAttribute("values",valueService.getAllValue());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account/update.jsp");
		dispatcher.forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if (SessionHelper.sessionCheck(request, response)) {

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
		System.out.println("UpdateAccountInfoServlet[post]:graduate="+utilGraduate.toString());
		//int graduate = Integer.parseInt(request.getParameter("graduate"));

		String department = request.getParameter("department");
		System.out.println("UpdateAccountInfoServlet[post]:department="+request.getParameter("department"));
		int occupationId = Integer.parseInt(request.getParameter("occupationId"));
		System.out.println("UpdateAccountInfoServlet[post]:occupationId="+request.getParameter("occupationId"));
		int sexId = Integer.parseInt(request.getParameter("sexId"));
		System.out.println("UpdateAccountInfoServlet[post]:sexId="+request.getParameter("sexId"));
		String contact = request.getParameter("contact");
		System.out.println("UpdateAccountInfoServlet[post]:contact="+request.getParameter("contact"));
		String freeSpace = request.getParameter("freeSpace");

		int jobOffer_id = 0;
		String jobOffer = request.getParameter("jobOffer");
		if (jobOffer.equals("内定あり")) {
			jobOffer_id = 1;
		} else {
			jobOffer_id = 0;
		}

		ValueService valueService = new ValueService();
		Value value_results[] =new Value[3];
		value_results[0] = valueService.getAndCreateValueByName(request.getParameter("value1"));
		value_results[1] = valueService.getAndCreateValueByName(request.getParameter("value2"));
		value_results[2]= valueService.getAndCreateValueByName(request.getParameter("value3"));
		//価値観が空白でない場合
		int[] value_id =new int[3];
		for(int i=0;i<3;i++){
			if (value_results[i]!= null) {
				value_id[i] = value_results[i].getId();
			} else {//価値観が空白の場合
				value_id[i] = 0;
			}
		}
		UpdateAccountInfoForm form = new UpdateAccountInfoForm(nickName, picturePath, graduate, department,
				occupationId, sexId,
				contact, freeSpace,
				jobOffer_id, value_id[0], value_id[1], value_id[2]);

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userID");

		System.out.println("UpdateAccountInfoServlet[post]:="+form.getGraduate());
		//Formにエラー個所がなければ、不正な値はなかったものとして処理.
		if (form.getError().isEmpty()) {
			UserService userService = new UserService();
			try {

				userService.updateAccountInfo(form, userId, value_id[0], value_id[1], value_id[2]);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (form.getError().isEmpty()) {
				System.out.println("UpdateAccountInfoServlet[post]:[fromエラーなし]success");
				//response.sendRedirect("/SE18G2/Top");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account/updateFinished.jsp");
				dispatcher.forward(request, response);
			} else {
				System.out.println("UpdateAccountInfoServlet[post]:[formError]");
				for(String error:form.getError())System.out.println(error);
				request.setAttribute("form", form.getError());
				doGet(request, response);
			}
		} else {
			System.out.println("UpdateAccountInfoServlet[post]:[formError]");
			for(String error:form.getError())System.out.println(error);
			request.setAttribute("form", form.getError());
			doGet(request, response);
		}
	}
	}

}