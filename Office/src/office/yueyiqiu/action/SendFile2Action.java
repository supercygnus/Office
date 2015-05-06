package office.yueyiqiu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import office.yueyiqiu.model.Transfile;
import office.yueyiqiu.util.InsertDB;

public class SendFile2Action extends SendFileAction{
	
	private InsertDB insertDB;
	private String info;
	private String touser;
	private File myFile;
	private String myFileFileName;
	private String myFileContentType;
	private String savePath;
	
	
	
	/**
	 * @return the savePath
	 */
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}




	/**
	 * @param savePath the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
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
	 * @return the touser
	 */
	public String getTouser() {
		return touser;
	}




	/**
	 * @param touser the touser to set
	 */
	public void setTouser(String touser) {
		this.touser = touser;
	}




	/**
	 * @return the myFile
	 */
	public File getMyFile() {
		return myFile;
	}




	/**
	 * @param myFile the myFile to set
	 */
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}




	/**
	 * @return the myFileFileName
	 */
	public String getMyFileFileName() {
		return myFileFileName;
	}




	/**
	 * @param myFileFileName the myFileFileName to set
	 */
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}




	/**
	 * @return the myFileContentType
	 */
	public String getMyFileContentType() {
		return myFileContentType;
	}




	/**
	 * @param myFileContentType the myFileContentType to set
	 */
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}




	/* (non-Javadoc)
	 * @see office.yueyiqiu.action.SendFileAction#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		System.out.println(myFileFileName);
		System.out.println(this.getSavePath());
		if(this.myFileFileName!=null&&!this.myFileFileName.equals("")){
			
			String filename=new Date().getTime()+this.myFileFileName.substring(this.myFileFileName.lastIndexOf("."), this.myFileFileName.length());
			System.out.println(filename);
			FileOutputStream fos=null;
			FileInputStream fis=null;
			
			try{
			//fos=new FileOutputStream(this.getSavePath()+"\\"+filename);
			fos=new FileOutputStream("D:\\JavaEEProject\\Office\\WebContent\\transfile\\"+filename);
			fis=new FileInputStream(this.getMyFile());
			byte[] buffer=new byte[1024];
			int legngth;
			
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
			
			String touserarray[]=this.touser.split(";");
			List userList=new ArrayList();
			for(int i=0;i<touserarray.length;i++){
				Transfile tf=new Transfile();
				tf.setFileName(filename);
				tf.setFileRealName(this.myFileFileName);
				tf.setFileInfo(info);
				tf.setFromUser(Integer.parseInt(this.getSession().get("user").toString()));
				tf.setToUser(Integer.parseInt(touserarray[i].trim()));
				tf.setFileType(myFileContentType);
				tf.setTime(new Date());
				userList.add(tf);
			}
			
			insertDB.saveTransFile(userList);
			
		}
		
	
		return this.SUCCESS;
	}
	
	public Map getSession(){
		return ActionContext.getContext().getSession();
	}
	
	
}
