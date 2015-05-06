package office.yueyiqiu.action;

import java.util.List;

import office.yueyiqiu.util.InsertDB;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;

public class SendAlarmAction extends ActionSupport{
	
	private SearchDB searchDB;
	private List deptList;
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
	 * @return the deptList
	 */
	public List getDeptList() {
		
		String hql="from Dept";
		
		this.deptList=this.searchDB.getInstanceList(hql);
		
		return deptList;
	}
	/**
	 * @param deptList the deptList to set
	 */
	public void setDeptList(List deptList) {
		this.deptList = deptList;
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		return this.SUCCESS;
	}
	
	
	
	
	
}	
