package office.yueyiqiu.action;

import java.util.Date;

import office.yueyiqiu.model.SendMsg;
import office.yueyiqiu.util.InsertDB;

public class SendMessage2Action extends SendMessageAction{
	
	private InsertDB insertDB;
	private int receiver;
	private String info;
	private String content;
	/**
	 * @return the insertDB
	 */
	public InsertDB getInsertDB() {
		return insertDB;
	}
	/**
	 * @param insertDB the insertDB to set
	 */
	public void setInsertDB(InsertDB insertDB) {
		this.insertDB = insertDB;
	}
	/**
	 * @return the receiver
	 */
	public int getReceiver() {
		return receiver;
	}
	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/* (non-Javadoc)
	 * @see office.yueyiqiu.action.SendMessageAction#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		SendMsg msg=new SendMsg();
		msg.setFromUser((int)this.getSession().get("user"));
		msg.setToUser(receiver);
		msg.setMsgInfo(info);
		msg.setMsgContent(content);
		msg.setMsgTime(new Date());
		this.insertDB.saveMsg(msg);
		return this.SUCCESS;
	}
	
	
	
	
	
}
