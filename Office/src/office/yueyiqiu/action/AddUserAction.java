package office.yueyiqiu.action;

import java.util.ArrayList;
import java.util.List;

import office.yueyiqiu.model.Dept;
import office.yueyiqiu.model.Groups;
import office.yueyiqiu.model.Roles;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;

public class AddUserAction extends ActionSupport{
	
	private SearchDB searchDB;
	private List deptList;
	private List groupList;
	private List roleList;
	
	
	
	
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
		return deptList;
	}





	/**
	 * @param deptList the deptList to set
	 */
	public void setDeptList(List deptList) {
		this.deptList = deptList;
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





	/**
	 * @return the roleList
	 */
	public List getRoleList() {
		return roleList;
	}





	/**
	 * @param roleList the roleList to set
	 */
	public void setRoleList(List roleList) {
		this.roleList = roleList;
	}





	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		String hql="from Dept";
		this.deptList=this.searchDB.getInstanceList(hql);
		this.groupList=new ArrayList();
		this.roleList=new ArrayList();
		
		this.groupList.add(0,new Groups(0,"選擇組"));
		this.roleList.add(0,new Roles(0,"選擇角色"));
		this.deptList.add(0,new Dept(0,"選擇部門"));
		
		return this.SUCCESS;
	}
	
	
	
}
