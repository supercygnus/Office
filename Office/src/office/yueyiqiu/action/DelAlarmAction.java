package office.yueyiqiu.action;

import java.util.ArrayList;
import java.util.List;

import office.yueyiqiu.util.InsertDB;

import com.opensymphony.xwork2.ActionSupport;

public class DelAlarmAction extends ActionSupport{
	
	private InsertDB insertDB;
	private List<String> delList;
	private int currentPage;
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
		
		
		for(int i=0;i<this.delList.size();i++){
			System.out.println(this.delList.get(i));
		}
		
		List<Integer> intAlarmList=new ArrayList<Integer>();
		
		for(int i=0;i<this.delList.size();i++){
			intAlarmList.add(Integer.parseInt(this.delList.get(i)));	
		}
		
		this.insertDB.delAlarmList(intAlarmList);
		
		return this.SUCCESS;
	}
	
	
	
	
	
}
