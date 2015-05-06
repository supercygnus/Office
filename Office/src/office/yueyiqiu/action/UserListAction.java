package office.yueyiqiu.action;

import java.util.List;

import office.yueyiqiu.model.RealUser;
import office.yueyiqiu.util.MyConverter;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport{
	
	private SearchDB searchDB;
	private int deptNumber;
	private String userList;
	
	
	
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



	/**
	 * @return the userList
	 */
	public String getUserList() {
		return userList;
	}



	/**
	 * @param userList the userList to set
	 */
	public void setUserList(String userList) {
		this.userList = userList;
	}



	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		System.out.println("I am here");
		
		String hql="from RealUser ru where ru.deptNumber='"+this.deptNumber+"'";
		List list=this.searchDB.getInstanceList(hql);
		int size=list.size();
		StringBuilder result=new StringBuilder();
		RealUser user=null;
		result.append("<table width=\"100%\" ><tr><td style=\"width:10\"></td><td><table border=0 width=\"100%\">");
		for(int i=0;i<size;i++){
			user=(RealUser) list.get(i);
			int number=user.getUserNumber();
			String name=user.getUserName();
			result.append("<tr style=\"height:20px;color:#404040;font-size:14px;\" onmouseout=\"mouseoutcolor('row");
			result.append(i);
			result.append("')\" onmouseover=\"mouseovercolor('row");
			result.append(i);
			result.append("')\" onclick=\"add('");
			result.append(number);
			result.append("')\" id=\"row");
			result.append(i);
			result.append("\">");
			result.append("<td align=\"right\"><img src=\"images/usrlist.gif\"></td><td align=\"left\">");
			result.append(name);
			result.append("<td></tr>");
		}
		result.append("</table></td></tr></table>");
		this.userList=result.toString();
		this.userList=new MyConverter().escape(userList);
		return this.SUCCESS;
	}
	
	
	
}
