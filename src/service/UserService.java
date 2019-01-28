package service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import dao.service.UsersValuesDAO;
import dao.table.UsersDAO;
import form.AccountSearchInfoForm;
import form.LoginForm;
import form.SimilarityUserForm;
import form.UpdateAccountInfoForm;
import form.UpdatePasswordForm;
import form.UpdateUserInfoForm;
import form.accountRegistrationForm;
import form.checkUserRegistrationForm;
import form.enneagramRegistrationForm;
import helper.HashHelper;
import helper.SessionHelper;
import model.User;

public class UserService {
	UsersDAO usersDAO = new UsersDAO();
	UsersValuesDAO usersValuesDAO =new UsersValuesDAO();
	private String errorStatement = "メールアドレス、又はパスワードが違います.";
	LocalDateTime dateTime = LocalDateTime.now();

	public void LoginUser(HttpServletRequest request, LoginForm form) throws NoSuchAlgorithmException {
		System.out.println("UserService.LoginUser:開始");
		System.out.println(form.getMailAddress());
		UsersDAO usersDAO = new UsersDAO();
		User user = usersDAO.selectUserByMailAddress(form.getMailAddress());
		System.out.println(form.getPassword());
		System.out.println(HashHelper.getHash(form.getMailAddress(), form.getPassword()));
		if (user == null) {
			form.setError(errorStatement);
		} else {
			if (HashHelper.getHash(form.getMailAddress(), form.getPassword()).equals(user.getPassword())) {
				SessionHelper.createUserSession(request, user.getId());
				System.out.println("UserService.LoginUser:開始:Success");
			} else {
				form.setError(errorStatement);
			}
		}
	}

	public ArrayList<User> accountSearchInfo(HttpServletRequest request, AccountSearchInfoForm form) {
		String nickname = form.getNickname();
		String department =form.getDepartment();
		String freespace = form.getFreespace();
		Integer graduate = null;
		if(!form.getGraduate_String().equals("")){
			graduate=Integer.valueOf(form.getGraduate_String());
		}
		String occupation_id_String= form.getOccupation_id_String();
		String sex_id_String = form.getSex_id_String();
		String display_id_String = form.getDisplay();
		UsersDAO usersDAO = new UsersDAO();
		ArrayList<User> users = usersDAO.selectUserBySearch(nickname, department, freespace, graduate,
				occupation_id_String, sex_id_String, "", display_id_String);
		return users;
	}
/**
 * ユーザーIDからUserを調べる。
 * @param userId
 * @return
 */
	public User accountView(int userId) {
		User user = new User();
		user = usersDAO.selectUserById(userId);

		return user;
	}


	public User getMyInfo(int userId) {
		UsersDAO dao = new UsersDAO();
		User user = new User();
		user = dao.findOne(userId);
		return user;
	}

	public User getMyAccountInfo(int userId) {
		System.out.println("UserService.getMyAccountInfo:Success");
		UsersDAO dao = new UsersDAO();
		User user = new User();
		user = dao.selectUserById(userId);
		return user;
	}

