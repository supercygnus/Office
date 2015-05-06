package office.yueyiqiu.action;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import office.yueyiqiu.model.Alarm;
import office.yueyiqiu.model.ShareFile;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;

public class ViewAlarmAction extends ActionSupport{
	
	private SearchDB searchDB;
	private int deptNumber=-1;
	private List deptList;
	private List alarmList;
	
	private int currentPage=1;
	private int pageSpan=5;
	private int maxPage;
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
	 * @return the deptList
	 */
	public List getDeptList() {
		
		String hql="from Dept";
		List list=this.searchDB.getInstanceList(hql);
		
		return list;
	}
	/**
	 * @param deptList the deptList to set
	 */
	public void setDeptList(List deptList) {
		this.deptList = deptList;
	}
	/**
	 * @return the alarmList
	 */
	public List getAlarmList() {
		
		System.out.println("get file list");
		String deptSql="";
		int begin=(this.currentPage-1)*this.pageSpan;
		int max=this.pageSpan;
		if(this.deptNumber!=-1){
			deptSql=" where oa_alarm.alarm_dept='"+this.deptNumber+"'";
		}
		
		String sql="select oa_alarm.alarm_number,oa_alarm.alarm_title"+
					",oa_alarm.alarm_time,oa_user.user_realname,oa_alarm.alarm_state,oa_dept.dept_name"+ 
					" from (oa_alarm inner join oa_user on oa_alarm.alarm_fromuser=oa_user.user_number)"+ 
					" inner join oa_dept on oa_alarm.alarm_dept=oa_dept.dept_number"+deptSql;
		
		List list=this.searchDB.getArrayList(sql, begin, max);
		List alarmList=new ArrayList();
		
		for(int i=0;i<list.size();i++){
			Object[] obj=(Object[]) list.get(i);
			Alarm alarm=new Alarm((int)obj[0],(String)obj[1],(Date)obj[2],(String)obj[3],(int)obj[4],(String)obj[5]);
			alarmList.add(alarm);
		}
		
		
		
		return alarmList;
		
		
	}
	/**
	 * @param alarmList the alarmList to set
	 */
	public void setAlarmList(List alarmList) {
		this.alarmList = alarmList;
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
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		this.updateInfo();
		return this.SUCCESS;
	}
	
	
	
	public void updateInfo(){
		
		String deptSql="";
		
		if(this.deptNumber!=-1){
			deptSql=" where alarm_dept='"+this.deptNumber+"'";
		}
		
		String sql="select count(*) from oa_alarm"+deptSql;
		
		List list=this.searchDB.getArrayList(sql, -1, -1);
		int total=((BigInteger)list.get(0)).intValue();
		
		this.setMaxPage(total%this.pageSpan==0?total/this.getPageSpan():total/this.getPageSpan()+1);
		
		
	}
	
	
}
