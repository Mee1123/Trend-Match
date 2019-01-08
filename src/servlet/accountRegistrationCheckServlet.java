package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import form.accountRegistrationCheckForm;
import service.UserService;;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/accountRegistration")
@MultipartConfig(maxFileSize=2147483647)
public class accountRegistrationCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public accountRegistrationCheckServlet() {
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

		//遷移元
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/accountRegistration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//jspからformの内容を取り出し
		System.out.println("ServletのdoPost");


		//内定情報
		int jobOffer = Integer.parseInt(request.getParameter("jobOffer"));
		System.out.println(jobOffer);

		//ニックネーム
		String nickname = request.getParameter("nickname");
		System.out.println(nickname);

		//卒業年度
		int graduate = Integer.parseInt(request.getParameter("graduate"));
		System.out.println(graduate);

		//所属
		String department = request.getParameter("department");
		System.out.println(department);

		//職種
		int occupation = Integer.parseInt(request.getParameter("occupation"));
		System.out.println(occupation);

		//性別
		int sex = Integer.parseInt(request.getParameter("sex"));
		System.out.println(sex);

		//連絡先
		String contact = request.getParameter("contact");
		System.out.println(contact);

		//フリースペース
		String freeSpace = request.getParameter("freespace");
		System.out.println(freeSpace);

		String value1 = request.getParameter("value1");
		String value2 = request.getParameter("value2");
		String value3 = request.getParameter("value3");
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);

		accountRegistrationCheckForm form = new accountRegistrationCheckForm(jobOffer,nickname,graduate,department,occupation,sex,contact,freeSpace,value1,value2,value3);

		//プロフィール画像
		try {
			Part part = request.getPart("picturepath");
			if(part != null){
				HttpSession session = request.getSession();
				//User user = (User) session.getAttribute("user");
				//int userId = user.getUserId();
				System.out.println("ファイルを受け付けます");
				String name = (String) session.getAttribute("id");
				part.write(getServletContext().getRealPath("/WEB-INF/uploaded") + "/" + name);
				}
			}
			catch (ArithmeticException e) {
				System.out.println("例外が発生しました。");
				System.out.println(e);
				form.setError("ファイルが不適切です");
			}


		//HttpSession session = request.getSession();
		//User user = (User) session.getAttribute("user");
		//int userId = user.getUserId();
		int userId = 28;
		UserService userService = new UserService();
		userService.RegistrationAccount(request,form,userId);
		System.out.println("formから戻りました");

		//Formにエラー個所がなければ、不正な値はなかったものとして処理.
		/*if(form.getError().isEmpty()){
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
				request.setAttribute("form", form);
				doGet(request, response);
				}
		}else {
			request.setAttribute("form", form);
			doGet(request, response);
		}*/

	}

}