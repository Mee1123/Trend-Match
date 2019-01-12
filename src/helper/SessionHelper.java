package helper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * セッションに関する関数<br>
 * 現状セッション内はuserIDのみ
 *
 * @author csuser
 *
 */
public class SessionHelper {
	public static void createUserSession(HttpServletRequest request, int userID) {
		HttpSession session = request.getSession();
		session.setAttribute("userID", userID);
	}

	public static void destroyUserSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("userID");
	}

	/**
	 * セッションがあるか調べます.なければFalse.あればtrueを返します.
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public static boolean sessionCheck(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		{
			HttpSession session = request.getSession();
			if (session.getAttribute("userID") == null) {
				System.out.println("セッションが切れてます.");

				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append("Served at: ").append(request.getContextPath());
				response.sendRedirect("/SE18G2/SessionOut.jsp");
				return false;
			} else {
				return true;
			}

		}
	}
}
