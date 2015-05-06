package office.yueyiqiu.action;

import java.util.List;

import org.apache.log4j.Logger;

import office.yueyiqiu.model.Groups;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;

public class GroupListAction extends ActionSupport{
	
	private static Logger logger = Logger.getLogger(GroupListAction.class);
	private SearchDB searchDB;
	private int dept;
	private List groupList;
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
	/**
	 * @return the groupList
	 */
	public List getGroupList() {
		return groupList;
	}
	/**
	 * @param groupList the groupList to set
	 */
	public void setGroupList(List groupList) {
		this.groupList = groupList;
	}
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		this.logger.debug(this.dept);
		String hql="from Groups g where g.deptNumber='"+this.dept+"'";
		this.groupList=this.searchDB.getInstanceList(hql);
		this.groupList.add(0,new Groups(0,"½Ð¿ï¾Ü"));
		
		return this.SUCCESS;
	}
	
	
	
	
}
