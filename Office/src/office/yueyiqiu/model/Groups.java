package office.yueyiqiu.model;

public class Groups {
	
	private int groupNumber;
	private int deptNumber;
	private String groupName;
	
	public Groups(int number,String name){
		
		this.groupNumber=number;
		this.groupName=name;
		
	}
	public Groups(){}
	
	
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
	
	
	
}
