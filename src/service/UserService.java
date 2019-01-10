package service;


import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.table.UsersDAO;
import form.AccountSearchInfoForm;
import form.LoginForm;
import form.UpdateUserInfoForm;
import form.accountRegistrationForm;
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
				SessionHelper.createUserSession(request, user.getId());
			} else {
				form.setError(errorStatement);
			}
		}
	}

	public ArrayList<User> accountSearchInfo(HttpServletRequest request, AccountSearchInfoForm form) {
		String nickname = form.getNickname();
		String department =form.getDepartment();
		String freespace = form.getFreespace();
		String graduate=form.getGraduate_String();
		String occupation_id_String= form.getOccupation_id_String();
		String sex_id_String = form.getSex_id_String();
		String display_id_String = form.getDisplay();
		UsersDAO usersDAO = new UsersDAO();
		ArrayList<User> users = usersDAO.selectUserBySearch(nickname, department, freespace, graduate,
				occupation_id_String, sex_id_String, "", display_id_String);
		return users;
	}

	public User accountView(int userId) {
		User user = new User();
		user = usersDAO.selectUserById(userId);

		return user;
	}


	public User getMyInfo(int userId) {
		UsersDAO dao = new UsersDAO();
		this.connection = dao.createConnection();
		User user = new User();
		user = dao.findOne(userId, connection);
		this.connection = null;
		return user;
	}

	public void updateUserInfo(UpdateUserInfoForm form,int userId) {
		System.out.println("Service,1,success");
		UsersDAO dao = new UsersDAO();
		dao.update(form,userId);
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
		int[] enneagram = form.getEnneagram();
		int eg1 = enneagram[1];
		int eg2 = enneagram[2];
		int eg3 = enneagram[3];
		int eg4 = enneagram[4];
		int eg5 = enneagram[5];
		int eg6 = enneagram[6];
		int eg7 = enneagram[7];
		int eg8 = enneagram[8];
		int eg9 = enneagram[9];

		//System.out.println(eg1);


		usersDAO.insertEnneagram(eg1,eg2,eg3,eg4,eg5,eg6,eg7,eg8,eg9,userID);
	}

	public void RegistrationAccount(HttpServletRequest request, accountRegistrationForm form,int userID) {
		System.out.println("サービスの処理");
		//型変換の必要なし
		//Part filePart = form.getFilePart();
		int jobOffer = form.getJoboffer_id();
		//System.out.println(jobOffer);
		String nickname = form.getNickname();
		int graduate = form.getGraduate_Int();
		String department = form.getDepartment();
		int occupation = form.getOccupation_id();
		int sex = form.getSex_id();
		String contact = form.getContact();
		String freeSpace = form.getFreespace();
		ArrayList<Integer> Values = form.getValue_id();
		int value1 = null;
		if(Values.size()>0){
			value1 = Values.get(0);
		}
		System.out.println(value1);
		int value2 = form.getValue2();
		int value3 = form.getValue3();


		System.out.println("DAOにいきます");


		usersDAO.insertAccount(jobOffer,nickname,graduate,department,occupation,sex,contact,freeSpace,value1,value2,value3,userID);
	}

  	public void DeleteUser(User user) {
		UsersDAO dao = new UsersDAO();
		this.connection = dao.createConnection();
		dao.deleteUser(user, connection);
		this.connection = null;
	}

  	public void Unsubscribe(User user) {
		UsersDAO dao = new UsersDAO();
		this.connection = dao.createConnection();
		dao.deleteUser(user, connection);
		this.connection = null;
	}
}
