package service;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import dao.table.UsersDAO;
import form.LoginForm;
import form.accountRegistrationCheckForm;
import form.checkUserRegistrationForm;
import form.enneagramRegistrationForm;
import helper.HashHelper;
import helper.SessionHelper;
import model.User;

public class UserService {
	private Connection connection = null;
	UsersDAO usersDAO = new UsersDAO();
	private String errorStatement = "メールアドレス、又はパスワードが違います.";

	public void LoginUser(HttpServletRequest request, LoginForm form) {
		User user = usersDAO.selectUserByMailAddress(form.getMailAddress());
		if (user == null) {
			form.setError(errorStatement);
		} else {
			if (form.getPassword().equals(user.getPassword())) {
				SessionHelper.createUserSession(request, user.getID());
			} else {
				form.setError(errorStatement);
			}
		}
	}


	public User getMyInfo(int userId) {
		UsersDAO dao = new UsersDAO();
		this.connection = dao.createConnection();
		User user = new User();
		user = dao.findOne(userId, connection);
		this.connection = null;
		return user;
	}



	public void RegistrationUser(HttpServletRequest request, checkUserRegistrationForm form) {
		//型変換の必要なし
		String name = form.getName();
		String mailAddress = form.getMailAddress();
		String password = form.getPassword();
		String hashPassword = null;
		try {
			hashPassword = HashHelper.getHash(name, password);
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		usersDAO.insertUser(name, mailAddress, hashPassword);
	}


	public void RegistrationEnneagram(HttpServletRequest request, enneagramRegistrationForm form,int userID) {
		//型変換の必要なし
		int eg1 = form.getEnneagram1();
		int eg2 = form.getEnneagram2();
		int eg3 = form.getEnneagram3();
		int eg4 = form.getEnneagram4();
		int eg5 = form.getEnneagram5();
		int eg6 = form.getEnneagram6();
		int eg7 = form.getEnneagram7();
		int eg8 = form.getEnneagram8();
		int eg9 = form.getEnneagram9();

		//System.out.println(eg1);


		usersDAO.insertEnneagram(eg1,eg2,eg3,eg4,eg5,eg6,eg7,eg8,eg9,userID);
	}

	public void RegistrationAccount(HttpServletRequest request, accountRegistrationCheckForm form,int userID) {
		//型変換の必要なし
		Part filePart = form.getFilePart();
		int jobOffer = form.getJobOffer();
		String nickname = form.getNickname();
		int graduate = form.getGraduate();
		String department = form.getDepartment();
		int occupation = form.getOccupation();
		int sex = form.getSex();
		String contact = form.getContact();
		String freeSpace = form.getFreeSpace();
		//String value1 = form.getValue1();
		//String value2 = form.getValue2();
		//String value3 = form.getValue3();


		System.out.println(freeSpace);


		usersDAO.insertAccount(filePart,jobOffer,nickname,graduate,department,occupation,sex,contact,freeSpace,userID);
	}

  	public void DeleteUser(User user) {
		UsersDAO dao = new UsersDAO();
		this.connection = dao.createConnection();
		dao.deleteUser(user, connection);
		this.connection = null;
	}
}
