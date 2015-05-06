package office.yueyiqiu.action;

import java.util.List;

import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;

public class SendDocAction extends ActionSupport{
	
	private SearchDB searchDB;
	private List deptList;
	private String result;
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
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		return this.SUCCESS; 
	}
	
	
	
}
