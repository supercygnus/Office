package office.yueyiqiu.model;

import java.util.Date;

public class NewUser {
	
	private int userNumber;
	private String userName;
	private String userPwd;
	private String realName;
	private String gender;
	private Date birth;
	private int deptNumber;
	private int groupNumber;
	private int roleNumber;
	private String email;
	private String phone;
	private String experience;
	private String imgpath;
	private int salary;
	
	
	private String deptName;
	private String groupName;
	private String roleName;
	
	public NewUser(){}
	
	public NewUser(String username,String realname,String gender,String deptName,String roleName,String phone,int usernumber){
		
		this.userName=username;
		this.realName=realname;
		this.gender=gender;
		this.deptName=deptName;
		this.roleName=roleName;
		this.phone=phone;
		this.userNumber=usernumber;
	}
	
	
	public NewUser(int usernumber,String username,String realname,String gender,Date birth,String deptname,String groupname,String rolename,String email,String phone,String jianli,int salary,String imgpath){
		
		this.userNumber=usernumber;
		this.userName=username;
		this.realName=realname;
		this.gender=gender;
		this.birth=birth;
		this.deptName=deptname;
		this.groupName=groupname;
		this.roleName=rolename;
		this.email=email;
		this.phone=phone;
		this.experience=jianli;
		this.salary=salary;
		this.imgpath=imgpath;
		
	}
	
	
	
	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	 * @return the userPwd
	 */
	public String getUserPwd() {
		return userPwd;
	}
	/**
	 * @param userPwd the userPwd to set
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}
	/**
	 * @param birth the birth to set
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
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
	 * @return the groupNumber
	 */
	public int getGroupNumber() {
		return groupNumber;
	}
	/**
	 * @param groupNumber the groupNumber to set
	 */
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	/**
	 * @return the roleNumber
	 */
	public int getRoleNumber() {
		return roleNumber;
	}
	/**
	 * @param roleNumber the roleNumber to set
	 */
	public void setRoleNumber(int roleNumber) {
		this.roleNumber = roleNumber;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the experience
	 */
	public String getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}
	/**
	 * @return the imgpath
	 */
	public String getImgpath() {
		return imgpath;
	}
	/**
	 * @param imgpath the imgpath to set
	 */
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}
