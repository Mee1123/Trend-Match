package form;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class enneagramRegistrationForm extends model.User {
	private ArrayList<String> error = new ArrayList<String>();

	/*
	 * public enneagramRegistrationForm(int enneagram_1,int enneagram_2, int
	 * enneagram_3,int enneagram_4, int enneagram_5, int enneagram_6, int
	 * enneagram_7,int enneagram_8, int enneagram_9) {
	 */
	public enneagramRegistrationForm(String enneagram_1, String enneagram_2, String enneagram_3, String enneagram_4,
			String enneagram_5, String enneagram_6, String enneagram_7, String enneagram_8, String enneagram_9) {

		checkCharacter(enneagram_1);
		checkCharacter(enneagram_2);
		checkCharacter(enneagram_3);
		checkCharacter(enneagram_4);
		checkCharacter(enneagram_5);
		checkCharacter(enneagram_6);
		checkCharacter(enneagram_7);
		checkCharacter(enneagram_8);
		checkCharacter(enneagram_9);

		if (getError().isEmpty()) {

			int enneagram1 = Integer.parseInt(enneagram_1);
			int enneagram2 = Integer.parseInt(enneagram_2);
			int enneagram3 = Integer.parseInt(enneagram_3);
			int enneagram4 = Integer.parseInt(enneagram_4);
			int enneagram5 = Integer.parseInt(enneagram_5);
			int enneagram6 = Integer.parseInt(enneagram_6);
			int enneagram7 = Integer.parseInt(enneagram_7);
			int enneagram8 = Integer.parseInt(enneagram_8);
			int enneagram9 = Integer.parseInt(enneagram_9);

			int[] enneagram = new int[] { enneagram1, enneagram2, enneagram3, enneagram4, enneagram5, enneagram6,
					enneagram7, enneagram8, enneagram9, };
			setEnneagram(enneagram);
		}
		/*
		 * checkEnneagramValue(enneagram1); checkEnneagramValue(enneagram2);
		 * checkEnneagramValue(enneagram3); checkEnneagramValue(enneagram4);
		 * checkEnneagramValue(enneagram5); checkEnneagramValue(enneagram6);
		 * checkEnneagramValue(enneagram7); checkEnneagramValue(enneagram8);
		 * checkEnneagramValue(enneagram9);
		 */
		System.out.println("Form,1,success");
	}

	public void checkCharacter(String enneagram_Value) {
		Pattern p = Pattern.compile("^[0-9]*$");
		Matcher m = p.matcher(enneagram_Value);
		if (m.find() == false) {
			error.add("数字以外が入力されています");
			System.out.println("数字以外が入力されています");
		} else {
			int enneagram_Int = Integer.parseInt(enneagram_Value);
			checkEnneagramValue(enneagram_Int);
		}
	}

	public void checkEnneagramValue(int enneagram_Value) {
		if (enneagram_Value < 0 || enneagram_Value > 10) {
			error.add("不正な入力値があります");
			System.out.println("不正な入力値があります");
		}

	}

	public ArrayList<String> getError() {
		return error;
	}

	public void setError(String error) {
		this.error.add(error);
	}
}