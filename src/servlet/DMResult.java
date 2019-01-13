package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.SessionHelper;

/**
 * Servlet implementation class DMResult
 */
@WebServlet("/DMResult")
public class DMResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DMResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (SessionHelper.sessionCheck(request, response)) {
			System.out.println("DMResult.doGet:start");
			//セッションからユーザーIdの取得
			HttpSession session = request.getSession();
			session.getAttribute("userID");
			//会話したユーザーのニックネームと最新会話のリスト作成
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (SessionHelper.sessionCheck(request, response)) {
			doGet(request, response);
		}
	}

}
