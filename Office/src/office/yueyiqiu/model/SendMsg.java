package office.yueyiqiu.model;

import java.util.Date;

public class SendMsg {
	
	private int msgNumber;
	private int fromUser;
	private int toUser;
	private String msgInfo;
	private String msgContent;
	private Date msgTime;
	private String fromUserName;
	private String msgTimeStr;
	
	public SendMsg(int number,String fromUserName,String info,String time,String content){
		
		this.msgNumber=number;
		this.fromUserName=fromUserName;
		this.msgInfo=info;
		this.msgContent=content;
		this.msgTimeStr=time;
		
	}
	
	public SendMsg(int number,String fromUserName,String msgInfo,String time){
		
		this.msgNumber=number;
		this.fromUserName=fromUserName;
		this.msgInfo=msgInfo;
		this.msgTimeStr=time;
	}
	
	
	public SendMsg(){
		
		
	}
	
	/**
	 * @return the msgNumber
	 */
	public int getMsgNumber() {
		return msgNumber;
	}
	/**
	 * @param msgNumber the msgNumber to set
	 */
	public void setMsgNumber(int msgNumber) {
		this.msgNumber = msgNumber;
	}
	/**
	 * @return the fromUser
	 */
	public int getFromUser() {
		return fromUser;
	}
	/**
	 * @param fromUser the fromUser to set
	 */
	public void setFromUser(int fromUser) {
		this.fromUser = fromUser;
	}
	/**
	 * @return the toUser
	 */
	public int getToUser() {
		return toUser;
	}
	/**
	 * @param toUser the toUser to set
	 */
	public void setToUser(int toUser) {
		this.toUser = toUser;
	}
	/**
	 * @return the msgInfo
	 */
	public String getMsgInfo() {
		return msgInfo;
	}
	/**
	 * @param msgInfo the msgInfo to set
	 */
	public void setMsgInfo(String msgInfo) {
		this.msgInfo = msgInfo;
	}
	/**
	 * @return the msgContent
	 */
	public String getMsgContent() {
		return msgContent;
	}
	/**
	 * @param msgContent the msgContent to set
	 */
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	/**
	 * @return the msgTime
	 */
	public Date getMsgTime() {
		return msgTime;
	}
	/**
	 * @param msgTime the msgTime to set
	 */
	public void setMsgTime(Date msgTime) {
		this.msgTime = msgTime;
	}
	/**
	 * @return the fromUserName
	 */
	public String getFromUserName() {
		return fromUserName;
	}
	/**
	 * @param fromUserName the fromUserName to set
	 */
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	/**
	 * @return the msgTimeStr
	 */
	public String getMsgTimeStr() {
		return msgTimeStr;
	}
	/**
	 * @param msgTimeStr the msgTimeStr to set
	 */
	public void setMsgTimeStr(String msgTimeStr) {
		this.msgTimeStr = msgTimeStr;
	}
	
	
	
	
}
