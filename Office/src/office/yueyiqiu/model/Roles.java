package office.yueyiqiu.model;

public class Roles {
	private int roleNumber;
	private int groupNumber;
	private String roleName;
	private int roleRight;
	
	public Roles(){}
	public Roles(int number,String name){
		
		this.roleNumber=number;
		this.roleName=name;
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
	 * @return the roleRight
	 */
	public int getRoleRight() {
		return roleRight;
	}
	/**
	 * @param roleRight the roleRight to set
	 */
	public void setRoleRight(int roleRight) {
		this.roleRight = roleRight;
	}
	
	
}
