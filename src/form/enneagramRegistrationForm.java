package form;

import java.util.ArrayList;

public class enneagramRegistrationForm extends model.User{
	private ArrayList<String> error = new ArrayList<String>();

	public enneagramRegistrationForm(int enneagram_1,int enneagram_2, int enneagram_3,int enneagram_4, int enneagram_5, int enneagram_6, int enneagram_7,int enneagram_8, int enneagram_9) {

		int[] enneagram = new int[] { enneagram_1, enneagram_2, enneagram_3, enneagram_4, enneagram_5, enneagram_6,
				enneagram_7, enneagram_8, enneagram_9, };
		setEnneagram(enneagram);
		checkEnneagramValue(enneagram_1);
		checkEnneagramValue(enneagram_2);
		checkEnneagramValue(enneagram_3);
		checkEnneagramValue(enneagram_4);
		checkEnneagramValue(enneagram_5);
		checkEnneagramValue(enneagram_6);
		checkEnneagramValue(enneagram_7);
		checkEnneagramValue(enneagram_8);
		checkEnneagramValue(enneagram_9);
		System.out.println("Form,2,success");
	}


	public void checkEnneagramValue(int enneagram_Value) {
		if(enneagram_Value<0 ||enneagram_Value>10){
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