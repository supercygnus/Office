package office.yueyiqiu.action;

import java.util.List;

import office.yueyiqiu.model.Roles;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;

public class RoleListAction extends ActionSupport{
	private SearchDB searchDB;
	private int group;
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
	 * @return the group
	 */
	public int getGroup() {
		return group;
	}
	/**
	 * @param group the group to set
	 */
	public void setGroup(int group) {
		this.group = group;
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
		
		String hql="from Roles r where r.groupNumber='"+this.group+"'";
		this.roleList=this.searchDB.getInstanceList(hql);
		this.roleList.add(0,new Roles(0,"½Ð¿ï¾Ü"));
		return this.SUCCESS;
	}
	
	
	
	
}
