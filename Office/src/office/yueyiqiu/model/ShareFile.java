package office.yueyiqiu.model;

import java.util.Date;

public class ShareFile {
	
	private int shareNumber;
	private String shareName;
	private String realName;
	private int fromUser;
	private Date time;
	private String shareTitle;
	private String shareInfo;
	private double size;
	private int shareType;
	private String shareFileType;
	
	private String fromUserRealname;
	private String shareTypeName;
	
	
	public ShareFile(){}
	public ShareFile(int number,String name,String realname,String userrealname,double size,Date time,String title,String typename){
		
		this.shareNumber=number;
		this.shareName=name;
		this.realName=realname;
		this.time=time;
		this.fromUserRealname=userrealname;
		this.size=size;
		this.shareTitle=title;
		this.shareTypeName=typename;
		
	}
	
	
	
	/**
	 * @return the shareNumber
	 */
	public int getShareNumber() {
		return shareNumber;
	}
	/**
	 * @param shareNumber the shareNumber to set
	 */
	public void setShareNumber(int shareNumber) {
		this.shareNumber = shareNumber;
	}
	/**
	 * @return the shareName
	 */
	public String getShareName() {
		return shareName;
	}
	/**
	 * @param shareName the shareName to set
	 */
	public void setShareName(String shareName) {
		this.shareName = shareName;
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
	 * @return the shareTitle
	 */
	public String getShareTitle() {
		return shareTitle;
	}
	/**
	 * @param shareTitle the shareTitle to set
	 */
	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}
	/**
	 * @return the shareInfo
	 */
	public String getShareInfo() {
		return shareInfo;
	}
	/**
	 * @param shareInfo the shareInfo to set
	 */
	public void setShareInfo(String shareInfo) {
		this.shareInfo = shareInfo;
	}
	/**
	 * @return the size
	 */
	public double getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(double size) {
		this.size = size;
	}
	/**
	 * @return the shareType
	 */
	public int getShareType() {
		return shareType;
	}
	/**
	 * @param shareType the shareType to set
	 */
	public void setShareType(int shareType) {
		this.shareType = shareType;
	}
	/**
	 * @return the shareFileType
	 */
	public String getShareFileType() {
		return shareFileType;
	}
	/**
	 * @param shareFileType the shareFileType to set
	 */
	public void setShareFileType(String shareFileType) {
		this.shareFileType = shareFileType;
	}
	/**
	 * @return the fromUserRealname
	 */
	public String getFromUserRealname() {
		return fromUserRealname;
	}
	/**
	 * @param fromUserRealname the fromUserRealname to set
	 */
	public void setFromUserRealname(String fromUserRealname) {
		this.fromUserRealname = fromUserRealname;
	}
	/**
	 * @return the shareTypeName
	 */
	public String getShareTypeName() {
		return shareTypeName;
	}
	/**
	 * @param shareTypeName the shareTypeName to set
	 */
	public void setShareTypeName(String shareTypeName) {
		this.shareTypeName = shareTypeName;
	}
	
	
	
	
}
