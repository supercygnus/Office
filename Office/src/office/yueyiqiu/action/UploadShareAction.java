package office.yueyiqiu.action;

import java.util.List;

import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;

public class UploadShareAction extends ActionSupport{
	
	private SearchDB searchDB;
	private List typeList;
	
	
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
	 * @return the typeList
	 */
	public List getTypeList() {
		String hql="from ShareType";
		List list=this.searchDB.getInstanceList(hql);
		return list;
	}


	/**
	 * @param typeList the typeList to set
	 */
	public void setTypeList(List typeList) {
		this.typeList = typeList;
	}




	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		return this.SUCCESS;
	}
	
	
	
	
}
