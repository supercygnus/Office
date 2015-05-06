package office.yueyiqiu.action;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import office.yueyiqiu.model.ShareFile;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;

public class ViewShareAction extends ActionSupport{
	
	private SearchDB searchDB;
	private int shareType=-1;
	private List shareList;
	private List shareTypeList;
	
	
	private int currentPage=1;
	private int pageSpan=5;
	private int maxPage;
	
	
	
	
	
	/**
	 * @return the shareTypeList
	 */
	public List getShareTypeList() {
		System.out.println("get type list");
		String hql="from ShareType";
		List list=this.searchDB.getInstanceList(hql);
		
		
		return list;
	}
	/**
	 * @param shareTypeList the shareTypeList to set
	 */
	public void setShareTypeList(List shareTypeList) {
		this.shareTypeList = shareTypeList;
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
	 * @return the shareType
	 */
	public int getShareType() {
		return shareType;
	}
	/**
	 * @param shareType the shareType to set
	 */
	public void setShareType(int shareType) {
		this.shareType = shareType;
	}
	/**
	 * @return the shareList
	 */
	public List getShareList() {
		
		System.out.println("get file list");
		String typeSql="";
		int begin=(this.currentPage-1)*this.pageSpan;
		int max=this.pageSpan;
		if(this.shareType!=-1){
			typeSql=" where oa_sharetype.type_number='"+this.shareType+"'";
		}
		
		String sql="select oa_sharefile.share_number,oa_sharefile.share_name,oa_sharefile.share_realname,oa_user.user_realname,"
				 +"oa_sharefile.share_size,oa_sharefile.share_time,oa_sharefile.share_title,oa_sharetype.type_name"
				 +" from (oa_sharefile inner join oa_sharetype on oa_sharefile.share_type=oa_sharetype.type_number)" 
				 +" inner join oa_user on share_fromuser=oa_user.user_number"+typeSql;
		
		List list=this.searchDB.getArrayList(sql, begin, max);
		List shareList=new ArrayList();
		
		for(int i=0;i<list.size();i++){
			Object[] obj=(Object[]) list.get(i);
			ShareFile file=new ShareFile((int)obj[0],(String)obj[1],(String)obj[2],(String)obj[3],((BigDecimal)obj[4]).doubleValue(),(Date)obj[5],(String)obj[6],(String)obj[7]);
			shareList.add(file);
		}
		
		
		//System.out.println(((ShareFile)shareList.get(0)).getRealName());
		//System.out.println(((ShareFile)shareList.get(1)).getRealName());
		return shareList;
	}
	/**
	 * @param shareList the shareList to set
	 */
	public void setShareList(List shareList) {
		this.shareList = shareList;
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
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		this.updateInfo();
		
		return this.SUCCESS;
	}
	
	
	public void updateInfo(){
		
		String typeSql="";
		
		if(this.shareType!=-1){
			typeSql=" where share_type='"+this.shareType+"'";
		}
		
		String sql="select count(*) from oa_sharefile"+typeSql;
		
		List list=this.searchDB.getArrayList(sql, -1, -1);
		int total=((BigInteger)list.get(0)).intValue();
		
		this.setMaxPage(total%this.pageSpan==0?total/this.getPageSpan():total/this.getPageSpan()+1);
		
		
	}
	
	
}
