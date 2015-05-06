package office.yueyiqiu.action;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import office.yueyiqiu.model.Attinfo;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;

public class ViewAttAction extends ActionSupport{
	
	private SearchDB searchDB;
	private List attList;
	
	private int currentPage=1;
	private int pageSpan=5;
	private int maxPage;
	
	
	
	
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
	 * @return the attList
	 */
	public List getAttList() {
		
		int begin=(this.currentPage-1)*this.pageSpan;
		int max=this.pageSpan;
		
		String sql="select date_format(oa_attinfo.att_time,'%Y¦~%m¤ë%d¤é'),oa_user.user_realname,oa_dept.dept_name"+
					",oa_attinfo.att_startstate,oa_attinfo.att_starttime,oa_attinfo.att_startip,"+
					"oa_attinfo.att_endstate,oa_attinfo.att_endtime,oa_attinfo.att_endip"+
					" from (oa_attinfo inner join oa_user on oa_attinfo.att_user=oa_user.user_number)"+ 
					" inner join oa_dept on oa_user.dept_number=oa_dept.dept_number order by att_time desc";
		
		List list=this.searchDB.getArrayList(sql, begin, max);
		List attList=new ArrayList();
		
		for(int i=0;i<list.size();i++){
			
			Object[] obj=(Object[]) list.get(i);
			
			Attinfo info=new Attinfo((String)obj[0],(String)obj[1],(String)obj[2],(int)obj[3],(String)obj[4],(String)obj[5],(int)obj[6],(String)obj[7],(String)obj[8]);
			attList.add(info);
		}
		
		return attList;
	}
	/**
	 * @param attList the attList to set
	 */
	public void setAttList(List attList) {
		this.attList = attList;
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
		
		String sql="select count(*)"+
					" from (oa_attinfo inner join oa_user on oa_attinfo.att_user=oa_user.user_number)"+
					" inner join oa_dept on oa_user.dept_number=oa_dept.dept_number";
		
		List list=this.searchDB.getArrayList(sql, -1, -1);
		int total=((BigInteger)list.get(0)).intValue();
		this.setMaxPage(total%this.pageSpan==0?total/this.pageSpan:total/this.pageSpan+1);
		
		
	}
	
}
