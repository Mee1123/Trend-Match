package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.table.ValuesDAO;
import form.accountRegistrationForm;
import model.Value;
import service.UserService;
import service.ValueService;;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/checkAccountRegistration")
@MultipartConfig(maxFileSize = 2147483647)
public class accountRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public accountRegistrationServlet() {
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

		// 遷移元
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/checkAccountRegistration.jsp");
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
		// jspからformの内容を取り出し
		System.out.println("ServletのdoPost");
		if (request.getParameter("goto").equals("いいえ")) {

			ArrayList<Value> values = new ArrayList<Value>();
			ValuesDAO valuesDAO = new ValuesDAO();
			values = valuesDAO.selectValueAll();
			request.setAttribute("values", values);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/accountRegistration.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("goto").equals("はい")) {
			int jobOffer_id = 0;
			int occupation_id = 0;
			int sex_id = 0;

			// 内定情報
			String jobOffer = request.getParameter("jobOffer");
			System.out.println(jobOffer);
			if (jobOffer.equals("内定あり")) {
				jobOffer_id = 1;
			} else {
				jobOffer_id = 0;
			}

			// ニックネーム
			String nickname = request.getParameter("nickname");
			System.out.println(nickname);

			// 卒業年度
			int graduate = Integer.parseInt(request.getParameter("graduate"));
			System.out.println(graduate);

			// 所属
			String department = request.getParameter("department");
			System.out.println(department);

			// 職種
			String occupation = request.getParameter("occupation");
			System.out.println(occupation);
			if (occupation.equals("学部生")) {
				occupation_id = 1;
			} else if (occupation.equals("大学院生")) {
				occupation_id = 2;
			} else if (occupation.equals("農業・水産")) {
				occupation_id = 3;
			} else if (occupation.equals("林業")) {
				occupation_id = 4;
			} else if (occupation.equals("漁業")) {
				occupation_id = 5;
			} else if (occupation.equals("鉱業")) {
				occupation_id = 6;
			} else if (occupation.equals("建設業")) {
				occupation_id = 7;
			} else if (occupation.equals("製造業")) {
				occupation_id = 8;
			} else if (occupation.equals("電気・ガス")) {
				occupation_id = 9;
			} else if (occupation.equals("運輸・通信業")) {
				occupation_id = 10;
			} else if (occupation.equals("卸売・小売・飲食業")) {
				occupation_id = 11;
			} else if (occupation.equals("金融・保険業")) {
				occupation_id = 12;
			} else if (occupation.equals("不動産業")) {
				occupation_id = 13;
			} else if (occupation.equals("サービス業")) {
				occupation_id = 14;
			} else {
				occupation_id = 15;
			}

			// 性別
			String sex = request.getParameter("sex");
			System.out.println(sex);
			if (sex.equals("男")) {
				sex_id = 1;
			} else if (sex.equals("女")) {
				sex_id = 2;
			} else {
				sex_id = 0;
			}

			// 連絡先
			String contact = request.getParameter("contact");
			System.out.println(contact);

			// フリースペース
			String freeSpace = request.getParameter("freespace");
			System.out.println(freeSpace);

			// 価値観
			String value1 = request.getParameter("value1");
			String value2 = request.getParameter("value2");
			String value3 = request.getParameter("value3");
			System.out.println(value1);
			System.out.println(value2);
			System.out.println(value3);

			// 価値観のID化
			// まずはサービス
			ValueService valueService = new ValueService();
			Value value1_result = valueService.getValueID(value1);
			Value value2_result = valueService.getValueID(value2);
			Value value3_result = valueService.getValueID(value3);
			int value1_id = value1_result.getId();
			int value2_id = value2_result.getId();
			int value3_id = value3_result.getId();
			System.out.println(value1_id);
			System.out.println(value2_id);
			System.out.println(value3_id);

			accountRegistrationForm form = new accountRegistrationForm(jobOffer_id, nickname, graduate, department,
					occupation_id, sex_id, contact, freeSpace, value1_id, value2_id, value3_id);
			System.out.println("formから戻りました");

			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("userID");

			// int userId = 28;

			UserService userService = new UserService();
			System.out.println("サービスの生成");
			userService.RegistrationAccount(request, form, userId);

			// Formにエラー個所がなければ、不正な値はなかったものとして処理.
			if (form.getError().isEmpty()) {
				UserService service = new UserService();
				try {
					service.RegistrationAccount(request, form, userId);

					// プロフィール画像
					/*
					 * try { Part part = request.getPart("picturepath"); if(part
					 * != null){ //User user = (User)
					 * session.getAttribute("user"); //int userId =
					 * user.getUserId(); System.out.println("ファイルを受け付けます");
					 * String name = (String) session.getAttribute("userID");
					 * part.write(getServletContext().getRealPath(
					 * "/WEB-INF/uploaded") + "/" + name); } } catch
					 * (ArithmeticException e) {
					 * System.out.println("例外が発生しました。"); System.out.println(e);
					 * form.setError("ファイルが不適切です"); }
					 */
					// 遷移先
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/WEB-INF/finishAccountRegistration.jsp");
					dispatcher.forward(request, response);

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			} else {
				request.setAttribute("form", form);
				doGet(request, response);
			}

		}
	}

}