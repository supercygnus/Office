package office.yueyiqiu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import office.yueyiqiu.util.InsertDB;

import com.opensymphony.xwork2.ActionSupport;

public class ChangePicAction extends ActionSupport{
	
	private InsertDB insertDB;
	private File pic;
	private String picFileName;
	private String picContentType;
	private String oldpic;
	private String result;
	private String userName;
	private int userNumber;
	private String savePath;
	
	
	
	/**
	 * @return the savePath
	 */
	public String getSavePath() {
		return savePath;
	}
	/**
	 * @param savePath the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
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
	 * @return the insertDB
	 */
	public InsertDB getInsertDB() {
		return insertDB;
	}
	/**
	 * @param insertDB the insertDB to set
	 */
	public void setInsertDB(InsertDB insertDB) {
		this.insertDB = insertDB;
	}
	/**
	 * @return the pic
	 */
	public File getPic() {
		return pic;
	}
	/**
	 * @param pic the pic to set
	 */
	public void setPic(File pic) {
		this.pic = pic;
	}
	/**
	 * @return the picFileName
	 */
	public String getPicFileName() {
		return picFileName;
	}
	/**
	 * @param picFileName the picFileName to set
	 */
	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}
	/**
	 * @return the picContentType
	 */
	public String getPicContentType() {
		return picContentType;
	}
	/**
	 * @param picContentType the picContentType to set
	 */
	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}
	/**
	 * @return the oldpic
	 */
	public String getOldpic() {
		return oldpic;
	}
	/**
	 * @param oldpic the oldpic to set
	 */
	public void setOldpic(String oldpic) {
		this.oldpic = oldpic;
	}
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		String filename = null;
		
		if(this.picFileName!=null&&!this.picFileName.equals("")){
			
			filename=this.userName+".jpg";
			System.out.println(filename);
			FileOutputStream fos=null;
			FileInputStream fis=null;
			
			try{
			//fos=new FileOutputStream(this.getSavePath()+"\\"+filename);
			fos=new FileOutputStream("D:\\JavaEEProject\\Office\\WebContent\\"+this.getSavePath()+"\\"+filename);
			fis=new FileInputStream(this.getPic());
			byte[] buffer=new byte[1024];
			int legngth;
			
			while((legngth=fis.read(buffer))>0){
				fos.write(buffer, 0, legngth);
			}
			
			}
			catch(Exception e){
				System.out.println("上傳失敗");
				
			}
			finally{
				
				fos.close();
				fis.close();
			}
			
			
		}
		
		
		String sql="update oa_user set user_imgpath='"+filename+"' where user_number='"+this.userNumber+"'";
		
		int i=this.insertDB.update(sql);
		
		if(i<1){
			this.result="更新失敗,請重試";
		}
		
		return this.SUCCESS;
	}
	
	
	
	
	
}
