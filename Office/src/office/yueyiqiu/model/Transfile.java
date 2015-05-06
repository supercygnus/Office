package office.yueyiqiu.model;

import java.util.Date;

public class Transfile {
	
	private int fileNumber;
	private String fileName;
	private String fileRealName;
	private int fromUser;
	private int toUser;
	private Date time;
	private String fileInfo;
	private String fileType;
	private String timeStr;
	private String fileUserRealName;
	
	public Transfile(){
		
	}
	
	public Transfile(String filename,String filerealname,int fromuser,int touser,String time,String fileinfo,String fromuserrealname,int filenumber){
		
		this.fileName=filename;
		this.fileRealName=filerealname;
		this.fromUser=fromuser;
		this.toUser=touser;
		this.timeStr=time;
		this.fileInfo=fileinfo;
		this.fileUserRealName=fromuserrealname;
		this.fileNumber=filenumber;
	}
	
	
	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * @return the timeStr
	 */
	public String getTimeStr() {
		return timeStr;
	}
	/**
	 * @param timeStr the timeStr to set
	 */
	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}
	/**
	 * @return the fileUserRealName
	 */
	public String getFileUserRealName() {
		return fileUserRealName;
	}
	/**
	 * @param fileUserRealName the fileUserRealName to set
	 */
	public void setFileUserRealName(String fileUserRealName) {
		this.fileUserRealName = fileUserRealName;
	}
	/**
	 * @return the fileNumber
	 */
	public int getFileNumber() {
		return fileNumber;
	}
	/**
	 * @param fileNumber the fileNumber to set
	 */
	public void setFileNumber(int fileNumber) {
		this.fileNumber = fileNumber;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the fileRealName
	 */
	public String getFileRealName() {
		return fileRealName;
	}
	/**
	 * @param fileRealName the fileRealName to set
	 */
	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}
	/**
	 * @return the fromUser
	 */
	public int getFromUser() {
		return fromUser;
	}
	/**
	 * @param fromUser the fromUser to set
	 */
	public void setFromUser(int fromUser) {
		this.fromUser = fromUser;
	}
	/**
	 * @return the toUser
	 */
	public int getToUser() {
		return toUser;
	}
	/**
	 * @param toUser the toUser to set
	 */
	public void setToUser(int toUser) {
		this.toUser = toUser;
	}
	
	/**
	 * @return the fileInfo
	 */
	public String getFileInfo() {
		return fileInfo;
	}
	/**
	 * @param fileInfo the fileInfo to set
	 */
	public void setFileInfo(String fileInfo) {
		this.fileInfo = fileInfo;
	}
	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}
	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
}
