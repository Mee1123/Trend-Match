package service;

import java.util.ArrayList;

import dao.table.MessagesDAO;
import form.MessageForm;
import helper.SortHelper;
import model.Message;

public class MessageService {
	MessagesDAO messagesDAO = new MessagesDAO();

	public Boolean createMessage(MessageForm messageForm) {
		try {
			int receiveUserId = Integer.valueOf(messageForm.getReceiveUserId());
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
		return messages;
	}

	/**
	 * ユーザー間の最新メッセージ以外を削除します.
	 *
	 * @return
	 */
	public ArrayList<Message> latestMessage(ArrayList<Message> messages, int userId) {
		ArrayList<Integer> usersId = new ArrayList<>(userId);
		ArrayList<Message> newMessages = new ArrayList<>();
		for (Message message : messages) {
			if (!usersId.contains(message.getSendUserId())) {
				newMessages.add(message);
			}
			if (!usersId.contains(message.getReceiveUserId())) {
				newMessages.add(message);
			}
		}
		return newMessages;
	}
	/**
	 * 2人ユーザー間のメッセージを表示します.
	 * @param userId1
	 * @param userId2
	 * @return
	 */
	public ArrayList<Message> getMessageByUsers(int userId1,int userId2) {
		ArrayList<Message> messages = new ArrayList<Message>();
		ArrayList<Message> sendMessages = messagesDAO.selectMessageBySendUserIdAndReceiveUserId(userId1, userId2);
		ArrayList<Message> receiveMessages = messagesDAO.selectMessageBySendUserIdAndReceiveUserId(userId2, userId1);
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
		return messages;
	}
}
