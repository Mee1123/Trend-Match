package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import form.UpdateAccountInfoForm;
import model.User;
import service.UserService;;

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
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int userId = user.getUserId();
		UserService userService = new UserService();
		//User user = new User();
		//アカウント情報を取りに行く
		user = userService.getMyAccountInfo(userId);
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
		String department = request.getParameter("department");
		int occupationId = Integer.parseInt(request.getParameter("occupationId"));
		int sexId = Integer.parseInt(request.getParameter("sexId"));
		String contact = request.getParameter("contact");
		String freeSpace = request.getParameter("freeSpace");
		int jobOfferId = Integer.parseInt(request.getParameter("jobOfferId"));
		int valueId1 = Integer.parseInt(request.getParameter("valueId1"));
		int valueId2 = Integer.parseInt(request.getParameter("valueId2"));
		int valueId3 = Integer.parseInt(request.getParameter("valueId3"));

		//String mailaddress = request.getParameter("mailaddress");
		//String password = request.getParameter("password");
		//String name = request.getParameter("name");
		//User user = new User();
		//user.setMailAddress(mailaddress);
		//user.setPassword(password);
		//user.setName(name);

		UpdateAccountInfoForm form = new UpdateAccountInfoForm(nickName,picturePath,department,occupationId,sexId,contact,freeSpace,
				jobOfferId,valueId1,valueId2,valueId3);

		//Formにエラー個所がなければ、不正な値はなかったものとして処理.
		if (form.getError().isEmpty()) {
			UserService userService = new UserService();
			try {
				userService.updateAccountInfo(request,form);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (form.getError().isEmpty()) {
				System.out.println("Servlet,2,success");
				//response.sendRedirect("/SE18G2/Top");
				response.sendRedirect("/WEB-INF/jsp/account/updateFinished.jsp");//登録完了画面へ移行させる
			} else {
				request.setAttribute("form", form);
				doGet(request, response);
			}
		}
	}

}