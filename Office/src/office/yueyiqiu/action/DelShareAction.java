package office.yueyiqiu.action;

import java.io.File;

import office.yueyiqiu.util.InsertDB;

import com.opensymphony.xwork2.ActionSupport;

public class DelShareAction extends ActionSupport{
	
	private InsertDB insertDB;
	private String fileName;
	private String inputPath;
	
	
	
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
	 * @return the inputPath
	 */
	public String getInputPath() {
		return inputPath;
	}
	/**
	 * @param inputPath the inputPath to set
	 */
	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {

		this.delete();
		return this.SUCCESS;
	}
	
	
	public void delete(){
		
		this.insertDB.delShareFile(this.fileName);
		
		File file=new File("D:\\JavaEEProject\\Office\\WebContent\\"+this.inputPath+"\\"+this.fileName);
		if(file!=null){
			file.delete();
		}
			
	}
	
	
}
