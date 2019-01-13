package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import form.DMResultForm;
import helper.SessionHelper;
import model.Message;
import service.MessageService;

/**
 * Servlet implementation class DMResult
 */
@WebServlet("/DMResult")
public class DMResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DMResultServlet() {
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
			int userId = (int) session.getAttribute("userID");
			//会話したユーザーのニックネームと最新会話のリスト作成
			MessageService messageService =new MessageService();
			ArrayList<Message> messages = messageService.getMessageByUser(userId);
			ArrayList<DMResultForm> usersList= messageService.latestMessage(messages, userId);
			//パラメータ挿入&画面遷移
			request.setAttribute("usersList", usersList);
			response.getWriter().append("Served at: ").append(request.getContextPath());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/AccountMatchingResult.jsp");
			dispatcher.forward(request, response);
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
