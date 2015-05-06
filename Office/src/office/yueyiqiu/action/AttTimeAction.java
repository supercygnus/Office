package office.yueyiqiu.action;

import java.util.*;

import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;

public class AttTimeAction extends ActionSupport{
		
	private SearchDB searchDB;
	private String startTime;
	private String endTime;
	private List hourList;
	private List minList;
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
	 * @return the hourList
	 */
	public List getHourList() {
		List time=new ArrayList();
		
		for(int i=0;i<24;i++){
			time.add(i);
		}
		
		return time;
	}
	/**
	 * @param hourList the hourList to set
	 */
	public void setHourList(List hourList) {
		this.hourList = hourList;
	}
	/**
	 * @return the minList
	 */
	public List getMinList() {
		
		List time=new ArrayList();
		
		for(int i=0;i<60;i++){
			time.add(i);
		}
		
		return time;
	}
	/**
	 * @param minList the minList to set
	 */
	public void setMinList(List minList) {
		this.minList = minList;
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		String sql="select * from oa_attendtime";
		List list=this.searchDB.getArrayList(sql, -1, -1);
		Object[] obj=(Object[]) list.get(0);
		
		this.startTime=obj[0]+"點"+obj[1]+"分";
		this.endTime=obj[2]+"點"+obj[3]+"分";
		
		return this.SUCCESS;
	}
	
	
	
	
	
}
