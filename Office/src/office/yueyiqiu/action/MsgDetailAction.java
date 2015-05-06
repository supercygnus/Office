package office.yueyiqiu.action;

import java.util.List;
import java.util.Map;

import office.yueyiqiu.model.SendMsg;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MsgDetailAction extends ActionSupport{
	
	private SearchDB searchDB;
	private int msgNumber;
	private int currentPage;
	private SendMsg msg;
	/**
	 * @return the searchDB
	 */
	public SearchDB getSearchDB() {
		return searchDB;
	}
	/**
	 * @param searchDB the searchDB to set
	 */
	public void setSearchDB(SearchDB searchDB) {
		this.searchDB = searchDB;
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
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * @return the msg
	 */
	public SendMsg getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(SendMsg msg) {
		this.msg = msg;
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		int usernumber=(int) this.getSession().get("user");
		String sql="select oa_message.message_number,oa_user.user_realname,oa_message.message_info,date_format(oa_message.message_time,'%Y-%m-%d-%T') as msgtime,oa_message.message_content"+
		" from oa_message inner join oa_user on oa_message.message_fromuser=oa_user.user_number "+
		" where oa_message.message_touser='"+usernumber+"' and oa_message.message_number='"+this.msgNumber+"'";
		
		List msgList=this.searchDB.getArrayList(sql,-1,-1);
		
		Object[] obj=(Object[]) msgList.get(0);
		
		this.msg=new SendMsg((int)obj[0],(String)obj[1],(String)obj[2],(String)obj[3],(String)obj[4]);
		
		return this.SUCCESS;
	}
	
	
	public Map getSession(){
		return ActionContext.getContext().getSession();
	}
	
}
