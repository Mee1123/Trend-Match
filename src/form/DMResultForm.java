package form;

import java.util.Date;

import model.Message;

public class DMResultForm extends Message {
	String userNickname;
	int userId;

	public DMResultForm(Message message, String userNickname,int userId) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(message.getId(), message.getSendUserId(), message.getReceiveUserId(), message.getMessageContents(),
				message.getCreatedAt());
		setUserNickname(userNickname);
		setUserId(userId);
	}

	public DMResultForm(Message message) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(message.getId(), message.getSendUserId(), message.getReceiveUserId(), message.getMessageContents(),
				message.getCreatedAt());
	}

	public DMResultForm(int id, int sendUserId, int receiveUserId, String messageContents, Date createdAt,
			String userNickname,int userId) {
		super(id, sendUserId, receiveUserId, messageContents, createdAt);
		setUserNickname(userNickname);
		// TODO 自動生成されたコンストラクター・スタブ
		setUserId(userId);
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
