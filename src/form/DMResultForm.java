package form;

import java.util.Date;

import model.Message;

public class DMResultForm extends Message {
	String userNickname;

	public DMResultForm(Message message,String userNickname) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(message.getId(),message.getSendUserId(),message.getReceiveUserId(),message.getMessageContents(),message.getCreatedAt());
		setUserNickname(userNickname);
	}
	public DMResultForm(Message message) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(message.getId(),message.getSendUserId(),message.getReceiveUserId(),message.getMessageContents(),message.getCreatedAt());
	}
	public DMResultForm(int id, int sendUserId, int receiveUserId, String messageContents, Date createdAt,String userNickname) {
		super(id, sendUserId, receiveUserId, messageContents, createdAt);
		setUserNickname(userNickname);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}


}
