package office.yueyiqiu.action;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import office.yueyiqiu.model.Dept;
import office.yueyiqiu.model.NewUser;
import office.yueyiqiu.util.HelloLog4J;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;



public class ViewUserAction extends ActionSupport{
	
	private static Logger logger = Logger.getLogger(ViewUserAction.class);
	private SearchDB searchDB;
	private List userList;
	private List deptList;
	private int deptNumber=-1;
	
	private int currentPage=1;
	private int pageSpan=5;
	private int maxPage;
	private int totalMessage;
	
	
	
	
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
	 * @return the userList
	 */
	public List getUserList() {
		
		String deptSql="";
		int begin=(this.currentPage-1)*this.pageSpan;
		int max=this.pageSpan;
		if(this.deptNumber!=-1){
			deptSql=" where oa_user.dept_number='"+this.deptNumber+"'";
		}
		logger.debug(this.deptNumber);
		String sql="select user_name,user_realname,user_gender,dept_name,role_name,user_phone,user_number from "+
			 "(select oa_user.user_name,oa_user.user_realname,oa_user.user_gender,oa_user.role_number,oa_user.user_phone,oa_user.user_number,oa_dept.dept_name "+ 
			 "from oa_user inner join oa_dept on oa_user.dept_number=oa_dept.dept_number"+deptSql+") as A inner join oa_role on A.role_number=oa_role.role_number";
		
		List list=this.searchDB.getArrayList(sql, begin, max);
		List fileList=new ArrayList();
		
		for(int i=0;i<list.size();i++){
			Object[] obj=(Object[]) list.get(i);
			
			NewUser user=new NewUser((String)obj[0],(String)obj[1],(String)obj[2],(String)obj[3],(String)obj[4],(String)obj[5],(int)obj[6]);
			fileList.add(user);
		}
		
		return fileList;
	}



	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List userList) {
		this.userList = userList;
	}



	/**
	 * @return the deptList
	 */
	public List getDeptList() {
		String hql="from Dept";
		List list=this.searchDB.getInstanceList(hql);
		list.add(0,new Dept(-1,"查看全部"));
		return list;
	}



	/**
	 * @param deptList the deptList to set
	 */
	public void setDeptList(List deptList) {
		this.deptList = deptList;
	}



	/**
	 * @return the deptNumber
	 */
	public int getDeptNumber() {
		return deptNumber;
	}



	/**
	 * @param deptNumber the deptNumber to set
	 */
	public void setDeptNumber(int deptNumber) {
		this.deptNumber = deptNumber;
	}



	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		this.updateinfo();
		return this.SUCCESS;
		
	}
	
	public void updateinfo(){
		
		String deptSql="";
		
		if(this.deptNumber!=-1){
			deptSql=" where dept_number='"+this.deptNumber+"'";
		}
		
		String sql="select count(*) from oa_user"+deptSql;
		
		List list=this.searchDB.getArrayList(sql, -1, -1);
		int total=((BigInteger)list.get(0)).intValue();
		
		this.setMaxPage(total%this.pageSpan==0?total/this.getPageSpan():total/this.getPageSpan()+1);
		
	}
	
}
