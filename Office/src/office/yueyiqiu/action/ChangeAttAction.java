package office.yueyiqiu.action;

import office.yueyiqiu.util.InsertDB;

import com.opensymphony.xwork2.ActionSupport;

public class ChangeAttAction extends ActionSupport{
	
	private InsertDB insertDB;
	private String startHour;
	private String endHour;
	private String startMin;
	private String endMin;
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
	 * @return the startHour
	 */
	public String getStartHour() {
		return startHour;
	}
	/**
	 * @param startHour the startHour to set
	 */
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}
	/**
	 * @return the endHour
	 */
	public String getEndHour() {
		return endHour;
	}
	/**
	 * @param endHour the endHour to set
	 */
	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}
	/**
	 * @return the startMin
	 */
	public String getStartMin() {
		return startMin;
	}
	/**
	 * @param startMin the startMin to set
	 */
	public void setStartMin(String startMin) {
		this.startMin = startMin;
	}
	/**
	 * @return the endMin
	 */
	public String getEndMin() {
		return endMin;
	}
	/**
	 * @param endMin the endMin to set
	 */
	public void setEndMin(String endMin) {
		this.endMin = endMin;
	}
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		String sql="update oa_attendtime set att_starthour='"+this.startHour+"',att_startmin='"+this.startMin+"'"+
		" ,att_endhour='"+this.endHour+"' ,att_endmin='"+this.endMin+"'";
		
		this.insertDB.update(sql);
		
		return this.SUCCESS;
	}
	
	
	
	
	
}
