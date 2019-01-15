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
import form.MessageForm;
import helper.SessionHelper;
import model.Message;
import service.MessageService;
import service.UserService;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (SessionHelper.sessionCheck(request, response)) {
			System.out.println("DMResult.doGet:start");
			// セッションからユーザーIdの取得
			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("userID");
			// 対象ユーザーを取得
			String conversationUserIdString = request.getParameter("Id");
			int conversationUserId;
			UserService userService = new UserService();
			if (conversationUserIdString != null)
				try {
					// 対象ユーザーIdをint変換
					conversationUserId = Integer.valueOf(conversationUserIdString);
					System.out.println("DMResultServlet.Get:[chat open]userId=" + conversationUserIdString);
					request.setAttribute("userId", userId);
					request.setAttribute("user", userService.accountView(conversationUserId));
					try {
						// chatリスト生成
						MessageService messageService = new MessageService();
						ArrayList<Message> chatList = messageService.getMessageByUsers(userId, conversationUserId);
						System.out.println("messageList=" + chatList.get(0).getSendUserId());
						request.setAttribute("messageList", chatList);

					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("DMResultServlet.Get:[chatなし]新しい会話");
					}

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("DMResultServlet.Get:[chat取得失敗]もしかして,不正なId");
				}


			// 会話したユーザーのニックネームと最新会話のリスト作成
			MessageService messageService = new MessageService();
			ArrayList<Message> messages = messageService.getMessageByUser(userId);
			ArrayList<DMResultForm> usersList = messageService.latestMessage(messages, userId);
			// パラメータ挿入&画面遷移
			request.setAttribute("usersList", usersList);
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/DMResult.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (SessionHelper.sessionCheck(request, response)) {
			System.out.println("DMResult.doPost:start");
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			// セッションからユーザーIdの取得
			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("userID");
			// ユーザーからform情報の取得
			String receiveUserId = request.getParameter("toUserId");
			String messageContents = request.getParameter("message");
			System.out.println("DMResult.doPost:receiveUserId="+receiveUserId);
			MessageService messageService = new MessageService();
			MessageForm messageForm = new MessageForm(userId, receiveUserId, messageContents);
			if (messageService.createMessage(messageForm))
			System.out.println("DMResult.doPost:success");
			doGet(request, response);

		}

	}
}
