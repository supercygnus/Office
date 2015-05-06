package office.yueyiqiu.model;

import java.util.Date;

public class Alarm {
	
	private int alarmNumber;
	private int fromUser;
	private int deptNumber;
	private String title;
	private String detail;
	private Date time;
	
	
	private String fromUserName;
	private int state;
	private String deptName;
	
	
	public Alarm(){}
	
	public Alarm(int alarmNumber,String title,Date time,String userName,int state,String deptName){
		
			this.alarmNumber=alarmNumber;
			this.title=title;
			this.time=time;
			this.fromUserName=userName;
			this.state=state;
			this.deptName=deptName;
	}
	
	
	public Alarm(String title,Date time,String realname,String deptName,String detail){
		
		this.time=time;
		this.title=title;
		this.fromUserName=realname;
		this.deptName=deptName;
		this.detail=detail;
		
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
	 * @return the state
	 */
	public int getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}
	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
	 * @return the deptNumber
	 */
	public int getDeptNumber() {
		return deptNumber;
	}
	/**
	 * @param deptNumber the deptNumber to set
	 */
	public void setDeptNumber(int deptNumber) {
		this.deptNumber = deptNumber;
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
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
}
