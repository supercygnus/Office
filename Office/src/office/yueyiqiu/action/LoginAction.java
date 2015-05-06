package office.yueyiqiu.action;

import java.util.List;
import java.util.Map;

import office.yueyiqiu.model.User;
import office.yueyiqiu.util.LoginDB;
import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;


public class LoginAction extends ActionSupport{
	
	private LoginDB loginDB;
	private SearchDB searchDB;
	private String uid;
	private String pwd;
	private String verifycode;
	private String result="";
	
	
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		String code=(String) this.getSession().get("code");
		System.out.println("code="+code);
		System.out.println("vcode="+this.verifycode);
		if(code!=null){
			if(!code.toLowerCase().equals(this.verifycode.toLowerCase())){
				this.result="ÅçÃÒ½X¿ù»~";
				return this.SUCCESS;
			}
			else{
				
				String hql="from User u where u.userName='"+this.uid+"' and u.userPassword='"+this.pwd+"'";
				List list=this.loginDB.getUser(hql);
				if(list.size()>0){
					User user=(User) list.get(0);
					int right=user.getRole().getRoleRight();
					System.out.println("right="+right);
					this.getSession().put("user", user.getUserNumber());
					this.getSession().put("right", right);
					
					
					String sql="select oa_user.user_realname,oa_dept.dept_name,oa_group.group_name,oa_role.role_name from"+ 
								" ((oa_user inner join oa_dept on oa_user.dept_number=oa_dept.dept_number)"+
								" inner join oa_group on oa_user.group_number=oa_group.group_number) inner join oa_role"+
								" on oa_user.role_number=oa_role.role_number where oa_user.user_name='"+this.uid+"' and oa_user.user_pwd='"+this.pwd+"'";
					
					Object[] obj=(Object[]) (this.searchDB.getArrayList(sql, -1, -1)).get(0);
					
					User userDetail=new User((String)obj[0],(String)obj[1],(String)obj[2],(String)obj[3]);
					
					this.getSession().put("userdetail", userDetail);
					
					return "mainmanage";
				}
				else{
					this.result="¥Î¤á¦WºÙ©Î±K½X¿ù»~";
					return this.SUCCESS;
				}
			}
		}
		return this.SUCCESS;
	}
	
	
	public Map getSession(){
		return  ActionContext.getContext().getSession();
	}
	
	
	
	/**
	 * @return the loginDB
	 */
	public LoginDB getLoginDB() {
		return loginDB;
	}


	/**
	 * @param loginDB the loginDB to set
	 */
	public void setLoginDB(LoginDB loginDB) {
		this.loginDB = loginDB;
	}


	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}


	/**
	 * @param uid the uid to set
	 */
	@RequiredStringValidator
	public void setUid(String uid) {
		this.uid = uid;
	}


	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}


	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	/**
	 * @return the verifycode
	 */
	public String getVerifycode() {
		return verifycode;
	}


	/**
	 * @param verifycode the verifycode to set
	 */
	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}


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
	
	
	
}
