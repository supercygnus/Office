package office.yueyiqiu.action;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import office.yueyiqiu.model.SendMsg;
import office.yueyiqiu.util.InsertDB;
import office.yueyiqiu.util.SearchDB;

public class ReceiveMessageAction extends ActionSupport{
	
	private SearchDB searchDB;
	private InsertDB insertDB;
	private List messageList;
	
	private int currentPage=1;
	private int pageSpan=5;
	private int maxPage;
	private int totalMessage;
	
	
	
	
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
	 * @return the pageSpan
	 */
	public int getPageSpan() {
		return pageSpan;
	}


	/**
	 * @param pageSpan the pageSpan to set
	 */
	public void setPageSpan(int pageSpan) {
		this.pageSpan = pageSpan;
	}


	/**
	 * @return the maxPage
	 */
	public int getMaxPage() {
		return maxPage;
	}


	/**
	 * @param maxPage the maxPage to set
	 */
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}


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
	 * @param messageList the messageList to set
	 */
	public void setMessageList(List messageList) {
		this.messageList = messageList;
	}


	public List getMessageList(){
		System.out.println("Go!!!");
		int usernumber=(int) this.getSession().get("user");
		int begin=(this.currentPage-1)*this.pageSpan;
		int max=this.pageSpan;
		String sql="select oa_message.message_number as msgnumber,oa_user.user_realname as fromuser,oa_message.message_info as msginfo,date_format(oa_message.message_time,'%Y-%m-%d-%T') as msgtime "+
				   "from oa_message inner join oa_user on "+
				   "oa_message.message_fromuser=oa_user.user_number where oa_message.message_touser='"+usernumber+"'";
		
		System.out.println(sql);
		List list=this.searchDB.getArrayList(sql,begin,max);
		System.out.println("Gokkkk!!!");
		List fileList=new ArrayList();
		
		System.out.println("list size="+list.size());
		
		
		for(int i=0;i<list.size();i++){
			System.out.println("yes!!");
			Object[] obj=(Object[]) list.get(i);
			SendMsg msg=new SendMsg((int)obj[0],(String)obj[1],(String)obj[2],(String)obj[3]);
			fileList.add(msg);
		}
		System.out.println(((SendMsg)fileList.get(0)).getMsgInfo());
		System.out.println("Go3!!!");
		return fileList;
	}

	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		this.updateInfo();
		return this.SUCCESS;
	}
	
	public void updateInfo(){
		
		int number=(int) this.getSession().get("user");
		String sql="select count(*) from oa_message where message_touser='"+number+"'";
		List list=this.searchDB.getArrayList(sql, -1, -1);
		if(list!=null){
		int total=((BigInteger) list.get(0)).intValue();
		this.setMaxPage(total%this.getPageSpan()==0?total/this.getPageSpan():total/this.getPageSpan()+1);
		}
		
	}
	
	
	public Map getSession(){
		return ActionContext.getContext().getSession();
	}
	
}
