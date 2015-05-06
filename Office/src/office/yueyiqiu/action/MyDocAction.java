package office.yueyiqiu.action;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import office.yueyiqiu.model.Docs;
import office.yueyiqiu.util.InsertDB;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MyDocAction extends ActionSupport{
	
	private SearchDB searchDB;
	private List docList;
	
	private int currentPage=1;
	private int pageSpan=5;
	private int maxPage;
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
	 * @return the docList
	 */
	public List getDocList() {
		
		int usernumber=(int) this.getSession().get("user");
		int begin=(this.currentPage-1)*this.pageSpan;
		int max=this.pageSpan;
		
		String sql="select oa_doc.doc_num,oa_user.user_realname,oa_dept.dept_name,oa_doc.doc_title,date_format(oa_doc.doc_time,'%Y-%m-%d-%T') "+
					" from oa_user,oa_doc,oa_dept"+
					" where oa_user.user_number=oa_doc.doc_from and oa_doc.doc_from='"+usernumber+"'"+ 
					" and oa_dept.dept_number=oa_user.dept_number";
		
		List list=this.searchDB.getArrayList(sql, begin, max);
		List docList=new ArrayList();
		
		for(int i=0;i<list.size();i++){
			
			Object[] obj=(Object[]) list.get(i);
			Docs doc=new Docs((int)obj[0],(String)obj[1],(String)obj[2],(String)obj[3],(String)obj[4]);
			docList.add(doc);
		}
		
		return docList;
	}
	/**
	 * @param docList the docList to set
	 */
	public void setDocList(List docList) {
		this.docList = docList;
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
		int user=(int) this.getSession().get("user");
		String sql="select count(*) from oa_user,oa_doc,oa_dept "+
					" where oa_user.user_number=oa_doc.doc_from and oa_user.dept_number=oa_dept.dept_number"+
					" and oa_doc.doc_from='"+user+"'";
		
		List list=this.searchDB.getArrayList(sql, -1, -1);
		int total=((BigInteger)list.get(0)).intValue();
		this.setMaxPage(total%this.pageSpan==0?total/this.pageSpan:total/this.pageSpan+1);
		
	}
	
	
	public Map getSession(){
		return ActionContext.getContext().getSession();
	}
	
}
