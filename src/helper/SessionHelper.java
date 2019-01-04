package helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * セッションに関する関数<br>現状セッション内はuserIDのみ
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
}
