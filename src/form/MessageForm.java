package form;

import java.util.ArrayList;

import helper.ValidationHelper;
import model.Message;

public class MessageForm extends Message {
	private ArrayList<String> error = new ArrayList<>();
	private String receiveUserIdString;

	public MessageForm(int sendUserId, String receiveUserId, String messageContents) {
		// TODO 自動生成されたコンストラクター・スタブ
		setSendUserId(sendUserId);
		setReceiveUserIdString(receiveUserId);
		setMessageContents(messageContents);
		receiveUserIdValidation();
		messageContentsValidation();
	}

	public void receiveUserIdValidation(){
		if(ValidationHelper.maximumText(10, receiveUserIdString, "ユーザーid")!=null){
			error.add(ValidationHelper.maximumText(10, receiveUserIdString, "ユーザーid"));
		}
		if(ValidationHelper.minimumText(1, receiveUserIdString, "ユーザーid")!=null){
			error.add(ValidationHelper.maximumText(1, receiveUserIdString, "ユーザーid"));
		}
		if(ValidationHelper.regularExpressionText("[0123456789]+", receiveUserIdString, "ユーザーid")!=null){
			error.add(ValidationHelper.regularExpressionText("[0123456789]+", receiveUserIdString, "ユーザーid"));
		}
	}
	public void messageContentsValidation(){
		if(ValidationHelper.maximumText(1000000000, receiveUserIdString, "ユーザーid")!=null){
			error.add(ValidationHelper.maximumText(1000000000, receiveUserIdString, "ユーザーid"));
		}
		if(ValidationHelper.minimumText(1, receiveUserIdString, "ユーザーid")!=null){
			error.add(ValidationHelper.maximumText(1, receiveUserIdString, "ユーザーid"));
		}
	}


	public ArrayList<String> getError() {
		return error;
	}

	public void setError(String error) {
		this.error.add(error);
	}

	public String getReceiveUserIdString() {
		return receiveUserIdString;
	}

	public void setReceiveUserIdString(String receiveUserIdString) {
		this.receiveUserIdString = receiveUserIdString;
	}

}
