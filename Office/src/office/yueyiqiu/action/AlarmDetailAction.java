package office.yueyiqiu.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import office.yueyiqiu.model.Alarm;
import office.yueyiqiu.util.InsertDB;
import office.yueyiqiu.util.SearchDB;

public class AlarmDetailAction extends ActionSupport{
	
	private SearchDB searchDB;
	private InsertDB insertDB;
	private int alarmNumber;
	private Alarm alarm;
	private int currentPage;
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
	 * @return the alarmNumber
	 */
	public int getAlarmNumber() {
		return alarmNumber;
	}
	/**
	 * @param alarmNumber the alarmNumber to set
	 */
	public void setAlarmNumber(int alarmNumber) {
		this.alarmNumber = alarmNumber;
	}
	/**
	 * @return the alarm
	 */
	public Alarm getAlarm() {
		return alarm;
	}
	/**
	 * @param alarm the alarm to set
	 */
	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
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
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		String sqlUpdate="update oa_alarm set alarm_state='1' where alarm_number='"+this.alarmNumber+"'";
		
		this.insertDB.update(sqlUpdate);
		
		
		String sql="select oa_alarm.alarm_title,oa_alarm.alarm_time,oa_user.user_realname,oa_dept.dept_name,oa_alarm.alarm_detail"+
					" from (oa_alarm inner join oa_user on oa_alarm.alarm_fromuser=oa_user.user_number)"+ 
					" inner join oa_dept on oa_alarm.alarm_dept=oa_dept.dept_number"+
					" where oa_alarm.alarm_number='"+this.alarmNumber+"'";
		
		List list=this.searchDB.getArrayList(sql, -1, -1);
		Object[] obj=(Object[]) list.get(0);
		
		this.alarm=new Alarm((String)obj[0],(Date)obj[1],(String)obj[2],(String)obj[3],(String)obj[4]);		
				
		return this.SUCCESS;
	}
	
	
	
	
	
}
