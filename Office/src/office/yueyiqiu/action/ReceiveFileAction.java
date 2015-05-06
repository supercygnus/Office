package office.yueyiqiu.action;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import office.yueyiqiu.model.SendMsg;
import office.yueyiqiu.model.Transfile;
import office.yueyiqiu.util.InsertDB;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReceiveFileAction extends ActionSupport{
	
	private SearchDB searchDB;
	private InsertDB insertDB;
	private List myFileList;
	
	
	private int currentPage=1;
	private int pageSpan=5;
	private int maxPage;
	private int totalMessage;
	
	
	
	/**
	 * @return the myFileList
	 */
	public List getMyFileList() {
		
		int usernumber=(int) this.getSession().get("user");
		int begin=(this.currentPage-1)*this.pageSpan;
		int max=this.pageSpan;
		System.out.println("begin="+begin+" end="+max);
		String sql="select oa_transfile.transfile_name,oa_transfile.transfile_realname,oa_transfile.transfile_fromuser,oa_transfile.transfile_touser,date_format(oa_transfile.transfile_time,'%Y-%m-%d-%T') as msgtime,oa_transfile.transfile_info,oa_user.user_realname,oa_transfile.transfile_number"+
				   " from oa_transfile inner join oa_user on oa_transfile.transfile_fromuser=oa_user.user_number"+
				   " where oa_transfile.transfile_touser='"+usernumber+"'";
		
		List list=this.searchDB.getArrayList(sql,begin,max);
		System.out.println("Gokkkk!!!");
		List fileList=new ArrayList();
		
		System.out.println("list size="+list.size());
		
		
		for(int i=0;i<list.size();i++){
			System.out.println("yes!!");
			Object[] obj=(Object[]) list.get(i);
			Transfile file=new Transfile((String)obj[0],(String)obj[1],(int)obj[2],(int)obj[3],(String)obj[4],(String)obj[5],(String)obj[6],(int)obj[7]);
			fileList.add(file);
		}
		System.out.println(((Transfile)fileList.get(0)).getFileName());
		System.out.println("Go3!!!");
		return fileList;
		
				   
		
	}

	/**
	 * @param myFileList the myFileList to set
	 */
	public void setMyFileList(List myFileList) {
		this.myFileList = myFileList;
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

	/**
	 * @return the pageSpan
	 */
	public int getPageSpan() {
		return pageSpan;
	}

	/**
	 * @param pageSpan the pageSpan to set
	 */
	public void setPageSpan(int pageSpan) {
		this.pageSpan = pageSpan;
	}

	/**
	 * @return the maxPage
	 */
	public int getMaxPage() {
		return maxPage;
	}

	/**
	 * @param maxPage the maxPage to set
	 */
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
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
		this.updateInfo();
		return this.SUCCESS;
	}
	
	public void updateInfo(){
		int usernumber=(int) this.getSession().get("user");
		String sql="select count(*) from oa_transfile where transfile_touser='"+usernumber+"'";
		List list=this.getSearchDB().getArrayList(sql,-1,-1);
		int total=((BigInteger) list.get(0)).intValue();
		this.setMaxPage(total%this.pageSpan==0?total/this.pageSpan:total/this.pageSpan+1);
	}
	
	
	public Map getSession(){
		return ActionContext.getContext().getSession();
	}
}
