package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.table.ValuesDAO;
import model.Value;


/**
 * Servlet implementation class Registration
 */
@WebServlet("/unfinishedAccountRegistration")
public class aboutMotivationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public aboutMotivationServlet() {
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


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/unfinishedAccountRegistration.jsp");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		//Formにエラー個所がなければ、不正な値はなかったものとして処理.
		//System.out.println(request.getParameter("goto"));

		//clickされたボタンに応じて遷移先を分岐
		if(request.getParameter("goto").equals("詳しくみる")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/motivation.jsp");
			dispatcher.forward(request, response);
		}else if(request.getParameter("goto").equals("次へ")){

			//ここでDBに遷移する何かを書く？
			ArrayList<Value> values = new ArrayList<Value>();
			ValuesDAO valuesDAO = new ValuesDAO();
			values = valuesDAO.selectValueAll();
			request.setAttribute("values",values);


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/accountRegistration.jsp");
			dispatcher.forward(request, response);
		}

	}

}
