package office.yueyiqiu.action;


import java.util.*;

import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;

public class UserUniqueAction extends ActionSupport{
	
	private SearchDB searchDB;
	private String name;
	private String flag;
	
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}





	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}





	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}





	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}





	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		System.out.println("enter unique");
		
		String sql="select * from oa_user where user_name='"+this.name+"'";
		System.out.println(this.name);
		List list=(List) this.searchDB.getArrayList(sql, -1, -1);
		
		if(list.size()>0)
			this.flag="notOK";
		else
			this.flag="OK";
		System.out.println(this.flag);
		return this.SUCCESS;
	}
	
	
	
}
