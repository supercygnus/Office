package office.yueyiqiu.action;

import java.io.File;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import office.yueyiqiu.util.InsertDB;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DelTransFileAction extends ActionSupport{
	
	private SearchDB searchDB;
	private InsertDB insertDB;
	private List<String> delList;
	private String inputPath;
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
	 * @return the inputPath
	 */
	public String getInputPath() {
		return inputPath;
	}
	/**
	 * @param inputPath the inputPath to set
	 */
	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	
	
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
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		System.out.println("enter delfile");
		//this.delete();
		System.out.println("KKman!!");
		for(int i=0;i<this.delList.size();i++){
			System.out.println(delList.get(i).toString());
		}
		
		return this.SUCCESS;
	}
	
	public void delete(){
		
		int usernumber=(int) this.getSession().get("user");
		
		if(this.delList!=null){
			
			this.insertDB.delTransFile(usernumber, delList);
			
			for(int i=0;i<this.delList.size();i++){
				
				String filename=this.delList.get(i);
				String sql="select count(*) from oa_transfile where transfile_name='"+filename+"'";
				List list=this.searchDB.getArrayList(sql, -1, -1);
				int total=((BigInteger)list.get(0)).intValue();
				
				if(total>0){
					continue;
						   }
				String realpath="/transfile";
				File file=new File(realpath+"\\"+filename);
				
				if(file!=null){
					file.delete();
				}
				
			}
		}
		
	}
	
	public Map getSession(){
		return ActionContext.getContext().getSession();
	}
	
}
