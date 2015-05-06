package office.yueyiqiu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import office.yueyiqiu.model.ShareFile;
import office.yueyiqiu.util.InsertDB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadShare2Action extends ActionSupport{
	
	private InsertDB insertDB;
	private String savePath;
	private String title;
	private String info;
	private int type;
	private File shareFile;
	private String shareFileFileName;
	private String shareFileContentType;
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
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return the shareFile
	 */
	public File getShareFile() {
		return shareFile;
	}
	/**
	 * @param shareFile the shareFile to set
	 */
	public void setShareFile(File shareFile) {
		this.shareFile = shareFile;
	}
	/**
	 * @return the shareFileFileName
	 */
	public String getShareFileFileName() {
		return shareFileFileName;
	}
	/**
	 * @param shareFileFileName the shareFileFileName to set
	 */
	public void setShareFileFileName(String shareFileFileName) {
		this.shareFileFileName = shareFileFileName;
	}
	
	
	
	/**
	 * @return the shareFileContentType
	 */
	public String getShareFileContentType() {
		return shareFileContentType;
	}
	/**
	 * @param shareFileContentType the shareFileContentType to set
	 */
	public void setShareFileContentType(String shareFileContentType) {
		this.shareFileContentType = shareFileContentType;
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		double filesize=0;
		String filename=(new Date()).getTime()+this.shareFileFileName.substring(this.shareFileFileName.lastIndexOf("."), this.shareFileFileName.length());
		System.out.println(filename);
		FileOutputStream fos=null;
		FileInputStream fis=null;
		
		try{
		//fos=new FileOutputStream(this.getSavePath()+"\\"+filename);
		fos=new FileOutputStream("D:\\JavaEEProject\\Office\\WebContent\\"+this.getSavePath()+"\\"+filename);
		fis=new FileInputStream(this.getShareFile());
		byte[] buffer=new byte[1024];
		int legngth;
		filesize=fis.available()/1000;
		while((legngth=fis.read(buffer))>0){
			fos.write(buffer, 0, legngth);
		}
		
		}
		catch(Exception e){
			System.out.println("¤W¶Ç¥¢±Ñ");
			
		}
		finally{
			
			fos.close();
			fis.close();
		}
		
		System.out.println(this.shareFileContentType);
		ShareFile sf=new ShareFile();
		sf.setFromUser((int)ActionContext.getContext().getSession().get("user"));
		sf.setRealName(shareFileFileName);
		sf.setShareName(filename);
		sf.setShareTitle(title);
		sf.setShareInfo(info);
		sf.setShareType(getType());
		sf.setShareFileType(shareFileContentType);
		sf.setTime(new Date());
		sf.setSize(filesize);
		
		this.insertDB.saveShareFile(sf);
		
		return this.SUCCESS;
	}
	
}