	public void RegistrationUser(HttpServletRequest request, checkUserRegistrationForm form) {
		//型変換の必要なし
		String name = form.getName();
		String mailAddress = form.getMailAddress();
		String password = form.getPassword();
		String hashPassword = null;
		try {
			hashPassword = HashHelper.getHash(mailAddress, password);
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		UsersDAO usersDAO = new UsersDAO();
		usersDAO.insertUser(name, mailAddress, hashPassword);
	}

	public void RegistrationEnneagram(HttpServletRequest request, enneagramRegistrationForm form,int userID) {
		System.out.println("UserService.RegistrationEnneagram:Success");
		//型変換の必要なし
		int[] enneagram = form.getEnneagram();

		int eg1 = enneagram[0];
		int eg2 = enneagram[1];
		int eg3 = enneagram[2];
		int eg4 = enneagram[3];
		int eg5 = enneagram[4];
		int eg6 = enneagram[5];
		int eg7 = enneagram[6];
		int eg8 = enneagram[7];
		int eg9 = enneagram[8];

		//System.out.println(eg1);

		usersDAO.insertEnneagram(eg1,eg2,eg3,eg4,eg5,eg6,eg7,eg8,eg9,userID);
	}

	public void RegistrationAccount(HttpServletRequest request, accountRegistrationForm form,int userID) {
		System.out.println("UserService.RegistrationAccount:処理開始");
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
		int[] value = {0,0,0};
		if(Values.size()>0){
			value[0] = Values.get(0);
		}
		System.out.println(value[0]);
		if(Values.size()>1){
			value[1] = Values.get(1);
		}
		if(Values.size()>2){
			value[2] = Values.get(2);
		}
		System.out.println("UserService.RegistrationAccount:この後userDAOにいきます");
		usersDAO.insertAccount(jobOffer,nickname,graduate,department,occupation,sex,contact,freeSpace,value[0],value[1],value[2],userID);
		System.out.println("UserService.RegistrationAccount:登録終了");
	}

  	public void DeleteUser(User user) {
		UsersDAO dao = new UsersDAO();
		dao.deleteUser(user);
	}
	public void updateUserInfo(UpdateUserInfoForm form, int userId) throws NoSuchAlgorithmException {
		System.out.println("UserService.updateUserInfo:success");
		UsersDAO dao = new UsersDAO();
		//String hashPassword = HashHelper.getHash(form.getMailAddress(), form.getPassword());
		//dao.update(form, userId,hashPassword);
		dao.update(form, userId);
	}
	public void updatePasswordInfo(UpdatePasswordForm form, int userId) throws NoSuchAlgorithmException {
		System.out.println("UserService.updateUserInfo:success");
		UsersDAO dao = new UsersDAO();
		String hashPassword = HashHelper.getHash(form.getMailAddress(), form.getPassword());
		dao.updatePassword(form, userId,hashPassword);
	}

	public void updateAccountInfo(UpdateAccountInfoForm form, int userId, int value1, int value2, int value3) {
		System.out.println("UserService.updateAccountInfo:success");
		UsersDAO dao = new UsersDAO();
		dao.updateAccount(form,userId,value1,value2,value3);
	}

  	public void Unsubscribe(User user) {
		UsersDAO dao = new UsersDAO();
		dao.deleteUser(user);
	}
/**
 * ユーザーidを入れると類似度のリストを返します.
 * @param userId
 * @return ArrayList<SimilarityUserForm>
 */
  	public ArrayList<SimilarityUserForm> matching(int userId) {
  		java.util.Date newDate = new Date();
  		User user =usersDAO.selectUserById(userId);
  		boolean type = newDate.after(user.getGraduate());
  		//社会人か学生のエニアグラムを持っているuser全てを持ってくる.
  		ArrayList<User> users =  usersValuesDAO.selectEnneagramByUserType(type);
  		ArrayList<SimilarityUserForm> similarityUsers = new ArrayList<>();
  		int enneagram1[] = user.getEnneagram();
  		ArrayList<Integer> userValues = user.getValue_id();
		System.out.println("UserService.matching:類似度リストの計算を始めます."+users.size()+"人");
  		for (User instantUser: users) {
  			System.out.println("UserService.matching:[類似度計算開始]対象userId="+instantUser.getId());
  			SimilarityUserForm similarityUserForm = new SimilarityUserForm();
  			similarityUserForm.setId(instantUser.getId());
  			System.out.println("UserService.matching:[価値観計算開始]");
  			//価値観の一致率
  			int valueMatch=0;
  			instantUser.createValues();
  			System.out.println("ここは");
  			for(int userValue:userValues){
  				System.out.println("sa-bisu:"+instantUser.getValue_id());
  				if(instantUser.getValue_id().contains(userValue)){
  	  				valueMatch+=5;
  	  			}
  			}
 			System.out.println("UserService.matching:価値観補正 = "+valueMatch);
  			//ユークリッド距離の計算
  			int enneagram2[] =instantUser.getEnneagram();
  			double similarity=0;
  			for(int i=0; i<9;i++){
  				similarity =similarity + Math.pow(enneagram1[i]-enneagram2[i],2);
  				System.out.println("UserService.matching:エニアグラム[本人,相手]:["+enneagram1[i]+","+enneagram2[i]+"]:差分 = "+similarity);
  			}
  			System.out.println("UserService.matching:[ユークリッド距離の計算√前]ユークリッド距離^2 = "+similarity);
  			similarity = Math.sqrt(similarity);
  			System.out.println("UserService.matching:[ユークリッド距離の計算√後]ユークリッド距離 = "+similarity);
 			//重みの計算
  			similarity = 30 - similarity +valueMatch;
  			//
  			similarityUserForm.setSimilarity(similarity);
  			similarityUsers.add(similarityUserForm);
  			System.out.println("UserService.matching:類似度 ="+similarity);
		}
			System.out.println("UserService.matching:終了");
		return similarityUsers;

	}

}
