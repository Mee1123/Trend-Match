package form;

import java.util.ArrayList;

public class enneagramRegistrationForm extends model.User{
	private ArrayList<String> error = new ArrayList<String>();

	public enneagramRegistrationForm(int eg1,int eg2, int eg3,int eg4, int eg5, int eg6, int eg7,int eg8, int eg9) {
		setEnneagram1(eg1);
		setEnneagram2(eg2);
		setEnneagram3(eg3);
		setEnneagram4(eg4);
		setEnneagram5(eg5);
		setEnneagram6(eg6);
		setEnneagram7(eg7);
		setEnneagram8(eg8);
		setEnneagram9(eg9);
		checkEnneagramValue(eg1);
		checkEnneagramValue(eg2);
		checkEnneagramValue(eg3);
		checkEnneagramValue(eg4);
		checkEnneagramValue(eg5);
		checkEnneagramValue(eg6);
		checkEnneagramValue(eg7);
		checkEnneagramValue(eg8);
		checkEnneagramValue(eg9);
		System.out.println("Form,1,success");
	}


	public void checkEnneagramValue(int egValue) {
		if(egValue<0 ||egValue>10){
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