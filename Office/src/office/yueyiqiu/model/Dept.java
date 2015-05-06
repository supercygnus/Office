package office.yueyiqiu.model;

public class Dept {
	
	private int deptNumber;
	private String deptName;
	
	
	public Dept(int number,String name){
		
		this.deptNumber=number;
		this.deptName=name;
	}
	
	
	public Dept(){}
	
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
	
	
	
}
