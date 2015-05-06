package office.yueyiqiu.action;

import java.util.Date;

import office.yueyiqiu.model.Alarm;
import office.yueyiqiu.util.InsertDB;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SendAlarm2Action extends ActionSupport{
	
	private InsertDB insertDB;
	private SearchDB searchDB;
	private String result;
	private String detail;
	private String title;
	private int dept;
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
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the dept
	 */
	public int getDept() {
		return dept;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(int dept) {
		this.dept = dept;
	}
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		int user=(int) ActionContext.getContext().getSession().get("user");
		
		Alarm alarm=new Alarm();
		
		alarm.setDeptNumber(this.dept);
		alarm.setDetail(detail);
		alarm.setTitle(title);
		alarm.setFromUser(user);
		alarm.setTime(new Date());
		
		
		this.insertDB.saveAlarm(alarm);
		this.result="µo°e¦¨¥\";
		this.comet();
		
		
		return this.SUCCESS;
	}
	
	
	
	public void comet(){
		
		
	}
	
}
