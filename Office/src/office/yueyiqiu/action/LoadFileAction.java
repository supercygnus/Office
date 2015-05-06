package office.yueyiqiu.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import office.yueyiqiu.util.InsertDB;
import office.yueyiqiu.util.SearchDB;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoadFileAction extends ActionSupport{
	
	private SearchDB searchDB;
	private InsertDB insertDB;
	private int fileNumber;
	private String inputPath;
	private String fileName;
	private String downloadName;
	private String fileType;
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
	 * @return the inputPath
	 */
	public String getInputPath() {
		return ServletActionContext.getRequest().getRealPath(this.inputPath);
	}
	/**
	 * @param inputPath the inputPath to set
	 */
	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
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
	 * @return the downloadName
	 */
	public String getDownloadName() {
		try {
			this.downloadName=new String(this.downloadName.getBytes(),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return downloadName;
	}
	/**
	 * @param downloadName the downloadName to set
	 */
	public void setDownloadName(String downloadName) {
		this.downloadName = downloadName;
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
	
	
	
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	/**
	 * @return the searchDB
	 */
	public SearchDB getSearchDB() {
		return searchDB;
	}
	/**
	 * @param searchDB the searchDB to set
	 */
	public void setSearchDB(SearchDB searchDB) {
		this.searchDB = searchDB;
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
	@Override
	public String execute() throws Exception {
		
		String sql="select transfile_name,transfile_realname,transfile_type from oa_transfile where transfile_number='"+this.fileNumber+"'";
		List list=this.searchDB.getArrayList(sql, -1, -1);
		if(!(list.size()>0)){
			return this.INPUT;
		}
		
		Object[] o=(Object[]) list.get(0);
		
		this.fileName=(String) o[0];
		this.downloadName=(String) o[1];
		this.fileType=(String) o[2];
	
		return this.SUCCESS;
	}
	
	
	public InputStream getInputDownloadStream(){
		System.out.println(this.inputPath);
		System.out.println(this.getInputPath());
		return ServletActionContext.getServletContext().getResourceAsStream(this.inputPath+"\\"+this.fileName);
	}
	

}
