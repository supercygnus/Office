package office.yueyiqiu.model;

public class Attinfo {
	
	private String time;
	private String realName;
	private String deptName;
	private int startState;
	private String startTime;
	private int endState;
	private String endTime;
	private String startIp;
	private String endIp;
	
	public Attinfo(){}
	
	public Attinfo(String time,String realname,String deptname,int startstate,String starttime,String startip,int endstate,String endtime,String endip){
		
		this.time=time;
		this.realName=realname;
		this.deptName=deptname;
		this.startState=startstate;
		this.startTime=starttime;
		this.startIp=startip;
		this.endState=endstate;
		this.endTime=endtime;
		this.endIp=endip;
		
	}
	
	
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
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
	 * @return the startState
	 */
	public int getStartState() {
		return startState;
	}
	/**
	 * @param startState the startState to set
	 */
	public void setStartState(int startState) {
		this.startState = startState;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endState
	 */
	public int getEndState() {
		return endState;
	}
	/**
	 * @param endState the endState to set
	 */
	public void setEndState(int endState) {
		this.endState = endState;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the startIp
	 */
	public String getStartIp() {
		return startIp;
	}
	/**
	 * @param startIp the startIp to set
	 */
	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}
	/**
	 * @return the endIp
	 */
	public String getEndIp() {
		return endIp;
	}
	/**
	 * @param endIp the endIp to set
	 */
	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}
	
	
	
	
}
