package office.yueyiqiu.model;

public class Docs {
	
	private int docNumber;
	private String fromUserName;
	private String title;
	private String docTime;
	private String deptName;
	
	public Docs(){}
	
	
	public Docs(int docNum,String fromusername,String deptname,String title,String time){
		
		this.docNumber=docNum;
		this.fromUserName=fromusername;
		this.deptName=deptname;
		this.title=title;
		this.docTime=time;
		
	}
	
	/**
	 * @return the docNumber
	 */
	public int getDocNumber() {
		return docNumber;
	}
	/**
	 * @param docNumber the docNumber to set
	 */
	public void setDocNumber(int docNumber) {
		this.docNumber = docNumber;
	}
	
	/**
	 * @return the fromUserName
	 */
	public String getFromUserName() {
		return fromUserName;
	}


	/**
	 * @param fromUserName the fromUserName to set
	 */
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the docTime
	 */
	public String getDocTime() {
		return docTime;
	}
	/**
	 * @param docTime the docTime to set
	 */
	public void setDocTime(String docTime) {
		this.docTime = docTime;
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
