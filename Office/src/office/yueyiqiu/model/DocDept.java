package office.yueyiqiu.model;

public class DocDept {
	
	private String deptName;
	private int deptState;
	
	public DocDept(){}
	
	public DocDept(String name,int state){
		
		this.deptName=name;
		this.deptState=state;
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
	 * @return the deptState
	 */
	public int getDeptState() {
		return deptState;
	}
	/**
	 * @param deptState the deptState to set
	 */
	public void setDeptState(int deptState) {
		this.deptState = deptState;
	}
	
	
	
}
