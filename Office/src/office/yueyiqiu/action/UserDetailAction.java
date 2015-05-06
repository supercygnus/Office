package office.yueyiqiu.action;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import office.yueyiqiu.model.NewUser;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionSupport;

public class UserDetailAction extends ActionSupport{
	
	private SearchDB searchDB;
	private int userNumber;
	private NewUser user;
	private String savePath;
	private String result;
	
	
	
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}




	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
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
	 * @return the userNumber
	 */
	public int getUserNumber() {
		return userNumber;
	}




	/**
	 * @param userNumber the userNumber to set
	 */
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}




	/**
	 * @return the user
	 */
	public NewUser getUser() {
		return user;
	}




	/**
	 * @param user the user to set
	 */
	public void setUser(NewUser user) {
		this.user = user;
	}




	/**
	 * @return the savePath
	 */
	public String getSavePath() {
		return savePath;
	}




	/**
	 * @param savePath the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}




	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		String sql="select oa_user.user_number,oa_user.user_name,oa_user.user_realname,"+
				"oa_user.user_gender,oa_user.user_birth,oa_dept.dept_name,oa_group.group_name,oa_role.role_name,"+
				"oa_user.user_email,oa_user.user_phone,oa_user.user_jianli,oa_user.user_salary,oa_user.user_imgpath"+ 
				" from oa_user,oa_dept,oa_role,oa_group"+ 
				" where oa_user.dept_number=oa_dept.dept_number and oa_user.group_number=oa_group.group_number and oa_user.role_number=oa_role.role_number"+
				" and oa_user.user_number='"+this.userNumber+"'";
		List list=this.searchDB.getArrayList(sql, -1, -1);
		
		if(!list.isEmpty()){
			
			Object[] obj=(Object[]) list.get(0);
			
			this.user=new NewUser((int)obj[0],(String)obj[1],(String)obj[2],(String)obj[3],(Date)obj[4],(String)obj[5],(String)obj[6],
					(String)obj[7],(String)obj[8],(String)obj[9],(String)obj[10],(int)obj[11],
					(String)obj[12]);
			
		}
		
		return this.SUCCESS;
	}
	
	
	
	
}
