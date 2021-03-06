package service;

import java.util.ArrayList;

import dao.table.MessagesDAO;
import dao.table.UsersDAO;
import form.DMResultForm;
import form.MessageForm;
import helper.SortHelper;
import model.Message;
import model.User;

public class MessageService {
	MessagesDAO messagesDAO = new MessagesDAO();

	public Boolean createMessage(MessageForm messageForm) {
		try {
			int receiveUserId = Integer.valueOf(messageForm.getReceiveUserIdString());
			Boolean result = messagesDAO.insertMessage(messageForm.getSendUserId(), receiveUserId,
					messageForm.getMessageContents());
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	/**
	 * 引数のユーザーIdが送信者のメッセージを取得します.メッセージは新しい順に入ります.<br>
	 * エラーの場合はNullを返します.
	 *
	 * @param sendUserId
	 * @return
	 */
	public ArrayList<Message> getMessageBySendUser(int sendUserId) {
		return messagesDAO.selectMessageBySendUserId(sendUserId);
	}

	/**
	 * 引数のユーザーIdが受信者のメッセージを取得します.メッセージは新しい順に入ります.<br>
	 * エラーの場合はNullを返します.
	 *
	 * @param sendUserId
	 * @return
	 */
	public ArrayList<Message> getMessageByReceiveUser(int receiveUserId) {
		return messagesDAO.selectMessageByReceiveUserId(receiveUserId);
	}

	/**
	 * 引数のユーザーIdが受信者または送信者のメッセージを取得します.メッセージは新しい順に入ります.<br>
	 *
	 * @param sendUserId
	 * @return
	 */
	public ArrayList<Message> getMessageByUser(int userId) {
		System.out.println("MessageService.getMessageByUser:userId="+userId);
		ArrayList<Message> messages = new ArrayList<Message>();
		ArrayList<Message> sendMessages = messagesDAO.selectMessageBySendUserId(userId);
		ArrayList<Message> receiveMessages = messagesDAO.selectMessageByReceiveUserId(userId);
		if (sendMessages != null && receiveMessages != null) {
			messages.addAll(sendMessages);
			messages.addAll(receiveMessages);
			messages.sort((a, b) -> SortHelper.messageCreatedAt(a, b));
			System.out.println("MessageService.getMessageByUser:リスト化成功");
		} else if (sendMessages != null) {
			System.out.println("MessageService.getMessageByUser:受信者取得失敗");
			return sendMessages;
		} else if (receiveMessages != null) {
			System.out.println("MessageService.getMessageByUser:送信者取得失敗");
			return receiveMessages;
		} else {
			System.out.println("MessageService.getMessageByUser:受信者及び送信者取得失敗");
		}
		for(Message message:messages)System.out.println(message.getMessageContents()+":"+message.getSendUserId()+":"+message.getReceiveUserId());
		return messages;
	}

	/**
	 * ユーザー間の最新メッセージ以外を削除します.
	 *
	 * @return
	 */
	public ArrayList<DMResultForm> latestMessage(ArrayList<Message> messages, int userId) {
		ArrayList<Integer> usersId = new ArrayList<>();
		usersId.add(userId);
		ArrayList<DMResultForm> dmResultForms = new ArrayList<>();
		UsersDAO usersDAO = new UsersDAO();
		for (Message message : messages) {
			System.out.println("newMessage:"+message.getMessageContents()+":"+message.getSendUserId()+":"+message.getReceiveUserId());
			System.out.println("MessageService.latestMessage:userIdList="+usersId);
			if (!usersId.contains(message.getSendUserId())) {
				User user = usersDAO.selectUserById(message.getSendUserId());
				if(user != null){
					DMResultForm dmResultForm = new DMResultForm(message,user.getNickname(),user.getId());
					dmResultForms.add(dmResultForm);
				}
				usersId.add(message.getSendUserId());
			}
			if (!usersId.contains(message.getReceiveUserId())) {
				User user = usersDAO.selectUserById(message.getReceiveUserId());
				if(user != null){
					DMResultForm dmResultForm = new DMResultForm(message,user.getNickname(),user.getId());
					dmResultForms.add(dmResultForm);
				}
				usersId.add(message.getReceiveUserId());
			}
		}
		return dmResultForms;
	}
	/**
	 * 2人ユーザー間のメッセージを表示します.
	 * @param userId1
	 * @param userId2
	 * @return
	 */
	public ArrayList<Message> getMessageByUsers(int userId1,int userId2) {
		System.out.println("MessageService.getMessageByUsers:userId1="+userId1+",userid2="+userId2);
		ArrayList<Message> messages = new ArrayList<Message>();
		ArrayList<Message> sendMessages = messagesDAO.selectMessageBySendUserIdAndReceiveUserId(userId1, userId2);
		ArrayList<Message> receiveMessages = messagesDAO.selectMessageBySendUserIdAndReceiveUserId(userId2, userId1);
		if (sendMessages != null && receiveMessages != null) {
			messages.addAll(sendMessages);
			messages.addAll(receiveMessages);
			messages.sort((a, b) -> SortHelper.messageCreatedAt(a, b));
			System.out.println("MessageService.getMessageByUsers:リスト化成功");
		} else if (sendMessages != null) {
			System.out.println("MessageService.getMessageByUsers:受信者取得失敗");
			return sendMessages;
		} else if (receiveMessages != null) {
			System.out.println("MessageService.getMessageByUsers:送信者取得失敗");
			return receiveMessages;
		} else {
			System.out.println("MessageService.getMessageByUsers:受信者及び送信者取得失敗");
		}
		for(Message message:messages)System.out.println(message.getMessageContents()+":"+message.getSendUserId()+":"+message.getReceiveUserId());
		return messages;
	}
}
