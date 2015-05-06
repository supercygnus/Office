package office.yueyiqiu.model;

public class User {
	
	private int userNumber;
	private String userName;
	private String userPassword;
	private Role role;
	
	
	private String userRealname;
	private String userDeptname;
	private String userGroupname;
	private String userRolename;
	
	public User(){}
	
	public User(String real,String dept,String group,String role){
		
		this.userRealname=real;
		this.userDeptname=dept;
		this.userGroupname=group;
		this.userRolename=role;
		
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the userRealname
	 */
	public String getUserRealname() {
		return userRealname;
	}

	/**
	 * @param userRealname the userRealname to set
	 */
	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}

	/**
	 * @return the userDeptname
	 */
	public String getUserDeptname() {
		return userDeptname;
	}

	/**
	 * @param userDeptname the userDeptname to set
	 */
	public void setUserDeptname(String userDeptname) {
		this.userDeptname = userDeptname;
	}

	/**
	 * @return the userGroupname
	 */
	public String getUserGroupname() {
		return userGroupname;
	}

	/**
	 * @param userGroupname the userGroupname to set
	 */
	public void setUserGroupname(String userGroupname) {
		this.userGroupname = userGroupname;
	}

	/**
	 * @return the userRolename
	 */
	public String getUserRolename() {
		return userRolename;
	}

	/**
	 * @param userRolename the userRolename to set
	 */
	public void setUserRolename(String userRolename) {
		this.userRolename = userRolename;
	}
	
	
	
}
