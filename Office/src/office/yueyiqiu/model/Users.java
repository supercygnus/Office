package office.yueyiqiu.model;

import java.util.Date;

import office.yueyiqiu.util.InsertDB;

public class Users {
	
	private int userNumber; 
	private String userName;
	private String userPwd;
	private String userRealName;
	private String userGender;
	private Date userBirth;
	private int deptNumber;
	private int groupNumber;
	private int roleNumber;
	private String userEmail;
	private String userPhone;
	private String jianli;
	private String imgpath;
	private int salary; 
	
	
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
	 * @return the userRealName
	 */
	public String getUserRealName() {
		return userRealName;
	}
	/**
	 * @param userRealName the userRealName to set
	 */
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	/**
	 * @return the userGender
	 */
	public String getUserGender() {
		return userGender;
	}
	/**
	 * @param userGender the userGender to set
	 */
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	/**
	 * @return the userBirth
	 */
	public Date getUserBirth() {
		return userBirth;
	}
	/**
	 * @param userBirth the userBirth to set
	 */
	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
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
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 * @return the userPhone
	 */
	public String getUserPhone() {
		return userPhone;
	}
	/**
	 * @param userPhone the userPhone to set
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	/**
	 * @return the jianli
	 */
	public String getJianli() {
		return jianli;
	}
	/**
	 * @param jianli the jianli to set
	 */
	public void setJianli(String jianli) {
		this.jianli = jianli;
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
