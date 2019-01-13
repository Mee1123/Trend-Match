package model;

import java.util.Date;

import helper.DateHelper;

public class Message extends Default {
	private int sendUserId;
	private int receiveUserId;
	private String messageContents;
	private Date createdAt;


	public int getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(int sendUserId) {
		this.sendUserId = sendUserId;
	}
	public int getReceiveUserId() {
		return receiveUserId;
	}
	public void setReceiveUserId(int receiveUserId) {
		this.receiveUserId = receiveUserId;
	}
	public String getMessageContents() {
		return messageContents;
	}
	public void setMessageContents(String messageContents) {
		this.messageContents = messageContents;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setCreatedAt(java.sql.Date createdAt) {
		Date createdAtUtil = DateHelper.toUtilDate(createdAt);
		this.createdAt = createdAtUtil;
	}
	/**
	 * 現在時刻を取得
	 */
	public void setCreatedAt() {
		this.createdAt = new Date();
	}

}
