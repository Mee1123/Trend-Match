package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import form.accountRegistrationCheckForm;;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/accountRegistration")
@MultipartConfig(location="/tmp", maxFileSize=2147483647)
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
		String jobOffer = request.getParameter("jobOffer");
		System.out.println(jobOffer);

		//ニックネーム
		String nickname = request.getParameter("nickname");
		System.out.println(nickname);

		//卒業年度
		String graduate = request.getParameter("graduate")+"0331";
		System.out.println(graduate);

		//所属
		String department = request.getParameter("department");
		System.out.println(department);

		//職種
		String occupation = request.getParameter("occupation");
		System.out.println(occupation);

		//性別
		String sex = request.getParameter("sex");
		System.out.println(sex);

		//連絡先
		String contact = request.getParameter("contact");
		System.out.println(contact);

		//フリースペース
		String freeSpace = request.getParameter("freespace");
		System.out.println(freeSpace);

		String value1 = request.getParameter("valueId1");
		String value2 = request.getParameter("valueId2");
		String value3 = request.getParameter("valueId3");
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);

		accountRegistrationCheckForm form = new accountRegistrationCheckForm(jobOffer,nickname,graduate,department,occupation,sex,contact,freeSpace);

		//プロフィール画像
		/*
		try {
			Part part = request.getPart("file");
			if(part != null){
				HttpSession session = request.getSession();
				int userId = (int) session.getAttribute("userID");
				System.out.println("ファイルを受け付けます:userID="+userId);
				int name = 1;
				part.write(getServletContext().getRealPath("/WebContent/picture") + "/" + name);
				}
		}catch (ArithmeticException e) {
				System.out.println("例外が発生しました。");
				System.out.println(e);
				form.setError("ファイルが不適切です");
		}
*/

		if(form.getError().isEmpty()){
			//System.out.println("エラーなし");
			request.setAttribute("jobOffer",jobOffer );
			request.setAttribute("nickname", nickname);
			request.setAttribute("graduate", graduate);
			request.setAttribute("department", department);
			request.setAttribute("occupation", occupation);
			request.setAttribute("sex", sex);
			request.setAttribute("contact", contact);
			request.setAttribute("freeSpace", freeSpace);
			request.setAttribute("value1", value1);
			request.setAttribute("value2", value2);
			request.setAttribute("value3", value3);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/checkAccountRegistration.jsp");
			//System.out.println(dispatcher);
			dispatcher.forward(request, response);

		}else{
			System.out.println("エラーあり");
			request.setAttribute("form", form);
			doGet(request, response);
		}
	}
}