package office.yueyiqiu.action;

import java.util.ArrayList;
import java.util.List;

import office.yueyiqiu.util.InsertDB;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;

public class DelMessageAction extends ActionSupport{
	
	private SearchDB searchDB;
	private InsertDB insertDB;
	private List<String> delList;
	private int currentPage;
	
	

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
	 * @return the delList
	 */
	public List<String> getDelList() {
		return delList;
	}





	/**
	 * @param delList the delList to set
	 */
	public void setDelList(List<String> delList) {
		this.delList = delList;
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





	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		this.delete();
		return this.SUCCESS;
	}
	
	public void delete(){
		
		List<Integer> intMsgList=new ArrayList<Integer>();
		
		for(int i=0;i<this.delList.size();i++){
			intMsgList.add(Integer.parseInt(this.delList.get(i)));	
		}
		this.insertDB.delMsgList(intMsgList);
		
	}
	
	
}
