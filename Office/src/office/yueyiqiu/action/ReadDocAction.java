package office.yueyiqiu.action;

import java.math.BigInteger;
import java.util.List;

import office.yueyiqiu.util.SearchDB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReadDocAction extends ActionSupport{
	
	private SearchDB searchDB;
	private int docNum;
	private String title;
	private String content;
	private int canRead;
	
	
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the canRead
	 */
	public int getCanRead() {
		return canRead;
	}

	/**
	 * @param canRead the canRead to set
	 */
	public void setCanRead(int canRead) {
		this.canRead = canRead;
	}

	/**
	 * @return the docNum
	 */
	public int getDocNum() {
		return docNum;
	}

	/**
	 * @param docNum the docNum to set
	 */
	public void setDocNum(int docNum) {
		this.docNum = docNum;
	}

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

	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		int user=(int) ActionContext.getContext().getSession().get("user");
		
		String sql="select oa_doc.doc_num,oa_doc.doc_title,oa_doc.doc_content,'0'"+
				" from oa_doc"+ 
				" where doc_num in"+ 
				" (select doc_num from oa_docdept where dept_num=(select dept_number from oa_user where user_number='"+user+"') and doc_num='"+this.docNum+"'"+ 
				" and doc_type='2' and '0' not in (select count(*) from oa_docdept where doc_type='1' and dept_state='0' and doc_num='"+this.docNum+"'))"+
				" union"+
				" select oa_doc.doc_num,oa_doc.doc_title,oa_doc.doc_content,'1'"+
				" from oa_doc"+
				" where doc_num='"+this.docNum+"'";
		
		List list=this.searchDB.getArrayList(sql, -1, -1);
		
		Object[] obj=(Object[]) list.get(0);
		
		this.title=(String) obj[1];
		this.content=(String) obj[2];
		this.canRead=Integer.parseInt((String)obj[3]);
		return this.SUCCESS;
	}
	
	
	
	
	
	
}
